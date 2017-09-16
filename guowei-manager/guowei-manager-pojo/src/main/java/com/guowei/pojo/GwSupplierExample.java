package com.guowei.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GwSupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GwSupplierExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Long value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Long value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Long value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Long value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Long value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Long value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Long> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Long> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Long value1, Long value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Long value1, Long value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("supplier_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("supplier_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("supplier_name =", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("supplier_name <>", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("supplier_name >", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_name >=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("supplier_name <", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_name <=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("supplier_name like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("supplier_name not like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("supplier_name in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("supplier_name not in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("supplier_name between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("supplier_name not between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNull() {
            addCriterion("supplier_addr is null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNotNull() {
            addCriterion("supplier_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrEqualTo(String value) {
            addCriterion("supplier_addr =", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotEqualTo(String value) {
            addCriterion("supplier_addr <>", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThan(String value) {
            addCriterion("supplier_addr >", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_addr >=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThan(String value) {
            addCriterion("supplier_addr <", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThanOrEqualTo(String value) {
            addCriterion("supplier_addr <=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLike(String value) {
            addCriterion("supplier_addr like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotLike(String value) {
            addCriterion("supplier_addr not like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIn(List<String> values) {
            addCriterion("supplier_addr in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotIn(List<String> values) {
            addCriterion("supplier_addr not in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrBetween(String value1, String value2) {
            addCriterion("supplier_addr between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotBetween(String value1, String value2) {
            addCriterion("supplier_addr not between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameIsNull() {
            addCriterion("supplier_contactname is null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameIsNotNull() {
            addCriterion("supplier_contactname is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameEqualTo(String value) {
            addCriterion("supplier_contactname =", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameNotEqualTo(String value) {
            addCriterion("supplier_contactname <>", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameGreaterThan(String value) {
            addCriterion("supplier_contactname >", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_contactname >=", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameLessThan(String value) {
            addCriterion("supplier_contactname <", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameLessThanOrEqualTo(String value) {
            addCriterion("supplier_contactname <=", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameLike(String value) {
            addCriterion("supplier_contactname like", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameNotLike(String value) {
            addCriterion("supplier_contactname not like", value, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameIn(List<String> values) {
            addCriterion("supplier_contactname in", values, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameNotIn(List<String> values) {
            addCriterion("supplier_contactname not in", values, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameBetween(String value1, String value2) {
            addCriterion("supplier_contactname between", value1, value2, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactnameNotBetween(String value1, String value2) {
            addCriterion("supplier_contactname not between", value1, value2, "supplierContactname");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionIsNull() {
            addCriterion("supplier_contactposition is null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionIsNotNull() {
            addCriterion("supplier_contactposition is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionEqualTo(String value) {
            addCriterion("supplier_contactposition =", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionNotEqualTo(String value) {
            addCriterion("supplier_contactposition <>", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionGreaterThan(String value) {
            addCriterion("supplier_contactposition >", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_contactposition >=", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionLessThan(String value) {
            addCriterion("supplier_contactposition <", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionLessThanOrEqualTo(String value) {
            addCriterion("supplier_contactposition <=", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionLike(String value) {
            addCriterion("supplier_contactposition like", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionNotLike(String value) {
            addCriterion("supplier_contactposition not like", value, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionIn(List<String> values) {
            addCriterion("supplier_contactposition in", values, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionNotIn(List<String> values) {
            addCriterion("supplier_contactposition not in", values, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionBetween(String value1, String value2) {
            addCriterion("supplier_contactposition between", value1, value2, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactpositionNotBetween(String value1, String value2) {
            addCriterion("supplier_contactposition not between", value1, value2, "supplierContactposition");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneIsNull() {
            addCriterion("supplier_contactphone is null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneIsNotNull() {
            addCriterion("supplier_contactphone is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneEqualTo(String value) {
            addCriterion("supplier_contactphone =", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneNotEqualTo(String value) {
            addCriterion("supplier_contactphone <>", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneGreaterThan(String value) {
            addCriterion("supplier_contactphone >", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_contactphone >=", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneLessThan(String value) {
            addCriterion("supplier_contactphone <", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneLessThanOrEqualTo(String value) {
            addCriterion("supplier_contactphone <=", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneLike(String value) {
            addCriterion("supplier_contactphone like", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneNotLike(String value) {
            addCriterion("supplier_contactphone not like", value, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneIn(List<String> values) {
            addCriterion("supplier_contactphone in", values, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneNotIn(List<String> values) {
            addCriterion("supplier_contactphone not in", values, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneBetween(String value1, String value2) {
            addCriterion("supplier_contactphone between", value1, value2, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactphoneNotBetween(String value1, String value2) {
            addCriterion("supplier_contactphone not between", value1, value2, "supplierContactphone");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatIsNull() {
            addCriterion("supplier_contactwechat is null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatIsNotNull() {
            addCriterion("supplier_contactwechat is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatEqualTo(String value) {
            addCriterion("supplier_contactwechat =", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatNotEqualTo(String value) {
            addCriterion("supplier_contactwechat <>", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatGreaterThan(String value) {
            addCriterion("supplier_contactwechat >", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_contactwechat >=", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatLessThan(String value) {
            addCriterion("supplier_contactwechat <", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatLessThanOrEqualTo(String value) {
            addCriterion("supplier_contactwechat <=", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatLike(String value) {
            addCriterion("supplier_contactwechat like", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatNotLike(String value) {
            addCriterion("supplier_contactwechat not like", value, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatIn(List<String> values) {
            addCriterion("supplier_contactwechat in", values, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatNotIn(List<String> values) {
            addCriterion("supplier_contactwechat not in", values, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatBetween(String value1, String value2) {
            addCriterion("supplier_contactwechat between", value1, value2, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andSupplierContactwechatNotBetween(String value1, String value2) {
            addCriterion("supplier_contactwechat not between", value1, value2, "supplierContactwechat");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
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