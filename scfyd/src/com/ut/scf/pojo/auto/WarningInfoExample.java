package com.ut.scf.pojo.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WarningInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public WarningInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andWarningIdIsNull() {
			addCriterion("warning_id is null");
			return (Criteria) this;
		}

		public Criteria andWarningIdIsNotNull() {
			addCriterion("warning_id is not null");
			return (Criteria) this;
		}

		public Criteria andWarningIdEqualTo(String value) {
			addCriterion("warning_id =", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdNotEqualTo(String value) {
			addCriterion("warning_id <>", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdGreaterThan(String value) {
			addCriterion("warning_id >", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdGreaterThanOrEqualTo(String value) {
			addCriterion("warning_id >=", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdLessThan(String value) {
			addCriterion("warning_id <", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdLessThanOrEqualTo(String value) {
			addCriterion("warning_id <=", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdLike(String value) {
			addCriterion("warning_id like", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdNotLike(String value) {
			addCriterion("warning_id not like", value, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdIn(List<String> values) {
			addCriterion("warning_id in", values, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdNotIn(List<String> values) {
			addCriterion("warning_id not in", values, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdBetween(String value1, String value2) {
			addCriterion("warning_id between", value1, value2, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningIdNotBetween(String value1, String value2) {
			addCriterion("warning_id not between", value1, value2, "warningId");
			return (Criteria) this;
		}

		public Criteria andWarningTitleIsNull() {
			addCriterion("warning_title is null");
			return (Criteria) this;
		}

		public Criteria andWarningTitleIsNotNull() {
			addCriterion("warning_title is not null");
			return (Criteria) this;
		}

		public Criteria andWarningTitleEqualTo(String value) {
			addCriterion("warning_title =", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleNotEqualTo(String value) {
			addCriterion("warning_title <>", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleGreaterThan(String value) {
			addCriterion("warning_title >", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleGreaterThanOrEqualTo(String value) {
			addCriterion("warning_title >=", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleLessThan(String value) {
			addCriterion("warning_title <", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleLessThanOrEqualTo(String value) {
			addCriterion("warning_title <=", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleLike(String value) {
			addCriterion("warning_title like", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleNotLike(String value) {
			addCriterion("warning_title not like", value, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleIn(List<String> values) {
			addCriterion("warning_title in", values, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleNotIn(List<String> values) {
			addCriterion("warning_title not in", values, "warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleBetween(String value1, String value2) {
			addCriterion("warning_title between", value1, value2,
					"warningTitle");
			return (Criteria) this;
		}

		public Criteria andWarningTitleNotBetween(String value1, String value2) {
			addCriterion("warning_title not between", value1, value2,
					"warningTitle");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("send_time is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("send_time is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("send_time =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("send_time <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("send_time >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("send_time >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterionForJDBCDate("send_time <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("send_time <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("send_time in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("send_time not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("send_time between", value1, value2,
					"sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("send_time not between", value1, value2,
					"sendTime");
			return (Criteria) this;
		}

		public Criteria andWarningStatusIsNull() {
			addCriterion("warning_status is null");
			return (Criteria) this;
		}

		public Criteria andWarningStatusIsNotNull() {
			addCriterion("warning_status is not null");
			return (Criteria) this;
		}

		public Criteria andWarningStatusEqualTo(String value) {
			addCriterion("warning_status =", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusNotEqualTo(String value) {
			addCriterion("warning_status <>", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusGreaterThan(String value) {
			addCriterion("warning_status >", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusGreaterThanOrEqualTo(String value) {
			addCriterion("warning_status >=", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusLessThan(String value) {
			addCriterion("warning_status <", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusLessThanOrEqualTo(String value) {
			addCriterion("warning_status <=", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusLike(String value) {
			addCriterion("warning_status like", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusNotLike(String value) {
			addCriterion("warning_status not like", value, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusIn(List<String> values) {
			addCriterion("warning_status in", values, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusNotIn(List<String> values) {
			addCriterion("warning_status not in", values, "warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusBetween(String value1, String value2) {
			addCriterion("warning_status between", value1, value2,
					"warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningStatusNotBetween(String value1, String value2) {
			addCriterion("warning_status not between", value1, value2,
					"warningStatus");
			return (Criteria) this;
		}

		public Criteria andWarningMsgIsNull() {
			addCriterion("warning_msg is null");
			return (Criteria) this;
		}

		public Criteria andWarningMsgIsNotNull() {
			addCriterion("warning_msg is not null");
			return (Criteria) this;
		}

		public Criteria andWarningMsgEqualTo(String value) {
			addCriterion("warning_msg =", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgNotEqualTo(String value) {
			addCriterion("warning_msg <>", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgGreaterThan(String value) {
			addCriterion("warning_msg >", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgGreaterThanOrEqualTo(String value) {
			addCriterion("warning_msg >=", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgLessThan(String value) {
			addCriterion("warning_msg <", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgLessThanOrEqualTo(String value) {
			addCriterion("warning_msg <=", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgLike(String value) {
			addCriterion("warning_msg like", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgNotLike(String value) {
			addCriterion("warning_msg not like", value, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgIn(List<String> values) {
			addCriterion("warning_msg in", values, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgNotIn(List<String> values) {
			addCriterion("warning_msg not in", values, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgBetween(String value1, String value2) {
			addCriterion("warning_msg between", value1, value2, "warningMsg");
			return (Criteria) this;
		}

		public Criteria andWarningMsgNotBetween(String value1, String value2) {
			addCriterion("warning_msg not between", value1, value2,
					"warningMsg");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table warning_info
	 * @mbggenerated  Thu May 25 17:06:18 CST 2017
	 */
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table warning_info
     *
     * @mbggenerated do_not_delete_during_merge Thu May 25 16:43:20 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}