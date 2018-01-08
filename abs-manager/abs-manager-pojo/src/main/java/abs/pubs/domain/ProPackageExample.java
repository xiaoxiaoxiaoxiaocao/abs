package abs.pubs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProPackageExample() {
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

        public Criteria andStatesIsNull() {
            addCriterion("states is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("states is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(Integer value) {
            addCriterion("states =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(Integer value) {
            addCriterion("states <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(Integer value) {
            addCriterion("states >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("states >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(Integer value) {
            addCriterion("states <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(Integer value) {
            addCriterion("states <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<Integer> values) {
            addCriterion("states in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<Integer> values) {
            addCriterion("states not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(Integer value1, Integer value2) {
            addCriterion("states between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(Integer value1, Integer value2) {
            addCriterion("states not between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andPkgTypeIsNull() {
            addCriterion("pkg_type is null");
            return (Criteria) this;
        }

        public Criteria andPkgTypeIsNotNull() {
            addCriterion("pkg_type is not null");
            return (Criteria) this;
        }

        public Criteria andPkgTypeEqualTo(Integer value) {
            addCriterion("pkg_type =", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeNotEqualTo(Integer value) {
            addCriterion("pkg_type <>", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeGreaterThan(Integer value) {
            addCriterion("pkg_type >", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pkg_type >=", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeLessThan(Integer value) {
            addCriterion("pkg_type <", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pkg_type <=", value, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeIn(List<Integer> values) {
            addCriterion("pkg_type in", values, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeNotIn(List<Integer> values) {
            addCriterion("pkg_type not in", values, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeBetween(Integer value1, Integer value2) {
            addCriterion("pkg_type between", value1, value2, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pkg_type not between", value1, value2, "pkgType");
            return (Criteria) this;
        }

        public Criteria andPkgNameIsNull() {
            addCriterion("pkg_name is null");
            return (Criteria) this;
        }

        public Criteria andPkgNameIsNotNull() {
            addCriterion("pkg_name is not null");
            return (Criteria) this;
        }

        public Criteria andPkgNameEqualTo(String value) {
            addCriterion("pkg_name =", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameNotEqualTo(String value) {
            addCriterion("pkg_name <>", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameGreaterThan(String value) {
            addCriterion("pkg_name >", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_name >=", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameLessThan(String value) {
            addCriterion("pkg_name <", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameLessThanOrEqualTo(String value) {
            addCriterion("pkg_name <=", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameLike(String value) {
            addCriterion("pkg_name like", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameNotLike(String value) {
            addCriterion("pkg_name not like", value, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameIn(List<String> values) {
            addCriterion("pkg_name in", values, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameNotIn(List<String> values) {
            addCriterion("pkg_name not in", values, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameBetween(String value1, String value2) {
            addCriterion("pkg_name between", value1, value2, "pkgName");
            return (Criteria) this;
        }

        public Criteria andPkgNameNotBetween(String value1, String value2) {
            addCriterion("pkg_name not between", value1, value2, "pkgName");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andUpdttimeIsNull() {
            addCriterion("updttime is null");
            return (Criteria) this;
        }

        public Criteria andUpdttimeIsNotNull() {
            addCriterion("updttime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdttimeEqualTo(Date value) {
            addCriterion("updttime =", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeNotEqualTo(Date value) {
            addCriterion("updttime <>", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeGreaterThan(Date value) {
            addCriterion("updttime >", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updttime >=", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeLessThan(Date value) {
            addCriterion("updttime <", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeLessThanOrEqualTo(Date value) {
            addCriterion("updttime <=", value, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeIn(List<Date> values) {
            addCriterion("updttime in", values, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeNotIn(List<Date> values) {
            addCriterion("updttime not in", values, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeBetween(Date value1, Date value2) {
            addCriterion("updttime between", value1, value2, "updttime");
            return (Criteria) this;
        }

        public Criteria andUpdttimeNotBetween(Date value1, Date value2) {
            addCriterion("updttime not between", value1, value2, "updttime");
            return (Criteria) this;
        }

        public Criteria andPtaskidIsNull() {
            addCriterion("ptaskId is null");
            return (Criteria) this;
        }

        public Criteria andPtaskidIsNotNull() {
            addCriterion("ptaskId is not null");
            return (Criteria) this;
        }

        public Criteria andPtaskidEqualTo(String value) {
            addCriterion("ptaskId =", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidNotEqualTo(String value) {
            addCriterion("ptaskId <>", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidGreaterThan(String value) {
            addCriterion("ptaskId >", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidGreaterThanOrEqualTo(String value) {
            addCriterion("ptaskId >=", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidLessThan(String value) {
            addCriterion("ptaskId <", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidLessThanOrEqualTo(String value) {
            addCriterion("ptaskId <=", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidLike(String value) {
            addCriterion("ptaskId like", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidNotLike(String value) {
            addCriterion("ptaskId not like", value, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidIn(List<String> values) {
            addCriterion("ptaskId in", values, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidNotIn(List<String> values) {
            addCriterion("ptaskId not in", values, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidBetween(String value1, String value2) {
            addCriterion("ptaskId between", value1, value2, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andPtaskidNotBetween(String value1, String value2) {
            addCriterion("ptaskId not between", value1, value2, "ptaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidIsNull() {
            addCriterion("rtaskId is null");
            return (Criteria) this;
        }

        public Criteria andRtaskidIsNotNull() {
            addCriterion("rtaskId is not null");
            return (Criteria) this;
        }

        public Criteria andRtaskidEqualTo(String value) {
            addCriterion("rtaskId =", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidNotEqualTo(String value) {
            addCriterion("rtaskId <>", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidGreaterThan(String value) {
            addCriterion("rtaskId >", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidGreaterThanOrEqualTo(String value) {
            addCriterion("rtaskId >=", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidLessThan(String value) {
            addCriterion("rtaskId <", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidLessThanOrEqualTo(String value) {
            addCriterion("rtaskId <=", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidLike(String value) {
            addCriterion("rtaskId like", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidNotLike(String value) {
            addCriterion("rtaskId not like", value, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidIn(List<String> values) {
            addCriterion("rtaskId in", values, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidNotIn(List<String> values) {
            addCriterion("rtaskId not in", values, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidBetween(String value1, String value2) {
            addCriterion("rtaskId between", value1, value2, "rtaskid");
            return (Criteria) this;
        }

        public Criteria andRtaskidNotBetween(String value1, String value2) {
            addCriterion("rtaskId not between", value1, value2, "rtaskid");
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