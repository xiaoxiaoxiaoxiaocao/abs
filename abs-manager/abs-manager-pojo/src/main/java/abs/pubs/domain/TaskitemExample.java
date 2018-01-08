package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskitemExample() {
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

        public Criteria andTasktypeIsNull() {
            addCriterion("tasktype is null");
            return (Criteria) this;
        }

        public Criteria andTasktypeIsNotNull() {
            addCriterion("tasktype is not null");
            return (Criteria) this;
        }

        public Criteria andTasktypeEqualTo(String value) {
            addCriterion("tasktype =", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotEqualTo(String value) {
            addCriterion("tasktype <>", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeGreaterThan(String value) {
            addCriterion("tasktype >", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeGreaterThanOrEqualTo(String value) {
            addCriterion("tasktype >=", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLessThan(String value) {
            addCriterion("tasktype <", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLessThanOrEqualTo(String value) {
            addCriterion("tasktype <=", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLike(String value) {
            addCriterion("tasktype like", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotLike(String value) {
            addCriterion("tasktype not like", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeIn(List<String> values) {
            addCriterion("tasktype in", values, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotIn(List<String> values) {
            addCriterion("tasktype not in", values, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeBetween(String value1, String value2) {
            addCriterion("tasktype between", value1, value2, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotBetween(String value1, String value2) {
            addCriterion("tasktype not between", value1, value2, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(String value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(String value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(String value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(String value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(String value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(String value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLike(String value) {
            addCriterion("taskid like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotLike(String value) {
            addCriterion("taskid not like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<String> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<String> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(String value1, String value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(String value1, String value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andControlIsNull() {
            addCriterion("control is null");
            return (Criteria) this;
        }

        public Criteria andControlIsNotNull() {
            addCriterion("control is not null");
            return (Criteria) this;
        }

        public Criteria andControlEqualTo(String value) {
            addCriterion("control =", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlNotEqualTo(String value) {
            addCriterion("control <>", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlGreaterThan(String value) {
            addCriterion("control >", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlGreaterThanOrEqualTo(String value) {
            addCriterion("control >=", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlLessThan(String value) {
            addCriterion("control <", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlLessThanOrEqualTo(String value) {
            addCriterion("control <=", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlLike(String value) {
            addCriterion("control like", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlNotLike(String value) {
            addCriterion("control not like", value, "control");
            return (Criteria) this;
        }

        public Criteria andControlIn(List<String> values) {
            addCriterion("control in", values, "control");
            return (Criteria) this;
        }

        public Criteria andControlNotIn(List<String> values) {
            addCriterion("control not in", values, "control");
            return (Criteria) this;
        }

        public Criteria andControlBetween(String value1, String value2) {
            addCriterion("control between", value1, value2, "control");
            return (Criteria) this;
        }

        public Criteria andControlNotBetween(String value1, String value2) {
            addCriterion("control not between", value1, value2, "control");
            return (Criteria) this;
        }

        public Criteria andFontsizzeIsNull() {
            addCriterion("fontsizze is null");
            return (Criteria) this;
        }

        public Criteria andFontsizzeIsNotNull() {
            addCriterion("fontsizze is not null");
            return (Criteria) this;
        }

        public Criteria andFontsizzeEqualTo(String value) {
            addCriterion("fontsizze =", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeNotEqualTo(String value) {
            addCriterion("fontsizze <>", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeGreaterThan(String value) {
            addCriterion("fontsizze >", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeGreaterThanOrEqualTo(String value) {
            addCriterion("fontsizze >=", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeLessThan(String value) {
            addCriterion("fontsizze <", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeLessThanOrEqualTo(String value) {
            addCriterion("fontsizze <=", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeLike(String value) {
            addCriterion("fontsizze like", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeNotLike(String value) {
            addCriterion("fontsizze not like", value, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeIn(List<String> values) {
            addCriterion("fontsizze in", values, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeNotIn(List<String> values) {
            addCriterion("fontsizze not in", values, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeBetween(String value1, String value2) {
            addCriterion("fontsizze between", value1, value2, "fontsizze");
            return (Criteria) this;
        }

        public Criteria andFontsizzeNotBetween(String value1, String value2) {
            addCriterion("fontsizze not between", value1, value2, "fontsizze");
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

        public Criteria andFontcolorIsNull() {
            addCriterion("fontcolor is null");
            return (Criteria) this;
        }

        public Criteria andFontcolorIsNotNull() {
            addCriterion("fontcolor is not null");
            return (Criteria) this;
        }

        public Criteria andFontcolorEqualTo(String value) {
            addCriterion("fontcolor =", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorNotEqualTo(String value) {
            addCriterion("fontcolor <>", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorGreaterThan(String value) {
            addCriterion("fontcolor >", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorGreaterThanOrEqualTo(String value) {
            addCriterion("fontcolor >=", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorLessThan(String value) {
            addCriterion("fontcolor <", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorLessThanOrEqualTo(String value) {
            addCriterion("fontcolor <=", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorLike(String value) {
            addCriterion("fontcolor like", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorNotLike(String value) {
            addCriterion("fontcolor not like", value, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorIn(List<String> values) {
            addCriterion("fontcolor in", values, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorNotIn(List<String> values) {
            addCriterion("fontcolor not in", values, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorBetween(String value1, String value2) {
            addCriterion("fontcolor between", value1, value2, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andFontcolorNotBetween(String value1, String value2) {
            addCriterion("fontcolor not between", value1, value2, "fontcolor");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("starttime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("starttime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEdntimeIsNull() {
            addCriterion("edntime is null");
            return (Criteria) this;
        }

        public Criteria andEdntimeIsNotNull() {
            addCriterion("edntime is not null");
            return (Criteria) this;
        }

        public Criteria andEdntimeEqualTo(String value) {
            addCriterion("edntime =", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeNotEqualTo(String value) {
            addCriterion("edntime <>", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeGreaterThan(String value) {
            addCriterion("edntime >", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeGreaterThanOrEqualTo(String value) {
            addCriterion("edntime >=", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeLessThan(String value) {
            addCriterion("edntime <", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeLessThanOrEqualTo(String value) {
            addCriterion("edntime <=", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeLike(String value) {
            addCriterion("edntime like", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeNotLike(String value) {
            addCriterion("edntime not like", value, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeIn(List<String> values) {
            addCriterion("edntime in", values, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeNotIn(List<String> values) {
            addCriterion("edntime not in", values, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeBetween(String value1, String value2) {
            addCriterion("edntime between", value1, value2, "edntime");
            return (Criteria) this;
        }

        public Criteria andEdntimeNotBetween(String value1, String value2) {
            addCriterion("edntime not between", value1, value2, "edntime");
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

        public Criteria andCountEqualTo(String value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(String value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(String value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(String value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(String value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(String value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLike(String value) {
            addCriterion("count like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotLike(String value) {
            addCriterion("count not like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<String> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<String> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(String value1, String value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(String value1, String value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andTimelengthIsNull() {
            addCriterion("timelength is null");
            return (Criteria) this;
        }

        public Criteria andTimelengthIsNotNull() {
            addCriterion("timelength is not null");
            return (Criteria) this;
        }

        public Criteria andTimelengthEqualTo(String value) {
            addCriterion("timelength =", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthNotEqualTo(String value) {
            addCriterion("timelength <>", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthGreaterThan(String value) {
            addCriterion("timelength >", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthGreaterThanOrEqualTo(String value) {
            addCriterion("timelength >=", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthLessThan(String value) {
            addCriterion("timelength <", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthLessThanOrEqualTo(String value) {
            addCriterion("timelength <=", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthLike(String value) {
            addCriterion("timelength like", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthNotLike(String value) {
            addCriterion("timelength not like", value, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthIn(List<String> values) {
            addCriterion("timelength in", values, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthNotIn(List<String> values) {
            addCriterion("timelength not in", values, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthBetween(String value1, String value2) {
            addCriterion("timelength between", value1, value2, "timelength");
            return (Criteria) this;
        }

        public Criteria andTimelengthNotBetween(String value1, String value2) {
            addCriterion("timelength not between", value1, value2, "timelength");
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

        public Criteria andConfigidIsNull() {
            addCriterion("configId is null");
            return (Criteria) this;
        }

        public Criteria andConfigidIsNotNull() {
            addCriterion("configId is not null");
            return (Criteria) this;
        }

        public Criteria andConfigidEqualTo(Integer value) {
            addCriterion("configId =", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotEqualTo(Integer value) {
            addCriterion("configId <>", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThan(Integer value) {
            addCriterion("configId >", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThanOrEqualTo(Integer value) {
            addCriterion("configId >=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThan(Integer value) {
            addCriterion("configId <", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThanOrEqualTo(Integer value) {
            addCriterion("configId <=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidIn(List<Integer> values) {
            addCriterion("configId in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotIn(List<Integer> values) {
            addCriterion("configId not in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidBetween(Integer value1, Integer value2) {
            addCriterion("configId between", value1, value2, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotBetween(Integer value1, Integer value2) {
            addCriterion("configId not between", value1, value2, "configid");
            return (Criteria) this;
        }

        public Criteria andCmdIsNull() {
            addCriterion("cmd is null");
            return (Criteria) this;
        }

        public Criteria andCmdIsNotNull() {
            addCriterion("cmd is not null");
            return (Criteria) this;
        }

        public Criteria andCmdEqualTo(String value) {
            addCriterion("cmd =", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotEqualTo(String value) {
            addCriterion("cmd <>", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThan(String value) {
            addCriterion("cmd >", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThanOrEqualTo(String value) {
            addCriterion("cmd >=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThan(String value) {
            addCriterion("cmd <", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThanOrEqualTo(String value) {
            addCriterion("cmd <=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLike(String value) {
            addCriterion("cmd like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotLike(String value) {
            addCriterion("cmd not like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdIn(List<String> values) {
            addCriterion("cmd in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotIn(List<String> values) {
            addCriterion("cmd not in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdBetween(String value1, String value2) {
            addCriterion("cmd between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotBetween(String value1, String value2) {
            addCriterion("cmd not between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNull() {
            addCriterion("logtype is null");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNotNull() {
            addCriterion("logtype is not null");
            return (Criteria) this;
        }

        public Criteria andLogtypeEqualTo(String value) {
            addCriterion("logtype =", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotEqualTo(String value) {
            addCriterion("logtype <>", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThan(String value) {
            addCriterion("logtype >", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThanOrEqualTo(String value) {
            addCriterion("logtype >=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThan(String value) {
            addCriterion("logtype <", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThanOrEqualTo(String value) {
            addCriterion("logtype <=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLike(String value) {
            addCriterion("logtype like", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotLike(String value) {
            addCriterion("logtype not like", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeIn(List<String> values) {
            addCriterion("logtype in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotIn(List<String> values) {
            addCriterion("logtype not in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeBetween(String value1, String value2) {
            addCriterion("logtype between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotBetween(String value1, String value2) {
            addCriterion("logtype not between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNull() {
            addCriterion("errorinfo is null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNotNull() {
            addCriterion("errorinfo is not null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoEqualTo(String value) {
            addCriterion("errorinfo =", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotEqualTo(String value) {
            addCriterion("errorinfo <>", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThan(String value) {
            addCriterion("errorinfo >", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("errorinfo >=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThan(String value) {
            addCriterion("errorinfo <", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThanOrEqualTo(String value) {
            addCriterion("errorinfo <=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLike(String value) {
            addCriterion("errorinfo like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotLike(String value) {
            addCriterion("errorinfo not like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIn(List<String> values) {
            addCriterion("errorinfo in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotIn(List<String> values) {
            addCriterion("errorinfo not in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoBetween(String value1, String value2) {
            addCriterion("errorinfo between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotBetween(String value1, String value2) {
            addCriterion("errorinfo not between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proId =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proId <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proId >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proId >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proId <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proId <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proId in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proId not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proId between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proId not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andMacsIsNull() {
            addCriterion("macs is null");
            return (Criteria) this;
        }

        public Criteria andMacsIsNotNull() {
            addCriterion("macs is not null");
            return (Criteria) this;
        }

        public Criteria andMacsEqualTo(String value) {
            addCriterion("macs =", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsNotEqualTo(String value) {
            addCriterion("macs <>", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsGreaterThan(String value) {
            addCriterion("macs >", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsGreaterThanOrEqualTo(String value) {
            addCriterion("macs >=", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsLessThan(String value) {
            addCriterion("macs <", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsLessThanOrEqualTo(String value) {
            addCriterion("macs <=", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsLike(String value) {
            addCriterion("macs like", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsNotLike(String value) {
            addCriterion("macs not like", value, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsIn(List<String> values) {
            addCriterion("macs in", values, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsNotIn(List<String> values) {
            addCriterion("macs not in", values, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsBetween(String value1, String value2) {
            addCriterion("macs between", value1, value2, "macs");
            return (Criteria) this;
        }

        public Criteria andMacsNotBetween(String value1, String value2) {
            addCriterion("macs not between", value1, value2, "macs");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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