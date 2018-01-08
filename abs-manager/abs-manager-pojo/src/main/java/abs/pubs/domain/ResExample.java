package abs.pubs.domain;

import java.util.ArrayList;
import java.util.List;

public class ResExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ResExample() {
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

		public Criteria andResidIsNull() {
			addCriterion("resid is null");
			return (Criteria) this;
		}

		public Criteria andResidIsNotNull() {
			addCriterion("resid is not null");
			return (Criteria) this;
		}

		public Criteria andResidEqualTo(String value) {
			addCriterion("resid =", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidNotEqualTo(String value) {
			addCriterion("resid <>", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidGreaterThan(String value) {
			addCriterion("resid >", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidGreaterThanOrEqualTo(String value) {
			addCriterion("resid >=", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidLessThan(String value) {
			addCriterion("resid <", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidLessThanOrEqualTo(String value) {
			addCriterion("resid <=", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidLike(String value) {
			addCriterion("resid like", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidNotLike(String value) {
			addCriterion("resid not like", value, "resid");
			return (Criteria) this;
		}

		public Criteria andResidIn(List<String> values) {
			addCriterion("resid in", values, "resid");
			return (Criteria) this;
		}

		public Criteria andResidNotIn(List<String> values) {
			addCriterion("resid not in", values, "resid");
			return (Criteria) this;
		}

		public Criteria andResidBetween(String value1, String value2) {
			addCriterion("resid between", value1, value2, "resid");
			return (Criteria) this;
		}

		public Criteria andResidNotBetween(String value1, String value2) {
			addCriterion("resid not between", value1, value2, "resid");
			return (Criteria) this;
		}

		public Criteria andResnameIsNull() {
			addCriterion("resname is null");
			return (Criteria) this;
		}

		public Criteria andResnameIsNotNull() {
			addCriterion("resname is not null");
			return (Criteria) this;
		}

		public Criteria andResnameEqualTo(String value) {
			addCriterion("resname =", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameNotEqualTo(String value) {
			addCriterion("resname <>", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameGreaterThan(String value) {
			addCriterion("resname >", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameGreaterThanOrEqualTo(String value) {
			addCriterion("resname >=", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameLessThan(String value) {
			addCriterion("resname <", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameLessThanOrEqualTo(String value) {
			addCriterion("resname <=", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameLike(String value) {
			addCriterion("resname like", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameNotLike(String value) {
			addCriterion("resname not like", value, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameIn(List<String> values) {
			addCriterion("resname in", values, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameNotIn(List<String> values) {
			addCriterion("resname not in", values, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameBetween(String value1, String value2) {
			addCriterion("resname between", value1, value2, "resname");
			return (Criteria) this;
		}

		public Criteria andResnameNotBetween(String value1, String value2) {
			addCriterion("resname not between", value1, value2, "resname");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("area is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("area is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(String value) {
			addCriterion("area =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(String value) {
			addCriterion("area <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(String value) {
			addCriterion("area >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(String value) {
			addCriterion("area >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(String value) {
			addCriterion("area <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(String value) {
			addCriterion("area <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLike(String value) {
			addCriterion("area like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotLike(String value) {
			addCriterion("area not like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<String> values) {
			addCriterion("area in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<String> values) {
			addCriterion("area not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(String value1, String value2) {
			addCriterion("area between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(String value1, String value2) {
			addCriterion("area not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andPlaycntIsNull() {
			addCriterion("playcnt is null");
			return (Criteria) this;
		}

		public Criteria andPlaycntIsNotNull() {
			addCriterion("playcnt is not null");
			return (Criteria) this;
		}

		public Criteria andPlaycntEqualTo(Integer value) {
			addCriterion("playcnt =", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntNotEqualTo(Integer value) {
			addCriterion("playcnt <>", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntGreaterThan(Integer value) {
			addCriterion("playcnt >", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntGreaterThanOrEqualTo(Integer value) {
			addCriterion("playcnt >=", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntLessThan(Integer value) {
			addCriterion("playcnt <", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntLessThanOrEqualTo(Integer value) {
			addCriterion("playcnt <=", value, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntIn(List<Integer> values) {
			addCriterion("playcnt in", values, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntNotIn(List<Integer> values) {
			addCriterion("playcnt not in", values, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntBetween(Integer value1, Integer value2) {
			addCriterion("playcnt between", value1, value2, "playcnt");
			return (Criteria) this;
		}

		public Criteria andPlaycntNotBetween(Integer value1, Integer value2) {
			addCriterion("playcnt not between", value1, value2, "playcnt");
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

		public Criteria andEndtimeIsNull() {
			addCriterion("endtime is null");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNotNull() {
			addCriterion("endtime is not null");
			return (Criteria) this;
		}

		public Criteria andEndtimeEqualTo(String value) {
			addCriterion("endtime =", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotEqualTo(String value) {
			addCriterion("endtime <>", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThan(String value) {
			addCriterion("endtime >", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
			addCriterion("endtime >=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThan(String value) {
			addCriterion("endtime <", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThanOrEqualTo(String value) {
			addCriterion("endtime <=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLike(String value) {
			addCriterion("endtime like", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotLike(String value) {
			addCriterion("endtime not like", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIn(List<String> values) {
			addCriterion("endtime in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotIn(List<String> values) {
			addCriterion("endtime not in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeBetween(String value1, String value2) {
			addCriterion("endtime between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotBetween(String value1, String value2) {
			addCriterion("endtime not between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("priority is null");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("priority is not null");
			return (Criteria) this;
		}

		public Criteria andPriorityEqualTo(String value) {
			addCriterion("priority =", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotEqualTo(String value) {
			addCriterion("priority <>", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThan(String value) {
			addCriterion("priority >", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(String value) {
			addCriterion("priority >=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThan(String value) {
			addCriterion("priority <", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThanOrEqualTo(String value) {
			addCriterion("priority <=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLike(String value) {
			addCriterion("priority like", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotLike(String value) {
			addCriterion("priority not like", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityIn(List<String> values) {
			addCriterion("priority in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotIn(List<String> values) {
			addCriterion("priority not in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityBetween(String value1, String value2) {
			addCriterion("priority between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotBetween(String value1, String value2) {
			addCriterion("priority not between", value1, value2, "priority");
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

		public Criteria andHrefIsNull() {
			addCriterion("href is null");
			return (Criteria) this;
		}

		public Criteria andHrefIsNotNull() {
			addCriterion("href is not null");
			return (Criteria) this;
		}

		public Criteria andHrefEqualTo(String value) {
			addCriterion("href =", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefNotEqualTo(String value) {
			addCriterion("href <>", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefGreaterThan(String value) {
			addCriterion("href >", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefGreaterThanOrEqualTo(String value) {
			addCriterion("href >=", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefLessThan(String value) {
			addCriterion("href <", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefLessThanOrEqualTo(String value) {
			addCriterion("href <=", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefLike(String value) {
			addCriterion("href like", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefNotLike(String value) {
			addCriterion("href not like", value, "href");
			return (Criteria) this;
		}

		public Criteria andHrefIn(List<String> values) {
			addCriterion("href in", values, "href");
			return (Criteria) this;
		}

		public Criteria andHrefNotIn(List<String> values) {
			addCriterion("href not in", values, "href");
			return (Criteria) this;
		}

		public Criteria andHrefBetween(String value1, String value2) {
			addCriterion("href between", value1, value2, "href");
			return (Criteria) this;
		}

		public Criteria andHrefNotBetween(String value1, String value2) {
			addCriterion("href not between", value1, value2, "href");
			return (Criteria) this;
		}

		public Criteria andMd5IsNull() {
			addCriterion("md5 is null");
			return (Criteria) this;
		}

		public Criteria andMd5IsNotNull() {
			addCriterion("md5 is not null");
			return (Criteria) this;
		}

		public Criteria andMd5EqualTo(String value) {
			addCriterion("md5 =", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5NotEqualTo(String value) {
			addCriterion("md5 <>", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5GreaterThan(String value) {
			addCriterion("md5 >", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5GreaterThanOrEqualTo(String value) {
			addCriterion("md5 >=", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5LessThan(String value) {
			addCriterion("md5 <", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5LessThanOrEqualTo(String value) {
			addCriterion("md5 <=", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5Like(String value) {
			addCriterion("md5 like", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5NotLike(String value) {
			addCriterion("md5 not like", value, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5In(List<String> values) {
			addCriterion("md5 in", values, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5NotIn(List<String> values) {
			addCriterion("md5 not in", values, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5Between(String value1, String value2) {
			addCriterion("md5 between", value1, value2, "md5");
			return (Criteria) this;
		}

		public Criteria andMd5NotBetween(String value1, String value2) {
			addCriterion("md5 not between", value1, value2, "md5");
			return (Criteria) this;
		}

		public Criteria andFilesizeIsNull() {
			addCriterion("filesize is null");
			return (Criteria) this;
		}

		public Criteria andFilesizeIsNotNull() {
			addCriterion("filesize is not null");
			return (Criteria) this;
		}

		public Criteria andFilesizeEqualTo(Integer value) {
			addCriterion("filesize =", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeNotEqualTo(Integer value) {
			addCriterion("filesize <>", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeGreaterThan(Integer value) {
			addCriterion("filesize >", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeGreaterThanOrEqualTo(Integer value) {
			addCriterion("filesize >=", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeLessThan(Integer value) {
			addCriterion("filesize <", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeLessThanOrEqualTo(Integer value) {
			addCriterion("filesize <=", value, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeIn(List<Integer> values) {
			addCriterion("filesize in", values, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeNotIn(List<Integer> values) {
			addCriterion("filesize not in", values, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeBetween(Integer value1, Integer value2) {
			addCriterion("filesize between", value1, value2, "filesize");
			return (Criteria) this;
		}

		public Criteria andFilesizeNotBetween(Integer value1, Integer value2) {
			addCriterion("filesize not between", value1, value2, "filesize");
			return (Criteria) this;
		}

		public Criteria andDefauIsNull() {
			addCriterion("defau is null");
			return (Criteria) this;
		}

		public Criteria andDefauIsNotNull() {
			addCriterion("defau is not null");
			return (Criteria) this;
		}

		public Criteria andDefauEqualTo(Byte value) {
			addCriterion("defau =", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauNotEqualTo(Byte value) {
			addCriterion("defau <>", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauGreaterThan(Byte value) {
			addCriterion("defau >", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauGreaterThanOrEqualTo(Byte value) {
			addCriterion("defau >=", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauLessThan(Byte value) {
			addCriterion("defau <", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauLessThanOrEqualTo(Byte value) {
			addCriterion("defau <=", value, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauIn(List<Byte> values) {
			addCriterion("defau in", values, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauNotIn(List<Byte> values) {
			addCriterion("defau not in", values, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauBetween(Byte value1, Byte value2) {
			addCriterion("defau between", value1, value2, "defau");
			return (Criteria) this;
		}

		public Criteria andDefauNotBetween(Byte value1, Byte value2) {
			addCriterion("defau not between", value1, value2, "defau");
			return (Criteria) this;
		}

		public Criteria andTextIsNull() {
			addCriterion("text is null");
			return (Criteria) this;
		}

		public Criteria andTextIsNotNull() {
			addCriterion("text is not null");
			return (Criteria) this;
		}

		public Criteria andTextEqualTo(String value) {
			addCriterion("text =", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextNotEqualTo(String value) {
			addCriterion("text <>", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextGreaterThan(String value) {
			addCriterion("text >", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextGreaterThanOrEqualTo(String value) {
			addCriterion("text >=", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextLessThan(String value) {
			addCriterion("text <", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextLessThanOrEqualTo(String value) {
			addCriterion("text <=", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextLike(String value) {
			addCriterion("text like", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextNotLike(String value) {
			addCriterion("text not like", value, "text");
			return (Criteria) this;
		}

		public Criteria andTextIn(List<String> values) {
			addCriterion("text in", values, "text");
			return (Criteria) this;
		}

		public Criteria andTextNotIn(List<String> values) {
			addCriterion("text not in", values, "text");
			return (Criteria) this;
		}

		public Criteria andTextBetween(String value1, String value2) {
			addCriterion("text between", value1, value2, "text");
			return (Criteria) this;
		}

		public Criteria andTextNotBetween(String value1, String value2) {
			addCriterion("text not between", value1, value2, "text");
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