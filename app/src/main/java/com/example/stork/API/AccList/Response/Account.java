package com.example.stork.API.AccList.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Account {
    @SerializedName("$type")
    @Expose
    public String $type;
    @SerializedName("IsBlockedAccount")
    @Expose
    public Boolean isBlockedAccount;
    @SerializedName("BlockageType")
    @Expose
    public String blockageType;
    @SerializedName("IsPartialBlockedAccount")
    @Expose
    public Boolean isPartialBlockedAccount;
    @SerializedName("IsAggregatedAccount")
    @Expose
    public Boolean isAggregatedAccount;
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("BranchName")
    @Expose
    public String branchName;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("ProductCode")
    @Expose
    public String productCode;
    @SerializedName("OriginalProductCode")
    @Expose
    public String originalProductCode;
    @SerializedName("ProjectCode")
    @Expose
    public String projectCode;
    @SerializedName("ShortName")
    @Expose
    public String shortName;
    @SerializedName("AccountOpenningChannelCode")
    @Expose
    public String accountOpenningChannelCode;
    @SerializedName("IsClosed")
    @Expose
    public Boolean isClosed;
    @SerializedName("IsDisplayedOnInternet")
    @Expose
    public Boolean isDisplayedOnInternet;
    @SerializedName("IsAutoInvested")
    @Expose
    public Boolean isAutoInvested;
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;
    @SerializedName("AnalysisCode")
    @Expose
    public String analysisCode;
    @SerializedName("ReceivableInterestRate")
    @Expose
    public Float receivableInterestRate;
    @SerializedName("DebtInterestRate")
    @Expose
    public Float debtInterestRate;
    @SerializedName("AmountOfBalance")
    @Expose
    public Float amountOfBalance;
    @SerializedName("AmountOfBalanceGross")
    @Expose
    public Float amountOfBalanceGross;
    @SerializedName("AvailableCaptainBalance")
    @Expose
    public Float availableCaptainBalance;
    @SerializedName("AvailableBalance")
    @Expose
    public Float availableBalance;
    @SerializedName("AvailableBalanceGross")
    @Expose
    public Float availableBalanceGross;
    @SerializedName("PreviousDateBalanceGross")
    @Expose
    public Float previousDateBalanceGross;
    @SerializedName("SCCode")
    @Expose
    public List<Object> sCCode = null;
    @SerializedName("IsPersonnelAccount")
    @Expose
    public Boolean isPersonnelAccount;
    @SerializedName("AccountName")
    @Expose
    public String accountName;
    @SerializedName("IBANNo")
    @Expose
    public String iBANNo;
    @SerializedName("CaptainAccountFundBalance")
    @Expose
    public Float captainAccountFundBalance;
    @SerializedName("CaptainAccountBalance")
    @Expose
    public Float captainAccountBalance;
    @SerializedName("AvailableCreditDepositBalance")
    @Expose
    public Float availableCreditDepositBalance;
    @SerializedName("CaptainAccountFlag")
    @Expose
    public Boolean captainAccountFlag;
    @SerializedName("ModernAccountFlag")
    @Expose
    public Boolean modernAccountFlag;
    @SerializedName("ModernAccountMinumumBalance")
    @Expose
    public Float modernAccountMinumumBalance;
    @SerializedName("DormantAccountFlag")
    @Expose
    public Boolean dormantAccountFlag;
    @SerializedName("ValueDate")
    @Expose
    public String valueDate;
    @SerializedName("MaturityDate")
    @Expose
    public String maturityDate;
    @SerializedName("AccountClosingDate")
    @Expose
    public Object accountClosingDate;
    @SerializedName("AccountClosingUserCode")
    @Expose
    public Object accountClosingUserCode;
    @SerializedName("AccountOpenningDate")
    @Expose
    public Object accountOpenningDate;
    @SerializedName("AccountOpenningUserCode")
    @Expose
    public String accountOpenningUserCode;
    @SerializedName("ReverseBalancePositionFlag")
    @Expose
    public String reverseBalancePositionFlag;
    @SerializedName("ReverseBalanceAbilityFlag")
    @Expose
    public String reverseBalanceAbilityFlag;
    @SerializedName("CDAFlag")
    @Expose
    public String cDAFlag;
    @SerializedName("BlockageCodeName")
    @Expose
    public String blockageCodeName;
    @SerializedName("BlockageName")
    @Expose
    public String blockageName;
    @SerializedName("BlockageReasonCode")
    @Expose
    public String blockageReasonCode;
    @SerializedName("BlockageReasonCodeName")
    @Expose
    public String blockageReasonCodeName;
    @SerializedName("BlockageExplanation")
    @Expose
    public String blockageExplanation;
    @SerializedName("BlockageUserCode")
    @Expose
    public String blockageUserCode;
    @SerializedName("BlockageAmount")
    @Expose
    public Float blockageAmount;
    @SerializedName("BlockageMaturityDate")
    @Expose
    public Object blockageMaturityDate;
    @SerializedName("BlockageValueDate")
    @Expose
    public Object blockageValueDate;
    @SerializedName("PreviousDateBalance")
    @Expose
    public Float previousDateBalance;
    @SerializedName("TotalPartialBlockageAmount")
    @Expose
    public Float totalPartialBlockageAmount;
    @SerializedName("DebitAccuredInterestAmountForKMH")
    @Expose
    public Float debitAccuredInterestAmountForKMH;
    @SerializedName("CaptainAvailableBalance")
    @Expose
    public Float captainAvailableBalance;
    @SerializedName("HasSchoolPayment")
    @Expose
    public String hasSchoolPayment;
    @SerializedName("AvailableCreditDeposit")
    @Expose
    public Float availableCreditDeposit;
    @SerializedName("BatchDate")
    @Expose
    public Object batchDate;
    @SerializedName("DelayCount")
    @Expose
    public Integer delayCount;
    @SerializedName("MinPaymentAmount")
    @Expose
    public Float minPaymentAmount;
    @SerializedName("LastPaymentDate")
    @Expose
    public Object lastPaymentDate;
    @SerializedName("CDALimit")
    @Expose
    public Float cDALimit;
    @SerializedName("DebitAccruedInterestAmount")
    @Expose
    public Float debitAccruedInterestAmount;
    @SerializedName("DayToMaturity")
    @Expose
    public Integer dayToMaturity;
    @SerializedName("CreditInterestRate")
    @Expose
    public Float creditInterestRate;
    @SerializedName("NetInterestAmount")
    @Expose
    public Float netInterestAmount;
    @SerializedName("CreditAccruedInterestAmount")
    @Expose
    public Float creditAccruedInterestAmount;
    @SerializedName("RollType")
    @Expose
    public String rollType;
    @SerializedName("IsSuitableForIncomeAndOut")
    @Expose
    public Boolean isSuitableForIncomeAndOut;
    @SerializedName("IsPos")
    @Expose
    public Boolean isPos;
    @SerializedName("CdaCashSuffix")
    @Expose
    public Integer cdaCashSuffix;
    @SerializedName("CdaAvailableLimit")
    @Expose
    public Float cdaAvailableLimit;
    @SerializedName("IsDormantAccount")
    @Expose
    public Boolean isDormantAccount;
    @SerializedName("RateType")
    @Expose
    public String rateType;
    @SerializedName("CdaChangeReasonCode")
    @Expose
    public Object cdaChangeReasonCode;
    @SerializedName("CdaReasonDescription")
    @Expose
    public Object cdaReasonDescription;
    @SerializedName("TransactionCodeList")
    @Expose
    public Object transactionCodeList;
    @SerializedName("AdditionalTufeRate")
    @Expose
    public Float additionalTufeRate;
    @SerializedName("TransferrableBlockageAmount")
    @Expose
    public Float transferrableBlockageAmount;
    @SerializedName("IsFreeZoneAccount")
    @Expose
    public Boolean isFreeZoneAccount;


    public String get$type() {
        return $type;
    }

    public Boolean getBlockedAccount() {
        return isBlockedAccount;
    }

    public String getBlockageType() {
        return blockageType;
    }

    public Boolean getPartialBlockedAccount() {
        return isPartialBlockedAccount;
    }

    public Boolean getAggregatedAccount() {
        return isAggregatedAccount;
    }

    public Integer getAccountSuffix() {
        return accountSuffix;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getOriginalProductCode() {
        return originalProductCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getShortName() {
        return shortName;
    }

    public String getAccountOpenningChannelCode() {
        return accountOpenningChannelCode;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public Boolean getDisplayedOnInternet() {
        return isDisplayedOnInternet;
    }

    public Boolean getAutoInvested() {
        return isAutoInvested;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getAnalysisCode() {
        return analysisCode;
    }

    public Float getReceivableInterestRate() {
        return receivableInterestRate;
    }

    public Float getDebtInterestRate() {
        return debtInterestRate;
    }

    public Float getAmountOfBalance() {
        return amountOfBalance;
    }

    public Float getAmountOfBalanceGross() {
        return amountOfBalanceGross;
    }

    public Float getAvailableCaptainBalance() {
        return availableCaptainBalance;
    }

    public Float getAvailableBalance() {
        return availableBalance;
    }

    public Float getAvailableBalanceGross() {
        return availableBalanceGross;
    }

    public Float getPreviousDateBalanceGross() {
        return previousDateBalanceGross;
    }

    public List<Object> getsCCode() {
        return sCCode;
    }

    public Boolean getPersonnelAccount() {
        return isPersonnelAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getiBANNo() {
        return iBANNo;
    }

    public Float getCaptainAccountFundBalance() {
        return captainAccountFundBalance;
    }

    public Float getCaptainAccountBalance() {
        return captainAccountBalance;
    }

    public Float getAvailableCreditDepositBalance() {
        return availableCreditDepositBalance;
    }

    public Boolean getCaptainAccountFlag() {
        return captainAccountFlag;
    }

    public Boolean getModernAccountFlag() {
        return modernAccountFlag;
    }

    public Float getModernAccountMinumumBalance() {
        return modernAccountMinumumBalance;
    }

    public Boolean getDormantAccountFlag() {
        return dormantAccountFlag;
    }

    public String getValueDate() {
        return valueDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public Object getAccountClosingDate() {
        return accountClosingDate;
    }

    public Object getAccountClosingUserCode() {
        return accountClosingUserCode;
    }

    public Object getAccountOpenningDate() {
        return accountOpenningDate;
    }

    public String getAccountOpenningUserCode() {
        return accountOpenningUserCode;
    }

    public String getReverseBalancePositionFlag() {
        return reverseBalancePositionFlag;
    }

    public String getReverseBalanceAbilityFlag() {
        return reverseBalanceAbilityFlag;
    }

    public String getcDAFlag() {
        return cDAFlag;
    }

    public String getBlockageCodeName() {
        return blockageCodeName;
    }

    public String getBlockageName() {
        return blockageName;
    }

    public String getBlockageReasonCode() {
        return blockageReasonCode;
    }

    public String getBlockageReasonCodeName() {
        return blockageReasonCodeName;
    }

    public String getBlockageExplanation() {
        return blockageExplanation;
    }

    public String getBlockageUserCode() {
        return blockageUserCode;
    }

    public Float getBlockageAmount() {
        return blockageAmount;
    }

    public Object getBlockageMaturityDate() {
        return blockageMaturityDate;
    }

    public Object getBlockageValueDate() {
        return blockageValueDate;
    }

    public Float getPreviousDateBalance() {
        return previousDateBalance;
    }

    public Float getTotalPartialBlockageAmount() {
        return totalPartialBlockageAmount;
    }

    public Float getDebitAccuredInterestAmountForKMH() {
        return debitAccuredInterestAmountForKMH;
    }

    public Float getCaptainAvailableBalance() {
        return captainAvailableBalance;
    }

    public String getHasSchoolPayment() {
        return hasSchoolPayment;
    }

    public Float getAvailableCreditDeposit() {
        return availableCreditDeposit;
    }

    public Object getBatchDate() {
        return batchDate;
    }

    public Integer getDelayCount() {
        return delayCount;
    }

    public Float getMinPaymentAmount() {
        return minPaymentAmount;
    }

    public Object getLastPaymentDate() {
        return lastPaymentDate;
    }

    public Float getcDALimit() {
        return cDALimit;
    }

    public Float getDebitAccruedInterestAmount() {
        return debitAccruedInterestAmount;
    }

    public Integer getDayToMaturity() {
        return dayToMaturity;
    }

    public Float getCreditInterestRate() {
        return creditInterestRate;
    }

    public Float getNetInterestAmount() {
        return netInterestAmount;
    }

    public Float getCreditAccruedInterestAmount() {
        return creditAccruedInterestAmount;
    }

    public String getRollType() {
        return rollType;
    }

    public Boolean getSuitableForIncomeAndOut() {
        return isSuitableForIncomeAndOut;
    }

    public Boolean getPos() {
        return isPos;
    }

    public Integer getCdaCashSuffix() {
        return cdaCashSuffix;
    }

    public Float getCdaAvailableLimit() {
        return cdaAvailableLimit;
    }

    public Boolean getDormantAccount() {
        return isDormantAccount;
    }

    public String getRateType() {
        return rateType;
    }

    public Object getCdaChangeReasonCode() {
        return cdaChangeReasonCode;
    }

    public Object getCdaReasonDescription() {
        return cdaReasonDescription;
    }

    public Object getTransactionCodeList() {
        return transactionCodeList;
    }

    public Float getAdditionalTufeRate() {
        return additionalTufeRate;
    }

    public Float getTransferrableBlockageAmount() {
        return transferrableBlockageAmount;
    }

    public Boolean getFreeZoneAccount() {
        return isFreeZoneAccount;
    }
}
