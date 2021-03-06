package com.ut.scf.pojo.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CorpInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CorpInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(String value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(String value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(String value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(String value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(String value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(String value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLike(String value) {
            addCriterion("corp_id like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotLike(String value) {
            addCriterion("corp_id not like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<String> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<String> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(String value1, String value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(String value1, String value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNull() {
            addCriterion("corp_name is null");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNotNull() {
            addCriterion("corp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorpNameEqualTo(String value) {
            addCriterion("corp_name =", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotEqualTo(String value) {
            addCriterion("corp_name <>", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThan(String value) {
            addCriterion("corp_name >", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("corp_name >=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThan(String value) {
            addCriterion("corp_name <", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThanOrEqualTo(String value) {
            addCriterion("corp_name <=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLike(String value) {
            addCriterion("corp_name like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotLike(String value) {
            addCriterion("corp_name not like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameIn(List<String> values) {
            addCriterion("corp_name in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotIn(List<String> values) {
            addCriterion("corp_name not in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameBetween(String value1, String value2) {
            addCriterion("corp_name between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotBetween(String value1, String value2) {
            addCriterion("corp_name not between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIsNull() {
            addCriterion("corp_type is null");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIsNotNull() {
            addCriterion("corp_type is not null");
            return (Criteria) this;
        }

        public Criteria andCorpTypeEqualTo(String value) {
            addCriterion("corp_type =", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotEqualTo(String value) {
            addCriterion("corp_type <>", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeGreaterThan(String value) {
            addCriterion("corp_type >", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("corp_type >=", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeLessThan(String value) {
            addCriterion("corp_type <", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeLessThanOrEqualTo(String value) {
            addCriterion("corp_type <=", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeLike(String value) {
            addCriterion("corp_type like", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotLike(String value) {
            addCriterion("corp_type not like", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIn(List<String> values) {
            addCriterion("corp_type in", values, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotIn(List<String> values) {
            addCriterion("corp_type not in", values, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeBetween(String value1, String value2) {
            addCriterion("corp_type between", value1, value2, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotBetween(String value1, String value2) {
            addCriterion("corp_type not between", value1, value2, "corpType");
            return (Criteria) this;
        }

        public Criteria andAgencyNumIsNull() {
            addCriterion("agency_num is null");
            return (Criteria) this;
        }

        public Criteria andAgencyNumIsNotNull() {
            addCriterion("agency_num is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyNumEqualTo(String value) {
            addCriterion("agency_num =", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumNotEqualTo(String value) {
            addCriterion("agency_num <>", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumGreaterThan(String value) {
            addCriterion("agency_num >", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumGreaterThanOrEqualTo(String value) {
            addCriterion("agency_num >=", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumLessThan(String value) {
            addCriterion("agency_num <", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumLessThanOrEqualTo(String value) {
            addCriterion("agency_num <=", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumLike(String value) {
            addCriterion("agency_num like", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumNotLike(String value) {
            addCriterion("agency_num not like", value, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumIn(List<String> values) {
            addCriterion("agency_num in", values, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumNotIn(List<String> values) {
            addCriterion("agency_num not in", values, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumBetween(String value1, String value2) {
            addCriterion("agency_num between", value1, value2, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andAgencyNumNotBetween(String value1, String value2) {
            addCriterion("agency_num not between", value1, value2, "agencyNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumIsNull() {
            addCriterion("orgn_num is null");
            return (Criteria) this;
        }

        public Criteria andOrgnNumIsNotNull() {
            addCriterion("orgn_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnNumEqualTo(String value) {
            addCriterion("orgn_num =", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumNotEqualTo(String value) {
            addCriterion("orgn_num <>", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumGreaterThan(String value) {
            addCriterion("orgn_num >", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumGreaterThanOrEqualTo(String value) {
            addCriterion("orgn_num >=", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumLessThan(String value) {
            addCriterion("orgn_num <", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumLessThanOrEqualTo(String value) {
            addCriterion("orgn_num <=", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumLike(String value) {
            addCriterion("orgn_num like", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumNotLike(String value) {
            addCriterion("orgn_num not like", value, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumIn(List<String> values) {
            addCriterion("orgn_num in", values, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumNotIn(List<String> values) {
            addCriterion("orgn_num not in", values, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumBetween(String value1, String value2) {
            addCriterion("orgn_num between", value1, value2, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andOrgnNumNotBetween(String value1, String value2) {
            addCriterion("orgn_num not between", value1, value2, "orgnNum");
            return (Criteria) this;
        }

        public Criteria andSysTypeIsNull() {
            addCriterion("sys_type is null");
            return (Criteria) this;
        }

        public Criteria andSysTypeIsNotNull() {
            addCriterion("sys_type is not null");
            return (Criteria) this;
        }

        public Criteria andSysTypeEqualTo(Short value) {
            addCriterion("sys_type =", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeNotEqualTo(Short value) {
            addCriterion("sys_type <>", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeGreaterThan(Short value) {
            addCriterion("sys_type >", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sys_type >=", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeLessThan(Short value) {
            addCriterion("sys_type <", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeLessThanOrEqualTo(Short value) {
            addCriterion("sys_type <=", value, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeIn(List<Short> values) {
            addCriterion("sys_type in", values, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeNotIn(List<Short> values) {
            addCriterion("sys_type not in", values, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeBetween(Short value1, Short value2) {
            addCriterion("sys_type between", value1, value2, "sysType");
            return (Criteria) this;
        }

        public Criteria andSysTypeNotBetween(Short value1, Short value2) {
            addCriterion("sys_type not between", value1, value2, "sysType");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountIsNull() {
            addCriterion("max_credit_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountIsNotNull() {
            addCriterion("max_credit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountEqualTo(BigDecimal value) {
            addCriterion("max_credit_amount =", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountNotEqualTo(BigDecimal value) {
            addCriterion("max_credit_amount <>", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountGreaterThan(BigDecimal value) {
            addCriterion("max_credit_amount >", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_credit_amount >=", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountLessThan(BigDecimal value) {
            addCriterion("max_credit_amount <", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_credit_amount <=", value, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountIn(List<BigDecimal> values) {
            addCriterion("max_credit_amount in", values, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountNotIn(List<BigDecimal> values) {
            addCriterion("max_credit_amount not in", values, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_credit_amount between", value1, value2, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andMaxCreditAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_credit_amount not between", value1, value2, "maxCreditAmount");
            return (Criteria) this;
        }

        public Criteria andIsCountryIsNull() {
            addCriterion("is_country is null");
            return (Criteria) this;
        }

        public Criteria andIsCountryIsNotNull() {
            addCriterion("is_country is not null");
            return (Criteria) this;
        }

        public Criteria andIsCountryEqualTo(Byte value) {
            addCriterion("is_country =", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryNotEqualTo(Byte value) {
            addCriterion("is_country <>", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryGreaterThan(Byte value) {
            addCriterion("is_country >", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_country >=", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryLessThan(Byte value) {
            addCriterion("is_country <", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryLessThanOrEqualTo(Byte value) {
            addCriterion("is_country <=", value, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryIn(List<Byte> values) {
            addCriterion("is_country in", values, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryNotIn(List<Byte> values) {
            addCriterion("is_country not in", values, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryBetween(Byte value1, Byte value2) {
            addCriterion("is_country between", value1, value2, "isCountry");
            return (Criteria) this;
        }

        public Criteria andIsCountryNotBetween(Byte value1, Byte value2) {
            addCriterion("is_country not between", value1, value2, "isCountry");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonIsNull() {
            addCriterion("control_person is null");
            return (Criteria) this;
        }

        public Criteria andControlPersonIsNotNull() {
            addCriterion("control_person is not null");
            return (Criteria) this;
        }

        public Criteria andControlPersonEqualTo(String value) {
            addCriterion("control_person =", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonNotEqualTo(String value) {
            addCriterion("control_person <>", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonGreaterThan(String value) {
            addCriterion("control_person >", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonGreaterThanOrEqualTo(String value) {
            addCriterion("control_person >=", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonLessThan(String value) {
            addCriterion("control_person <", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonLessThanOrEqualTo(String value) {
            addCriterion("control_person <=", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonLike(String value) {
            addCriterion("control_person like", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonNotLike(String value) {
            addCriterion("control_person not like", value, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonIn(List<String> values) {
            addCriterion("control_person in", values, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonNotIn(List<String> values) {
            addCriterion("control_person not in", values, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonBetween(String value1, String value2) {
            addCriterion("control_person between", value1, value2, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andControlPersonNotBetween(String value1, String value2) {
            addCriterion("control_person not between", value1, value2, "controlPerson");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("reg_date is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("reg_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(Date value) {
            addCriterion("reg_date =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(Date value) {
            addCriterion("reg_date <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(Date value) {
            addCriterion("reg_date >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_date >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(Date value) {
            addCriterion("reg_date <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(Date value) {
            addCriterion("reg_date <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<Date> values) {
            addCriterion("reg_date in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<Date> values) {
            addCriterion("reg_date not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(Date value1, Date value2) {
            addCriterion("reg_date between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(Date value1, Date value2) {
            addCriterion("reg_date not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andRealPayCapIsNull() {
            addCriterion("real_pay_cap is null");
            return (Criteria) this;
        }

        public Criteria andRealPayCapIsNotNull() {
            addCriterion("real_pay_cap is not null");
            return (Criteria) this;
        }

        public Criteria andRealPayCapEqualTo(Integer value) {
            addCriterion("real_pay_cap =", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapNotEqualTo(Integer value) {
            addCriterion("real_pay_cap <>", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapGreaterThan(Integer value) {
            addCriterion("real_pay_cap >", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_pay_cap >=", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapLessThan(Integer value) {
            addCriterion("real_pay_cap <", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapLessThanOrEqualTo(Integer value) {
            addCriterion("real_pay_cap <=", value, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapIn(List<Integer> values) {
            addCriterion("real_pay_cap in", values, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapNotIn(List<Integer> values) {
            addCriterion("real_pay_cap not in", values, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapBetween(Integer value1, Integer value2) {
            addCriterion("real_pay_cap between", value1, value2, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andRealPayCapNotBetween(Integer value1, Integer value2) {
            addCriterion("real_pay_cap not between", value1, value2, "realPayCap");
            return (Criteria) this;
        }

        public Criteria andCcyIsNull() {
            addCriterion("ccy is null");
            return (Criteria) this;
        }

        public Criteria andCcyIsNotNull() {
            addCriterion("ccy is not null");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("ccy =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyNotEqualTo(String value) {
            addCriterion("ccy <>", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyGreaterThan(String value) {
            addCriterion("ccy >", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyGreaterThanOrEqualTo(String value) {
            addCriterion("ccy >=", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyLessThan(String value) {
            addCriterion("ccy <", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyLessThanOrEqualTo(String value) {
            addCriterion("ccy <=", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyLike(String value) {
            addCriterion("ccy like", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyNotLike(String value) {
            addCriterion("ccy not like", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyIn(List<String> values) {
            addCriterion("ccy in", values, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyNotIn(List<String> values) {
            addCriterion("ccy not in", values, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyBetween(String value1, String value2) {
            addCriterion("ccy between", value1, value2, "ccy");
            return (Criteria) this;
        }

        public Criteria andCcyNotBetween(String value1, String value2) {
            addCriterion("ccy not between", value1, value2, "ccy");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoIsNull() {
            addCriterion("loan_card_no is null");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoIsNotNull() {
            addCriterion("loan_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoEqualTo(String value) {
            addCriterion("loan_card_no =", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoNotEqualTo(String value) {
            addCriterion("loan_card_no <>", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoGreaterThan(String value) {
            addCriterion("loan_card_no >", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("loan_card_no >=", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoLessThan(String value) {
            addCriterion("loan_card_no <", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoLessThanOrEqualTo(String value) {
            addCriterion("loan_card_no <=", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoLike(String value) {
            addCriterion("loan_card_no like", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoNotLike(String value) {
            addCriterion("loan_card_no not like", value, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoIn(List<String> values) {
            addCriterion("loan_card_no in", values, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoNotIn(List<String> values) {
            addCriterion("loan_card_no not in", values, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoBetween(String value1, String value2) {
            addCriterion("loan_card_no between", value1, value2, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andLoanCardNoNotBetween(String value1, String value2) {
            addCriterion("loan_card_no not between", value1, value2, "loanCardNo");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationIsNull() {
            addCriterion("national_tax_registration is null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationIsNotNull() {
            addCriterion("national_tax_registration is not null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationEqualTo(String value) {
            addCriterion("national_tax_registration =", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationNotEqualTo(String value) {
            addCriterion("national_tax_registration <>", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationGreaterThan(String value) {
            addCriterion("national_tax_registration >", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationGreaterThanOrEqualTo(String value) {
            addCriterion("national_tax_registration >=", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationLessThan(String value) {
            addCriterion("national_tax_registration <", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationLessThanOrEqualTo(String value) {
            addCriterion("national_tax_registration <=", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationLike(String value) {
            addCriterion("national_tax_registration like", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationNotLike(String value) {
            addCriterion("national_tax_registration not like", value, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationIn(List<String> values) {
            addCriterion("national_tax_registration in", values, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationNotIn(List<String> values) {
            addCriterion("national_tax_registration not in", values, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationBetween(String value1, String value2) {
            addCriterion("national_tax_registration between", value1, value2, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andNationalTaxRegistrationNotBetween(String value1, String value2) {
            addCriterion("national_tax_registration not between", value1, value2, "nationalTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationIsNull() {
            addCriterion("local_tax_registration is null");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationIsNotNull() {
            addCriterion("local_tax_registration is not null");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationEqualTo(String value) {
            addCriterion("local_tax_registration =", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationNotEqualTo(String value) {
            addCriterion("local_tax_registration <>", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationGreaterThan(String value) {
            addCriterion("local_tax_registration >", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationGreaterThanOrEqualTo(String value) {
            addCriterion("local_tax_registration >=", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationLessThan(String value) {
            addCriterion("local_tax_registration <", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationLessThanOrEqualTo(String value) {
            addCriterion("local_tax_registration <=", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationLike(String value) {
            addCriterion("local_tax_registration like", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationNotLike(String value) {
            addCriterion("local_tax_registration not like", value, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationIn(List<String> values) {
            addCriterion("local_tax_registration in", values, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationNotIn(List<String> values) {
            addCriterion("local_tax_registration not in", values, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationBetween(String value1, String value2) {
            addCriterion("local_tax_registration between", value1, value2, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andLocalTaxRegistrationNotBetween(String value1, String value2) {
            addCriterion("local_tax_registration not between", value1, value2, "localTaxRegistration");
            return (Criteria) this;
        }

        public Criteria andRegCapIsNull() {
            addCriterion("reg_cap is null");
            return (Criteria) this;
        }

        public Criteria andRegCapIsNotNull() {
            addCriterion("reg_cap is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapEqualTo(Integer value) {
            addCriterion("reg_cap =", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotEqualTo(Integer value) {
            addCriterion("reg_cap <>", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapGreaterThan(Integer value) {
            addCriterion("reg_cap >", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_cap >=", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapLessThan(Integer value) {
            addCriterion("reg_cap <", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapLessThanOrEqualTo(Integer value) {
            addCriterion("reg_cap <=", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapIn(List<Integer> values) {
            addCriterion("reg_cap in", values, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotIn(List<Integer> values) {
            addCriterion("reg_cap not in", values, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapBetween(Integer value1, Integer value2) {
            addCriterion("reg_cap between", value1, value2, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_cap not between", value1, value2, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegAddressIsNull() {
            addCriterion("reg_address is null");
            return (Criteria) this;
        }

        public Criteria andRegAddressIsNotNull() {
            addCriterion("reg_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddressEqualTo(String value) {
            addCriterion("reg_address =", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressNotEqualTo(String value) {
            addCriterion("reg_address <>", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressGreaterThan(String value) {
            addCriterion("reg_address >", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressGreaterThanOrEqualTo(String value) {
            addCriterion("reg_address >=", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressLessThan(String value) {
            addCriterion("reg_address <", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressLessThanOrEqualTo(String value) {
            addCriterion("reg_address <=", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressLike(String value) {
            addCriterion("reg_address like", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressNotLike(String value) {
            addCriterion("reg_address not like", value, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressIn(List<String> values) {
            addCriterion("reg_address in", values, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressNotIn(List<String> values) {
            addCriterion("reg_address not in", values, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressBetween(String value1, String value2) {
            addCriterion("reg_address between", value1, value2, "regAddress");
            return (Criteria) this;
        }

        public Criteria andRegAddressNotBetween(String value1, String value2) {
            addCriterion("reg_address not between", value1, value2, "regAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNull() {
            addCriterion("office_address is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNotNull() {
            addCriterion("office_address is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressEqualTo(String value) {
            addCriterion("office_address =", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotEqualTo(String value) {
            addCriterion("office_address <>", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThan(String value) {
            addCriterion("office_address >", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("office_address >=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThan(String value) {
            addCriterion("office_address <", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThanOrEqualTo(String value) {
            addCriterion("office_address <=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLike(String value) {
            addCriterion("office_address like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotLike(String value) {
            addCriterion("office_address not like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIn(List<String> values) {
            addCriterion("office_address in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotIn(List<String> values) {
            addCriterion("office_address not in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressBetween(String value1, String value2) {
            addCriterion("office_address between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotBetween(String value1, String value2) {
            addCriterion("office_address not between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalIsNull() {
            addCriterion("spec_natural is null");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalIsNotNull() {
            addCriterion("spec_natural is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalEqualTo(String value) {
            addCriterion("spec_natural =", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalNotEqualTo(String value) {
            addCriterion("spec_natural <>", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalGreaterThan(String value) {
            addCriterion("spec_natural >", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalGreaterThanOrEqualTo(String value) {
            addCriterion("spec_natural >=", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalLessThan(String value) {
            addCriterion("spec_natural <", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalLessThanOrEqualTo(String value) {
            addCriterion("spec_natural <=", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalLike(String value) {
            addCriterion("spec_natural like", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalNotLike(String value) {
            addCriterion("spec_natural not like", value, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalIn(List<String> values) {
            addCriterion("spec_natural in", values, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalNotIn(List<String> values) {
            addCriterion("spec_natural not in", values, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalBetween(String value1, String value2) {
            addCriterion("spec_natural between", value1, value2, "specNatural");
            return (Criteria) this;
        }

        public Criteria andSpecNaturalNotBetween(String value1, String value2) {
            addCriterion("spec_natural not between", value1, value2, "specNatural");
            return (Criteria) this;
        }

        public Criteria andBusiScopeIsNull() {
            addCriterion("busi_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusiScopeIsNotNull() {
            addCriterion("busi_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusiScopeEqualTo(String value) {
            addCriterion("busi_scope =", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeNotEqualTo(String value) {
            addCriterion("busi_scope <>", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeGreaterThan(String value) {
            addCriterion("busi_scope >", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeGreaterThanOrEqualTo(String value) {
            addCriterion("busi_scope >=", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeLessThan(String value) {
            addCriterion("busi_scope <", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeLessThanOrEqualTo(String value) {
            addCriterion("busi_scope <=", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeLike(String value) {
            addCriterion("busi_scope like", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeNotLike(String value) {
            addCriterion("busi_scope not like", value, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeIn(List<String> values) {
            addCriterion("busi_scope in", values, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeNotIn(List<String> values) {
            addCriterion("busi_scope not in", values, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeBetween(String value1, String value2) {
            addCriterion("busi_scope between", value1, value2, "busiScope");
            return (Criteria) this;
        }

        public Criteria andBusiScopeNotBetween(String value1, String value2) {
            addCriterion("busi_scope not between", value1, value2, "busiScope");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcIsNull() {
            addCriterion("history_evc is null");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcIsNotNull() {
            addCriterion("history_evc is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcEqualTo(String value) {
            addCriterion("history_evc =", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcNotEqualTo(String value) {
            addCriterion("history_evc <>", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcGreaterThan(String value) {
            addCriterion("history_evc >", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcGreaterThanOrEqualTo(String value) {
            addCriterion("history_evc >=", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcLessThan(String value) {
            addCriterion("history_evc <", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcLessThanOrEqualTo(String value) {
            addCriterion("history_evc <=", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcLike(String value) {
            addCriterion("history_evc like", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcNotLike(String value) {
            addCriterion("history_evc not like", value, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcIn(List<String> values) {
            addCriterion("history_evc in", values, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcNotIn(List<String> values) {
            addCriterion("history_evc not in", values, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcBetween(String value1, String value2) {
            addCriterion("history_evc between", value1, value2, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andHistoryEvcNotBetween(String value1, String value2) {
            addCriterion("history_evc not between", value1, value2, "historyEvc");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdIsNull() {
            addCriterion("rela_corp_id is null");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdIsNotNull() {
            addCriterion("rela_corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdEqualTo(String value) {
            addCriterion("rela_corp_id =", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdNotEqualTo(String value) {
            addCriterion("rela_corp_id <>", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdGreaterThan(String value) {
            addCriterion("rela_corp_id >", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdGreaterThanOrEqualTo(String value) {
            addCriterion("rela_corp_id >=", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdLessThan(String value) {
            addCriterion("rela_corp_id <", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdLessThanOrEqualTo(String value) {
            addCriterion("rela_corp_id <=", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdLike(String value) {
            addCriterion("rela_corp_id like", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdNotLike(String value) {
            addCriterion("rela_corp_id not like", value, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdIn(List<String> values) {
            addCriterion("rela_corp_id in", values, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdNotIn(List<String> values) {
            addCriterion("rela_corp_id not in", values, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdBetween(String value1, String value2) {
            addCriterion("rela_corp_id between", value1, value2, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andRelaCorpIdNotBetween(String value1, String value2) {
            addCriterion("rela_corp_id not between", value1, value2, "relaCorpId");
            return (Criteria) this;
        }

        public Criteria andStaffNumIsNull() {
            addCriterion("staff_num is null");
            return (Criteria) this;
        }

        public Criteria andStaffNumIsNotNull() {
            addCriterion("staff_num is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNumEqualTo(Integer value) {
            addCriterion("staff_num =", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumNotEqualTo(Integer value) {
            addCriterion("staff_num <>", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumGreaterThan(Integer value) {
            addCriterion("staff_num >", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_num >=", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumLessThan(Integer value) {
            addCriterion("staff_num <", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumLessThanOrEqualTo(Integer value) {
            addCriterion("staff_num <=", value, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumIn(List<Integer> values) {
            addCriterion("staff_num in", values, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumNotIn(List<Integer> values) {
            addCriterion("staff_num not in", values, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumBetween(Integer value1, Integer value2) {
            addCriterion("staff_num between", value1, value2, "staffNum");
            return (Criteria) this;
        }

        public Criteria andStaffNumNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_num not between", value1, value2, "staffNum");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNull() {
            addCriterion("fixed_phone is null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNotNull() {
            addCriterion("fixed_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneEqualTo(String value) {
            addCriterion("fixed_phone =", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotEqualTo(String value) {
            addCriterion("fixed_phone <>", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThan(String value) {
            addCriterion("fixed_phone >", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_phone >=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThan(String value) {
            addCriterion("fixed_phone <", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThanOrEqualTo(String value) {
            addCriterion("fixed_phone <=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLike(String value) {
            addCriterion("fixed_phone like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotLike(String value) {
            addCriterion("fixed_phone not like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIn(List<String> values) {
            addCriterion("fixed_phone in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotIn(List<String> values) {
            addCriterion("fixed_phone not in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneBetween(String value1, String value2) {
            addCriterion("fixed_phone between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotBetween(String value1, String value2) {
            addCriterion("fixed_phone not between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andContactInfoIsNull() {
            addCriterion("contact_info is null");
            return (Criteria) this;
        }

        public Criteria andContactInfoIsNotNull() {
            addCriterion("contact_info is not null");
            return (Criteria) this;
        }

        public Criteria andContactInfoEqualTo(String value) {
            addCriterion("contact_info =", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoNotEqualTo(String value) {
            addCriterion("contact_info <>", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoGreaterThan(String value) {
            addCriterion("contact_info >", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoGreaterThanOrEqualTo(String value) {
            addCriterion("contact_info >=", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoLessThan(String value) {
            addCriterion("contact_info <", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoLessThanOrEqualTo(String value) {
            addCriterion("contact_info <=", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoLike(String value) {
            addCriterion("contact_info like", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoNotLike(String value) {
            addCriterion("contact_info not like", value, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoIn(List<String> values) {
            addCriterion("contact_info in", values, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoNotIn(List<String> values) {
            addCriterion("contact_info not in", values, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoBetween(String value1, String value2) {
            addCriterion("contact_info between", value1, value2, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andContactInfoNotBetween(String value1, String value2) {
            addCriterion("contact_info not between", value1, value2, "contactInfo");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}