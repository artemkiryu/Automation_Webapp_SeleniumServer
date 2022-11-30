package dataprovider;

import email.ImapsEmailDriver;
import org.apache.commons.lang3.StringUtils;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bludshot on 10/5/15.
 */
public class EmailParser extends ImapsEmailDriver {

    Message unseenPasswordMail;

    public EmailParser(String host, String userName, String password) {
        super(host, userName, password);
        unseenPasswordMail = null;
    }

    public String getTempPassword(final String subject, final String accountID) throws Exception {

        boolean isMailFound = isMailReceivedWithSubject(subject, accountID);

        String tempPassword = null;

        if (isMailFound) {
            String line;
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(unseenPasswordMail.getInputStream()));

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            tempPassword = buffer.toString().split("Temporary Password: ")[1].substring(0, 7);
        }
        return tempPassword;

    }

    public boolean checkAccountIDInEmail(Message message, String accountID) throws Exception {
        boolean isAccountIDPresent = false;

        String line;
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        if (buffer.toString().contains(accountID))
            isAccountIDPresent = true;

        return isAccountIDPresent;
    }


    public boolean isMailReceivedWithSubject(final String subject, final String accountID) throws Exception {

        boolean isMailFound = false;
        int pollCount = 0;

        //Connect to Inbox
        connect();
        Thread.sleep(5000);
        reporter.info("Checking for mail with subject : " + subject);
        Message[] messages = null;
        while (!isMailFound && pollCount <= 48) {
            messages = currentFolder.search(new SubjectTerm(subject), currentFolder.getMessages());
            if (messages.length > 0) {
                for (Message mail : messages) {
                    reporter.info("+++++++++++++++++++++++++++++Inside EMAIL PARSER For Loop+++++++++++++++++++++");
                    if (checkAccountIDInEmail(mail, accountID)) {
                        unseenPasswordMail = mail;
                        isMailFound = true;
                        mail.setFlag(Flags.Flag.SEEN, true);
                        Thread.sleep(6000);
                        reporter.info("Mail Received with Subject and Account ID : " + " Subject = " + subject + " And AccountID = " + accountID);
                        break;
                    }
                }
            }
            Thread.sleep(5000);
            pollCount++;
        }
        //    disconnect();
        return isMailFound;
    }

    public boolean isMailReceivedWithSubject(final String subject) throws Exception {

        boolean isMailFound = false;
        int pollCount = 0;

        //Connect to Inbox
        connect();
        Thread.sleep(2000);
        reporter.info("Checking for mail with subject : " + subject);
        Message[] messages = null;
        while (!isMailFound && pollCount <= 48) {
            messages = currentFolder.search(new SubjectTerm(subject), currentFolder.getMessages());
            if (messages.length > 0) {
                for (Message mail : messages) {
                    reporter.info("+++++++++++++++++++++++++++++Inside EMAIL PARSER For Loop+++++++++++++++++++++");
                    if (!mail.isSet(Flags.Flag.SEEN)) {
                        unseenPasswordMail = mail;
                        isMailFound = true;
                        mail.setFlag(Flags.Flag.SEEN, true);
                        Thread.sleep(6000);
                        reporter.info("Mail Received with Subject " + subject);
                        break;
                    }
                }
            }
            Thread.sleep(5000);
            pollCount++;
        }
        //    disconnect();
        return isMailFound;
    }

    public void cleanUpUsedMails(String subject) throws Exception {
        try {
            Folder trash = store.getFolder("[Gmail]/Trash");
            Message[] messages = currentFolder.search(new SubjectTerm(subject), currentFolder.getMessages());
            if (messages.length > 0) {
                currentFolder.copyMessages(messages, trash);
                Thread.sleep(1000);
            }
            //    currentFolder.close(true);
        } catch (MessagingException e) {
            reporter.info("Error in cleaning up mailbox : " + e.getMessage());
        }
    }

    /*public String getBodyTextOfMail(String subject) throws Exception {
        Message message = null;
        if (isMailReceivedWithSubject(subject))
            message = unseenPasswordMail;
        else
            throw new Exception("Email not Found with Subject : " + subject);
        //Message message = getUnseenMailWithSubject(subject);
        Multipart mp = (Multipart) message.getContent();

        for (int i = 0; i < mp.getCount(); i++) {
            Part bp = mp.getBodyPart(i);
           // if (bp.isMimeType("text/plain")) {
                return (String) bp.getContent().toString();
            //}
        }
        return null;
    }*/
    public String getTextFromMessage(String subject) throws Exception {
        Message message = null;
        String result = "";
        if (isMailReceivedWithSubject(subject)) {
            message = unseenPasswordMail;
            try {
                if (message.isMimeType("text/plain")) {
                    result = message.getContent().toString();
                } else if (message.isMimeType("multipart/*")) {
                    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                    result = getTextFromMimeMultipart(mimeMultipart);
                } else if (message.isMimeType("text/html")) {
                    String html = (String) message.getContent();
                    result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
                }
            } catch (Exception e) {
            }
        }
        return result.trim();
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws Exception {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }
   /* public String getBodyTextOfMail(String subject) throws Exception {
        Message message = null;
        if (isMailReceivedWithSubject(subject)){

        }
            //message = this.message;
            //message = unseenPasswordMail;
        else
            throw new Exception("Email not Found with Subject : " + subject);

            String line;
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(unseenPasswordMail.getInputStream()));

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reporter.info("--------------"+buffer.toString());
            return buffer.toString();

    }*/

    public List<String> getAttachmentNameWithSubject(final String subject) throws Exception {
        //Message mail = getUnseenMailWithSubject(subject);
        Message mail = null;
        if (isMailReceivedWithSubject(subject))
            mail = unseenPasswordMail;
        else
            throw new Exception("Email not Found with Subject : " + subject);
        Multipart multipart = (Multipart) mail.getContent();
        List<String> attachmentsNameList = new ArrayList<>();
        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
                    !StringUtils.isNotBlank(bodyPart.getFileName())) {
                continue; // dealing with attachments only
            }
            attachmentsNameList.add(bodyPart.getFileName());
        }
        return attachmentsNameList;
    }

    public List<String> getAttachmentNameAndDownloadAttachments(String subject, String path) throws Exception {
        Message mail = null;
        if (isMailReceivedWithSubject(subject))
            mail = unseenPasswordMail;
        else
            throw new Exception("Email not Found with Subject : " + subject);
        Multipart multipart = (Multipart) mail.getContent();
        List<String> attachmentsNameList = new ArrayList<>();
        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
                    !StringUtils.isNotBlank(bodyPart.getFileName())) {
                continue; // dealing with attachments only
            }
            attachmentsNameList.add(bodyPart.getFileName());
            InputStream is = bodyPart.getInputStream();
            File f = new File(path + bodyPart.getFileName()); //use "./target/tmp/" for path
            FileOutputStream fos = new FileOutputStream(f);
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buf)) != -1) {
                fos.write(buf, 0, bytesRead);
            }
        }
        return attachmentsNameList;
    }

    private String getText(Part p) throws Exception {
        //   Message message = getUnseenMailWithSubject(subject);
        //    Part p = (Part)message.getContent();

        if (p.isMimeType("text*//*")) {
            String s = (String) p.getContent();
            if (p.isMimeType("text/html"))
                return s;
        }

        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart*//*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }

        return null;
    }
}
