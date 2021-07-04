package com.macro.mall.model;

import static com.macro.mall.constant.MbgConstants.CREATE_TIME;
import static com.macro.mall.constant.MbgConstants.HANDLE_STATUS;
import static com.macro.mall.constant.MbgConstants.ID;
import static com.macro.mall.constant.MbgConstants.NOTE;
import static com.macro.mall.constant.MbgConstants.REPORT_MEMBER_NAME;
import static com.macro.mall.constant.MbgConstants.REPORT_OBJECT;
import static com.macro.mall.constant.MbgConstants.REPORT_STATUS;
import static com.macro.mall.constant.MbgConstants.REPORT_TYPE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsMemberReportExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsMemberReportExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, ID);
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNull() {
            addCriterion("report_type is null");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNotNull() {
            addCriterion("report_type is not null");
            return (Criteria) this;
        }

        public Criteria andReportTypeEqualTo(Integer value) {
            addCriterion("report_type =", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeNotEqualTo(Integer value) {
            addCriterion("report_type <>", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThan(Integer value) {
            addCriterion("report_type >", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_type >=", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThan(Integer value) {
            addCriterion("report_type <", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("report_type <=", value, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeIn(List<Integer> values) {
            addCriterion("report_type in", values, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeNotIn(List<Integer> values) {
            addCriterion("report_type not in", values, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("report_type between", value1, value2, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_type not between", value1, value2, REPORT_TYPE);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameIsNull() {
            addCriterion("report_member_name is null");
            return (Criteria) this;
        }

        public Criteria andReportMemberNameIsNotNull() {
            addCriterion("report_member_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportMemberNameEqualTo(String value) {
            addCriterion("report_member_name =", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameNotEqualTo(String value) {
            addCriterion("report_member_name <>", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameGreaterThan(String value) {
            addCriterion("report_member_name >", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_member_name >=", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameLessThan(String value) {
            addCriterion("report_member_name <", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameLessThanOrEqualTo(String value) {
            addCriterion("report_member_name <=", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameLike(String value) {
            addCriterion("report_member_name like", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameNotLike(String value) {
            addCriterion("report_member_name not like", value, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameIn(List<String> values) {
            addCriterion("report_member_name in", values, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameNotIn(List<String> values) {
            addCriterion("report_member_name not in", values, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameBetween(String value1, String value2) {
            addCriterion("report_member_name between", value1, value2, REPORT_MEMBER_NAME);
            return (Criteria) this;
        }

        public Criteria andReportMemberNameNotBetween(String value1, String value2) {
            addCriterion("report_member_name not between", value1, value2, REPORT_MEMBER_NAME);
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
            addCriterion("create_time =", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andReportObjectIsNull() {
            addCriterion("report_object is null");
            return (Criteria) this;
        }

        public Criteria andReportObjectIsNotNull() {
            addCriterion("report_object is not null");
            return (Criteria) this;
        }

        public Criteria andReportObjectEqualTo(String value) {
            addCriterion("report_object =", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectNotEqualTo(String value) {
            addCriterion("report_object <>", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectGreaterThan(String value) {
            addCriterion("report_object >", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectGreaterThanOrEqualTo(String value) {
            addCriterion("report_object >=", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectLessThan(String value) {
            addCriterion("report_object <", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectLessThanOrEqualTo(String value) {
            addCriterion("report_object <=", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectLike(String value) {
            addCriterion("report_object like", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectNotLike(String value) {
            addCriterion("report_object not like", value, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectIn(List<String> values) {
            addCriterion("report_object in", values, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectNotIn(List<String> values) {
            addCriterion("report_object not in", values, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectBetween(String value1, String value2) {
            addCriterion("report_object between", value1, value2, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportObjectNotBetween(String value1, String value2) {
            addCriterion("report_object not between", value1, value2, REPORT_OBJECT);
            return (Criteria) this;
        }

        public Criteria andReportStatusIsNull() {
            addCriterion("report_status is null");
            return (Criteria) this;
        }

        public Criteria andReportStatusIsNotNull() {
            addCriterion("report_status is not null");
            return (Criteria) this;
        }

        public Criteria andReportStatusEqualTo(Integer value) {
            addCriterion("report_status =", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusNotEqualTo(Integer value) {
            addCriterion("report_status <>", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusGreaterThan(Integer value) {
            addCriterion("report_status >", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_status >=", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusLessThan(Integer value) {
            addCriterion("report_status <", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusLessThanOrEqualTo(Integer value) {
            addCriterion("report_status <=", value, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusIn(List<Integer> values) {
            addCriterion("report_status in", values, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusNotIn(List<Integer> values) {
            addCriterion("report_status not in", values, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusBetween(Integer value1, Integer value2) {
            addCriterion("report_status between", value1, value2, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andReportStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("report_status not between", value1, value2, REPORT_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(Integer value) {
            addCriterion("handle_status =", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(Integer value) {
            addCriterion("handle_status <>", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(Integer value) {
            addCriterion("handle_status >", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("handle_status >=", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(Integer value) {
            addCriterion("handle_status <", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("handle_status <=", value, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(List<Integer> values) {
            addCriterion("handle_status in", values, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(List<Integer> values) {
            addCriterion("handle_status not in", values, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(Integer value1, Integer value2) {
            addCriterion("handle_status between", value1, value2, HANDLE_STATUS);
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("handle_status not between", value1, value2, HANDLE_STATUS);
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
            addCriterion("note =", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, NOTE);
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, NOTE);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {

        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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