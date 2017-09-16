package com.guowei.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GwTemplateproductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GwTemplateproductExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andWarnstockIsNull() {
            addCriterion("warnstock is null");
            return (Criteria) this;
        }

        public Criteria andWarnstockIsNotNull() {
            addCriterion("warnstock is not null");
            return (Criteria) this;
        }

        public Criteria andWarnstockEqualTo(Integer value) {
            addCriterion("warnstock =", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockNotEqualTo(Integer value) {
            addCriterion("warnstock <>", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockGreaterThan(Integer value) {
            addCriterion("warnstock >", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockGreaterThanOrEqualTo(Integer value) {
            addCriterion("warnstock >=", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockLessThan(Integer value) {
            addCriterion("warnstock <", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockLessThanOrEqualTo(Integer value) {
            addCriterion("warnstock <=", value, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockIn(List<Integer> values) {
            addCriterion("warnstock in", values, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockNotIn(List<Integer> values) {
            addCriterion("warnstock not in", values, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockBetween(Integer value1, Integer value2) {
            addCriterion("warnstock between", value1, value2, "warnstock");
            return (Criteria) this;
        }

        public Criteria andWarnstockNotBetween(Integer value1, Integer value2) {
            addCriterion("warnstock not between", value1, value2, "warnstock");
            return (Criteria) this;
        }

        public Criteria andSellpriceIsNull() {
            addCriterion("sellprice is null");
            return (Criteria) this;
        }

        public Criteria andSellpriceIsNotNull() {
            addCriterion("sellprice is not null");
            return (Criteria) this;
        }

        public Criteria andSellpriceEqualTo(BigDecimal value) {
            addCriterion("sellprice =", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotEqualTo(BigDecimal value) {
            addCriterion("sellprice <>", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceGreaterThan(BigDecimal value) {
            addCriterion("sellprice >", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellprice >=", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceLessThan(BigDecimal value) {
            addCriterion("sellprice <", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellprice <=", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceIn(List<BigDecimal> values) {
            addCriterion("sellprice in", values, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotIn(List<BigDecimal> values) {
            addCriterion("sellprice not in", values, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellprice between", value1, value2, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellprice not between", value1, value2, "sellprice");
            return (Criteria) this;
        }

        public Criteria andStorageracksIsNull() {
            addCriterion("storageracks is null");
            return (Criteria) this;
        }

        public Criteria andStorageracksIsNotNull() {
            addCriterion("storageracks is not null");
            return (Criteria) this;
        }

        public Criteria andStorageracksEqualTo(Byte value) {
            addCriterion("storageracks =", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksNotEqualTo(Byte value) {
            addCriterion("storageracks <>", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksGreaterThan(Byte value) {
            addCriterion("storageracks >", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksGreaterThanOrEqualTo(Byte value) {
            addCriterion("storageracks >=", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksLessThan(Byte value) {
            addCriterion("storageracks <", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksLessThanOrEqualTo(Byte value) {
            addCriterion("storageracks <=", value, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksIn(List<Byte> values) {
            addCriterion("storageracks in", values, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksNotIn(List<Byte> values) {
            addCriterion("storageracks not in", values, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksBetween(Byte value1, Byte value2) {
            addCriterion("storageracks between", value1, value2, "storageracks");
            return (Criteria) this;
        }

        public Criteria andStorageracksNotBetween(Byte value1, Byte value2) {
            addCriterion("storageracks not between", value1, value2, "storageracks");
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

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andPronameIsNull() {
            addCriterion("proName is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proName is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(String value) {
            addCriterion("proName =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(String value) {
            addCriterion("proName <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(String value) {
            addCriterion("proName >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(String value) {
            addCriterion("proName >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(String value) {
            addCriterion("proName <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(String value) {
            addCriterion("proName <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLike(String value) {
            addCriterion("proName like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotLike(String value) {
            addCriterion("proName not like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<String> values) {
            addCriterion("proName in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<String> values) {
            addCriterion("proName not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(String value1, String value2) {
            addCriterion("proName between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(String value1, String value2) {
            addCriterion("proName not between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andProimageIsNull() {
            addCriterion("proImage is null");
            return (Criteria) this;
        }

        public Criteria andProimageIsNotNull() {
            addCriterion("proImage is not null");
            return (Criteria) this;
        }

        public Criteria andProimageEqualTo(String value) {
            addCriterion("proImage =", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageNotEqualTo(String value) {
            addCriterion("proImage <>", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageGreaterThan(String value) {
            addCriterion("proImage >", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageGreaterThanOrEqualTo(String value) {
            addCriterion("proImage >=", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageLessThan(String value) {
            addCriterion("proImage <", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageLessThanOrEqualTo(String value) {
            addCriterion("proImage <=", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageLike(String value) {
            addCriterion("proImage like", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageNotLike(String value) {
            addCriterion("proImage not like", value, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageIn(List<String> values) {
            addCriterion("proImage in", values, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageNotIn(List<String> values) {
            addCriterion("proImage not in", values, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageBetween(String value1, String value2) {
            addCriterion("proImage between", value1, value2, "proimage");
            return (Criteria) this;
        }

        public Criteria andProimageNotBetween(String value1, String value2) {
            addCriterion("proImage not between", value1, value2, "proimage");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNull() {
            addCriterion("proPrice is null");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNotNull() {
            addCriterion("proPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPropriceEqualTo(BigDecimal value) {
            addCriterion("proPrice =", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotEqualTo(BigDecimal value) {
            addCriterion("proPrice <>", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThan(BigDecimal value) {
            addCriterion("proPrice >", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proPrice >=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThan(BigDecimal value) {
            addCriterion("proPrice <", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proPrice <=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceIn(List<BigDecimal> values) {
            addCriterion("proPrice in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotIn(List<BigDecimal> values) {
            addCriterion("proPrice not in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proPrice between", value1, value2, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proPrice not between", value1, value2, "proprice");
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