package dataprovider;


import org.sqlite.util.StringUtils;
import pageObjects.CommonActionsPage;
import pojo.*;

import java.util.*;

/**
 * Created by pkapoor on 02/01/14.
 * This Class is responsible for fetching all kind of Data from the Excel file
 * which is stored as list of maps in a Variable
 */
public class TestData extends CommonActionsPage {

    HashMap<String, String> testDataList;
    List<HashMap<String, String>> testDataList1;
    String uniqueCode = "A" + String.valueOf(System.currentTimeMillis());

    private final String uniqueKey = randomString(6);
    final String STRING_APPENDER = "H";
    final String MAIL_APPENDER = "@gmail.com";

    private String randomString(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public TestData(HashMap<String, String> listOfRaces) {
        this.testDataList = listOfRaces;
    }

    public TestData(List<HashMap<String, String>> listOfRaces) {
        this.testDataList1 = listOfRaces;
    }


    public List<Event> getEventDataList() {

        List<Event> eventList = new ArrayList<>();
        Event event;

        for (Map<String, String> testData : testDataList1) {
            event = new Event(testData.get("TITLE"), testData.get("EVENT_CODE"), testData.get("START_DATE"), testData.get("START_TIME")
                    , testData.get("END_DATE"), testData.get("END_TIME"), testData.get("TIMEZONE"), testData.get("ACCOUNT")
                    , testData.get("STATUS"), testData.get("NOTES"), testData.get("EXT_EVNT_ID"), testData.get("REG_INV"), testData.get("CURRENCY"));
            eventList.add(event);
        }
        return eventList;

    }

    public List<EventAttributes> getEventAttributes() {

        List<EventAttributes> eventList = new ArrayList<>();
        EventAttributes eventAttributes;

        for (Map<String, String> testData : testDataList1) {
            eventAttributes = new EventAttributes(testData.get("EVENT_AUDIENCE"), testData.get("EVENT_DELIVERY"), testData.get("EVENT_TYPE"), testData.get("SESSIONS_SETUP")
                    , testData.get("REGISTRANT_GOAL"), testData.get("ATTENDANCE_GOAL"));
            eventList.add(eventAttributes);
        }
        return eventList;

    }

    public List<AddPlugins> getAddPluginList() {

        List<AddPlugins> pluginsList = new ArrayList<>();
        AddPlugins addPlugins;

        for (Map<String, String> testData : testDataList1) {
            addPlugins = new AddPlugins(testData.get("PLUGINNAME"), testData.get("USERID"), testData.get("PASSWORD"), testData.get("APIURL"));
            pluginsList.add(addPlugins);
        }
        return pluginsList;

    }

    public List<AddJobs> getAddJobsList() {

        List<AddJobs> addJobsList = new ArrayList<>();
        AddJobs addJobs;

        for (Map<String, String> testData : testDataList1) {
            addJobs = new AddJobs(testData.get("APPLICATION"), testData.get("JOBNAME"), testData.get("JOBDESCRIPTION"), testData.get("PROFILEDUPLICATION"),
                    testData.get("ATTENDEETYPE"), testData.get("REGSTATUS"), testData.get("REGSTATUSOVERWRITE"), testData.get("LISTNAME"),
                    testData.get("RETREIVALPAGE"), testData.get("STARTINGPAGE"), testData.get("ENDINGPAGE"), testData.get("AGENDASTATUS"),
                    testData.get("REGSESSIONSTATUS"), testData.get("SESSIONSTATUS"), testData.get("CAMPAIGNID"), testData.get("ENDDATE"), testData.get("EMAIL"));
            addJobsList.add(addJobs);
        }
        return addJobsList;

    }


    public List<AddFormLogicRulesPageData> getFormLogicRulesDataList() {
        List<AddFormLogicRulesPageData> addFormLogicRulesPageDataList = new ArrayList<>();
        AddFormLogicRulesPageData addFormLogicRulesData;
        for (Map<String, String> formLogicRulesData : testDataList1) {
            addFormLogicRulesData = new AddFormLogicRulesPageData(formLogicRulesData.get("LOGIC_NAME"), formLogicRulesData.get("ACTIONS_TYPE"), formLogicRulesData.get("QUESTION_TITLE"), formLogicRulesData.get("CONDITIONS_TYPE"));
            addFormLogicRulesPageDataList.add(addFormLogicRulesData);
        }
        return addFormLogicRulesPageDataList;
    }


    public List<AccountSettings> getAccountSettingsDataList() {

        List<AccountSettings> accountSettingsList = new ArrayList<>();
        AccountSettings accountSettings;

        for (Map<String, String> subAccountData : testDataList1) {
            accountSettings = new AccountSettings(uniqueCode, subAccountData.get("SUPPORT_REP"), subAccountData.get("PARENT_ACCOUNT"), subAccountData.get("CUST_ID_NUM"),
                    true, uniqueCode, subAccountData.get("PRIMARY_CONTACT"), subAccountData.get("EMAIL"));
            accountSettingsList.add(accountSettings);
        }
        return accountSettingsList;
    }

    public AddAgenda getAgendaData() {
        AddAgenda addAgenda;

        Map<String, String> testData = testDataList;

        addAgenda = new AddAgenda(testData.get("AGENDA_TYPE"), testData.get("AGENDA_NAME"), testData.get("UNIQUE_CODE") + String.valueOf(System.currentTimeMillis()),
                testData.get("AGENDA_STARTDATE"), testData.get("AGENDA_STARTTIME"), testData.get("AGENDA_ENDDATE"),
                testData.get("AGENDA_ENDTIME"), testData.get("SORT_ORDER"), testData.get("AGENDA_CEU"),
                testData.get("CAPACITY"), testData.get("MAX_ORDER"), testData.get("POINTS"),
                testData.get("TAGS"), testData.get("LOCATION"),
                testData.get("TRACK"), testData.get("GROUP"), testData.get("LABEL"), testData.get("DESCRIPTION"), testData.get("USER_NOTES"), testData.get("CLASSIFICATION"));
        return addAgenda;
    }

    public AddAgenda getAgendaMerchandiseData() {
        AddAgenda addAgenda;

        Map<String, String> testData = testDataList;

        addAgenda = new AddAgenda(testData.get("AGENDA_TYPE"), testData.get("AGENDA_NAME"), testData.get("UNIQUE_CODE") + String.valueOf(System.currentTimeMillis()),
                testData.get("SORT_ORDER"),
                testData.get("CAPACITY"), testData.get("MAX_ORDER"), testData.get("GROUP"), testData.get("LABEL"), testData.get("DESCRIPTION"), testData.get("USER_NOTES"), testData.get("CLASSIFICATION"));
        return addAgenda;
    }

    public AddAgenda getAgendaFeesDiscountData() {
        AddAgenda addAgenda;

        Map<String, String> testData = testDataList;

        addAgenda = new AddAgenda(testData.get("AGENDA_TYPE"), testData.get("AGENDA_NAME"), testData.get("UNIQUE_CODE") + String.valueOf(System.currentTimeMillis()),
                testData.get("SORT_ORDER"),
                testData.get("LABEL"), testData.get("DESCRIPTION"), testData.get("USER_NOTES"));
        return addAgenda;
    }

    public FeeStructureData getAgendaFeeDetails() {
        FeeStructureData feeStructureData;

        Map<String, String> testData = testDataList;

        feeStructureData = new FeeStructureData(testData.get("FEE_TYPE"), testData.get("TAX_RULES"), testData.get("DISCOUNT_RULES"), testData.get("EXPIRATION_DATE"),
                testData.get("TIME"), testData.get("FEE_CODE") + String.valueOf(System.currentTimeMillis()), testData.get("DISPLAY_FOR_REG_FORM"),
                testData.get("AMOUNT"), testData.get("GL_AMOUNT"), testData.get("PERCENTAGE"), testData.get("CANCELLATION_FEE"));
        return feeStructureData;
    }


    public FeeStructureData getAgendaOtherFeesDetails() {
        FeeStructureData feeStructureData;

        Map<String, String> testData = testDataList;

        feeStructureData = new FeeStructureData(testData.get("FEE_TYPE"), testData.get("DISCOUNT_RULES"),
                testData.get("FEE_CODE") + String.valueOf(System.currentTimeMillis()), testData.get("DISPLAY_FOR_REG_FORM"),
                testData.get("AMOUNT"), testData.get("GL_AMOUNT"), testData.get("PERCENTAGE"));
        return feeStructureData;
    }

    public Event getEventData() {

        Event event;

        Map<String, String> testData = testDataList;

        event = new Event(testData.get("TITLE"), testData.get("EVENT_CODE"), testData.get("START_DATE"), testData.get("START_TIME"), testData.get("END_DATE"),
                testData.get("END_TIME"), testData.get("TIMEZONE"), testData.get("ACCOUNT"), testData.get("STATUS"), testData.get("NOTES"), testData.get("EXT_EVNT_ID"),
                testData.get("REG_INV"), testData.get("CURRENCY"));
        return event;
    }

    public AccountSettings getAccountSettingsData() {

        AccountSettings accountSettings;

        Map<String, String> subAccountData = testDataList;

        accountSettings = new AccountSettings(uniqueCode, subAccountData.get("SUPPORT_REP"), subAccountData.get("PARENT_ACCOUNT"), subAccountData.get("CUST_ID_NUM"),
                true, uniqueCode, subAccountData.get("PRIMARY_CONTACT"), subAccountData.get("EMAIL"));
        return accountSettings;
    }

    public PrivacyConfigurationData getPrivacyConfigurationData() {

        PrivacyConfigurationData privacyConfigurationData;

        Map<String, String> testData = testDataList;

        privacyConfigurationData = new PrivacyConfigurationData(testData.get("POLICY_TYPE"), testData.get("CONFIG_NAME"), testData.get("START_DATE"), testData.get("END_DATE"), testData.get("SERVICE_AUTH_TYPE"),
                testData.get("SERVICE_URL"), testData.get("CLIENT_ID"), testData.get("CLIENT_SECRET"), testData.get("TOKEN_URL"), testData.get("RESOURCE_URL"), testData.get("WAIT_MESSAGE"),
                testData.get("SERVICE_ERROR_MESSAGE"), testData.get("EXTERNAL_ID_KEY"), testData.get("TRIGGER_FIELD"), testData.get("TRIGGER_VALUE"), testData.get("CERTAIN_FIELD"), testData.get("TARGET_FIELD"));
        return privacyConfigurationData;
    }
    public FormPreviewRegistrantDetails getRegistrationDetailsData() {
        FormPreviewRegistrantDetails formPreviewRegistrantDetails;

        Map<String, String> registrantDetails = testDataList;

        formPreviewRegistrantDetails = new FormPreviewRegistrantDetails(registrantDetails.get("FIRSTNAME"), registrantDetails.get("LASTNAME"), registrantDetails.get("EMAIL"),
                registrantDetails.get("OCCUPATION"), registrantDetails.get("COMPANYNAME"), registrantDetails.get("ADDRESS_LINE1")
                , registrantDetails.get("ADDRESS_LINE2"), registrantDetails.get("CITY"), registrantDetails.get("STATE")
                , registrantDetails.get("ZIPCODE"), registrantDetails.get("COUNTRY"), registrantDetails.get("PHONENO"));
        return formPreviewRegistrantDetails;
    }

    public List<CreateRegistrationData> getCreateRegistrationData() {

        List<CreateRegistrationData> registrationDataList = new ArrayList<>();
        CreateRegistrationData createRegistrationData;
        ContactInformation contactInformation;

        AssistantInfo assistantInfo;
        ContactDetails contactDetails;

        Address mailingAddressDetail;
        AdditionalInfo mailingAddressAdditionalInfo;
        MailingAddress mailingAddress;

        Address billingAddress;
        BillingInfo billingInfo;

        Address shippingAddress;
        ShippingInfo shippingInfo;

        for (Map<String, String> testData : testDataList1) {
            /*contactInformation = new ContactInformation(testData.get("FIRST_NAME"), testData.get("LAST_NAME"),
                    testData.get("EMAIL"), testData.get("POSITION"), testData.get("ORGANIZATION"), testData.get("USER_NAME"),
                    testData.get("EXTERNAL_PROFILE_ID"), "", testData.get("PREFIX"), testData.get("BADGE_NAME"),
                    testData.get("GENDER"), testData.get("DATE_OF_BIRTH"), testData.get("PASSWORD"));*/
            contactInformation = new ContactInformation(testData.get("EVENT_CODE"), testData.get("FIRST_NAME"), testData.get("LAST_NAME"),
                    testData.get("EMAIL"), testData.get("POSITION"), testData.get("ORGANIZATION"), testData.get("USER_NAME"),
                    testData.get("EXTERNAL_PROFILE_ID"), "", testData.get("PREFIX"), testData.get("MI"), testData.get("SUFFIX"), testData.get("BADGE_NAME"),
                    testData.get("GENDER"), testData.get("DATE_OF_BIRTH"), testData.get("PASSWORD"));

            assistantInfo = new AssistantInfo(testData.get("ASSISTANT_NAME"), testData.get("ASSISTANT_EMAIL"),
                    testData.get("ASSISTANT_PHONE"));

            contactDetails = new ContactDetails(testData.get("PHONE"), testData.get("FAX"), testData.get("MOBILE"),
                    testData.get("OTHER_PHONE"), testData.get("WEB_ADDRESS"), testData.get("FACEBOOK"), testData.get("LINKEDIN"),
                    assistantInfo, testData.get("GOOGLE"), testData.get("TWITTER"));

            mailingAddressDetail = new Address(testData.get("MAILING_ADDRESS"), testData.get("MAILING_ADDRESS_LINE_2"),
                    testData.get("MAILING_ADDRESS_LINE_3"), testData.get("MAILING_COUNTRY"), testData.get("MAILING_STATE"),
                    "", testData.get("MAILING_CITY"), testData.get("MAILING_POSTAL_CODE"));

            mailingAddressAdditionalInfo = new AdditionalInfo(testData.get("ADDITIONAL_NAME"), testData.get("ADDITIONAL_EMAIL"),
                    testData.get("ADDITIONAL_PHONE"));

            mailingAddress = new MailingAddress(mailingAddressDetail, mailingAddressAdditionalInfo);

            billingAddress = new Address(testData.get("BILLING_ADDRESS"), testData.get("BILLING_ADDRESS_LINE_2"),
                    testData.get("BILLING_ADDRESS_LINE_3"), testData.get("BILLING_COUNTRY"), testData.get("BILLING_STATE"),
                    "", testData.get("BILLING_CITY"), testData.get("BILLING_POSTAL_CODE"));

            billingInfo = new BillingInfo(testData.get("BILL_TO_NAME"), testData.get("BILL_TO_ORGANIZATION"), billingAddress);

            shippingAddress = new Address(testData.get("SHIPPING_ADDRESS"), testData.get("SHIPPING_ADDRESS_LINE_2"),
                    testData.get("SHIPPING_ADDRESS_LINE_3"), testData.get("SHIPPING_COUNTRY"), testData.get("SHIPPING_STATE"),
                    "", testData.get("SHIPPING_CITY"), testData.get("SHIPPING_POSTAL_CODE"));

            shippingInfo = new ShippingInfo(testData.get("SHIP_TO_NAME"), testData.get("SHIP_TO_ORGANIZATION"), shippingAddress);


            createRegistrationData = new CreateRegistrationData(contactInformation, contactDetails, Boolean.valueOf(testData.get("CC_EMAIL_TO_ASSISTANT")),
                    mailingAddress, Boolean.valueOf(testData.get("CC_EMAIL_TO_ASSISTANT")), billingInfo, shippingInfo,
                    testData.get("PRIMARY_LOCATION"), Boolean.valueOf(testData.get("ENABLE_MANUAL_OVERRIDE")), testData.get("FROM_DATE"),
                    testData.get("UNTIL_DATE"), testData.get("FROM_TIME"), testData.get("UNTIL_TIME"),
                    testData.get("ATTENDEE_TYPE"), testData.get("STATUS"), testData.get("PROPERTIES"), testData.get("USER_NOTES"));
            registrationDataList.add(createRegistrationData);
        }
        return registrationDataList;
    }

    public List<AddTags> getTagsData() {
        List<AddTags> addTagsList = new ArrayList<>();
        AddTags addTags;

        for (Map<String, String> tagsData : testDataList1) {
            addTags = new AddTags(tagsData.get("TAGS_NAME"), tagsData.get("TAGS_LABEL"), tagsData.get("TAG_OBJECT"));
            addTagsList.add(addTags);
        }
        return addTagsList;
    }

    public List<AddReviewer> getAddReviewerData() {
        List<AddReviewer> addReviewerList = new ArrayList<>();
        AddReviewer addReviewer;

        for (Map<String, String> tagsData : testDataList1) {
            addReviewer = new AddReviewer(tagsData.get("firstName"), tagsData.get("lastName"), tagsData.get("email"),
                    tagsData.get("userName"), tagsData.get("password"), tagsData.get("track"), tagsData.get("tier"));
            addReviewerList.add(addReviewer);
        }
        return addReviewerList;
    }

    public List<FormPreviewRegistrantDetails> getFormRegistrationDetails() {
        List<FormPreviewRegistrantDetails> formPreviewRegistrantDetailsList = new ArrayList<>();
        FormPreviewRegistrantDetails formPreviewRegistrantDetails;
        for (Map<String, String> registrantDetails : testDataList1) {
            formPreviewRegistrantDetails = new FormPreviewRegistrantDetails(registrantDetails.get("FIRSTNAME"), registrantDetails.get("LASTNAME"), registrantDetails.get("EMAIL"),
                    registrantDetails.get("OCCUPATION"), registrantDetails.get("COMPANYNAME"), registrantDetails.get("ADDRESS_LINE1")
                    , registrantDetails.get("ADDRESS_LINE2"), registrantDetails.get("CITY"), registrantDetails.get("STATE")
                    , registrantDetails.get("ZIPCODE"), registrantDetails.get("COUNTRY"), registrantDetails.get("PHONENO"));
            formPreviewRegistrantDetailsList.add(formPreviewRegistrantDetails);
        }
        return formPreviewRegistrantDetailsList;
    }

    public ExportAgenda getExportAgendaData() {

        ExportAgenda exportAgenda;

        Map<String, String> exportData = testDataList;

        exportAgenda = new ExportAgenda(exportData.get("CategoryType"), exportData.get("FileType"), exportData.get("FileName"));
        return exportAgenda;
    }

    public SectionHeader getSectionHeaderData() {
        SectionHeader sectionHeaderData;
        Map<String, String> testData = testDataList;
        sectionHeaderData = new SectionHeader(testData.get("TEXT_ABOVE_HEADER"), testData.get("HEADER_TEXT"), testData.get("TEXT_BELOW_HEADER"));
        return sectionHeaderData;
    }

    public AddFormData getFormData() {
        AddFormData addFormData;
        Map<String, String> testAddFormData = testDataList;
        addFormData = new AddFormData(testAddFormData.get("FORM_NAME"), testAddFormData.get("SUBTITLE"), testAddFormData.get("CC"), testAddFormData.get("HYPERLINK_LABEL"), testAddFormData.get("GOOGLE_ANALYTICS_TRACKING_ID"), testAddFormData.get("REG_STATUS"), testAddFormData.get("USER_NOTES"));
        return addFormData;
    }

    public AddFormEntryPageData getFormEntryPageData() {
        AddFormEntryPageData addFormEntryPageData;
        Map<String, String> testFormEntryPageData = testDataList;
        addFormEntryPageData = new AddFormEntryPageData(testFormEntryPageData.get("DATA_FIELD"));
        return addFormEntryPageData;
    }

    public TravelConfigurationData getTravelConfigurationData() {

        TravelConfigurationData travelConfigurationData;

        Map<String, String> travelData = testDataList;

        travelConfigurationData = new TravelConfigurationData(travelData.get("TRANSFER_TIME"), travelData.get("BOOKING_STATUS"),
                travelData.get("PAYMENT_CODE"), travelData.get("TRAVEL_TYPE"), travelData.get("TRAVEL_ACTION_CODE"), travelData.get("MODE_TRANSPORTATION_TYPE")
                , travelData.get("TRANSPORTATION_TYPE"), travelData.get("EVENT_AIRPORTS"));
        return travelConfigurationData;
    }

    public AddFormQuestionsData getFormQuestionsData() {
        AddFormQuestionsData addFormQuestionsData;
        Map<String, String> formQuestionsData = testDataList;
        addFormQuestionsData = new AddFormQuestionsData(formQuestionsData.get("QUESTION_SECTION_NAME"));
        return addFormQuestionsData;
    }

    public AddFormTravelData getFormTravelData() {
        AddFormTravelData addFormTravelData;
        Map<String, String> travelQuestionData = testDataList;
        addFormTravelData = new AddFormTravelData(travelQuestionData.get("TRAVEL_CUSTOM_QUESTION"));
        return addFormTravelData;
    }

    public AddFormAddlRegsPageData getFormAddlRegsData() {
        AddFormAddlRegsPageData addFormAddlRegsPageData;
        Map<String, String> addlRegsData = testDataList;
        addFormAddlRegsPageData = new AddFormAddlRegsPageData(addlRegsData.get("INSTRUCTION_TEXT"));
        return addFormAddlRegsPageData;
    }

    public AddFormCustomHTMLData getFormCustomHTMLData() {
        AddFormCustomHTMLData addFormCustomHTMLData;
        Map<String, String> testData = testDataList;
        addFormCustomHTMLData = new AddFormCustomHTMLData(testData.get("CUSTOM_HTML_SECTION_NAME"));
        return addFormCustomHTMLData;
    }

    public TaskDetailsData getTaskDetailsData() {
        TaskDetailsData taskDetailsData;
        Map<String, String> testTaskData = testDataList;
        taskDetailsData = new TaskDetailsData(testTaskData.get("SUBJECT"), testTaskData.get("DUE_DATE"), testTaskData.get("DUE_TIME"), testTaskData.get("START_DATE"), testTaskData.get("STATUS"), testTaskData.get("PRIORITY"), testTaskData.get("REMINDER"), testTaskData.get("REMINDER_DATE"), testTaskData.get("REMINDER_TIME"), testTaskData.get("NOTES"), testTaskData.get("USER_NAME"));
        return taskDetailsData;
    }

    public DocumentDetailsData getDocumentDetailsData() {
        DocumentDetailsData documentDetailsData;
        Map<String, String> testDocumentData = testDataList;
        documentDetailsData = new DocumentDetailsData(testDocumentData.get("DOC_NAME"), testDocumentData.get("DOC_TYPE"), testDocumentData.get("DESCRIPTION"), testDocumentData.get("FILE_HREF"));
        return documentDetailsData;
    }

    public GroupDetailsData getGroupDetailsData() {
        GroupDetailsData groupDetailsData;
        Map<String, String> testGroupData = testDataList;
        groupDetailsData = new GroupDetailsData(testGroupData.get("GROUP_NAME"), testGroupData.get("GROUP_CODE"), testGroupData.get("DESCRIPTION"), testGroupData.get("NOTES"), testGroupData.get("ATTENDEE_TYPE"));
        return groupDetailsData;
    }

    public GroupCustomFieldData getGroupCustomFieldsDetailsData() {
        GroupCustomFieldData groupCustomFieldData;
        Map<String, String> testGroupData = testDataList;
        groupCustomFieldData = new GroupCustomFieldData(testGroupData.get("CUSTOM_FIELD_NAME"));
        return groupCustomFieldData;
    }

    public EventQuestionData getEventQuestionDetailsData() {
        EventQuestionData eventQuestionData;
        Map<String, String> testEventQuestionData = testDataList;
        eventQuestionData = new EventQuestionData(testEventQuestionData.get("QUESTION_TYPE"), testEventQuestionData.get("NAME"), testEventQuestionData.get("CODE"), testEventQuestionData.get("DISPLAY_REGFORM"), testEventQuestionData.get("ERROR_MESSAGE"), testEventQuestionData.get("ANSWER_OPTIONS"), testEventQuestionData.get("DEFAULT_ANSWER"), testEventQuestionData.get("INPUTFIELD_SIZE"), testEventQuestionData.get("MINIMUM_CHARACTERS"), testEventQuestionData.get("MAXIMUM_CHARACTERS"), testEventQuestionData.get("SHOW_ONLINE"), testEventQuestionData.get("QUESTION_ANSWERS"), testEventQuestionData.get("QUESTION_FONT"), testEventQuestionData.get("ANSWERS_FONT"), testEventQuestionData.get("HORIZONTAL_QF"), testEventQuestionData.get("HORIZONTAL_AF"), testEventQuestionData.get("VERTICAL_QF"), testEventQuestionData.get("VERTICAL_AF"));
        return eventQuestionData;
    }

    public AddRolesData getRolesDetailsData() {
        AddRolesData addRolesData;
        Map<String, String> testRolesData = testDataList;
        addRolesData = new AddRolesData(testRolesData.get("ROLE"), testRolesData.get("SORT_ORDER"));
        return addRolesData;
    }

    public List<AddJobFunctionData> getJobFunctionDetailsData() {
        List<AddJobFunctionData> addJobFunctionDataList = new ArrayList<>();
        AddJobFunctionData addJobFunctionData;
        for (Map<String, String> testJobFunctionsData : testDataList1) {
            addJobFunctionData = new AddJobFunctionData(testJobFunctionsData.get("JOB_FUNCTION_TITLE"));
            addJobFunctionDataList.add(addJobFunctionData);
        }
        return addJobFunctionDataList;
    }

    public List<AddIndustryData> getIndustryData() {
        List<AddIndustryData> addIndustryDataList = new ArrayList<>();
        AddIndustryData addIndustryData;
        for (Map<String, String> testIndustryData : testDataList1) {
            addIndustryData = new AddIndustryData(testIndustryData.get("INDUSTRY_NAME"));
            addIndustryDataList.add(addIndustryData);
        }
        return addIndustryDataList;
    }

    public AddEventContactData getRegistrationContactData() {

        AddEventContactData addRegistrationContact;

        Map<String, String> registrationContactData = testDataList;

        addRegistrationContact = new AddEventContactData(registrationContactData.get("NAME"), registrationContactData.get("EMAIL"),
                registrationContactData.get("ORGANIZATION"), registrationContactData.get("URL"),
                registrationContactData.get("PHONE"), registrationContactData.get("FAX"), registrationContactData.get("TOLL_FREE_NUMBER"),
                registrationContactData.get("ADDRESS_LINE1"), registrationContactData.get("ADDRESS_LINE2"),
                registrationContactData.get("ADDRESS_LINE3"), registrationContactData.get("CITY"),
                registrationContactData.get("STATE"), registrationContactData.get("ZIP_CODE"),
                registrationContactData.get("NON_US_PROVIENCE"), registrationContactData.get("COUNTRY"),
                registrationContactData.get("ACCOUNT"), registrationContactData.get("USER_NOTES"));
        return addRegistrationContact;
    }

    public CustomStatusData getCustomStatusesData() {

        CustomStatusData customStatusData;

        Map<String, String> registrationContactData = testDataList;

        customStatusData = new CustomStatusData(registrationContactData.get("NAME"), registrationContactData.get("SORT_ORDER"),
                registrationContactData.get("STATUS_GROUP"), registrationContactData.get("GROUP_NAME"),
                registrationContactData.get("DESCRIPTION"), registrationContactData.get("STATUS"));
        return customStatusData;
    }

    public AttendeeTypeData getAttendeeTypeData() {
        AttendeeTypeData attendeeTypeData;

        Map<String, String> attendeeData = testDataList;

        attendeeTypeData = new AttendeeTypeData(attendeeData.get("ATTENDEE_NAME"), attendeeData.get("ATTENDEE_CODE"),
                attendeeData.get("SORT_ORDER"), attendeeData.get("DISPLAY_REG_FORM"), attendeeData.get("PASS_CODE"),
                attendeeData.get("CAPACITY"), attendeeData.get("DEFAULT_STATUS"), attendeeData.get("ATTENDEE_GROUP"),
                attendeeData.get("ADD_NEW_TYPE"), attendeeData.get("CONFIRMATION_HEADER"), attendeeData.get("CONFIRMATION_FOOTER"),
                attendeeData.get("REGISTRATION_FEE_TYPE"), attendeeData.get("REGISTRATION_TAX_RULES"),
                attendeeData.get("REGISTRATION_DISCOUNT_RULES"), attendeeData.get("EXPIRY_DATE"), attendeeData.get("EXPIRY_TIME"),
                attendeeData.get("FEE_CODE"), attendeeData.get("DISPLAY_FEE_REG_FORM"), attendeeData.get("REGISTRATION_FEE_AMOUNT"),
                attendeeData.get("REGISTRATION_GL_ACCOUNT"), attendeeData.get("CANCELLATION_FEE_TYPE"),
                attendeeData.get("CANCELLATION_EXPIRY_DATE"), attendeeData.get("CANCELLATION_EXPIRY_TIME"),
                attendeeData.get("CANCELLATION_FEE_CODE"), attendeeData.get("CANCELLATION_DISPLAY_FEE_REG_FORM"),
                attendeeData.get("CANCELLATION_FEE_AMOUNT"), attendeeData.get("CANCELLATION_GL_ACCOUNT"),
                attendeeData.get("AVAILABLE_HOTEL"), attendeeData.get("EXHIBITOR_MANAGEMENT"));
        return attendeeTypeData;
    }

    public AddPackageData getAddPackageData() {
        AddPackageData addPackageData;

        Map<String, String> packageData = testDataList;

        addPackageData = new AddPackageData(packageData.get("PACKAGE_NAME"), packageData.get("PACKAGE_CODE"),
                packageData.get("PACKAGE_MULTIPLIER"));
        return addPackageData;
    }


    public CustomQuestionDataSelect getCustomQuestionData() {
        CustomQuestionDataSelect customQuestionData;

        Map<String, String> questionData = testDataList;

        customQuestionData = new CustomQuestionDataSelect(questionData.get("QUESTION_TYPE"), questionData.get("QUESTION_NAME"), questionData.get("QUESTION_CODE"),
                questionData.get("DISPLAY_REG_FORM"), questionData.get("ERROR_MESSAGE"), questionData.get("ANSWER_OPTIONS"), questionData.get("SHOW_ONLINE"), questionData.get("QUESTION_ANSWER"),
                questionData.get("QUESTION_FONT"), questionData.get("QUESTION_HORIZONTAL_FORM"), questionData.get("QUESTION_VERTICAL_FORM"), questionData.get("ANSWER_FONT"),
                questionData.get("ANSWER_HORIZONTAL_FORM"), questionData.get("ANSWER_VERTICAL_FORM"), questionData.get("CLASS"));
        return customQuestionData;
    }


    public AddSuplierData getSupplierDetailInfo() {
        AddSuplierData supplierDetailInfo;
        Map<String, String> testData = testDataList;
        supplierDetailInfo = new AddSuplierData(testData.get("SUPPLIER_TYPE"), testData.get("SUPPLIER_NAME"), testData.get("SUPPLIER_UNIQUE_CODE"), testData.get("SUPPLIER_COUNTRY"), testData.get("SUPPLIER_STATE"));
        return supplierDetailInfo;
    }

    public SupplierData getSupplierData() {

        SupplierData supplierData;

        Map<String, String> supplierTestData = testDataList;

        supplierData = new SupplierData(supplierTestData.get("SUPPLIER_NAME"), supplierTestData.get("GL_ACCOUNT"), supplierTestData.get("CONTRACT_AMOUNT"), supplierTestData.get("ACTUAL_AMOUNT"));
        return supplierData;
    }
    public RegistrationEmailData getRegistrationEmailData() {
        RegistrationEmailData registrationEmailData;

        Map<String, String> questionData = testDataList;

        registrationEmailData = new RegistrationEmailData(questionData.get("EMAI_TEMPELATE"), questionData.get("FROM"),
                questionData.get("TO"), questionData.get("REPLY_TO"),
                questionData.get("CC"), questionData.get("BCC"), questionData.get("APPEND"), questionData.get("SUBJECT"),
                questionData.get("MESSAGE"), questionData.get("ATTACHEMENT"));
        return registrationEmailData;
    }

    public RegistrationAgendaData getRegistrationAgendaData() {
        RegistrationAgendaData registrationAgendaData;

        Map<String, String> questionData = testDataList;

        registrationAgendaData = new RegistrationAgendaData(questionData.get("AGENDA_ITEM"), questionData.get("QUANTITY"),
                questionData.get("STATUS"));
        return registrationAgendaData;
    }

    public MobileSettingsData getMobileSettingsData() {

        MobileSettingsData mobileSettingsData;

        Map<String, String> settingsData = testDataList;

        mobileSettingsData = new MobileSettingsData(settingsData.get("SETTINGS_NAME"), settingsData.get("DATE_DISPLAY_FORMAT"), settingsData.get("TIME_DISPLAY_FORMAT"),
                settingsData.get("HOME_SCREEN_LABEL"), settingsData.get("LOGIN_TIME_OUT"), settingsData.get("LOGIN_TIME_OUT_UNIT"), settingsData.get("WEB_URL"));
        return mobileSettingsData;
    }

    public GeneralColorCodeData getGeneralColorCodeData() {

        GeneralColorCodeData generalColorCodeData;

        Map<String, String> testData = testDataList;

        generalColorCodeData = new GeneralColorCodeData(testData.get("NAVIGATION_BACKGROUND_COLOR_CODE"), testData.get("LOGO_BACKGROUND_COLOR_CODE"), testData.get("NAVIGATION_BAR_COLOR_CODE"),
                testData.get("BODY_BACKGROUND_COLOR_CODE"), testData.get("BODY_TEXT"), testData.get("BANNER_URL"));
        return generalColorCodeData;
    }

    public AppointmentsColorCodeData getAppointmentsColorCodeData() {

        AppointmentsColorCodeData appointmentsColorCodeData;

        Map<String, String> testData = testDataList;

        appointmentsColorCodeData = new AppointmentsColorCodeData(testData.get("SELF_SCHEDULED_COLOR_CODE"), testData.get("MATCHED_APPOINTMENT_COLOR_CODE"), testData.get("BLOCKED_TIME_COLOR_CODE"),
                testData.get("AVAILABLE_TIME_COLOR_CODE"), testData.get("AGENDA_SESSION_COLOR_CODE"), testData.get("SSA_REQUEST_SENT_COLOR_CODE"), testData.get("SSA_REQUEST_RECIEVED_COLOR_CODE"),
                testData.get("PRIMARY_BUTTON_COLOR_CODE"), testData.get("SECONDARY_BUTTON_COLOR_CODE"));
        return appointmentsColorCodeData;
    }

    public HotelData getCreateHotelData() {

        HotelData hotelData;
        Map<String, String> testData = testDataList;
        hotelData = new HotelData(testData.get("HOTEL_CODE"),
                testData.get("ROOM_TYPE_CODE"), testData.get("START_DATE"),
                testData.get("END_DATE"), testData.get("RATE"), testData.get("INVENTORY"),
                testData.get("CONTRACTED"), testData.get("HOTEL_COUNTRY"), testData.get("HOTEL_STATE"),
                testData.get("OCCUPANCY"), testData.get("WEB_URL"), testData.get("EMAIL_ID"), testData.get("HOTEL_CITY"),
                testData.get("ZIP_CODE"), testData.get("NONUS_PROVINCE"), testData.get("PHONE_NUMBER"), testData.get("FAX_NUMBER"),
                testData.get("TOLLFREE_NUMBER"), testData.get("USER_NOTES"), testData.get("SLEEPING_ROOMS"),
                testData.get("REG_FROM_LABEL"), testData.get("HOTEL_DESCRIPTION"), testData.get("LARGEST_MEETINGSPACE"),
                testData.get("TOTAL_MEETINGSPACE"), testData.get("MEETING_ROOMS"));
        return hotelData;

    }

    public AccommodationBlockInformation getBlockInformation() {


        AccommodationBlockInformation accommodationBlockInformation;

        Map<String, String> testData = testDataList;
        accommodationBlockInformation = new AccommodationBlockInformation(testData.get("HOTEL_NAME"), testData.get("ROOM_TYPE"), testData.get("START_DATE"),
                testData.get("END_DATE"), testData.get("INVENTORY"),
                testData.get("CONTRACTED"), testData.get("ROOM_RATE"));
        return accommodationBlockInformation;

    }

    public SubBlockData getSubBlockData() {

        SubBlockData subBlockData;

        Map<String, String> testData = testDataList;
        subBlockData = new SubBlockData(testData.get("SUB_BLOCK_NAME"), testData.get("BLOCK_CODE"), testData.get("DATE"), testData.get("ALLOCATED_VALUE"));
        return subBlockData;

    }


    public AddSessionsFormsData getSessionsFormData() {
        AddSessionsFormsData addSessionsFormsData;
        Map<String, String> testData = testDataList;
        addSessionsFormsData = new AddSessionsFormsData(testData.get("SESSION_NAME"), testData.get("SESSION_TYPE"), testData.get("SESSION_GROUP_BY"), testData.get("SESSION_GROUP_BY_STYLE"), testData.get("SESSION_TEMPLATE"));
        return addSessionsFormsData;
    }


    public AddFormAgendaData getFormAgendaData() {
        AddFormAgendaData addFormAgendaData;
        Map<String, String> testData = testDataList;
        addFormAgendaData = new AddFormAgendaData(testData.get("AGENDA_SECTIONS"));
        return addFormAgendaData;
    }

    public AddFormLogicRulesPageData getFormLogicRulesData() {
        AddFormLogicRulesPageData addFormLogicRulesData;
        Map<String, String> formLogicRulesData = testDataList;
        addFormLogicRulesData = new AddFormLogicRulesPageData(formLogicRulesData.get("LOGIC_NAME"), formLogicRulesData.get("ACTIONS_TYPE"), formLogicRulesData.get("QUESTION_TITLE"), formLogicRulesData.get("CONDITIONS_TYPE"));
        return addFormLogicRulesData;
    }

    public AddNewRegistrationDataForGroup getRegistrationForGroupData() {
        AddNewRegistrationDataForGroup addNewRegistrationDataForGroup;
        Map<String, String> registrationsData = testDataList;
        addNewRegistrationDataForGroup = new AddNewRegistrationDataForGroup(registrationsData.get("FIRST_NAME"), registrationsData.get("LAST_NAME"), registrationsData.get("ATTENDEE_TYPE"));
        return addNewRegistrationDataForGroup;
    }

    public List<AddSessionData> getSessionDetails() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            addSessionData = new AddSessionData(sessionData.get("SessionName"), sessionData.get("SessionType"), sessionData.get("SessionCode"), sessionData.get("Tracks"), sessionData.get("Tags"), sessionData.get("SessionLevel"), sessionData.get("Points"), sessionData.get("SessionDurationHrs"), sessionData.get("SessionDurationMin"), sessionData.get("CEUCredits"), sessionData.get("SessionInstance"), sessionData.get("Speakers"), sessionData.get("Notes"),
                    sessionData.get("AbstractDescription"), sessionData.get("AbstractFile"), sessionData.get("SessionFile"), sessionData.get("SessionDescription"), sessionData.get("SessionLabel"), sessionData.get("JobFunctions"), sessionData.get("Industry"));
            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getSessionStandardFieldDetailsForImport() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Type"), sessionData.get("Session Code"), sessionData.get("Track"), sessionData.get("Tags"), sessionData.get("Session Level"), sessionData.get("Points"), "0", sessionData.get("Duration"), sessionData.get("CEU Credits"), sessionData.get("No.of Instances"), sessionData.get("Master Speakers"), sessionData.get("Session Notes"),
                    sessionData.get("Abstract Description"), null, null, sessionData.get("Session Description"), sessionData.get("Session Label"), sessionData.get("Job Function"), sessionData.get("Industry"));
            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getSessionStandardFieldForImportStandardSession() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Type"), sessionData.get("Session Code"), sessionData.get("Track"), sessionData.get("Tags"), sessionData.get("Session Level"), sessionData.get("Points"), null, sessionData.get("Duration"), sessionData.get("CEU Credits"), sessionData.get("No.of Instances"), sessionData.get("Master Speakers"), sessionData.get("Session Notes"),
                    sessionData.get("Abstract Description"), null, null, sessionData.get("Session Description"), sessionData.get("Session Label"), sessionData.get("Job Functions"), sessionData.get("Industries"));
            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getSessionStandardFieldDetailsForImportExport() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Type"), sessionData.get("Session Code"), sessionData.get("Track"), sessionData.get("Tags"), sessionData.get("Session Level"), sessionData.get("Points"), "0", sessionData.get("Duration"), sessionData.get("CEU Credits"), sessionData.get("No of Instances"), sessionData.get("Master Speakers"), sessionData.get("Session Notes"),
                    sessionData.get("Abstract Description"), null, null, sessionData.get("Session Description"), sessionData.get("Session Label"), sessionData.get("Job Functions"), sessionData.get("Industries"));
            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getSimpleSessionDetails() {
        List<AddSessionData> simpleSessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> simpleSessionData : testDataList1) {
            addSessionData = new AddSessionData(simpleSessionData.get("SessionName"), simpleSessionData.get("SessionType"), simpleSessionData.get("SessionCode"), simpleSessionData.get("Tracks"), simpleSessionData.get("Tags"), simpleSessionData.get("SessionLevel"), simpleSessionData.get("Points"), simpleSessionData.get("CEUCredits"), simpleSessionData.get("Speakers"), simpleSessionData.get("Notes"),
                    simpleSessionData.get("AbstractDescription"), simpleSessionData.get("SessionDescription"), simpleSessionData.get("SessionLabel"), simpleSessionData.get("JobFunctions"), simpleSessionData.get("Industry"));
            simpleSessionDataList.add(addSessionData);
        }
        return simpleSessionDataList;
    }

    public List<AddSessionData> getSessionInstanceDetails() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        // boolean OC = false;
        for (Map<String, String> sessionData : testDataList1) {
            /*if (sessionData.get("OverrideCapacity").equalsIgnoreCase("1")) {
                OC = true;
            } else {
                OC = false;
            }*/
            //addSessionData = new AddSessionData(sessionData.get("Speakers"), sessionData.get("InstanceStartDate"), sessionData.get("Location"), sessionData.get("Capacity"), sessionData.get("WaitListLimit"));
            addSessionData = new AddSessionData(sessionData.get("StartTime"), Boolean.valueOf(sessionData.get("OverrideCapacity")), sessionData.get("Capacity"),
                    sessionData.get("InstanceStartDate"), sessionData.get("Location"), sessionData.get("WaitListLimit"),
                    sessionData.get("EndTime"), sessionData.get("InstanceSpeakers"));
            sessionDataList.add(addSessionData);
            System.out.println(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getSimpleSessionInstanceDetails() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        //  boolean OC = false;
        for (Map<String, String> sessionData : testDataList1) {
            // || sessionData.get("OverrideCapacity").equalsIgnoreCase(null)

            addSessionData = new AddSessionData(sessionData.get("Speakers"), sessionData.get("Location"), sessionData.get("Capacity"), sessionData.get("WaitListLimit"), Boolean.valueOf(sessionData.get("OverrideCapacity")), sessionData.get("InstanceStartTime"), sessionData.get("InstanceEndTime"));
            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }


    public List<SessionFeeStructureData> getSessionFeeDetails() {
        List<SessionFeeStructureData> sessionFeeStructureDataList = new ArrayList<>();
        SessionFeeStructureData sessionFeeStructureData;
        for (Map<String, String> sessionFeeData : testDataList1) {
            sessionFeeStructureData = new SessionFeeStructureData(sessionFeeData.get("FeeDate"), sessionFeeData.get("FeeTimeMHrs"), sessionFeeData.get("FeeTimeMins"), sessionFeeData.get("FeeAmount"), sessionFeeData.get("FeeCode"), sessionFeeData.get("FeeLabel"), sessionFeeData.get("FeeGLAccount"), sessionFeeData.get("FeeCount"));
            sessionFeeStructureDataList.add(sessionFeeStructureData);
        }
        return sessionFeeStructureDataList;
    }

    public AddSpeakerData getAddSpeakerData() {
        AddSpeakerData addSpeakerData;
        Map<String, String> testData = testDataList;
        addSpeakerData = new AddSpeakerData(testData.get("FIRST_NAME"), testData.get("LAST_NAME"), testData.get("PREFIX"), testData.get("BADGE_NAME"),
                testData.get("MIDDLE_NAME"), testData.get("SUFFIX"), testData.get("SPEAKER_TYPE"), testData.get("EMAIL"), testData.get("USER_NAME"),
                testData.get("PASSWORD"), testData.get("GENDER"), testData.get("DATE_OF_BIRTH"), testData.get("ORGANIZATION"),
                testData.get("POSITION"), testData.get("PHONE"), testData.get("MOBILE"), testData.get("FAX"),
                testData.get("WEB_ADDRESS"), testData.get("FACEBOOK"), testData.get("LINKEDIN"),
                testData.get("GOOGLE"), testData.get("TWITTER"), testData.get("ADDRESS_LINE1"), testData.get("ADDRESS_LINE2"),
                testData.get("CITY"), testData.get("POSTAL_CODE"), testData.get("STATE"), testData.get("ZIPCODE"),
                testData.get("COUNTRY"), testData.get("PROFILE_PICTURE"), testData.get("BIO_NOTES"), testData.get("USER_NOTES"));
        return addSpeakerData;
    }

    public List<AddCustomFieldsData> getCustomFieldDetails() {
        List<AddCustomFieldsData> addCustomFieldsDataList = new ArrayList<>();
        AddCustomFieldsData addCustomFieldsData;
        for (Map<String, String> customFieldData : testDataList1) {
            addCustomFieldsData = new AddCustomFieldsData(customFieldData.get("FieldType"), customFieldData.get("FieldName"), customFieldData.get("FieldCode"), customFieldData.get("Class"), customFieldData.get("Options"));
            addCustomFieldsDataList.add(addCustomFieldsData);
        }
        return addCustomFieldsDataList;
    }

    public List<AddSpeakerData> getSpeakerDetails() {
        List<AddSpeakerData> addSpeakerDataList = new ArrayList<>();
        AddSpeakerData addSpeakerData;
        for (Map<String, String> speakerData : testDataList1) {
            addSpeakerData = new AddSpeakerData(speakerData.get("FirstName"), speakerData.get("LastName"), speakerData.get("SpeakerType"));
            addSpeakerDataList.add(addSpeakerData);
        }
        return addSpeakerDataList;
    }

    public List<AddSpeakerData> getSpeakerData() {
        List<AddSpeakerData> addSpeakerDataList = new ArrayList<>();
        AddSpeakerData addSpeakerData;
        for (Map<String, String> speakerData : testDataList1) {
            addSpeakerData = new AddSpeakerData(speakerData.get("FirstName"), speakerData.get("LastName"), speakerData.get("SpeakerType"),
                    speakerData.get("EMAIL"), speakerData.get("USER_NAME"), speakerData.get("PASSWORD"));
            addSpeakerDataList.add(addSpeakerData);
        }
        return addSpeakerDataList;
    }

    public List<AddLocationData> getLocationDetails() {
        List<AddLocationData> addLocationDataList = new ArrayList<>();
        AddLocationData addLocationData;
        for (Map<String, String> locationData : testDataList1) {
            addLocationData = new AddLocationData(locationData.get("Name"), locationData.get("Type"), locationData.get("Capacity"), locationData.get("Venue"));
            addLocationDataList.add(addLocationData);
        }
        return addLocationDataList;
    }

    public List<SessionPageFilters> getSessionPageFilters() {

        List<SessionPageFilters> sessionPageFiltersList = new ArrayList<>();
        SessionPageFilters sessionPageFilters;

        for (Map<String, String> sessionFilterData : testDataList1) {
            sessionPageFilters = new SessionPageFilters(sessionFilterData.get("FieldType"), sessionFilterData.get("FieldName"));
            sessionPageFiltersList.add(sessionPageFilters);

        }

        return sessionPageFiltersList;

    }

    public List<AddSessionTypesLevels> getSessionTypesLevelsDetails() {
        List<AddSessionTypesLevels> sessionTypesLevelsList = new ArrayList<>();
        AddSessionTypesLevels addSessionTypesLevels;

        for (Map<String, String> sessionTypesLevelsData : testDataList1) {
            addSessionTypesLevels = new AddSessionTypesLevels(sessionTypesLevelsData.get("TYPE_NAME"), sessionTypesLevelsData.get("LEVEL_NAME"), sessionTypesLevelsData.get("COLOR_CODE_R"), sessionTypesLevelsData.get("COLOR_CODE_G"), sessionTypesLevelsData.get("COLOR_CODE_B"));
            sessionTypesLevelsList.add(addSessionTypesLevels);
        }

        return sessionTypesLevelsList;

    }

    public List<SessionProposalInfo> getSessionProposalDetails() {
        List<SessionProposalInfo> simpleSessionDataList = new ArrayList<>();
        SessionProposalInfo sessionProposalInfo;
        for (Map<String, String> simpleSessionData : testDataList1) {
            sessionProposalInfo = new SessionProposalInfo(simpleSessionData.get("SessionName"), simpleSessionData.get("SessionType"), simpleSessionData.get("Tracks"), simpleSessionData.get("Tags"), simpleSessionData.get("SessionLevel"),
                    simpleSessionData.get("AbstractFile"), simpleSessionData.get("AbstractDescription"), simpleSessionData.get("SessionDescription"), simpleSessionData.get("notes"));
            simpleSessionDataList.add(sessionProposalInfo);
        }
        return simpleSessionDataList;
    }

    public List<SubmitterInfo> getSubmitterDetails() {
        List<SubmitterInfo> submitterInfoList = new ArrayList<>();
        SubmitterInfo submitterInfo;
        for (Map<String, String> simpleSessionData : testDataList1) {
            submitterInfo = new SubmitterInfo(simpleSessionData.get("SubmitterEmail"), simpleSessionData.get("SubmitterFirstName"), simpleSessionData.get("SubmitterLastName"), simpleSessionData.get("SubmitterPosition"));
            submitterInfoList.add(submitterInfo);
        }
        return submitterInfoList;
    }

    public List<SpeakerInformation> getSpeakerProposalInfo() {
        List<SpeakerInformation> speakerInformationList = new ArrayList<>();
        SpeakerInformation speakerInformation;
        for (Map<String, String> testData : testDataList1) {
            speakerInformation = new SpeakerInformation(testData.get("FIRST_NAME"), testData.get("LAST_NAME"), testData.get("PREFIX"),
                    testData.get("MIDDLE_NAME"), testData.get("SUFFIX"), testData.get("EMAIL"), testData.get("USER_NAME"),
                    testData.get("PASSWORD"), testData.get("CONFIRM_PWD"), testData.get("ORGANIZATION"),
                    testData.get("POSITION"), testData.get("PHONE"), testData.get("FACEBOOK"), testData.get("LINKEDIN"),
                    testData.get("GOOGLE"), testData.get("TWITTER"), testData.get("ADDRESS_LINE1"), testData.get("ADDRESS_LINE2"),
                    testData.get("CITY"), testData.get("POSTAL_CODE"), testData.get("STATE"),
                    testData.get("COUNTRY"), testData.get("PROFILE_PICTURE"), testData.get("BIO_NOTES"));
            speakerInformationList.add(speakerInformation);
        }
        return speakerInformationList;
    }

    public List<SpeakerInformation> getAdditionalSpeakerInfo() {
        List<SpeakerInformation> speakerInformationList = new ArrayList<>();
        SpeakerInformation speakerInformation;
        for (Map<String, String> testData : testDataList1) {
            speakerInformation = new SpeakerInformation(testData.get("FIRST_NAME"), testData.get("LAST_NAME"), testData.get("EMAIL"), testData.get("ORGANIZATION"),
                    testData.get("POSITION"), testData.get("PHONE"));
            speakerInformationList.add(speakerInformation);
        }
        return speakerInformationList;
    }

    public List<AddCustomFieldFilterData> getCustomFieldFiltersDataList() {

        List<AddCustomFieldFilterData> customFieldFilterList = new ArrayList<>();
        AddCustomFieldFilterData addCustomFieldFilterData;

        for (Map<String, String> testData : testDataList1) {
            addCustomFieldFilterData = new AddCustomFieldFilterData(testData.get("FilterType"), testData.get("FilterValue"));
            customFieldFilterList.add(addCustomFieldFilterData);
        }
        return customFieldFilterList;

    }

    public String sortAndConvertString(String name) {
        String a[] = name.split("\\|");
        List<String> tagsList = new ArrayList<>();
        for (String s : a) {
            tagsList.add(s);
        }
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);
        return tags;
    }
    public List<AddSessionData> getSessionStandardFieldDetailsForExport() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            String industries = sortAndConvertString(sessionData.get("Industries"));
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Session Code"), sessionData.get("Type"), sessionData.get("Points"), sessionData.get("Instance Code"), sessionData.get("Start Date"), sessionData.get("End Date"), sessionData.get("Location Name"), sessionData.get("Location Code"), sessionData.get("Capacity"), sessionData.get("Waitlist Limit"), sessionData.get("Override Capacity"), sessionData.get("Speakers"), sessionData.get("Abstract Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(),
                    sessionData.get("Session Notes"), sessionData.get("Session Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(), sessionData.get("CEU Credits"), sessionData.get("Session Label"), sessionData.get("Session Level"), sessionData.get("Track"), sessionData.get("Job Functions"), industries, sessionData.get("Tags"));

            sessionDataList.add(addSessionData);
        }
        return sessionDataList;
    }

    public List<AddSessionData> getConferenceSessionStandardFieldDetailsForExport() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            String industries = sortAndConvertString(sessionData.get("Industries"));
            String jobFunction = sortAndConvertString(sessionData.get("Job Functions"));
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Session Name"), sessionData.get("Session Code"), sessionData.get("Type"), sessionData.get("Track"), sessionData.get("Tags"), sessionData.get("Session Level"), sessionData.get("Points"), sessionData.get("Duration"), sessionData.get("CEU Credits"), sessionData.get("No of Instances"), sessionData.get("Master Speakers"), sessionData.get("Abstract Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(), sessionData.get("Session Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(), sessionData.get("Session Notes"), industries, sessionData.get("Session Label"), jobFunction);
            sessionDataList.add(addSessionData);

        }
        return sessionDataList;
    }

    public List<AddSessionData> getConferenceSessionInstanceFieldDetailsForExport() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            addSessionData = new AddSessionData(sessionData.get("Instance Code"), sessionData.get("Start Date"), sessionData.get("End Date"), sessionData.get("Location Name"), sessionData.get("Location Code"), sessionData.get("Capacity"), sessionData.get("Waitlist Limit"), sessionData.get("Override Capacity"), sessionData.get("Speakers"));
            sessionDataList.add(addSessionData);

        }
        return sessionDataList;
    }

    public List<AddSessionData> getConferenceSessionStandardFieldDetailsForExportWithInstances() {
        List<AddSessionData> sessionDataList = new ArrayList<>();
        AddSessionData addSessionData;
        for (Map<String, String> sessionData : testDataList1) {
            String industries = sortAndConvertString(sessionData.get("Industries"));
            addSessionData = new AddSessionData(sessionData.get("Session Name"), sessionData.get("Session Code"), sessionData.get("Type"), sessionData.get("Track"), sessionData.get("Tags"), sessionData.get("Session Level"), sessionData.get("Points"), sessionData.get("Duration"), sessionData.get("CEU Credits"), sessionData.get("Master Speakers"), sessionData.get("Abstract Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(), sessionData.get("Session Description").replace("<p>", "").replace("</p>", "").replace("&nbsp;", "").replace("/n", "").trim(), sessionData.get("Session Notes"), industries, sessionData.get("Session Label"), sessionData.get("Job Functions"));
            sessionDataList.add(addSessionData);

        }
        return sessionDataList;
    }

    public List<AddFormPostData> getFormPostDetails() {
        List<AddFormPostData> formPostDataList = new ArrayList<>();
        AddFormPostData addFormPostDataData;
        for (Map<String, String> formPostData : testDataList1) {
            addFormPostDataData = new AddFormPostData(formPostData.get("FormPostName"), formPostData.get("RegStatus"), formPostData.get("RegProperties"), formPostData.get("RegSessionStatus"), formPostData.get("Url"), formPostData.get("ActionMethod"), formPostData.get("SourceName"), formPostData.get("Value"), formPostData.get("FormFieldName"));
            formPostDataList.add(addFormPostDataData);
        }
        return formPostDataList;
    }

    public List<AddSpeakerData> getSpeakerDataList() {
        List<AddSpeakerData> speakerList = new ArrayList<>();
        AddSpeakerData addSpeakerData;

        for (Map<String, String> testData : testDataList1) {
            addSpeakerData = new AddSpeakerData(testData.get("FIRST_NAME"), testData.get("LAST_NAME"), testData.get("PREFIX"), testData.get("BADGE_NAME"),
                    testData.get("MIDDLE_NAME"), testData.get("SUFFIX"), testData.get("SPEAKER_TYPE"), testData.get("EMAIL"), testData.get("USER_NAME"),
                    testData.get("PASSWORD"), testData.get("GENDER"), testData.get("DATE_OF_BIRTH"), testData.get("ORGANIZATION"),
                    testData.get("POSITION"), testData.get("PHONE"), testData.get("MOBILE"), testData.get("FAX"),
                    testData.get("WEB_ADDRESS"), testData.get("FACEBOOK"), testData.get("LINKEDIN"),
                    testData.get("GOOGLE"), testData.get("TWITTER"), testData.get("ADDRESS_LINE1"), testData.get("ADDRESS_LINE2"),
                    testData.get("CITY"), testData.get("POSTAL_CODE"), testData.get("STATE"), testData.get("ZIPCODE"),
                    testData.get("COUNTRY"), testData.get("PROFILE_PICTURE"), testData.get("BIO_NOTES"), testData.get("USER_NOTES"));

            speakerList.add(addSpeakerData);

        }
        return speakerList;

    }

    public List<CustomQuestionData> getCustomQuestionDataList() {
        List<CustomQuestionData> customQuestionList = new ArrayList<>();
        CustomQuestionData customQuestionData;

        for (Map<String, String> questionData : testDataList1) {
            customQuestionData = new CustomQuestionData(questionData.get("QUESTION_FOR"), questionData.get("QUESTION_TYPE"), questionData.get("QUESTION_NAME"),
                    questionData.get("QUESTION_CODE"), questionData.get("DISPLAY_REG_FORM"),
                    questionData.get("ERROR_MESSAGE"), questionData.get("INPUT_SIZE"), questionData.get("MAXIMUM_CHARACTER"),
                    questionData.get("MINIMUM_CHARACTER"), questionData.get("DEFAULT_ANSWER"), questionData.get("SHOW_ONLINE"),
                    questionData.get("QUESTION_ANSWER"), questionData.get("QUESTION_FONT"),
                    questionData.get("QUESTION_HORIZONTAL_FORM"), questionData.get("QUESTION_VERTICAL_FORM"),
                    questionData.get("ANSWER_FONT"), questionData.get("ANSWER_HORIZONTAL_FORM"),
                    questionData.get("ANSWER_VERTICAL_FORM"), questionData.get("CLASS"));

            customQuestionList.add(customQuestionData);
        }

        return customQuestionList;
    }

    public List<CreateProfileData> getCreateProfileData() {

        List<CreateProfileData> profileDataList = new ArrayList<>();
        CreateProfileData createProfileData;
        ContactInformation contactInformation;

        AssistantInfo assistantInfo;
        ContactDetails contactDetails;

        Address mailingAddressDetail;
        AdditionalInfo mailingAddressAdditionalInfo;
        MailingAddress mailingAddress;

        Address billingAddress;
        BillingInfo billingInfo;

        Address shippingAddress;
        ShippingInfo shippingInfo;

        for (Map<String, String> testData : testDataList1) {
            contactInformation = new ContactInformation(testData.get("FIRST_NAME"), testData.get("LAST_NAME"),
                    testData.get("EMAIL"), testData.get("POSITION"), testData.get("ORGANIZATION"), testData.get("USER_NAME"),
                    testData.get("EXTERNAL_PROFILE_ID"), "", testData.get("PREFIX"), testData.get("MI"), testData.get("SUFFIX"), testData.get("BADGE_NAME"),
                    testData.get("GENDER"), testData.get("DATE_OF_BIRTH"), testData.get("PASSWORD"));

            assistantInfo = new AssistantInfo(testData.get("ASSISTANT_NAME"), testData.get("ASSISTANT_EMAIL"),
                    testData.get("ASSISTANT_PHONE"));

            contactDetails = new ContactDetails(testData.get("PHONE"), testData.get("FAX"), testData.get("MOBILE"),
                    testData.get("OTHER_PHONE"), testData.get("WEB_ADDRESS"), testData.get("FACEBOOK"), testData.get("LINKEDIN"),
                    assistantInfo, testData.get("GOOGLE"), testData.get("TWITTER"));

            mailingAddressDetail = new Address(testData.get("MAILING_ADDRESS"), testData.get("MAILING_ADDRESS_LINE_2"),
                    testData.get("MAILING_ADDRESS_LINE_3"), testData.get("MAILING_COUNTRY"), testData.get("MAILING_STATE"),
                    "", testData.get("MAILING_CITY"), testData.get("MAILING_POSTAL_CODE"));

            mailingAddressAdditionalInfo = new AdditionalInfo(testData.get("ADDITIONAL_NAME"), testData.get("ADDITIONAL_EMAIL"),
                    testData.get("ADDITIONAL_PHONE"));

            mailingAddress = new MailingAddress(mailingAddressDetail, mailingAddressAdditionalInfo);

            billingAddress = new Address(testData.get("BILLING_ADDRESS"), testData.get("BILLING_ADDRESS_LINE_2"),
                    testData.get("BILLING_ADDRESS_LINE_3"), testData.get("BILLING_COUNTRY"), testData.get("BILLING_STATE"),
                    "", testData.get("BILLING_CITY"), testData.get("BILLING_POSTAL_CODE"));

            billingInfo = new BillingInfo(testData.get("BILL_TO_NAME"), testData.get("BILL_TO_ORGANIZATION"), billingAddress);

            shippingAddress = new Address(testData.get("SHIPPING_ADDRESS"), testData.get("SHIPPING_ADDRESS_LINE_2"),
                    testData.get("SHIPPING_ADDRESS_LINE_3"), testData.get("SHIPPING_COUNTRY"), testData.get("SHIPPING_STATE"),
                    "", testData.get("SHIPPING_CITY"), testData.get("SHIPPING_POSTAL_CODE"));

            shippingInfo = new ShippingInfo(testData.get("SHIP_TO_NAME"), testData.get("SHIP_TO_ORGANIZATION"), shippingAddress);

            createProfileData = new CreateProfileData(contactInformation, contactDetails, Boolean.valueOf(testData.get("CC_EMAIL_TO_ASSISTANT")),
                    mailingAddress, Boolean.valueOf(testData.get("CC_EMAIL_TO_ASSISTANT")), billingInfo, shippingInfo, testData.get("USER_NOTES"));
            profileDataList.add(createProfileData);
        }
        return profileDataList;
    }

    public List<AddReportData> getAddReportsList() {

        List<AddReportData> addReportDataList = new ArrayList<>();
        AddReportData addReportData;
        for (Map<String, String> reportData : testDataList1) {
            addReportData = new AddReportData(reportData.get("REPORT_NAME"), reportData.get("DESCRIPTION"));
            addReportDataList.add(addReportData);
        }
        return addReportDataList;
    }

    public List<AddConnectionData> getAddConnectionsList() {

        List<AddConnectionData> addConnectionDataList = new ArrayList<>();
        AddConnectionData addConnectionData;
        for (Map<String, String> connectionData : testDataList1) {
            addConnectionData = new AddConnectionData(connectionData.get("ConnectionCategory"), connectionData.get("TargetName"), connectionData.get("ConnectionName"), connectionData.get("ServiceUrl"), connectionData.get("AuthenticationType"), connectionData.get("ClientId"), connectionData.get("ClientSecret"),
                    connectionData.get("GrantType"), connectionData.get("AuthorizationUrl"), connectionData.get("RefreshTokenUrl"), connectionData.get("ResourceUrl"),
                    connectionData.get("AccessTokenUrl"), connectionData.get("Scope"), connectionData.get("TestConnectionUrl"), connectionData.get("Username"), connectionData.get("Password"),
                    connectionData.get("Url"), connectionData.get("ContentType"), connectionData.get("RequestMethod"), connectionData.get("ApiTokenKey"), connectionData.get("AppType"));
            addConnectionDataList.add(addConnectionData);
        }
        return addConnectionDataList;
    }

    //for data source
    public  List<AddDataSource> getAddDataSource(){
        List<AddDataSource> addDataSourceList=new ArrayList<>();
        AddDataSource addDataSourceData;
        for (Map<String, String> dataSourceData : testDataList1) {
            addDataSourceData = new AddDataSource(dataSourceData.get("DATASOURCE"), dataSourceData.get("SOURCENAME"),
                    dataSourceData.get("SOURCESYSTEM"), dataSourceData.get("DESCRIPTION"), dataSourceData.get("SOURCETYPE"),
                    dataSourceData.get("ACTIONCATEGORY"), dataSourceData.get("INCOMINGWEBHOOKURL"), dataSourceData.get("REQUESTPERMINUTE"),
                    dataSourceData.get("CONNECTIONUSED"), dataSourceData.get("POLLAPIURL"), dataSourceData.get("POLLAPICONTENTTYPE"),
                    dataSourceData.get("POLLAPIREQUESTMETHOD"), dataSourceData.get("PAGINATIONSCHEME"), dataSourceData.get("PAGENUMBERFILED"),
                    dataSourceData.get("PAGESIZEFIELD"), dataSourceData.get("PAGESIZE"), dataSourceData.get("TOTALRECORDSFIELD"), dataSourceData.get("ACTIONTYPE"));
            addDataSourceList.add(addDataSourceData);
        }
        return addDataSourceList;
    }

    // for schedule
    public List<Schedule> getScheduleData() {
        List<Schedule> scheduleList = new ArrayList<>();
        Schedule scheduleData;
        for (Map<String, String> scheduleData1 : testDataList1) {
            scheduleData = new Schedule(scheduleData1.get("MEETING_ID"), scheduleData1.get("STATUS"),
                    scheduleData1.get("SOURCE_ACTION"), scheduleData1.get("START_TIME"), scheduleData1.get("FREQUENCY"), scheduleData1.get("TIME_ZONE"));
            scheduleList.add(scheduleData);
        }
        return scheduleList;
    }


    public List<AddFlowData> getAddFlowDataList() {

        List<AddFlowData> addFlowDataList = new ArrayList<>();
        AddFlowData addFlowData;
        for (Map<String, String> flowData : testDataList1) {
            addFlowData = new AddFlowData(flowData.get("FLOW_TITLE"), flowData.get("FLOW_SOURCE"), flowData.get("REG_STATUS"), flowData.get("CUSTOM_TAGS"), flowData.get("REG_SESSION_STATUS"), flowData.get("FLOW_TYPE"), flowData.get("EVENT_STATUS"), flowData.get("FLOW_CATEGORY"));
            addFlowDataList.add(addFlowData);
        }
        return addFlowDataList;
    }
    public List<AddInboundFlowData> getAddInboundFlowDataList() {

        List<AddInboundFlowData> addInboundFlowDataList = new ArrayList<>();
        AddInboundFlowData addInboundFlowData;
        for (Map<String, String> flowData : testDataList1) {
            addInboundFlowData = new AddInboundFlowData(flowData.get("FLOW_TITLE"), flowData.get("FLOW_SOURCE"), flowData.get("FLOW_VAR"));
            addInboundFlowDataList.add(addInboundFlowData);
        }
        return addInboundFlowDataList;
    }

    public List<RetryData> getRetryDataList() {

        List<RetryData> retryDataList = new ArrayList<>();
        RetryData retryData;
        for (Map<String, String> flowData : testDataList1) {
            retryData = new RetryData(flowData.get("REG_STATUS"), flowData.get("TAG_NAME"));
            retryDataList.add(retryData);
        }
        return retryDataList;
    }

    public List<Metrics> getMetricsDataList() {

        List<Metrics> metricsDataList = new ArrayList<>();
        Metrics metrics;
        for (Map<String, String> flowData : testDataList1) {
            metrics = new Metrics(flowData.get("REG_CODE"), flowData.get("TIME_INTERVAL"));
            metricsDataList.add(metrics);
        }
        return metricsDataList;
    }

    public List<AddDestinationData> getAddDestinationDataList() {
        List<AddDestinationData> addDestinationDataList = new ArrayList<>();
        AddDestinationData addDestinationData;
        for (Map<String, String> destinationData : testDataList1) {
            addDestinationData = new AddDestinationData(destinationData.get("DESTINATION"), destinationData.get("DESTINATION_NAME"), destinationData.get("CONNECTION_NAME"), destinationData.get("ACTIONS"), destinationData.get("MAPPING_NAME"));
            addDestinationDataList.add(addDestinationData);
        }
        return addDestinationDataList;
    }

    public List<AddDestinationDataInbound> getAddDestinationDataListInbound() {
        List<AddDestinationDataInbound> addDestinationDataListInbound = new ArrayList<>();
        AddDestinationDataInbound addDestinationDataInbound;
        for (Map<String, String> destinationData : testDataList1) {
            addDestinationDataInbound = new AddDestinationDataInbound(destinationData.get("DESTINATION"), destinationData.get("DESTINATION_NAME"), destinationData.get("CONNECTION_NAME"), destinationData.get("ACTIONS"), destinationData.get("MAPPING_NAME"),destinationData.get("URL"),destinationData.get("CONTENT_TYPE"),destinationData.get("REQUESTEDMETHOD"),destinationData.get("MAPPPINGNAMECUSTOM"),destinationData.get("MAPPPINGNAMEREG"),destinationData.get("MAPPPINGNAMEATTEND"),destinationData.get("AUTHENTICATIONTYPE"),destinationData.get("TESTCONNECTIONURL"),destinationData.get("USERNAME"),destinationData.get("PASSWORD"),destinationData.get("APITOKENKEY"),destinationData.get("RESOURCEURL"),destinationData.get("GRANTTYPE"),destinationData.get("CLIENTID"),destinationData.get("CLIENTSECRET"),destinationData.get("ACCESSTOKENURL"),destinationData.get("REFRESHTOKENURL"),destinationData.get("SCOPE"),destinationData.get("AUTHORIZATIONURL"));
            addDestinationDataListInbound.add(addDestinationDataInbound);
        }
        return addDestinationDataListInbound;
    }
    public List<AddActionData> getAddActionDataList() {
        List<AddActionData> addActionDataList = new ArrayList<>();
        AddActionData addActionData;
        for (Map<String, String> actionData : testDataList1) {
            addActionData = new AddActionData(actionData.get("LIST_ID"), actionData.get("CAMPAIGN_ID"), actionData.get("FORM_NAME"), actionData.get("FORM_URL"), actionData.get("ASSET_TYPE"), actionData.get("ACTIVITY_TYPE"),
                    actionData.get("Url"), actionData.get("RequestMethod"), actionData.get("ContentType"));
            addActionDataList.add(addActionData);
        }
        return addActionDataList;
    }


    public List<AddFilterData> getAddFilterList() {
        List<AddFilterData> addFilterDataList = new ArrayList<>();
        AddFilterData addFilterData;
        for (Map<String, String> filterData : testDataList1) {
            addFilterData = new AddFilterData(filterData.get("FILTER_TYPE"), filterData.get("FIELD_NAME"), filterData.get("OPERATOR"), filterData.get("SEARCH_STRING"), filterData.get("ATTENDEE_TAG"), filterData.get("SESSION_TAG"));
            addFilterDataList.add(addFilterData);
        }
        return addFilterDataList;
    }

    public List<AddFilterData> getAddProfileFilterList() {
        List<AddFilterData> addFilterDataList = new ArrayList<>();
        AddFilterData addFilterData;
        for (Map<String, String> filterData : testDataList1) {
            addFilterData = new AddFilterData(filterData.get("FLOW_TITLE"), filterData.get("FILTER_TYPE"), filterData.get("FIELD_NAME"), filterData.get("OPERATOR"), filterData.get("SEARCH_STRING"));
            addFilterDataList.add(addFilterData);
        }
        return addFilterDataList;
    }

    public List<AddFilterData> getAddEventFilterList() {
        List<AddFilterData> addFilterDataList = new ArrayList<>();
        AddFilterData addFilterData;
        for (Map<String, String> filterData : testDataList1) {
            addFilterData = new AddFilterData(filterData.get("FLOW_TITLE"), filterData.get("FILTER_TYPE"), filterData.get("FIELD_NAME"), filterData.get("OPERATOR"), filterData.get("SEARCH_STRING"));
            addFilterDataList.add(addFilterData);
        }
        return addFilterDataList;
    }

    public List<AddFilterData> getAddSessionFilterList() {
        List<AddFilterData> addFilterDataList = new ArrayList<>();
        AddFilterData addFilterData;
        for (Map<String, String> filterData : testDataList1) {
            addFilterData = new AddFilterData(filterData.get("FLOW_TITLE"), filterData.get("FILTER_TYPE"), filterData.get("FIELD_NAME"), filterData.get("OPERATOR"), filterData.get("SEARCH_STRING"), filterData.get("SESSION_TAG"));
            addFilterDataList.add(addFilterData);
        }
        return addFilterDataList;
    }

    public List<AddFilterData> getAddAttendeeTypeTagsFilterList() {
        List<AddFilterData> addFilterDataList = new ArrayList<>();
        AddFilterData addFilterData;
        for (Map<String, String> filterData : testDataList1) {
            addFilterData = new AddFilterData(filterData.get("FLOW_TITLE"), filterData.get("FILTER_TYPE"), filterData.get("ATTENDEE_TAG"));
            addFilterDataList.add(addFilterData);
        }
        return addFilterDataList;
    }

    public List<AddIFTestCaseDetails> getTestCaseDetailsList() {
        List<AddIFTestCaseDetails> addTestCaseDataList = new ArrayList<>();
        AddIFTestCaseDetails addIFTestCaseDetails;
        for (Map<String, String> testCaseData : testDataList1) {
            addIFTestCaseDetails = new AddIFTestCaseDetails(testCaseData.get("REG_EMAIL"), testCaseData.get("REG_CODE"), testCaseData.get("REQUEST_ID"), testCaseData.get("EVENT_CODE"), testCaseData.get("FLOW_NAME"), testCaseData.get("STATUS"), testCaseData.get("EXCEPTED_STATUS"));
            addTestCaseDataList.add(addIFTestCaseDetails);
        }
        return addTestCaseDataList;
    }

    public List<AttendeeTypeData> getAttendeeTypeWithTagsData() {
        List<AttendeeTypeData> addAttendeeTypeDataList = new ArrayList<>();
        AttendeeTypeData attendeeTypeData;
        for (Map<String, String> attendeeTypeData1 : testDataList1) {
            attendeeTypeData = new AttendeeTypeData(attendeeTypeData1.get("NAME"), attendeeTypeData1.get("CODE"), attendeeTypeData1.get("DISPLAY_REG_FORM"), attendeeTypeData1.get("CAPACITY"), attendeeTypeData1.get("DEFAULT_STATUS"), attendeeTypeData1.get("TAGS"));
            addAttendeeTypeDataList.add(attendeeTypeData);
        }
        return addAttendeeTypeDataList;
    }

    public List<Event> getEventDataListWithTags() {

        List<Event> eventList = new ArrayList<>();
        Event event;

        for (Map<String, String> testData : testDataList1) {
            event = new Event(testData.get("TITLE"), testData.get("EVENT_CODE"), testData.get("START_DATE"), testData.get("START_TIME")
                    , testData.get("END_DATE"), testData.get("END_TIME"), testData.get("TIMEZONE"), testData.get("ACCOUNT")
                    , testData.get("STATUS"), testData.get("EVENT_TAGS"), testData.get("NOTES"), testData.get("EXT_EVNT_ID"), testData.get("REG_INV"), testData.get("CURRENCY"));
            eventList.add(event);
        }
        return eventList;

    }

    public List<EmailTemplates> getEmailTemplatesData() {

        List<EmailTemplates> emailTemplatesList = new ArrayList<>();
        EmailTemplates emailTemplates;

        for (Map<String, String> testData : testDataList1) {
            emailTemplates = new EmailTemplates(testData.get("NAME"), testData.get("APPEND"), testData.get("SUBJECT"), testData.get("MESSAGE"), STRING_APPENDER + String.valueOf(System.currentTimeMillis()),
                    testData.get("SCHEDULED_TYPE"), testData.get("SCHEDULED_DATE"), testData.get("SCHEDULED_TIME"),
                    testData.get("FILTERS_COLUMNS"), testData.get("FILTERS_OPERATORS"), testData.get("FILTERS_VALUE"), testData.get("PASSWORD"), testData.get("ERROR_MESSAGE"));
            emailTemplatesList.add(emailTemplates);
        }
        return emailTemplatesList;

    }
    public List<EventEmailTemplate> getEmailTemplateData() {
        List<EventEmailTemplate> eventEmailTemplateList = new ArrayList<>();
        EventEmailTemplate eventEmailTemplate;
        for (Map<String, String> attendeeTypeData1 : testDataList1) {
            eventEmailTemplate = new EventEmailTemplate(attendeeTypeData1.get("NAME"), attendeeTypeData1.get("FROM_EMAIL"), attendeeTypeData1.get("REPLYTO_EMAIL"), attendeeTypeData1.get("MESSAGE_SUBJECT"), attendeeTypeData1.get("MESSAGE_BODY"), attendeeTypeData1.get("APPEND"));
            eventEmailTemplateList.add(eventEmailTemplate);
        }
        return eventEmailTemplateList;
    }

    public List<AddConfig> getConfigAppData() {
        List<AddConfig> configArrayList = new ArrayList<>();
        AddConfig addConfig;

        for (Map<String, String> testData : testDataList1) {
            addConfig = new AddConfig(testData.get("CONFIG_NAME") + String.valueOf(System.currentTimeMillis()), testData.get("APP_ID"), testData.get("CONFIG_TYPE"),
                    testData.get("IDP_NAME"), testData.get("BUTTON_LABEL"), testData.get("BUTTON_COLOR"), testData.get("BUTTON_TEXT_COLOR"), testData.get("BUTTON_ICON"),
                    testData.get("BUTTON_CLASS"), testData.get("ENTRY_POINTS"), testData.get("PROFILE_LOOKUP"));
            configArrayList.add(addConfig);
        }
        return configArrayList;
    }

    public List<LinkedInAppMappings> getLinkedInAppMappingData() {
        List<LinkedInAppMappings> linkedInAppMappingsList = new ArrayList<>();
        LinkedInAppMappings linkedInAppMappings;

        for (Map<String, String> testData : testDataList1) {
            linkedInAppMappings = new LinkedInAppMappings(testData.get("FIRST_NAME"), testData.get("LAST_NAME"), testData.get("EMAIL"),
                    testData.get("PICTURE_URL"), testData.get("NUM_CONNECTIONS"), testData.get("ID"));
            linkedInAppMappingsList.add(linkedInAppMappings);
        }
        return linkedInAppMappingsList;
    }

    public List<ECommerceAccount> getECommerceAccount() {

        List<ECommerceAccount> eCommerceAccountList = new ArrayList<>();
        ECommerceAccount eCommerceAccount;

        for (Map<String, String> testData : testDataList1) {
            eCommerceAccount = new ECommerceAccount(testData.get("NAME"), testData.get("ONLINE_PROCESSOR"),
                    testData.get("CURRENCY"), testData.get("EXACT_BUSINESS_NAME"), testData.get("ACCOUNT_MERCHANT_OR_VENDOR_ID"),
                    testData.get("ACCOUNT_PARTNER_ID"), testData.get("ACCOUNT_USER_ID"), testData.get("ACCOUNT_PASSWORD"),
                    testData.get("CONFIRM_ACCOUNT_PASSWORD"), testData.get("PAYPAL_MANAGER_URL"), Boolean.parseBoolean(testData.get("IS_PRIMARY_PROCESSING_ACCOUNT")),
                    testData.get("SINGLE_TRANSACTION_LIMIT"), testData.get("AVAILABLE_PAYMENT_METHODS"), Boolean.parseBoolean(testData.get("COLLECT_BILLING_ADDRESS")),
                    Boolean.parseBoolean(testData.get("MATCH_ZIP_CODE")), Boolean.parseBoolean(testData.get("MATCH_STREET_NUMBER")), Boolean.parseBoolean(testData.get("REQUIRE_AVS_YES_RESPONSE")),
                    Boolean.parseBoolean(testData.get("COLLECT_CSC_NUMBER")), Boolean.parseBoolean(testData.get("REQUIRE_CSC_YES_RESPONSE")), testData.get("USER_NOTES"),
                    testData.get("BIN"), Boolean.parseBoolean(testData.get("ACCOUNT_ACCESSIBILITY")), testData.get("TEST_PAYMENT"), testData.get("LIVE_PAYMENT"), Boolean.parseBoolean(testData.get("AUTO_ENFORCE")),
                    testData.get("AUTO_PARTNERID_CONFIRM"), testData.get("SHASTRING"));
            eCommerceAccountList.add(eCommerceAccount);
        }
        return eCommerceAccountList;

    }

    public List<FinancialData> getFinancialData() {
        List<FinancialData> financialDataList = new ArrayList<>();
        FinancialData financialData;
        for (Map<String, String> testData : testDataList1) {
            financialData = new FinancialData(testData.get("PAYMENT_TYPE"), testData.get("AMOUNT"), testData.get("TRANSACTION_DESC"), testData.get("NOTES"), testData.get("GLACCOUNT"), testData.get("DATE"), testData.get("TIME"),
                    Boolean.parseBoolean(testData.get("PAYMENT_RECEIVED")), Boolean.parseBoolean(testData.get("RECONCILED")), Boolean.parseBoolean(testData.get("PRINTCONFIRMATION")), testData.get("CARDHOLDER"), testData.get("CREDITCARDNUMBER"),
                    Boolean.parseBoolean(testData.get("PROCESSPAYMENT")), testData.get("MONTH"), testData.get("YEAR"), testData.get("CVC"), Boolean.parseBoolean(testData.get("BYPASSCSC")),
                    Boolean.parseBoolean(testData.get("BYPASSAVS")), testData.get("CHECKNO"), testData.get("IDNO"), testData.get("BANKACNO"),
                    testData.get("ROUTINGCODE"), testData.get("PONO"), testData.get("COSTCENTER"), testData.get("BANKACCTYPE"), testData.get("NAMEONACCOUNT"),
                    testData.get("IPACNO"), testData.get("ALCNO"), testData.get("TIN"), testData.get("AGENCYCODE"));
            financialDataList.add(financialData);
        }
        return financialDataList;
    }

    public List<FeeStructureData> getAgendaFeeStructureData() {
        List<FeeStructureData> feeStructureDataList = new ArrayList<>();
        FeeStructureData feeStructureData;
        for (Map<String, String> testData : testDataList1) {
            feeStructureData = new FeeStructureData(testData.get("FEE_TYPE"), testData.get("TAX_RULES"), testData.get("DISCOUNT_RULES"), testData.get("EXPIRATION_DATE"),
                    testData.get("TIME"), testData.get("FEE_CODE"), testData.get("DISPLAY_FOR_REG_FORM"),
                    testData.get("AMOUNT"), testData.get("GL_AMOUNT"), testData.get("PERCENTAGE"), testData.get("CANCELLATION_FEE"));
            feeStructureDataList.add(feeStructureData);
        }
        return feeStructureDataList;
    }

    public List<CreditCardData> getCreditCardData() {

        List<CreditCardData> creditCardDataList = new ArrayList<>();
        CreditCardData creditCardData;

        for (Map<String, String> testData : testDataList1) {
            creditCardData = new CreditCardData(testData.get("CARD_TYPE"), testData.get("CARD_NAME"),
                    testData.get("CARD_NUMBER"), testData.get("EXPIRY_MONTH"), testData.get("EXPIRY_YEAR"));
            creditCardDataList.add(creditCardData);
        }
        return creditCardDataList;

    }
}




