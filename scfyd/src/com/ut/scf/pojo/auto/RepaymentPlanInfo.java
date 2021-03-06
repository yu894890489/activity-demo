package com.ut.scf.pojo.auto;

import java.math.BigDecimal;
import java.util.Date;

public class RepaymentPlanInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.order_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.period
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private Byte period;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.current_repay_date
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private Date currentRepayDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.current_payable_principal
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private BigDecimal currentPayablePrincipal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.current_payable_interest
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private BigDecimal currentPayableInterest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.repay_status
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private String repayStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column repayment_plan_info.order_batch_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    private String orderBatchId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.order_id
     *
     * @return the value of repayment_plan_info.order_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.order_id
     *
     * @param orderId the value for repayment_plan_info.order_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.period
     *
     * @return the value of repayment_plan_info.period
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public Byte getPeriod() {
        return period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.period
     *
     * @param period the value for repayment_plan_info.period
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setPeriod(Byte period) {
        this.period = period;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.current_repay_date
     *
     * @return the value of repayment_plan_info.current_repay_date
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public Date getCurrentRepayDate() {
        return currentRepayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.current_repay_date
     *
     * @param currentRepayDate the value for repayment_plan_info.current_repay_date
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setCurrentRepayDate(Date currentRepayDate) {
        this.currentRepayDate = currentRepayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.current_payable_principal
     *
     * @return the value of repayment_plan_info.current_payable_principal
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public BigDecimal getCurrentPayablePrincipal() {
        return currentPayablePrincipal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.current_payable_principal
     *
     * @param currentPayablePrincipal the value for repayment_plan_info.current_payable_principal
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setCurrentPayablePrincipal(BigDecimal currentPayablePrincipal) {
        this.currentPayablePrincipal = currentPayablePrincipal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.current_payable_interest
     *
     * @return the value of repayment_plan_info.current_payable_interest
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public BigDecimal getCurrentPayableInterest() {
        return currentPayableInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.current_payable_interest
     *
     * @param currentPayableInterest the value for repayment_plan_info.current_payable_interest
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setCurrentPayableInterest(BigDecimal currentPayableInterest) {
        this.currentPayableInterest = currentPayableInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.repay_status
     *
     * @return the value of repayment_plan_info.repay_status
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public String getRepayStatus() {
        return repayStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.repay_status
     *
     * @param repayStatus the value for repayment_plan_info.repay_status
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column repayment_plan_info.order_batch_id
     *
     * @return the value of repayment_plan_info.order_batch_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public String getOrderBatchId() {
        return orderBatchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column repayment_plan_info.order_batch_id
     *
     * @param orderBatchId the value for repayment_plan_info.order_batch_id
     *
     * @mbggenerated Wed May 24 10:47:11 CST 2017
     */
    public void setOrderBatchId(String orderBatchId) {
        this.orderBatchId = orderBatchId;
    }
}