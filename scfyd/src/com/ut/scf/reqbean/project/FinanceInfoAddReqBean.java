package com.ut.scf.reqbean.project;
import java.math.BigDecimal;
import java.util.Date;
import com.ut.scf.reqbean.BaseReqBean;
public class FinanceInfoAddReqBean extends BaseReqBean{
	
  
   private Date applyDate;
  
   private String agencyName;
  
   private String agencyNum;
  
   private BigDecimal maxCredit;
  
   private BigDecimal availableCredit;
  
   private BigDecimal financeRate;
  
   private BigDecimal cashRate;
  
   private Date financeStartDate;
  
   private Date financeEndDate;
  
   private BigDecimal financeAmount;
  
   private BigDecimal expense;
  
   private Date marginPayDate;
  
   private BigDecimal marginDeposit;
  
   private BigDecimal actualMarginPay;
  
   private BigDecimal depositPay;
  
   private String remark;
  
   private String financeStatus;
  
   private String auditOpinion;
  
   private String opinionNote;
  
   private String hisOpinionNote;
  
   public Date getApplyDate() {
       return applyDate;
   }
  
   public void setApplyDate(Date applyDate) {
       this.applyDate = applyDate;
   }
  
   public String getAgencyName() {
       return agencyName;
   }
  
   public void setAgencyName(String agencyName) {
       this.agencyName = agencyName;
   }
  
   public String getAgencyNum() {
       return agencyNum;
   }
  
   public void setAgencyNum(String agencyNum) {
       this.agencyNum = agencyNum;
   }
  
   public BigDecimal getMaxCredit() {
       return maxCredit;
   }
  
   public void setMaxCredit(BigDecimal maxCredit) {
       this.maxCredit = maxCredit;
   }
  
   public BigDecimal getAvailableCredit() {
       return availableCredit;
   }
  
   public void setAvailableCredit(BigDecimal availableCredit) {
       this.availableCredit = availableCredit;
   }
  
   public BigDecimal getFinanceRate() {
       return financeRate;
   }
  
   public void setFinanceRate(BigDecimal financeRate) {
       this.financeRate = financeRate;
   }
  
   public BigDecimal getCashRate() {
       return cashRate;
   }
  
   public void setCashRate(BigDecimal cashRate) {
       this.cashRate = cashRate;
   }
  
   public Date getFinanceStartDate() {
       return financeStartDate;
   }
  
   public void setFinanceStartDate(Date financeStartDate) {
       this.financeStartDate = financeStartDate;
   }
  
   public Date getFinanceEndDate() {
       return financeEndDate;
   }
  
   public void setFinanceEndDate(Date financeEndDate) {
       this.financeEndDate = financeEndDate;
   }
  
   public BigDecimal getFinanceAmount() {
       return financeAmount;
   }
  
   public void setFinanceAmount(BigDecimal financeAmount) {
       this.financeAmount = financeAmount;
   }
  
   public BigDecimal getExpense() {
       return expense;
   }
  
   public void setExpense(BigDecimal expense) {
       this.expense = expense;
   }
  
   public Date getMarginPayDate() {
       return marginPayDate;
   }
  
   public void setMarginPayDate(Date marginPayDate) {
       this.marginPayDate = marginPayDate;
   }
  
   public BigDecimal getMarginDeposit() {
       return marginDeposit;
   }
  
   public void setMarginDeposit(BigDecimal marginDeposit) {
       this.marginDeposit = marginDeposit;
   }
  
   public BigDecimal getActualMarginPay() {
       return actualMarginPay;
   }
  
   public void setActualMarginPay(BigDecimal actualMarginPay) {
       this.actualMarginPay = actualMarginPay;
   }
  
   public BigDecimal getDepositPay() {
       return depositPay;
   }
  
   public void setDepositPay(BigDecimal depositPay) {
       this.depositPay = depositPay;
   }
  
   public String getRemark() {
       return remark;
   }
  
   public void setRemark(String remark) {
       this.remark = remark;
   }
  
   public String getFinanceStatus() {
       return financeStatus;
   }
  
   public void setFinanceStatus(String financeStatus) {
       this.financeStatus = financeStatus;
   }
  
   public String getAuditOpinion() {
       return auditOpinion;
   }
  
   public void setAuditOpinion(String auditOpinion) {
       this.auditOpinion = auditOpinion;
   }
  
   public String getOpinionNote() {
       return opinionNote;
   }
  
   public void setOpinionNote(String opinionNote) {
       this.opinionNote = opinionNote;
   }
  
   public String getHisOpinionNote() {
       return hisOpinionNote;
   }
  
   public void setHisOpinionNote(String hisOpinionNote) {
       this.hisOpinionNote = hisOpinionNote;
   }
}
