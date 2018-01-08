package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class ProPlsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProPlsExample() {
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

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Integer value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Integer value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Integer> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andPlsIdIsNull() {
            addCriterion("pls_id is null");
            return (Criteria) this;
        }

        public Criteria andPlsIdIsNotNull() {
            addCriterion("pls_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlsIdEqualTo(Integer value) {
            addCriterion("pls_id =", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdNotEqualTo(Integer value) {
            addCriterion("pls_id <>", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdGreaterThan(Integer value) {
            addCriterion("pls_id >", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pls_id >=", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdLessThan(Integer value) {
            addCriterion("pls_id <", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdLessThanOrEqualTo(Integer value) {
            addCriterion("pls_id <=", value, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdIn(List<Integer> values) {
            addCriterion("pls_id in", values, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdNotIn(List<Integer> values) {
            addCriterion("pls_id not in", values, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdBetween(Integer value1, Integer value2) {
            addCriterion("pls_id between", value1, value2, "plsId");
            return (Criteria) this;
        }

        public Criteria andPlsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pls_id not between", value1, value2, "plsId");
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

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andFontsizeIsNull() {
            addCriterion("fontSize is null");
            return (Criteria) this;
        }

        public Criteria andFontsizeIsNotNull() {
            addCriterion("fontSize is not null");
            return (Criteria) this;
        }

        public Criteria andFontsizeEqualTo(String value) {
            addCriterion("fontSize =", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotEqualTo(String value) {
            addCriterion("fontSize <>", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeGreaterThan(String value) {
            addCriterion("fontSize >", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeGreaterThanOrEqualTo(String value) {
            addCriterion("fontSize >=", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeLessThan(String value) {
            addCriterion("fontSize <", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeLessThanOrEqualTo(String value) {
            addCriterion("fontSize <=", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeLike(String value) {
            addCriterion("fontSize like", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotLike(String value) {
            addCriterion("fontSize not like", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeIn(List<String> values) {
            addCriterion("fontSize in", values, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotIn(List<String> values) {
            addCriterion("fontSize not in", values, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeBetween(String value1, String value2) {
            addCriterion("fontSize between", value1, value2, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotBetween(String value1, String value2) {
            addCriterion("fontSize not between", value1, value2, "fontsize");
            return (Criteria) this;
        }

        public Criteria andTcolorIsNull() {
            addCriterion("tColor is null");
            return (Criteria) this;
        }

        public Criteria andTcolorIsNotNull() {
            addCriterion("tColor is not null");
            return (Criteria) this;
        }

        public Criteria andTcolorEqualTo(String value) {
            addCriterion("tColor =", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorNotEqualTo(String value) {
            addCriterion("tColor <>", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorGreaterThan(String value) {
            addCriterion("tColor >", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorGreaterThanOrEqualTo(String value) {
            addCriterion("tColor >=", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorLessThan(String value) {
            addCriterion("tColor <", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorLessThanOrEqualTo(String value) {
            addCriterion("tColor <=", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorLike(String value) {
            addCriterion("tColor like", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorNotLike(String value) {
            addCriterion("tColor not like", value, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorIn(List<String> values) {
            addCriterion("tColor in", values, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorNotIn(List<String> values) {
            addCriterion("tColor not in", values, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorBetween(String value1, String value2) {
            addCriterion("tColor between", value1, value2, "tcolor");
            return (Criteria) this;
        }

        public Criteria andTcolorNotBetween(String value1, String value2) {
            addCriterion("tColor not between", value1, value2, "tcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorIsNull() {
            addCriterion("bColor is null");
            return (Criteria) this;
        }

        public Criteria andBcolorIsNotNull() {
            addCriterion("bColor is not null");
            return (Criteria) this;
        }

        public Criteria andBcolorEqualTo(String value) {
            addCriterion("bColor =", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorNotEqualTo(String value) {
            addCriterion("bColor <>", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorGreaterThan(String value) {
            addCriterion("bColor >", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorGreaterThanOrEqualTo(String value) {
            addCriterion("bColor >=", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorLessThan(String value) {
            addCriterion("bColor <", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorLessThanOrEqualTo(String value) {
            addCriterion("bColor <=", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorLike(String value) {
            addCriterion("bColor like", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorNotLike(String value) {
            addCriterion("bColor not like", value, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorIn(List<String> values) {
            addCriterion("bColor in", values, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorNotIn(List<String> values) {
            addCriterion("bColor not in", values, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorBetween(String value1, String value2) {
            addCriterion("bColor between", value1, value2, "bcolor");
            return (Criteria) this;
        }

        public Criteria andBcolorNotBetween(String value1, String value2) {
            addCriterion("bColor not between", value1, value2, "bcolor");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(String value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(String value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(String value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(String value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(String value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLike(String value) {
            addCriterion("speed like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotLike(String value) {
            addCriterion("speed not like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<String> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<String> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(String value1, String value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(String value1, String value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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