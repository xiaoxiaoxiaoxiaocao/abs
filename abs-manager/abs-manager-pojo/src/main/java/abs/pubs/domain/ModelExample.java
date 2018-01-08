package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class ModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNull() {
            addCriterion("resolution is null");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNotNull() {
            addCriterion("resolution is not null");
            return (Criteria) this;
        }

        public Criteria andResolutionEqualTo(String value) {
            addCriterion("resolution =", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotEqualTo(String value) {
            addCriterion("resolution <>", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThan(String value) {
            addCriterion("resolution >", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThanOrEqualTo(String value) {
            addCriterion("resolution >=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThan(String value) {
            addCriterion("resolution <", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThanOrEqualTo(String value) {
            addCriterion("resolution <=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLike(String value) {
            addCriterion("resolution like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotLike(String value) {
            addCriterion("resolution not like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionIn(List<String> values) {
            addCriterion("resolution in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotIn(List<String> values) {
            addCriterion("resolution not in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionBetween(String value1, String value2) {
            addCriterion("resolution between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotBetween(String value1, String value2) {
            addCriterion("resolution not between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andBgimgIsNull() {
            addCriterion("bgimg is null");
            return (Criteria) this;
        }

        public Criteria andBgimgIsNotNull() {
            addCriterion("bgimg is not null");
            return (Criteria) this;
        }

        public Criteria andBgimgEqualTo(String value) {
            addCriterion("bgimg =", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgNotEqualTo(String value) {
            addCriterion("bgimg <>", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgGreaterThan(String value) {
            addCriterion("bgimg >", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgGreaterThanOrEqualTo(String value) {
            addCriterion("bgimg >=", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgLessThan(String value) {
            addCriterion("bgimg <", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgLessThanOrEqualTo(String value) {
            addCriterion("bgimg <=", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgLike(String value) {
            addCriterion("bgimg like", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgNotLike(String value) {
            addCriterion("bgimg not like", value, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgIn(List<String> values) {
            addCriterion("bgimg in", values, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgNotIn(List<String> values) {
            addCriterion("bgimg not in", values, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgBetween(String value1, String value2) {
            addCriterion("bgimg between", value1, value2, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgimgNotBetween(String value1, String value2) {
            addCriterion("bgimg not between", value1, value2, "bgimg");
            return (Criteria) this;
        }

        public Criteria andBgcolorIsNull() {
            addCriterion("bgcolor is null");
            return (Criteria) this;
        }

        public Criteria andBgcolorIsNotNull() {
            addCriterion("bgcolor is not null");
            return (Criteria) this;
        }

        public Criteria andBgcolorEqualTo(String value) {
            addCriterion("bgcolor =", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotEqualTo(String value) {
            addCriterion("bgcolor <>", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorGreaterThan(String value) {
            addCriterion("bgcolor >", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorGreaterThanOrEqualTo(String value) {
            addCriterion("bgcolor >=", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLessThan(String value) {
            addCriterion("bgcolor <", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLessThanOrEqualTo(String value) {
            addCriterion("bgcolor <=", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorLike(String value) {
            addCriterion("bgcolor like", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotLike(String value) {
            addCriterion("bgcolor not like", value, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorIn(List<String> values) {
            addCriterion("bgcolor in", values, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotIn(List<String> values) {
            addCriterion("bgcolor not in", values, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorBetween(String value1, String value2) {
            addCriterion("bgcolor between", value1, value2, "bgcolor");
            return (Criteria) this;
        }

        public Criteria andBgcolorNotBetween(String value1, String value2) {
            addCriterion("bgcolor not between", value1, value2, "bgcolor");
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