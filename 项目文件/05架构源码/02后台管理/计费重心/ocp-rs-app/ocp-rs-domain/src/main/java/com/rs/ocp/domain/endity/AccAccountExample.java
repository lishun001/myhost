package com.rs.ocp.domain.endity;

import java.util.ArrayList;
import java.util.List;

public class AccAccountExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public AccAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_account
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_account
     *
     * @mbggenerated
     */
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountPidIsNull() {
            addCriterion("account_pid is null");
            return (Criteria) this;
        }

        public Criteria andAccountPidIsNotNull() {
            addCriterion("account_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPidEqualTo(Integer value) {
            addCriterion("account_pid =", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidNotEqualTo(Integer value) {
            addCriterion("account_pid <>", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidGreaterThan(Integer value) {
            addCriterion("account_pid >", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_pid >=", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidLessThan(Integer value) {
            addCriterion("account_pid <", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidLessThanOrEqualTo(Integer value) {
            addCriterion("account_pid <=", value, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidIn(List<Integer> values) {
            addCriterion("account_pid in", values, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidNotIn(List<Integer> values) {
            addCriterion("account_pid not in", values, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidBetween(Integer value1, Integer value2) {
            addCriterion("account_pid between", value1, value2, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountPidNotBetween(Integer value1, Integer value2) {
            addCriterion("account_pid not between", value1, value2, "accountPid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidIsNull() {
            addCriterion("account_gameid is null");
            return (Criteria) this;
        }

        public Criteria andAccountGameidIsNotNull() {
            addCriterion("account_gameid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountGameidEqualTo(Integer value) {
            addCriterion("account_gameid =", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidNotEqualTo(Integer value) {
            addCriterion("account_gameid <>", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidGreaterThan(Integer value) {
            addCriterion("account_gameid >", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_gameid >=", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidLessThan(Integer value) {
            addCriterion("account_gameid <", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidLessThanOrEqualTo(Integer value) {
            addCriterion("account_gameid <=", value, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidIn(List<Integer> values) {
            addCriterion("account_gameid in", values, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidNotIn(List<Integer> values) {
            addCriterion("account_gameid not in", values, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidBetween(Integer value1, Integer value2) {
            addCriterion("account_gameid between", value1, value2, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountGameidNotBetween(Integer value1, Integer value2) {
            addCriterion("account_gameid not between", value1, value2, "accountGameid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidIsNull() {
            addCriterion("account_areaid is null");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidIsNotNull() {
            addCriterion("account_areaid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidEqualTo(Integer value) {
            addCriterion("account_areaid =", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidNotEqualTo(Integer value) {
            addCriterion("account_areaid <>", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidGreaterThan(Integer value) {
            addCriterion("account_areaid >", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_areaid >=", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidLessThan(Integer value) {
            addCriterion("account_areaid <", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidLessThanOrEqualTo(Integer value) {
            addCriterion("account_areaid <=", value, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidIn(List<Integer> values) {
            addCriterion("account_areaid in", values, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidNotIn(List<Integer> values) {
            addCriterion("account_areaid not in", values, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidBetween(Integer value1, Integer value2) {
            addCriterion("account_areaid between", value1, value2, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountAreaidNotBetween(Integer value1, Integer value2) {
            addCriterion("account_areaid not between", value1, value2, "accountAreaid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridIsNull() {
            addCriterion("account_serverid is null");
            return (Criteria) this;
        }

        public Criteria andAccountServeridIsNotNull() {
            addCriterion("account_serverid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountServeridEqualTo(Integer value) {
            addCriterion("account_serverid =", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridNotEqualTo(Integer value) {
            addCriterion("account_serverid <>", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridGreaterThan(Integer value) {
            addCriterion("account_serverid >", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_serverid >=", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridLessThan(Integer value) {
            addCriterion("account_serverid <", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridLessThanOrEqualTo(Integer value) {
            addCriterion("account_serverid <=", value, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridIn(List<Integer> values) {
            addCriterion("account_serverid in", values, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridNotIn(List<Integer> values) {
            addCriterion("account_serverid not in", values, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridBetween(Integer value1, Integer value2) {
            addCriterion("account_serverid between", value1, value2, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountServeridNotBetween(Integer value1, Integer value2) {
            addCriterion("account_serverid not between", value1, value2, "accountServerid");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyIsNull() {
            addCriterion("account_currency is null");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyIsNotNull() {
            addCriterion("account_currency is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyEqualTo(Integer value) {
            addCriterion("account_currency =", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyNotEqualTo(Integer value) {
            addCriterion("account_currency <>", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyGreaterThan(Integer value) {
            addCriterion("account_currency >", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_currency >=", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyLessThan(Integer value) {
            addCriterion("account_currency <", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyLessThanOrEqualTo(Integer value) {
            addCriterion("account_currency <=", value, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyIn(List<Integer> values) {
            addCriterion("account_currency in", values, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyNotIn(List<Integer> values) {
            addCriterion("account_currency not in", values, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyBetween(Integer value1, Integer value2) {
            addCriterion("account_currency between", value1, value2, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountCurrencyNotBetween(Integer value1, Integer value2) {
            addCriterion("account_currency not between", value1, value2, "accountCurrency");
            return (Criteria) this;
        }

        public Criteria andAccountPointsIsNull() {
            addCriterion("account_points is null");
            return (Criteria) this;
        }

        public Criteria andAccountPointsIsNotNull() {
            addCriterion("account_points is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPointsEqualTo(Integer value) {
            addCriterion("account_points =", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsNotEqualTo(Integer value) {
            addCriterion("account_points <>", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsGreaterThan(Integer value) {
            addCriterion("account_points >", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_points >=", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsLessThan(Integer value) {
            addCriterion("account_points <", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsLessThanOrEqualTo(Integer value) {
            addCriterion("account_points <=", value, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsIn(List<Integer> values) {
            addCriterion("account_points in", values, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsNotIn(List<Integer> values) {
            addCriterion("account_points not in", values, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsBetween(Integer value1, Integer value2) {
            addCriterion("account_points between", value1, value2, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("account_points not between", value1, value2, "accountPoints");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialIsNull() {
            addCriterion("account_pointstrial is null");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialIsNotNull() {
            addCriterion("account_pointstrial is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialEqualTo(Integer value) {
            addCriterion("account_pointstrial =", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialNotEqualTo(Integer value) {
            addCriterion("account_pointstrial <>", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialGreaterThan(Integer value) {
            addCriterion("account_pointstrial >", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_pointstrial >=", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialLessThan(Integer value) {
            addCriterion("account_pointstrial <", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialLessThanOrEqualTo(Integer value) {
            addCriterion("account_pointstrial <=", value, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialIn(List<Integer> values) {
            addCriterion("account_pointstrial in", values, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialNotIn(List<Integer> values) {
            addCriterion("account_pointstrial not in", values, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialBetween(Integer value1, Integer value2) {
            addCriterion("account_pointstrial between", value1, value2, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountPointstrialNotBetween(Integer value1, Integer value2) {
            addCriterion("account_pointstrial not between", value1, value2, "accountPointstrial");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineIsNull() {
            addCriterion("account_deadline is null");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineIsNotNull() {
            addCriterion("account_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineEqualTo(Integer value) {
            addCriterion("account_deadline =", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineNotEqualTo(Integer value) {
            addCriterion("account_deadline <>", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineGreaterThan(Integer value) {
            addCriterion("account_deadline >", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_deadline >=", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineLessThan(Integer value) {
            addCriterion("account_deadline <", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineLessThanOrEqualTo(Integer value) {
            addCriterion("account_deadline <=", value, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineIn(List<Integer> values) {
            addCriterion("account_deadline in", values, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineNotIn(List<Integer> values) {
            addCriterion("account_deadline not in", values, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineBetween(Integer value1, Integer value2) {
            addCriterion("account_deadline between", value1, value2, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountDeadlineNotBetween(Integer value1, Integer value2) {
            addCriterion("account_deadline not between", value1, value2, "accountDeadline");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(Integer value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(Integer value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(Integer value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(Integer value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<Integer> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<Integer> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(Integer value1, Integer value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbIsNull() {
            addCriterion("account_isrmb is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbIsNotNull() {
            addCriterion("account_isrmb is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbEqualTo(Integer value) {
            addCriterion("account_isrmb =", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbNotEqualTo(Integer value) {
            addCriterion("account_isrmb <>", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbGreaterThan(Integer value) {
            addCriterion("account_isrmb >", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_isrmb >=", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbLessThan(Integer value) {
            addCriterion("account_isrmb <", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbLessThanOrEqualTo(Integer value) {
            addCriterion("account_isrmb <=", value, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbIn(List<Integer> values) {
            addCriterion("account_isrmb in", values, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbNotIn(List<Integer> values) {
            addCriterion("account_isrmb not in", values, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbBetween(Integer value1, Integer value2) {
            addCriterion("account_isrmb between", value1, value2, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountIsrmbNotBetween(Integer value1, Integer value2) {
            addCriterion("account_isrmb not between", value1, value2, "accountIsrmb");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNull() {
            addCriterion("account_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNotNull() {
            addCriterion("account_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeEqualTo(Integer value) {
            addCriterion("account_time =", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotEqualTo(Integer value) {
            addCriterion("account_time <>", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThan(Integer value) {
            addCriterion("account_time >", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_time >=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThan(Integer value) {
            addCriterion("account_time <", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThanOrEqualTo(Integer value) {
            addCriterion("account_time <=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIn(List<Integer> values) {
            addCriterion("account_time in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotIn(List<Integer> values) {
            addCriterion("account_time not in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeBetween(Integer value1, Integer value2) {
            addCriterion("account_time between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_time not between", value1, value2, "accountTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_account
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_account
     *
     * @mbggenerated
     */
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