package pojo;

/**
 * Created by Palash Kapoor on 3/28/2015.
 */
public class EventEmailTemplate {
    private String templateName;
    private String fromEmail;
    private String replyToEmail;
    private String messageSubject;
    private String messageBody;
    private String fileName;
    private String appendDropDownValue;
    private String currentUserOnlyCheckbox;
    private String enableEditorCheckbox;
    private String sendAsHTMLCheckbox;
    private String includeEventDisplayCheckbox;
    private String includeRegistrationCheckbox;
    private String useAsForgotPasswordCheckbox;
    private String attachItineraryPDFCheckbox;
    private String scheduleeEmailCheckBox;
    private String visibleToRadioButtonValue;
    private String speakerFileName;
    private String speakerTemplateName;
    private String speakerVisibleToRadioButtonValue;
    private String speakerCurrentUserOnlyCheckbox;
    private String speakerFromEmail;
    private String speakerReplyToEmail;
    private String speakerMessageSubject;
    private String speakerMessageBody;
    private String speakerAppendDropDownValue;
    private String speakerEnableEditorCheckbox;
    private String speakerSendAsHTMLCheckbox;
    private String speakerIncludeEventDisplayCheckbox;
    private String printableConfirmationName;
    private String printableConfirmationDescription;
    private String uploadDocName;
    private String uploadDocDesc;
    private String uploadDocFile;
    private String uploadDocImage;
    private String uploadDocReportType;
    private String uploadDocPreSortColumn;
    private String personalDocName;
    private String personalDocDesc;
    private String personalDocTemplateName;
    private String personalDocOutputFormatRadioButton;
    private String invoiceName;
    private String customBlockName;
    private String displayRuleName;

    public EventEmailTemplate(String templateName, String fromEmail, String replyToEmail, String messageSubject, String messageBody, String fileName, String appendDropDownValue, String currentUserOnlyCheckbox, String enableEditorCheckbox, String sendAsHTMLCheckbox, String includeEventDisplayCheckbox, String includeRegistrationCheckbox, String useAsForgotPasswordCheckbox, String attachItineraryPDFCheckbox, String scheduleeEmailCheckBox, String visibleToRadioButtonValue, String speakerFileName, String speakerTemplateName, String speakerVisibleToRadioButtonValue, String speakerCurrentUserOnlyCheckbox, String speakerFromEmail, String speakerReplyToEmail, String speakerMessageSubject, String speakerMessageBody, String speakerAppendDropDownValue, String speakerEnableEditorCheckbox, String speakerSendAsHTMLCheckbox, String speakerIncludeEventDisplayCheckbox, String printableConfirmationName, String printableConfirmationDescription, String uploadDocName, String uploadDocDesc, String uploadDocFile, String uploadDocImage, String uploadDocReportType, String uploadDocPreSortColumn, String personalDocName, String personalDocDesc, String personalDocTemplateName, String personalDocOutputFormatRadioButton, String invoiceName, String customBlockName, String displayRuleName) {
        this.templateName = templateName;
        this.fromEmail = fromEmail;
        this.replyToEmail = replyToEmail;
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
        this.fileName = fileName;
        this.appendDropDownValue = appendDropDownValue;
        this.currentUserOnlyCheckbox = currentUserOnlyCheckbox;
        this.enableEditorCheckbox = enableEditorCheckbox;
        this.sendAsHTMLCheckbox = sendAsHTMLCheckbox;
        this.includeEventDisplayCheckbox = includeEventDisplayCheckbox;
        this.includeRegistrationCheckbox = includeRegistrationCheckbox;
        this.useAsForgotPasswordCheckbox = useAsForgotPasswordCheckbox;
        this.attachItineraryPDFCheckbox = attachItineraryPDFCheckbox;
        this.scheduleeEmailCheckBox = scheduleeEmailCheckBox;
        this.visibleToRadioButtonValue = visibleToRadioButtonValue;
        this.speakerFileName = speakerFileName;
        this.speakerTemplateName = speakerTemplateName;
        this.speakerVisibleToRadioButtonValue = speakerVisibleToRadioButtonValue;
        this.speakerCurrentUserOnlyCheckbox = speakerCurrentUserOnlyCheckbox;
        this.speakerFromEmail = speakerFromEmail;
        this.speakerReplyToEmail = speakerReplyToEmail;
        this.speakerMessageSubject = speakerMessageSubject;
        this.speakerMessageBody = speakerMessageBody;
        this.speakerAppendDropDownValue = speakerAppendDropDownValue;
        this.speakerEnableEditorCheckbox = speakerEnableEditorCheckbox;
        this.speakerSendAsHTMLCheckbox = speakerSendAsHTMLCheckbox;
        this.speakerIncludeEventDisplayCheckbox = speakerIncludeEventDisplayCheckbox;
        this.printableConfirmationName = printableConfirmationName;
        this.printableConfirmationDescription = printableConfirmationDescription;
        this.uploadDocName = uploadDocName;
        this.uploadDocDesc = uploadDocDesc;
        this.uploadDocFile = uploadDocFile;
        this.uploadDocImage = uploadDocImage;
        this.uploadDocReportType = uploadDocReportType;
        this.uploadDocPreSortColumn = uploadDocPreSortColumn;
        this.personalDocName = personalDocName;
        this.personalDocDesc = personalDocDesc;
        this.personalDocTemplateName = personalDocTemplateName;
        this.personalDocOutputFormatRadioButton = personalDocOutputFormatRadioButton;
        this.invoiceName = invoiceName;
        this.customBlockName = customBlockName;
        this.displayRuleName = displayRuleName;
    }

    public EventEmailTemplate(String templateName, String fromEmail, String replyToEmail, String messageSubject, String messageBody, String appendDropDownValue) {
        this.templateName = templateName;
        this.fromEmail = fromEmail;
        this.replyToEmail = replyToEmail;
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
        this.appendDropDownValue = appendDropDownValue;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getReplyToEmail() {
        return replyToEmail;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getFileName() {
        return fileName;
    }

    public String getAppendDropDownValue() {
        return appendDropDownValue;
    }

    public String getCurrentUserOnlyCheckbox() {
        return currentUserOnlyCheckbox;
    }

    public String getEnableEditorCheckbox() {
        return enableEditorCheckbox;
    }

    public String getSendAsHTMLCheckbox() {
        return sendAsHTMLCheckbox;
    }

    public String getIncludeEventDisplayCheckbox() {
        return includeEventDisplayCheckbox;
    }

    public String getIncludeRegistrationCheckbox() {
        return includeRegistrationCheckbox;
    }

    public String getUseAsForgotPasswordCheckbox() {
        return useAsForgotPasswordCheckbox;
    }

    public String getAttachItineraryPDFCheckbox() {
        return attachItineraryPDFCheckbox;
    }

    public String getScheduleeEmailCheckBox() {
        return scheduleeEmailCheckBox;
    }

    public String getVisibleToRadioButtonValue() {
        return visibleToRadioButtonValue;
    }

    public String getSpeakerFileName() {
        return speakerFileName;
    }

    public String getSpeakerTemplateName() {
        return speakerTemplateName;
    }

    public String getSpeakerVisibleToRadioButtonValue() {
        return speakerVisibleToRadioButtonValue;
    }

    public String getSpeakerCurrentUserOnlyCheckbox() {
        return speakerCurrentUserOnlyCheckbox;
    }

    public String getSpeakerFromEmail() {
        return speakerFromEmail;
    }

    public String getSpeakerReplyToEmail() {
        return speakerReplyToEmail;
    }

    public String getSpeakerMessageSubject() {
        return speakerMessageSubject;
    }

    public String getSpeakerMessageBody() {
        return speakerMessageBody;
    }

    public String getSpeakerAppendDropDownValue() {
        return speakerAppendDropDownValue;
    }

    public String getSpeakerEnableEditorCheckbox() {
        return speakerEnableEditorCheckbox;
    }

    public String getSpeakerSendAsHTMLCheckbox() {
        return speakerSendAsHTMLCheckbox;
    }

    public String getSpeakerIncludeEventDisplayCheckbox() {
        return speakerIncludeEventDisplayCheckbox;
    }

    public String getPrintableConfirmationName() {
        return printableConfirmationName;
    }

    public String getPrintableConfirmationDescription() {
        return printableConfirmationDescription;
    }

    public String getUploadDocName() {
        return uploadDocName;
    }

    public String getUploadDocDesc() {
        return uploadDocDesc;
    }

    public String getUploadDocFile() {
        return uploadDocFile;
    }

    public String getUploadDocImage() {
        return uploadDocImage;
    }

    public String getUploadDocReportType() {
        return uploadDocReportType;
    }

    public String getUploadDocPreSortColumn() {
        return uploadDocPreSortColumn;
    }

    public String getPersonalDocName() {
        return personalDocName;
    }

    public String getPersonalDocDesc() {
        return personalDocDesc;
    }

    public String getPersonalDocTemplateName() {
        return personalDocTemplateName;
    }

    public String getPersonalDocOutputFormatRadioButton() {
        return personalDocOutputFormatRadioButton;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public String getCustomBlockName() {
        return customBlockName;
    }

    public String getDisplayRuleName() {
        return displayRuleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEmailTemplate that = (EventEmailTemplate) o;

        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (fromEmail != null ? !fromEmail.equals(that.fromEmail) : that.fromEmail != null) return false;
        if (replyToEmail != null ? !replyToEmail.equals(that.replyToEmail) : that.replyToEmail != null) return false;
        if (messageSubject != null ? !messageSubject.equals(that.messageSubject) : that.messageSubject != null)
            return false;
        if (messageBody != null ? !messageBody.equals(that.messageBody) : that.messageBody != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (appendDropDownValue != null ? !appendDropDownValue.equals(that.appendDropDownValue) : that.appendDropDownValue != null)
            return false;
        if (currentUserOnlyCheckbox != null ? !currentUserOnlyCheckbox.equals(that.currentUserOnlyCheckbox) : that.currentUserOnlyCheckbox != null)
            return false;
        if (enableEditorCheckbox != null ? !enableEditorCheckbox.equals(that.enableEditorCheckbox) : that.enableEditorCheckbox != null)
            return false;
        if (sendAsHTMLCheckbox != null ? !sendAsHTMLCheckbox.equals(that.sendAsHTMLCheckbox) : that.sendAsHTMLCheckbox != null)
            return false;
        if (includeEventDisplayCheckbox != null ? !includeEventDisplayCheckbox.equals(that.includeEventDisplayCheckbox) : that.includeEventDisplayCheckbox != null)
            return false;
        if (includeRegistrationCheckbox != null ? !includeRegistrationCheckbox.equals(that.includeRegistrationCheckbox) : that.includeRegistrationCheckbox != null)
            return false;
        if (useAsForgotPasswordCheckbox != null ? !useAsForgotPasswordCheckbox.equals(that.useAsForgotPasswordCheckbox) : that.useAsForgotPasswordCheckbox != null)
            return false;
        if (attachItineraryPDFCheckbox != null ? !attachItineraryPDFCheckbox.equals(that.attachItineraryPDFCheckbox) : that.attachItineraryPDFCheckbox != null)
            return false;
        if (scheduleeEmailCheckBox != null ? !scheduleeEmailCheckBox.equals(that.scheduleeEmailCheckBox) : that.scheduleeEmailCheckBox != null)
            return false;
        if (visibleToRadioButtonValue != null ? !visibleToRadioButtonValue.equals(that.visibleToRadioButtonValue) : that.visibleToRadioButtonValue != null)
            return false;
        if (speakerFileName != null ? !speakerFileName.equals(that.speakerFileName) : that.speakerFileName != null)
            return false;
        if (speakerTemplateName != null ? !speakerTemplateName.equals(that.speakerTemplateName) : that.speakerTemplateName != null)
            return false;
        if (speakerVisibleToRadioButtonValue != null ? !speakerVisibleToRadioButtonValue.equals(that.speakerVisibleToRadioButtonValue) : that.speakerVisibleToRadioButtonValue != null)
            return false;
        if (speakerCurrentUserOnlyCheckbox != null ? !speakerCurrentUserOnlyCheckbox.equals(that.speakerCurrentUserOnlyCheckbox) : that.speakerCurrentUserOnlyCheckbox != null)
            return false;
        if (speakerFromEmail != null ? !speakerFromEmail.equals(that.speakerFromEmail) : that.speakerFromEmail != null)
            return false;
        if (speakerReplyToEmail != null ? !speakerReplyToEmail.equals(that.speakerReplyToEmail) : that.speakerReplyToEmail != null)
            return false;
        if (speakerMessageSubject != null ? !speakerMessageSubject.equals(that.speakerMessageSubject) : that.speakerMessageSubject != null)
            return false;
        if (speakerMessageBody != null ? !speakerMessageBody.equals(that.speakerMessageBody) : that.speakerMessageBody != null)
            return false;
        if (speakerAppendDropDownValue != null ? !speakerAppendDropDownValue.equals(that.speakerAppendDropDownValue) : that.speakerAppendDropDownValue != null)
            return false;
        if (speakerEnableEditorCheckbox != null ? !speakerEnableEditorCheckbox.equals(that.speakerEnableEditorCheckbox) : that.speakerEnableEditorCheckbox != null)
            return false;
        if (speakerSendAsHTMLCheckbox != null ? !speakerSendAsHTMLCheckbox.equals(that.speakerSendAsHTMLCheckbox) : that.speakerSendAsHTMLCheckbox != null)
            return false;
        if (speakerIncludeEventDisplayCheckbox != null ? !speakerIncludeEventDisplayCheckbox.equals(that.speakerIncludeEventDisplayCheckbox) : that.speakerIncludeEventDisplayCheckbox != null)
            return false;
        if (printableConfirmationName != null ? !printableConfirmationName.equals(that.printableConfirmationName) : that.printableConfirmationName != null)
            return false;
        if (printableConfirmationDescription != null ? !printableConfirmationDescription.equals(that.printableConfirmationDescription) : that.printableConfirmationDescription != null)
            return false;
        if (uploadDocName != null ? !uploadDocName.equals(that.uploadDocName) : that.uploadDocName != null)
            return false;
        if (uploadDocDesc != null ? !uploadDocDesc.equals(that.uploadDocDesc) : that.uploadDocDesc != null)
            return false;
        if (uploadDocFile != null ? !uploadDocFile.equals(that.uploadDocFile) : that.uploadDocFile != null)
            return false;
        if (uploadDocImage != null ? !uploadDocImage.equals(that.uploadDocImage) : that.uploadDocImage != null)
            return false;
        if (uploadDocReportType != null ? !uploadDocReportType.equals(that.uploadDocReportType) : that.uploadDocReportType != null)
            return false;
        if (uploadDocPreSortColumn != null ? !uploadDocPreSortColumn.equals(that.uploadDocPreSortColumn) : that.uploadDocPreSortColumn != null)
            return false;
        if (personalDocName != null ? !personalDocName.equals(that.personalDocName) : that.personalDocName != null)
            return false;
        if (personalDocDesc != null ? !personalDocDesc.equals(that.personalDocDesc) : that.personalDocDesc != null)
            return false;
        if (personalDocTemplateName != null ? !personalDocTemplateName.equals(that.personalDocTemplateName) : that.personalDocTemplateName != null)
            return false;
        if (personalDocOutputFormatRadioButton != null ? !personalDocOutputFormatRadioButton.equals(that.personalDocOutputFormatRadioButton) : that.personalDocOutputFormatRadioButton != null)
            return false;
        if (invoiceName != null ? !invoiceName.equals(that.invoiceName) : that.invoiceName != null) return false;
        if (customBlockName != null ? !customBlockName.equals(that.customBlockName) : that.customBlockName != null)
            return false;
        return displayRuleName != null ? displayRuleName.equals(that.displayRuleName) : that.displayRuleName == null;

    }

    @Override
    public int hashCode() {
        int result = templateName != null ? templateName.hashCode() : 0;
        result = 31 * result + (fromEmail != null ? fromEmail.hashCode() : 0);
        result = 31 * result + (replyToEmail != null ? replyToEmail.hashCode() : 0);
        result = 31 * result + (messageSubject != null ? messageSubject.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (appendDropDownValue != null ? appendDropDownValue.hashCode() : 0);
        result = 31 * result + (currentUserOnlyCheckbox != null ? currentUserOnlyCheckbox.hashCode() : 0);
        result = 31 * result + (enableEditorCheckbox != null ? enableEditorCheckbox.hashCode() : 0);
        result = 31 * result + (sendAsHTMLCheckbox != null ? sendAsHTMLCheckbox.hashCode() : 0);
        result = 31 * result + (includeEventDisplayCheckbox != null ? includeEventDisplayCheckbox.hashCode() : 0);
        result = 31 * result + (includeRegistrationCheckbox != null ? includeRegistrationCheckbox.hashCode() : 0);
        result = 31 * result + (useAsForgotPasswordCheckbox != null ? useAsForgotPasswordCheckbox.hashCode() : 0);
        result = 31 * result + (attachItineraryPDFCheckbox != null ? attachItineraryPDFCheckbox.hashCode() : 0);
        result = 31 * result + (scheduleeEmailCheckBox != null ? scheduleeEmailCheckBox.hashCode() : 0);
        result = 31 * result + (visibleToRadioButtonValue != null ? visibleToRadioButtonValue.hashCode() : 0);
        result = 31 * result + (speakerFileName != null ? speakerFileName.hashCode() : 0);
        result = 31 * result + (speakerTemplateName != null ? speakerTemplateName.hashCode() : 0);
        result = 31 * result + (speakerVisibleToRadioButtonValue != null ? speakerVisibleToRadioButtonValue.hashCode() : 0);
        result = 31 * result + (speakerCurrentUserOnlyCheckbox != null ? speakerCurrentUserOnlyCheckbox.hashCode() : 0);
        result = 31 * result + (speakerFromEmail != null ? speakerFromEmail.hashCode() : 0);
        result = 31 * result + (speakerReplyToEmail != null ? speakerReplyToEmail.hashCode() : 0);
        result = 31 * result + (speakerMessageSubject != null ? speakerMessageSubject.hashCode() : 0);
        result = 31 * result + (speakerMessageBody != null ? speakerMessageBody.hashCode() : 0);
        result = 31 * result + (speakerAppendDropDownValue != null ? speakerAppendDropDownValue.hashCode() : 0);
        result = 31 * result + (speakerEnableEditorCheckbox != null ? speakerEnableEditorCheckbox.hashCode() : 0);
        result = 31 * result + (speakerSendAsHTMLCheckbox != null ? speakerSendAsHTMLCheckbox.hashCode() : 0);
        result = 31 * result + (speakerIncludeEventDisplayCheckbox != null ? speakerIncludeEventDisplayCheckbox.hashCode() : 0);
        result = 31 * result + (printableConfirmationName != null ? printableConfirmationName.hashCode() : 0);
        result = 31 * result + (printableConfirmationDescription != null ? printableConfirmationDescription.hashCode() : 0);
        result = 31 * result + (uploadDocName != null ? uploadDocName.hashCode() : 0);
        result = 31 * result + (uploadDocDesc != null ? uploadDocDesc.hashCode() : 0);
        result = 31 * result + (uploadDocFile != null ? uploadDocFile.hashCode() : 0);
        result = 31 * result + (uploadDocImage != null ? uploadDocImage.hashCode() : 0);
        result = 31 * result + (uploadDocReportType != null ? uploadDocReportType.hashCode() : 0);
        result = 31 * result + (uploadDocPreSortColumn != null ? uploadDocPreSortColumn.hashCode() : 0);
        result = 31 * result + (personalDocName != null ? personalDocName.hashCode() : 0);
        result = 31 * result + (personalDocDesc != null ? personalDocDesc.hashCode() : 0);
        result = 31 * result + (personalDocTemplateName != null ? personalDocTemplateName.hashCode() : 0);
        result = 31 * result + (personalDocOutputFormatRadioButton != null ? personalDocOutputFormatRadioButton.hashCode() : 0);
        result = 31 * result + (invoiceName != null ? invoiceName.hashCode() : 0);
        result = 31 * result + (customBlockName != null ? customBlockName.hashCode() : 0);
        result = 31 * result + (displayRuleName != null ? displayRuleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventEmailTemplate{" +
                "templateName='" + templateName + '\'' +
                ", fromEmail='" + fromEmail + '\'' +
                ", replyToEmail='" + replyToEmail + '\'' +
                ", messageSubject='" + messageSubject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", fileName='" + fileName + '\'' +
                ", appendDropDownValue='" + appendDropDownValue + '\'' +
                ", currentUserOnlyCheckbox='" + currentUserOnlyCheckbox + '\'' +
                ", enableEditorCheckbox='" + enableEditorCheckbox + '\'' +
                ", sendAsHTMLCheckbox='" + sendAsHTMLCheckbox + '\'' +
                ", includeEventDisplayCheckbox='" + includeEventDisplayCheckbox + '\'' +
                ", includeRegistrationCheckbox='" + includeRegistrationCheckbox + '\'' +
                ", useAsForgotPasswordCheckbox='" + useAsForgotPasswordCheckbox + '\'' +
                ", attachItineraryPDFCheckbox='" + attachItineraryPDFCheckbox + '\'' +
                ", scheduleeEmailCheckBox='" + scheduleeEmailCheckBox + '\'' +
                ", visibleToRadioButtonValue='" + visibleToRadioButtonValue + '\'' +
                ", speakerFileName='" + speakerFileName + '\'' +
                ", speakerTemplateName='" + speakerTemplateName + '\'' +
                ", speakerVisibleToRadioButtonValue='" + speakerVisibleToRadioButtonValue + '\'' +
                ", speakerCurrentUserOnlyCheckbox='" + speakerCurrentUserOnlyCheckbox + '\'' +
                ", speakerFromEmail='" + speakerFromEmail + '\'' +
                ", speakerReplyToEmail='" + speakerReplyToEmail + '\'' +
                ", speakerMessageSubject='" + speakerMessageSubject + '\'' +
                ", speakerMessageBody='" + speakerMessageBody + '\'' +
                ", speakerAppendDropDownValue='" + speakerAppendDropDownValue + '\'' +
                ", speakerEnableEditorCheckbox='" + speakerEnableEditorCheckbox + '\'' +
                ", speakerSendAsHTMLCheckbox='" + speakerSendAsHTMLCheckbox + '\'' +
                ", speakerIncludeEventDisplayCheckbox='" + speakerIncludeEventDisplayCheckbox + '\'' +
                ", printableConfirmationName='" + printableConfirmationName + '\'' +
                ", printableConfirmationDescription='" + printableConfirmationDescription + '\'' +
                ", uploadDocName='" + uploadDocName + '\'' +
                ", uploadDocDesc='" + uploadDocDesc + '\'' +
                ", uploadDocFile='" + uploadDocFile + '\'' +
                ", uploadDocImage='" + uploadDocImage + '\'' +
                ", uploadDocReportType='" + uploadDocReportType + '\'' +
                ", uploadDocPreSortColumn='" + uploadDocPreSortColumn + '\'' +
                ", personalDocName='" + personalDocName + '\'' +
                ", personalDocDesc='" + personalDocDesc + '\'' +
                ", personalDocTemplateName='" + personalDocTemplateName + '\'' +
                ", personalDocOutputFormatRadioButton='" + personalDocOutputFormatRadioButton + '\'' +
                ", invoiceName='" + invoiceName + '\'' +
                ", customBlockName='" + customBlockName + '\'' +
                ", displayRuleName='" + displayRuleName + '\'' +
                '}';
    }
}
