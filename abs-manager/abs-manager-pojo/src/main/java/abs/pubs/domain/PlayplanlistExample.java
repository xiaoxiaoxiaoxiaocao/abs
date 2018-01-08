package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayplanlistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayplanlistExample() {
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

        public Criteria andPlayplanidIsNull() {
            addCriterion("playPlanID is null");
            return (Criteria) this;
        }

        public Criteria andPlayplanidIsNotNull() {
            addCriterion("playPlanID is not null");
            return (Criteria) this;
        }

        public Criteria andPlayplanidEqualTo(Integer value) {
            addCriterion("playPlanID =", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidNotEqualTo(Integer value) {
            addCriterion("playPlanID <>", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidGreaterThan(Integer value) {
            addCriterion("playPlanID >", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("playPlanID >=", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidLessThan(Integer value) {
            addCriterion("playPlanID <", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidLessThanOrEqualTo(Integer value) {
            addCriterion("playPlanID <=", value, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidIn(List<Integer> values) {
            addCriterion("playPlanID in", values, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidNotIn(List<Integer> values) {
            addCriterion("playPlanID not in", values, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidBetween(Integer value1, Integer value2) {
            addCriterion("playPlanID between", value1, value2, "playplanid");
            return (Criteria) this;
        }

        public Criteria andPlayplanidNotBetween(Integer value1, Integer value2) {
            addCriterion("playPlanID not between", value1, value2, "playplanid");
            return (Criteria) this;
        }

        public Criteria andMaterialidIsNull() {
            addCriterion("materialId is null");
            return (Criteria) this;
        }

        public Criteria andMaterialidIsNotNull() {
            addCriterion("materialId is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialidEqualTo(Integer value) {
            addCriterion("materialId =", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotEqualTo(Integer value) {
            addCriterion("materialId <>", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidGreaterThan(Integer value) {
            addCriterion("materialId >", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidGreaterThanOrEqualTo(Integer value) {
            addCriterion("materialId >=", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidLessThan(Integer value) {
            addCriterion("materialId <", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidLessThanOrEqualTo(Integer value) {
            addCriterion("materialId <=", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidIn(List<Integer> values) {
            addCriterion("materialId in", values, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotIn(List<Integer> values) {
            addCriterion("materialId not in", values, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidBetween(Integer value1, Integer value2) {
            addCriterion("materialId between", value1, value2, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotBetween(Integer value1, Integer value2) {
            addCriterion("materialId not between", value1, value2, "materialid");
            return (Criteria) this;
        }

        public Criteria andPlaydurationIsNull() {
            addCriterion("playDuration is null");
            return (Criteria) this;
        }

        public Criteria andPlaydurationIsNotNull() {
            addCriterion("playDuration is not null");
            return (Criteria) this;
        }

        public Criteria andPlaydurationEqualTo(Integer value) {
            addCriterion("playDuration =", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationNotEqualTo(Integer value) {
            addCriterion("playDuration <>", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationGreaterThan(Integer value) {
            addCriterion("playDuration >", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("playDuration >=", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationLessThan(Integer value) {
            addCriterion("playDuration <", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationLessThanOrEqualTo(Integer value) {
            addCriterion("playDuration <=", value, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationIn(List<Integer> values) {
            addCriterion("playDuration in", values, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationNotIn(List<Integer> values) {
            addCriterion("playDuration not in", values, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationBetween(Integer value1, Integer value2) {
            addCriterion("playDuration between", value1, value2, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlaydurationNotBetween(Integer value1, Integer value2) {
            addCriterion("playDuration not between", value1, value2, "playduration");
            return (Criteria) this;
        }

        public Criteria andPlayorderIsNull() {
            addCriterion("playOrder is null");
            return (Criteria) this;
        }

        public Criteria andPlayorderIsNotNull() {
            addCriterion("playOrder is not null");
            return (Criteria) this;
        }

        public Criteria andPlayorderEqualTo(Integer value) {
            addCriterion("playOrder =", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderNotEqualTo(Integer value) {
            addCriterion("playOrder <>", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderGreaterThan(Integer value) {
            addCriterion("playOrder >", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("playOrder >=", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderLessThan(Integer value) {
            addCriterion("playOrder <", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderLessThanOrEqualTo(Integer value) {
            addCriterion("playOrder <=", value, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderIn(List<Integer> values) {
            addCriterion("playOrder in", values, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderNotIn(List<Integer> values) {
            addCriterion("playOrder not in", values, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderBetween(Integer value1, Integer value2) {
            addCriterion("playOrder between", value1, value2, "playorder");
            return (Criteria) this;
        }

        public Criteria andPlayorderNotBetween(Integer value1, Integer value2) {
            addCriterion("playOrder not between", value1, value2, "playorder");
            return (Criteria) this;
        }

        public Criteria andPropackageIsNull() {
            addCriterion("proPackage is null");
            return (Criteria) this;
        }

        public Criteria andPropackageIsNotNull() {
            addCriterion("proPackage is not null");
            return (Criteria) this;
        }

        public Criteria andPropackageEqualTo(String value) {
            addCriterion("proPackage =", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageNotEqualTo(String value) {
            addCriterion("proPackage <>", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageGreaterThan(String value) {
            addCriterion("proPackage >", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageGreaterThanOrEqualTo(String value) {
            addCriterion("proPackage >=", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageLessThan(String value) {
            addCriterion("proPackage <", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageLessThanOrEqualTo(String value) {
            addCriterion("proPackage <=", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageLike(String value) {
            addCriterion("proPackage like", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageNotLike(String value) {
            addCriterion("proPackage not like", value, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageIn(List<String> values) {
            addCriterion("proPackage in", values, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageNotIn(List<String> values) {
            addCriterion("proPackage not in", values, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageBetween(String value1, String value2) {
            addCriterion("proPackage between", value1, value2, "propackage");
            return (Criteria) this;
        }

        public Criteria andPropackageNotBetween(String value1, String value2) {
            addCriterion("proPackage not between", value1, value2, "propackage");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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