package com.guowei.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GwCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GwCompanyExample() {
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

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("company_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("company_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("company_addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("company_addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("company_addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("company_addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("company_addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("company_addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("company_addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("company_addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("company_addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("company_addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("company_addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameIsNull() {
            addCriterion("company_contactname is null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameIsNotNull() {
            addCriterion("company_contactname is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameEqualTo(String value) {
            addCriterion("company_contactname =", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameNotEqualTo(String value) {
            addCriterion("company_contactname <>", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameGreaterThan(String value) {
            addCriterion("company_contactname >", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("company_contactname >=", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameLessThan(String value) {
            addCriterion("company_contactname <", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameLessThanOrEqualTo(String value) {
            addCriterion("company_contactname <=", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameLike(String value) {
            addCriterion("company_contactname like", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameNotLike(String value) {
            addCriterion("company_contactname not like", value, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameIn(List<String> values) {
            addCriterion("company_contactname in", values, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameNotIn(List<String> values) {
            addCriterion("company_contactname not in", values, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameBetween(String value1, String value2) {
            addCriterion("company_contactname between", value1, value2, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactnameNotBetween(String value1, String value2) {
            addCriterion("company_contactname not between", value1, value2, "companyContactname");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionIsNull() {
            addCriterion("company_contactposition is null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionIsNotNull() {
            addCriterion("company_contactposition is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionEqualTo(String value) {
            addCriterion("company_contactposition =", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionNotEqualTo(String value) {
            addCriterion("company_contactposition <>", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionGreaterThan(String value) {
            addCriterion("company_contactposition >", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionGreaterThanOrEqualTo(String value) {
            addCriterion("company_contactposition >=", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionLessThan(String value) {
            addCriterion("company_contactposition <", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionLessThanOrEqualTo(String value) {
            addCriterion("company_contactposition <=", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionLike(String value) {
            addCriterion("company_contactposition like", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionNotLike(String value) {
            addCriterion("company_contactposition not like", value, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionIn(List<String> values) {
            addCriterion("company_contactposition in", values, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionNotIn(List<String> values) {
            addCriterion("company_contactposition not in", values, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionBetween(String value1, String value2) {
            addCriterion("company_contactposition between", value1, value2, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactpositionNotBetween(String value1, String value2) {
            addCriterion("company_contactposition not between", value1, value2, "companyContactposition");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneIsNull() {
            addCriterion("company_contactphone is null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneIsNotNull() {
            addCriterion("company_contactphone is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneEqualTo(String value) {
            addCriterion("company_contactphone =", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneNotEqualTo(String value) {
            addCriterion("company_contactphone <>", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneGreaterThan(String value) {
            addCriterion("company_contactphone >", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneGreaterThanOrEqualTo(String value) {
            addCriterion("company_contactphone >=", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneLessThan(String value) {
            addCriterion("company_contactphone <", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneLessThanOrEqualTo(String value) {
            addCriterion("company_contactphone <=", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneLike(String value) {
            addCriterion("company_contactphone like", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneNotLike(String value) {
            addCriterion("company_contactphone not like", value, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneIn(List<String> values) {
            addCriterion("company_contactphone in", values, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneNotIn(List<String> values) {
            addCriterion("company_contactphone not in", values, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneBetween(String value1, String value2) {
            addCriterion("company_contactphone between", value1, value2, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactphoneNotBetween(String value1, String value2) {
            addCriterion("company_contactphone not between", value1, value2, "companyContactphone");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatIsNull() {
            addCriterion("company_contactwechat is null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatIsNotNull() {
            addCriterion("company_contactwechat is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatEqualTo(String value) {
            addCriterion("company_contactwechat =", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatNotEqualTo(String value) {
            addCriterion("company_contactwechat <>", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatGreaterThan(String value) {
            addCriterion("company_contactwechat >", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatGreaterThanOrEqualTo(String value) {
            addCriterion("company_contactwechat >=", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatLessThan(String value) {
            addCriterion("company_contactwechat <", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatLessThanOrEqualTo(String value) {
            addCriterion("company_contactwechat <=", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatLike(String value) {
            addCriterion("company_contactwechat like", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatNotLike(String value) {
            addCriterion("company_contactwechat not like", value, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatIn(List<String> values) {
            addCriterion("company_contactwechat in", values, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatNotIn(List<String> values) {
            addCriterion("company_contactwechat not in", values, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatBetween(String value1, String value2) {
            addCriterion("company_contactwechat between", value1, value2, "companyContactwechat");
            return (Criteria) this;
        }

        public Criteria andCompanyContactwechatNotBetween(String value1, String value2) {
            addCriterion("company_contactwechat not between", value1, value2, "companyContactwechat");
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

        public Criteria andPurchasedIsNull() {
            addCriterion("purchased is null");
            return (Criteria) this;
        }

        public Criteria andPurchasedIsNotNull() {
            addCriterion("purchased is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasedEqualTo(Date value) {
            addCriterion("purchased =", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedNotEqualTo(Date value) {
            addCriterion("purchased <>", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedGreaterThan(Date value) {
            addCriterion("purchased >", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedGreaterThanOrEqualTo(Date value) {
            addCriterion("purchased >=", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedLessThan(Date value) {
            addCriterion("purchased <", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedLessThanOrEqualTo(Date value) {
            addCriterion("purchased <=", value, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedIn(List<Date> values) {
            addCriterion("purchased in", values, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedNotIn(List<Date> values) {
            addCriterion("purchased not in", values, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedBetween(Date value1, Date value2) {
            addCriterion("purchased between", value1, value2, "purchased");
            return (Criteria) this;
        }

        public Criteria andPurchasedNotBetween(Date value1, Date value2) {
            addCriterion("purchased not between", value1, value2, "purchased");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Long value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Long value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Long value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Long value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Long value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Long value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Long> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Long> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Long value1, Long value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Long value1, Long value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdIsNull() {
            addCriterion("sectemplate_id is null");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdIsNotNull() {
            addCriterion("sectemplate_id is not null");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdEqualTo(Long value) {
            addCriterion("sectemplate_id =", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdNotEqualTo(Long value) {
            addCriterion("sectemplate_id <>", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdGreaterThan(Long value) {
            addCriterion("sectemplate_id >", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sectemplate_id >=", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdLessThan(Long value) {
            addCriterion("sectemplate_id <", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("sectemplate_id <=", value, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdIn(List<Long> values) {
            addCriterion("sectemplate_id in", values, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdNotIn(List<Long> values) {
            addCriterion("sectemplate_id not in", values, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdBetween(Long value1, Long value2) {
            addCriterion("sectemplate_id between", value1, value2, "sectemplateId");
            return (Criteria) this;
        }

        public Criteria andSectemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("sectemplate_id not between", value1, value2, "sectemplateId");
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