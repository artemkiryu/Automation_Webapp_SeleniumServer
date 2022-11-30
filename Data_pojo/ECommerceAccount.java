package pojo;

/**
 * Created by bludshot on 22/7/15.
 */
public class ECommerceAccount {
    private String name;
    private String onlineProcessor;
    private String currency;
    private String exactBusinessName;
    private String accountMerchantOrVendorId;
    private String accountPartnerId;
    private String accountUserId;
    private String accountPassword;
    private String confirmAccountPassword;
    private String paypalManagerURL;
    private boolean isPrimaryProcessingAccount;
    private String singleTransactionLimit;
    private String availablePaymentMethods;
    private boolean collectBillingAddress;
    private boolean matchZipCode;
    private boolean matchStreetNumber;
    private boolean requireAVSYesResponse;
    private boolean collectCSCNumber;
    private boolean requireCSCYesResponse;
    private String userNotes;
    private String bin;
    private boolean isAccountAccessibility;
    private String testPaymentUrl;
    private String livePaymentUrl;
    private boolean autoEnforceCsc;
    private String accountPartnerIdConfirm;
    private String shaString;

    public ECommerceAccount(String name, String onlineProcessor, String currency, String exactBusinessName, String accountMerchantOrVendorId, String accountPartnerId, String accountUserId, String accountPassword, String confirmAccountPassword, String paypalManagerURL, boolean isPrimaryProcessingAccount, String singleTransactionLimit, String availablePaymentMethods, boolean collectBillingAddress, boolean matchZipCode, boolean matchStreetNumber, boolean requireAVSYesResponse, boolean collectCSCNumber, boolean requireCSCYesResponse, String userNotes, String bin, boolean isAccountAccessibility, String testPaymentUrl, String livePaymentUrl, boolean autoEnforceCsc, String accountPartnerIdConfirm, String shaString) {
        this.name = name;
        this.onlineProcessor = onlineProcessor;
        this.currency = currency;
        this.exactBusinessName = exactBusinessName;
        this.accountMerchantOrVendorId = accountMerchantOrVendorId;
        this.accountPartnerId = accountPartnerId;
        this.accountUserId = accountUserId;
        this.accountPassword = accountPassword;
        this.confirmAccountPassword = confirmAccountPassword;
        this.paypalManagerURL = paypalManagerURL;
        this.isPrimaryProcessingAccount = isPrimaryProcessingAccount;
        this.singleTransactionLimit = singleTransactionLimit;
        this.availablePaymentMethods = availablePaymentMethods;
        this.collectBillingAddress = collectBillingAddress;
        this.matchZipCode = matchZipCode;
        this.matchStreetNumber = matchStreetNumber;
        this.requireAVSYesResponse = requireAVSYesResponse;
        this.collectCSCNumber = collectCSCNumber;
        this.requireCSCYesResponse = requireCSCYesResponse;
        this.userNotes = userNotes;
        this.bin = bin;
        this.isAccountAccessibility = isAccountAccessibility;
        this.testPaymentUrl = testPaymentUrl;
        this.livePaymentUrl = livePaymentUrl;
        this.autoEnforceCsc = autoEnforceCsc;
        this.accountPartnerIdConfirm = accountPartnerIdConfirm;
        this.shaString = shaString;
    }

    public ECommerceAccount(String name, String onlineProcessor, String currency, String exactBusinessName, String accountMerchantOrVendorId, String accountPartnerId, String accountUserId, String accountPassword, boolean isPrimaryProcessingAccount, String singleTransactionLimit, String availablePaymentMethods, boolean collectBillingAddress, boolean matchZipCode, boolean matchStreetNumber, boolean requireAVSYesResponse, boolean collectCSCNumber, boolean requireCSCYesResponse, String userNotes, String bin, boolean isAccountAccessibility, String testPaymentUrl, String livePaymentUrl, boolean autoEnforceCsc) {
        this.name = name;
        this.onlineProcessor = onlineProcessor;
        this.currency = currency;
        this.exactBusinessName = exactBusinessName;
        this.accountMerchantOrVendorId = accountMerchantOrVendorId;
        this.accountPartnerId = accountPartnerId;
        this.accountUserId = accountUserId;
        this.accountPassword = accountPassword;
        this.isPrimaryProcessingAccount = isPrimaryProcessingAccount;
        this.singleTransactionLimit = singleTransactionLimit;
        this.availablePaymentMethods = availablePaymentMethods;
        this.collectBillingAddress = collectBillingAddress;
        this.matchZipCode = matchZipCode;
        this.matchStreetNumber = matchStreetNumber;
        this.requireAVSYesResponse = requireAVSYesResponse;
        this.collectCSCNumber = collectCSCNumber;
        this.requireCSCYesResponse = requireCSCYesResponse;
        this.userNotes = userNotes;
        this.bin = bin;
        this.isAccountAccessibility = isAccountAccessibility;
        this.testPaymentUrl = testPaymentUrl;
        this.livePaymentUrl = livePaymentUrl;
        this.autoEnforceCsc = autoEnforceCsc;
    }

    public ECommerceAccount(String name, String onlineProcessor, String currency, String exactBusinessName, String accountMerchantOrVendorId, String accountPartnerId, String accountUserId, String accountPassword, boolean isPrimaryProcessingAccount, String singleTransactionLimit, String availablePaymentMethods, boolean collectBillingAddress, boolean matchZipCode, boolean matchStreetNumber, boolean requireAVSYesResponse, boolean collectCSCNumber, boolean requireCSCYesResponse, String userNotes, String bin, boolean isAccountAccessibility) {
        this.name = name;
        this.onlineProcessor = onlineProcessor;
        this.currency = currency;
        this.exactBusinessName = exactBusinessName;
        this.accountMerchantOrVendorId = accountMerchantOrVendorId;
        this.accountPartnerId = accountPartnerId;
        this.accountUserId = accountUserId;
        this.accountPassword = accountPassword;
        this.isPrimaryProcessingAccount = isPrimaryProcessingAccount;
        this.singleTransactionLimit = singleTransactionLimit;
        this.availablePaymentMethods = availablePaymentMethods;
        this.collectBillingAddress = collectBillingAddress;
        this.matchZipCode = matchZipCode;
        this.matchStreetNumber = matchStreetNumber;
        this.requireAVSYesResponse = requireAVSYesResponse;
        this.collectCSCNumber = collectCSCNumber;
        this.requireCSCYesResponse = requireCSCYesResponse;
        this.userNotes = userNotes;
        this.bin = bin;
        this.isAccountAccessibility = isAccountAccessibility;
    }

    public String getAccountPartnerIdConfirm() {
        return accountPartnerIdConfirm;
    }

    public String getShaString() {
        return shaString;
    }

    public ECommerceAccount(String name, String onlineProcessor, String currency, String exactBusinessName, String accountMerchantOrVendorId, String accountPartnerId, String accountUserId, String accountPassword, String confirmAccountPassword, String paypalManagerURL, boolean isPrimaryProcessingAccount, String singleTransactionLimit, String availablePaymentMethods, boolean collectBillingAddress, boolean matchZipCode, boolean matchStreetNumber, boolean requireAVSYesResponse, boolean collectCSCNumber, boolean requireCSCYesResponse, String userNotes) {
        this.name = name;
        this.onlineProcessor = onlineProcessor;
        this.currency = currency;
        this.exactBusinessName = exactBusinessName;
        this.accountMerchantOrVendorId = accountMerchantOrVendorId;
        this.accountPartnerId = accountPartnerId;
        this.accountUserId = accountUserId;
        this.accountPassword = accountPassword;
        this.confirmAccountPassword = confirmAccountPassword;
        this.paypalManagerURL = paypalManagerURL;
        this.isPrimaryProcessingAccount = isPrimaryProcessingAccount;
        this.singleTransactionLimit = singleTransactionLimit;
        this.availablePaymentMethods = availablePaymentMethods;
        this.collectBillingAddress = collectBillingAddress;
        this.matchZipCode = matchZipCode;
        this.matchStreetNumber = matchStreetNumber;
        this.requireAVSYesResponse = requireAVSYesResponse;
        this.collectCSCNumber = collectCSCNumber;
        this.requireCSCYesResponse = requireCSCYesResponse;
        this.userNotes = userNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ECommerceAccount that = (ECommerceAccount) o;

        if (isPrimaryProcessingAccount != that.isPrimaryProcessingAccount) return false;
        if (collectBillingAddress != that.collectBillingAddress) return false;
        if (matchZipCode != that.matchZipCode) return false;
        if (matchStreetNumber != that.matchStreetNumber) return false;
        if (requireAVSYesResponse != that.requireAVSYesResponse) return false;
        if (collectCSCNumber != that.collectCSCNumber) return false;
        if (requireCSCYesResponse != that.requireCSCYesResponse) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (onlineProcessor != null ? !onlineProcessor.equals(that.onlineProcessor) : that.onlineProcessor != null)
            return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (exactBusinessName != null ? !exactBusinessName.equals(that.exactBusinessName) : that.exactBusinessName != null)
            return false;
        if (accountMerchantOrVendorId != null ? !accountMerchantOrVendorId.equals(that.accountMerchantOrVendorId) : that.accountMerchantOrVendorId != null)
            return false;
        if (accountPartnerId != null ? !accountPartnerId.equals(that.accountPartnerId) : that.accountPartnerId != null)
            return false;
        if (accountUserId != null ? !accountUserId.equals(that.accountUserId) : that.accountUserId != null)
            return false;
        if (accountPassword != null ? !accountPassword.equals(that.accountPassword) : that.accountPassword != null)
            return false;
        if (confirmAccountPassword != null ? !confirmAccountPassword.equals(that.confirmAccountPassword) : that.confirmAccountPassword != null)
            return false;
        if (paypalManagerURL != null ? !paypalManagerURL.equals(that.paypalManagerURL) : that.paypalManagerURL != null)
            return false;
        if (singleTransactionLimit != null ? !singleTransactionLimit.equals(that.singleTransactionLimit) : that.singleTransactionLimit != null)
            return false;
        if (availablePaymentMethods != null ? !availablePaymentMethods.equals(that.availablePaymentMethods) : that.availablePaymentMethods != null)
            return false;
        return !(userNotes != null ? !userNotes.equals(that.userNotes) : that.userNotes != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (onlineProcessor != null ? onlineProcessor.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (exactBusinessName != null ? exactBusinessName.hashCode() : 0);
        result = 31 * result + (accountMerchantOrVendorId != null ? accountMerchantOrVendorId.hashCode() : 0);
        result = 31 * result + (accountPartnerId != null ? accountPartnerId.hashCode() : 0);
        result = 31 * result + (accountUserId != null ? accountUserId.hashCode() : 0);
        result = 31 * result + (accountPassword != null ? accountPassword.hashCode() : 0);
        result = 31 * result + (confirmAccountPassword != null ? confirmAccountPassword.hashCode() : 0);
        result = 31 * result + (paypalManagerURL != null ? paypalManagerURL.hashCode() : 0);
        result = 31 * result + (isPrimaryProcessingAccount ? 1 : 0);
        result = 31 * result + (singleTransactionLimit != null ? singleTransactionLimit.hashCode() : 0);
        result = 31 * result + (availablePaymentMethods != null ? availablePaymentMethods.hashCode() : 0);
        result = 31 * result + (collectBillingAddress ? 1 : 0);
        result = 31 * result + (matchZipCode ? 1 : 0);
        result = 31 * result + (matchStreetNumber ? 1 : 0);
        result = 31 * result + (requireAVSYesResponse ? 1 : 0);
        result = 31 * result + (collectCSCNumber ? 1 : 0);
        result = 31 * result + (requireCSCYesResponse ? 1 : 0);
        result = 31 * result + (userNotes != null ? userNotes.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getOnlineProcessor() {
        return onlineProcessor;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExactBusinessName() {
        return exactBusinessName;
    }

    public String getAccountMerchantOrVendorId() {
        return accountMerchantOrVendorId;
    }

    public String getAccountPartnerId() {
        return accountPartnerId;
    }

    public String getAccountUserId() {
        return accountUserId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getConfirmAccountPassword() {
        return confirmAccountPassword;
    }

    public String getPaypalManagerURL() {
        return paypalManagerURL;
    }

    public boolean isPrimaryProcessingAccount() {
        return isPrimaryProcessingAccount;
    }

    public String getSingleTransactionLimit() {
        return singleTransactionLimit;
    }

    public String getAvailablePaymentMethods() {
        return availablePaymentMethods;
    }

    public boolean isCollectBillingAddress() {
        return collectBillingAddress;
    }

    public boolean isMatchZipCode() {
        return matchZipCode;
    }

    public boolean isMatchStreetNumber() {
        return matchStreetNumber;
    }

    public boolean isRequireAVSYesResponse() {
        return requireAVSYesResponse;
    }

    public boolean isCollectCSCNumber() {
        return collectCSCNumber;
    }

    public boolean isRequireCSCYesResponse() {
        return requireCSCYesResponse;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public String getBin() {
        return bin;
    }

    public boolean isAccountAccessibility() {
        return isAccountAccessibility;
    }

    public String getTestPaymentUrl() {
        return testPaymentUrl;
    }

    public String getLivePaymentUrl() {
        return livePaymentUrl;
    }

    public boolean isAutoEnforceCsc() {
        return autoEnforceCsc;
    }
}
