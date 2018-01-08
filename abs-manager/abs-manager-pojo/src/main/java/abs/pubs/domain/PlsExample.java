package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class PlsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlsExample() {
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

        public Criteria andAreatypeIsNull() {
            addCriterion("areatype is null");
            return (Criteria) this;
        }

        public Criteria andAreatypeIsNotNull() {
            addCriterion("areatype is not null");
            return (Criteria) this;
        }

        public Criteria andAreatypeEqualTo(String value) {
            addCriterion("areatype =", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotEqualTo(String value) {
            addCriterion("areatype <>", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeGreaterThan(String value) {
            addCriterion("areatype >", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeGreaterThanOrEqualTo(String value) {
            addCriterion("areatype >=", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLessThan(String value) {
            addCriterion("areatype <", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLessThanOrEqualTo(String value) {
            addCriterion("areatype <=", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLike(String value) {
            addCriterion("areatype like", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotLike(String value) {
            addCriterion("areatype not like", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeIn(List<String> values) {
            addCriterion("areatype in", values, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotIn(List<String> values) {
            addCriterion("areatype not in", values, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeBetween(String value1, String value2) {
            addCriterion("areatype between", value1, value2, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotBetween(String value1, String value2) {
            addCriterion("areatype not between", value1, value2, "areatype");
            return (Criteria) this;
        }

        public Criteria andStardateIsNull() {
            addCriterion("stardate is null");
            return (Criteria) this;
        }

        public Criteria andStardateIsNotNull() {
            addCriterion("stardate is not null");
            return (Criteria) this;
        }

        public Criteria andStardateEqualTo(String value) {
            addCriterion("stardate =", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotEqualTo(String value) {
            addCriterion("stardate <>", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateGreaterThan(String value) {
            addCriterion("stardate >", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateGreaterThanOrEqualTo(String value) {
            addCriterion("stardate >=", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateLessThan(String value) {
            addCriterion("stardate <", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateLessThanOrEqualTo(String value) {
            addCriterion("stardate <=", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateLike(String value) {
            addCriterion("stardate like", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotLike(String value) {
            addCriterion("stardate not like", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateIn(List<String> values) {
            addCriterion("stardate in", values, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotIn(List<String> values) {
            addCriterion("stardate not in", values, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateBetween(String value1, String value2) {
            addCriterion("stardate between", value1, value2, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotBetween(String value1, String value2) {
            addCriterion("stardate not between", value1, value2, "stardate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(String value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(String value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(String value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(String value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(String value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLike(String value) {
            addCriterion("enddate like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotLike(String value) {
            addCriterion("enddate not like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<String> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<String> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(String value1, String value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(String value1, String value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andStdtimeIsNull() {
            addCriterion("stdtime is null");
            return (Criteria) this;
        }

        public Criteria andStdtimeIsNotNull() {
            addCriterion("stdtime is not null");
            return (Criteria) this;
        }

        public Criteria andStdtimeEqualTo(String value) {
            addCriterion("stdtime =", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeNotEqualTo(String value) {
            addCriterion("stdtime <>", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeGreaterThan(String value) {
            addCriterion("stdtime >", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeGreaterThanOrEqualTo(String value) {
            addCriterion("stdtime >=", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeLessThan(String value) {
            addCriterion("stdtime <", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeLessThanOrEqualTo(String value) {
            addCriterion("stdtime <=", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeLike(String value) {
            addCriterion("stdtime like", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeNotLike(String value) {
            addCriterion("stdtime not like", value, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeIn(List<String> values) {
            addCriterion("stdtime in", values, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeNotIn(List<String> values) {
            addCriterion("stdtime not in", values, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeBetween(String value1, String value2) {
            addCriterion("stdtime between", value1, value2, "stdtime");
            return (Criteria) this;
        }

        public Criteria andStdtimeNotBetween(String value1, String value2) {
            addCriterion("stdtime not between", value1, value2, "stdtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeIsNull() {
            addCriterion("edtime is null");
            return (Criteria) this;
        }

        public Criteria andEdtimeIsNotNull() {
            addCriterion("edtime is not null");
            return (Criteria) this;
        }

        public Criteria andEdtimeEqualTo(String value) {
            addCriterion("edtime =", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotEqualTo(String value) {
            addCriterion("edtime <>", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeGreaterThan(String value) {
            addCriterion("edtime >", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeGreaterThanOrEqualTo(String value) {
            addCriterion("edtime >=", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLessThan(String value) {
            addCriterion("edtime <", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLessThanOrEqualTo(String value) {
            addCriterion("edtime <=", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeLike(String value) {
            addCriterion("edtime like", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotLike(String value) {
            addCriterion("edtime not like", value, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeIn(List<String> values) {
            addCriterion("edtime in", values, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotIn(List<String> values) {
            addCriterion("edtime not in", values, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeBetween(String value1, String value2) {
            addCriterion("edtime between", value1, value2, "edtime");
            return (Criteria) this;
        }

        public Criteria andEdtimeNotBetween(String value1, String value2) {
            addCriterion("edtime not between", value1, value2, "edtime");
            return (Criteria) this;
        }

        public Criteria andPlaymodeIsNull() {
            addCriterion("playmode is null");
            return (Criteria) this;
        }

        public Criteria andPlaymodeIsNotNull() {
            addCriterion("playmode is not null");
            return (Criteria) this;
        }

        public Criteria andPlaymodeEqualTo(String value) {
            addCriterion("playmode =", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeNotEqualTo(String value) {
            addCriterion("playmode <>", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeGreaterThan(String value) {
            addCriterion("playmode >", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeGreaterThanOrEqualTo(String value) {
            addCriterion("playmode >=", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeLessThan(String value) {
            addCriterion("playmode <", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeLessThanOrEqualTo(String value) {
            addCriterion("playmode <=", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeLike(String value) {
            addCriterion("playmode like", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeNotLike(String value) {
            addCriterion("playmode not like", value, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeIn(List<String> values) {
            addCriterion("playmode in", values, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeNotIn(List<String> values) {
            addCriterion("playmode not in", values, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeBetween(String value1, String value2) {
            addCriterion("playmode between", value1, value2, "playmode");
            return (Criteria) this;
        }

        public Criteria andPlaymodeNotBetween(String value1, String value2) {
            addCriterion("playmode not between", value1, value2, "playmode");
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