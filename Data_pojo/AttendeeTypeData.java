package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class AttendeeTypeData {

    private String name;
    private String code;
    private String sortOrder;
    private String displayRegForm;
    private String passCode;
    private String capacity;
    private String defaultStatus;
    private String attendeeGroup;
    private String addNewType;
    private String confirmationHeader;
    private String confirmationFooter;
    private String registrationFeeType;
    private String registrationTaxRules;
    private String registrationDiscountRules;
    private String expiryDate;
    private String time;
    private String feeCode;
    private String displayFeeRegForm;
    private String registrationFeeAmount;
    private String registrationFeeGLAccount;
    private String cancellationFeeType;
    private String cancellationExpiryDate;
    private String cancellationFeeTime;
    private String cancellationFeeCode;
    private String cancellationDisplayFeeRegForm;
    private String cancellationFeeAmount;
    private String cancellationFeeGLAccount;
    private String availableHotel;
    private String exhibitorManagement;

    private String attendeeTag;

    public AttendeeTypeData(String name, String code, String displayRegForm, String capacity, String defaultStatus, String attendeeTag) {
        this.name = name;
        this.code = code;
        this.displayRegForm = displayRegForm;
        this.capacity = capacity;
        this.defaultStatus = defaultStatus;
        this.attendeeTag = attendeeTag;
    }

    @Override
    public String toString() {
        return "AttendeeTypeData{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", displayRegForm='" + displayRegForm + '\'' +
                ", passCode='" + passCode + '\'' +
                ", capacity='" + capacity + '\'' +
                ", defaultStatus='" + defaultStatus + '\'' +
                ", attendeeGroup='" + attendeeGroup + '\'' +
                ", addNewType='" + addNewType + '\'' +
                ", confirmationHeader='" + confirmationHeader + '\'' +
                ", confirmationFooter='" + confirmationFooter + '\'' +
                ", registrationFeeType='" + registrationFeeType + '\'' +
                ", registrationTaxRules='" + registrationTaxRules + '\'' +
                ", registrationDiscountRules='" + registrationDiscountRules + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", time='" + time + '\'' +
                ", feeCode='" + feeCode + '\'' +
                ", displayFeeRegForm='" + displayFeeRegForm + '\'' +
                ", registrationFeeAmount='" + registrationFeeAmount + '\'' +
                ", registrationFeeGLAccount='" + registrationFeeGLAccount + '\'' +
                ", cancellationFeeType='" + cancellationFeeType + '\'' +
                ", cancellationExpiryDate='" + cancellationExpiryDate + '\'' +
                ", cancellationFeeTime='" + cancellationFeeTime + '\'' +
                ", cancellationFeeCode='" + cancellationFeeCode + '\'' +
                ", cancellationDisplayFeeRegForm='" + cancellationDisplayFeeRegForm + '\'' +
                ", cancellationFeeAmount='" + cancellationFeeAmount + '\'' +
                ", cancellationFeeGLAccount='" + cancellationFeeGLAccount + '\'' +
                ", availableHotel='" + availableHotel + '\'' +
                ", exhibitorManagement='" + exhibitorManagement + '\'' +
                ", attendeeTag='" + attendeeTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendeeTypeData that = (AttendeeTypeData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(sortOrder, that.sortOrder) &&
                Objects.equals(displayRegForm, that.displayRegForm) &&
                Objects.equals(passCode, that.passCode) &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(defaultStatus, that.defaultStatus) &&
                Objects.equals(attendeeGroup, that.attendeeGroup) &&
                Objects.equals(addNewType, that.addNewType) &&
                Objects.equals(confirmationHeader, that.confirmationHeader) &&
                Objects.equals(confirmationFooter, that.confirmationFooter) &&
                Objects.equals(registrationFeeType, that.registrationFeeType) &&
                Objects.equals(registrationTaxRules, that.registrationTaxRules) &&
                Objects.equals(registrationDiscountRules, that.registrationDiscountRules) &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(time, that.time) &&
                Objects.equals(feeCode, that.feeCode) &&
                Objects.equals(displayFeeRegForm, that.displayFeeRegForm) &&
                Objects.equals(registrationFeeAmount, that.registrationFeeAmount) &&
                Objects.equals(registrationFeeGLAccount, that.registrationFeeGLAccount) &&
                Objects.equals(cancellationFeeType, that.cancellationFeeType) &&
                Objects.equals(cancellationExpiryDate, that.cancellationExpiryDate) &&
                Objects.equals(cancellationFeeTime, that.cancellationFeeTime) &&
                Objects.equals(cancellationFeeCode, that.cancellationFeeCode) &&
                Objects.equals(cancellationDisplayFeeRegForm, that.cancellationDisplayFeeRegForm) &&
                Objects.equals(cancellationFeeAmount, that.cancellationFeeAmount) &&
                Objects.equals(cancellationFeeGLAccount, that.cancellationFeeGLAccount) &&
                Objects.equals(availableHotel, that.availableHotel) &&
                Objects.equals(exhibitorManagement, that.exhibitorManagement) &&
                Objects.equals(attendeeTag, that.attendeeTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, code, sortOrder, displayRegForm, passCode, capacity, defaultStatus, attendeeGroup, addNewType, confirmationHeader, confirmationFooter, registrationFeeType, registrationTaxRules, registrationDiscountRules, expiryDate, time, feeCode, displayFeeRegForm, registrationFeeAmount, registrationFeeGLAccount, cancellationFeeType, cancellationExpiryDate, cancellationFeeTime, cancellationFeeCode, cancellationDisplayFeeRegForm, cancellationFeeAmount, cancellationFeeGLAccount, availableHotel, exhibitorManagement, attendeeTag);
    }



    public AttendeeTypeData(String name, String code, String sortOrder, String displayRegForm, String passCode, String capacity, String defaultStatus, String attendeeGroup, String addNewType, String confirmationHeader, String confirmationFooter, String registrationFeeType, String registrationTaxRules, String registrationDiscountRules, String expiryDate, String time, String feeCode, String displayFeeRegForm, String registrationFeeAmount, String registrationFeeGLAccount, String cancellationFeeType, String cancellationExpiryDate, String cancellationFeeTime, String cancellationFeeCode, String cancellationDisplayFeeRegForm, String cancellationFeeAmount, String cancellationFeeGLAccount, String availableHotel, String exhibitorManagement) {
        this.name = name;
        this.code = code;
        this.sortOrder = sortOrder;
        this.displayRegForm = displayRegForm;
        this.passCode = passCode;
        this.capacity = capacity;
        this.defaultStatus = defaultStatus;
        this.attendeeGroup = attendeeGroup;
        this.addNewType = addNewType;
        this.confirmationHeader = confirmationHeader;
        this.confirmationFooter = confirmationFooter;
        this.registrationFeeType = registrationFeeType;
        this.registrationTaxRules = registrationTaxRules;
        this.registrationDiscountRules = registrationDiscountRules;
        this.expiryDate = expiryDate;
        this.time = time;
        this.feeCode = feeCode;
        this.displayFeeRegForm = displayFeeRegForm;
        this.registrationFeeAmount = registrationFeeAmount;
        this.registrationFeeGLAccount = registrationFeeGLAccount;
        this.cancellationFeeType = cancellationFeeType;
        this.cancellationExpiryDate = cancellationExpiryDate;
        this.cancellationFeeTime = cancellationFeeTime;
        this.cancellationFeeCode = cancellationFeeCode;
        this.cancellationDisplayFeeRegForm = cancellationDisplayFeeRegForm;
        this.cancellationFeeAmount = cancellationFeeAmount;
        this.cancellationFeeGLAccount = cancellationFeeGLAccount;
        this.availableHotel = availableHotel;
        this.exhibitorManagement = exhibitorManagement;
    }

    public String getAttendeeTag() {
        return attendeeTag;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public String getDisplayRegForm() {
        return displayRegForm;
    }

    public String getPassCode() {
        return passCode;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public String getAttendeeGroup() {
        return attendeeGroup;
    }

    public String getAddNewType() {
        return addNewType;
    }

    public String getConfirmationHeader() {
        return confirmationHeader;
    }

    public String getConfirmationFooter() {
        return confirmationFooter;
    }

    public String getRegistrationFeeType() {
        return registrationFeeType;
    }

    public String getRegistrationTaxRules() {
        return registrationTaxRules;
    }

    public String getRegistrationDiscountRules() {
        return registrationDiscountRules;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getTime() {
        return time;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public String getDisplayFeeRegForm() {
        return displayFeeRegForm;
    }

    public String getRegistrationFeeAmount() {
        return registrationFeeAmount;
    }

    public String getRegistrationFeeGLAccount() {
        return registrationFeeGLAccount;
    }

    public String getCancellationFeeType() {
        return cancellationFeeType;
    }

    public String getCancellationExpiryDate() {
        return cancellationExpiryDate;
    }

    public String getCancellationFeeTime() {
        return cancellationFeeTime;
    }

    public String getCancellationFeeCode() {
        return cancellationFeeCode;
    }

    public String getCancellationDisplayFeeRegForm() {
        return cancellationDisplayFeeRegForm;
    }

    public String getCancellationFeeAmount() {
        return cancellationFeeAmount;
    }

    public String getCancellationFeeGLAccount() {
        return cancellationFeeGLAccount;
    }

    public String getAvailableHotel() {
        return availableHotel;
    }

    public String getExhibitorManagement() {
        return exhibitorManagement;
    }

}
