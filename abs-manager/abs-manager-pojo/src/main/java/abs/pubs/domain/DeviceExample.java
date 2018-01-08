package abs.pubs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDevicenameIsNull() {
            addCriterion("deviceName is null");
            return (Criteria) this;
        }

        public Criteria andDevicenameIsNotNull() {
            addCriterion("deviceName is not null");
            return (Criteria) this;
        }

        public Criteria andDevicenameEqualTo(String value) {
            addCriterion("deviceName =", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotEqualTo(String value) {
            addCriterion("deviceName <>", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameGreaterThan(String value) {
            addCriterion("deviceName >", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameGreaterThanOrEqualTo(String value) {
            addCriterion("deviceName >=", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLessThan(String value) {
            addCriterion("deviceName <", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLessThanOrEqualTo(String value) {
            addCriterion("deviceName <=", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLike(String value) {
            addCriterion("deviceName like", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotLike(String value) {
            addCriterion("deviceName not like", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameIn(List<String> values) {
            addCriterion("deviceName in", values, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotIn(List<String> values) {
            addCriterion("deviceName not in", values, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameBetween(String value1, String value2) {
            addCriterion("deviceName between", value1, value2, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotBetween(String value1, String value2) {
            addCriterion("deviceName not between", value1, value2, "devicename");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionIsNull() {
            addCriterion("outputResolution is null");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionIsNotNull() {
            addCriterion("outputResolution is not null");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionEqualTo(String value) {
            addCriterion("outputResolution =", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionNotEqualTo(String value) {
            addCriterion("outputResolution <>", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionGreaterThan(String value) {
            addCriterion("outputResolution >", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionGreaterThanOrEqualTo(String value) {
            addCriterion("outputResolution >=", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionLessThan(String value) {
            addCriterion("outputResolution <", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionLessThanOrEqualTo(String value) {
            addCriterion("outputResolution <=", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionLike(String value) {
            addCriterion("outputResolution like", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionNotLike(String value) {
            addCriterion("outputResolution not like", value, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionIn(List<String> values) {
            addCriterion("outputResolution in", values, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionNotIn(List<String> values) {
            addCriterion("outputResolution not in", values, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionBetween(String value1, String value2) {
            addCriterion("outputResolution between", value1, value2, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andOutputresolutionNotBetween(String value1, String value2) {
            addCriterion("outputResolution not between", value1, value2, "outputresolution");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionIsNull() {
            addCriterion("firmwareVersion is null");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionIsNotNull() {
            addCriterion("firmwareVersion is not null");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionEqualTo(String value) {
            addCriterion("firmwareVersion =", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionNotEqualTo(String value) {
            addCriterion("firmwareVersion <>", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionGreaterThan(String value) {
            addCriterion("firmwareVersion >", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionGreaterThanOrEqualTo(String value) {
            addCriterion("firmwareVersion >=", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionLessThan(String value) {
            addCriterion("firmwareVersion <", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionLessThanOrEqualTo(String value) {
            addCriterion("firmwareVersion <=", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionLike(String value) {
            addCriterion("firmwareVersion like", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionNotLike(String value) {
            addCriterion("firmwareVersion not like", value, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionIn(List<String> values) {
            addCriterion("firmwareVersion in", values, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionNotIn(List<String> values) {
            addCriterion("firmwareVersion not in", values, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionBetween(String value1, String value2) {
            addCriterion("firmwareVersion between", value1, value2, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andFirmwareversionNotBetween(String value1, String value2) {
            addCriterion("firmwareVersion not between", value1, value2, "firmwareversion");
            return (Criteria) this;
        }

        public Criteria andAppversionIsNull() {
            addCriterion("appVersion is null");
            return (Criteria) this;
        }

        public Criteria andAppversionIsNotNull() {
            addCriterion("appVersion is not null");
            return (Criteria) this;
        }

        public Criteria andAppversionEqualTo(String value) {
            addCriterion("appVersion =", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotEqualTo(String value) {
            addCriterion("appVersion <>", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionGreaterThan(String value) {
            addCriterion("appVersion >", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionGreaterThanOrEqualTo(String value) {
            addCriterion("appVersion >=", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLessThan(String value) {
            addCriterion("appVersion <", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLessThanOrEqualTo(String value) {
            addCriterion("appVersion <=", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLike(String value) {
            addCriterion("appVersion like", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotLike(String value) {
            addCriterion("appVersion not like", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionIn(List<String> values) {
            addCriterion("appVersion in", values, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotIn(List<String> values) {
            addCriterion("appVersion not in", values, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionBetween(String value1, String value2) {
            addCriterion("appVersion between", value1, value2, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotBetween(String value1, String value2) {
            addCriterion("appVersion not between", value1, value2, "appversion");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskIsNull() {
            addCriterion("subnetMask is null");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskIsNotNull() {
            addCriterion("subnetMask is not null");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskEqualTo(String value) {
            addCriterion("subnetMask =", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskNotEqualTo(String value) {
            addCriterion("subnetMask <>", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskGreaterThan(String value) {
            addCriterion("subnetMask >", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskGreaterThanOrEqualTo(String value) {
            addCriterion("subnetMask >=", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskLessThan(String value) {
            addCriterion("subnetMask <", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskLessThanOrEqualTo(String value) {
            addCriterion("subnetMask <=", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskLike(String value) {
            addCriterion("subnetMask like", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskNotLike(String value) {
            addCriterion("subnetMask not like", value, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskIn(List<String> values) {
            addCriterion("subnetMask in", values, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskNotIn(List<String> values) {
            addCriterion("subnetMask not in", values, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskBetween(String value1, String value2) {
            addCriterion("subnetMask between", value1, value2, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andSubnetmaskNotBetween(String value1, String value2) {
            addCriterion("subnetMask not between", value1, value2, "subnetmask");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayIsNull() {
            addCriterion("defaultGateway is null");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayIsNotNull() {
            addCriterion("defaultGateway is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayEqualTo(String value) {
            addCriterion("defaultGateway =", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayNotEqualTo(String value) {
            addCriterion("defaultGateway <>", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayGreaterThan(String value) {
            addCriterion("defaultGateway >", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayGreaterThanOrEqualTo(String value) {
            addCriterion("defaultGateway >=", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayLessThan(String value) {
            addCriterion("defaultGateway <", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayLessThanOrEqualTo(String value) {
            addCriterion("defaultGateway <=", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayLike(String value) {
            addCriterion("defaultGateway like", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayNotLike(String value) {
            addCriterion("defaultGateway not like", value, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayIn(List<String> values) {
            addCriterion("defaultGateway in", values, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayNotIn(List<String> values) {
            addCriterion("defaultGateway not in", values, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayBetween(String value1, String value2) {
            addCriterion("defaultGateway between", value1, value2, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andDefaultgatewayNotBetween(String value1, String value2) {
            addCriterion("defaultGateway not between", value1, value2, "defaultgateway");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceIsNull() {
            addCriterion("hardDiskFreeSpace is null");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceIsNotNull() {
            addCriterion("hardDiskFreeSpace is not null");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceEqualTo(String value) {
            addCriterion("hardDiskFreeSpace =", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceNotEqualTo(String value) {
            addCriterion("hardDiskFreeSpace <>", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceGreaterThan(String value) {
            addCriterion("hardDiskFreeSpace >", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceGreaterThanOrEqualTo(String value) {
            addCriterion("hardDiskFreeSpace >=", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceLessThan(String value) {
            addCriterion("hardDiskFreeSpace <", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceLessThanOrEqualTo(String value) {
            addCriterion("hardDiskFreeSpace <=", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceLike(String value) {
            addCriterion("hardDiskFreeSpace like", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceNotLike(String value) {
            addCriterion("hardDiskFreeSpace not like", value, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceIn(List<String> values) {
            addCriterion("hardDiskFreeSpace in", values, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceNotIn(List<String> values) {
            addCriterion("hardDiskFreeSpace not in", values, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceBetween(String value1, String value2) {
            addCriterion("hardDiskFreeSpace between", value1, value2, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andHarddiskfreespaceNotBetween(String value1, String value2) {
            addCriterion("hardDiskFreeSpace not between", value1, value2, "harddiskfreespace");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIsNull() {
            addCriterion("systemType is null");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIsNotNull() {
            addCriterion("systemType is not null");
            return (Criteria) this;
        }

        public Criteria andSystemtypeEqualTo(String value) {
            addCriterion("systemType =", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotEqualTo(String value) {
            addCriterion("systemType <>", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeGreaterThan(String value) {
            addCriterion("systemType >", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeGreaterThanOrEqualTo(String value) {
            addCriterion("systemType >=", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeLessThan(String value) {
            addCriterion("systemType <", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeLessThanOrEqualTo(String value) {
            addCriterion("systemType <=", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeLike(String value) {
            addCriterion("systemType like", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotLike(String value) {
            addCriterion("systemType not like", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIn(List<String> values) {
            addCriterion("systemType in", values, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotIn(List<String> values) {
            addCriterion("systemType not in", values, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeBetween(String value1, String value2) {
            addCriterion("systemType between", value1, value2, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotBetween(String value1, String value2) {
            addCriterion("systemType not between", value1, value2, "systemtype");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryIsNull() {
            addCriterion("totalPhysicalMemory is null");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryIsNotNull() {
            addCriterion("totalPhysicalMemory is not null");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryEqualTo(String value) {
            addCriterion("totalPhysicalMemory =", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryNotEqualTo(String value) {
            addCriterion("totalPhysicalMemory <>", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryGreaterThan(String value) {
            addCriterion("totalPhysicalMemory >", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryGreaterThanOrEqualTo(String value) {
            addCriterion("totalPhysicalMemory >=", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryLessThan(String value) {
            addCriterion("totalPhysicalMemory <", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryLessThanOrEqualTo(String value) {
            addCriterion("totalPhysicalMemory <=", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryLike(String value) {
            addCriterion("totalPhysicalMemory like", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryNotLike(String value) {
            addCriterion("totalPhysicalMemory not like", value, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryIn(List<String> values) {
            addCriterion("totalPhysicalMemory in", values, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryNotIn(List<String> values) {
            addCriterion("totalPhysicalMemory not in", values, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryBetween(String value1, String value2) {
            addCriterion("totalPhysicalMemory between", value1, value2, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andTotalphysicalmemoryNotBetween(String value1, String value2) {
            addCriterion("totalPhysicalMemory not between", value1, value2, "totalphysicalmemory");
            return (Criteria) this;
        }

        public Criteria andLoginusernameIsNull() {
            addCriterion("LoginUserName is null");
            return (Criteria) this;
        }

        public Criteria andLoginusernameIsNotNull() {
            addCriterion("LoginUserName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginusernameEqualTo(String value) {
            addCriterion("LoginUserName =", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameNotEqualTo(String value) {
            addCriterion("LoginUserName <>", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameGreaterThan(String value) {
            addCriterion("LoginUserName >", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameGreaterThanOrEqualTo(String value) {
            addCriterion("LoginUserName >=", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameLessThan(String value) {
            addCriterion("LoginUserName <", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameLessThanOrEqualTo(String value) {
            addCriterion("LoginUserName <=", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameLike(String value) {
            addCriterion("LoginUserName like", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameNotLike(String value) {
            addCriterion("LoginUserName not like", value, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameIn(List<String> values) {
            addCriterion("LoginUserName in", values, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameNotIn(List<String> values) {
            addCriterion("LoginUserName not in", values, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameBetween(String value1, String value2) {
            addCriterion("LoginUserName between", value1, value2, "loginusername");
            return (Criteria) this;
        }

        public Criteria andLoginusernameNotBetween(String value1, String value2) {
            addCriterion("LoginUserName not between", value1, value2, "loginusername");
            return (Criteria) this;
        }

        public Criteria andCpuidIsNull() {
            addCriterion("cpuID is null");
            return (Criteria) this;
        }

        public Criteria andCpuidIsNotNull() {
            addCriterion("cpuID is not null");
            return (Criteria) this;
        }

        public Criteria andCpuidEqualTo(String value) {
            addCriterion("cpuID =", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotEqualTo(String value) {
            addCriterion("cpuID <>", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidGreaterThan(String value) {
            addCriterion("cpuID >", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidGreaterThanOrEqualTo(String value) {
            addCriterion("cpuID >=", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidLessThan(String value) {
            addCriterion("cpuID <", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidLessThanOrEqualTo(String value) {
            addCriterion("cpuID <=", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidLike(String value) {
            addCriterion("cpuID like", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotLike(String value) {
            addCriterion("cpuID not like", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidIn(List<String> values) {
            addCriterion("cpuID in", values, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotIn(List<String> values) {
            addCriterion("cpuID not in", values, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidBetween(String value1, String value2) {
            addCriterion("cpuID between", value1, value2, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotBetween(String value1, String value2) {
            addCriterion("cpuID not between", value1, value2, "cpuid");
            return (Criteria) this;
        }

        public Criteria andDiskidIsNull() {
            addCriterion("diskID is null");
            return (Criteria) this;
        }

        public Criteria andDiskidIsNotNull() {
            addCriterion("diskID is not null");
            return (Criteria) this;
        }

        public Criteria andDiskidEqualTo(String value) {
            addCriterion("diskID =", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidNotEqualTo(String value) {
            addCriterion("diskID <>", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidGreaterThan(String value) {
            addCriterion("diskID >", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidGreaterThanOrEqualTo(String value) {
            addCriterion("diskID >=", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidLessThan(String value) {
            addCriterion("diskID <", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidLessThanOrEqualTo(String value) {
            addCriterion("diskID <=", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidLike(String value) {
            addCriterion("diskID like", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidNotLike(String value) {
            addCriterion("diskID not like", value, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidIn(List<String> values) {
            addCriterion("diskID in", values, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidNotIn(List<String> values) {
            addCriterion("diskID not in", values, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidBetween(String value1, String value2) {
            addCriterion("diskID between", value1, value2, "diskid");
            return (Criteria) this;
        }

        public Criteria andDiskidNotBetween(String value1, String value2) {
            addCriterion("diskID not between", value1, value2, "diskid");
            return (Criteria) this;
        }

        public Criteria andGroupingIsNull() {
            addCriterion("grouping is null");
            return (Criteria) this;
        }

        public Criteria andGroupingIsNotNull() {
            addCriterion("grouping is not null");
            return (Criteria) this;
        }

        public Criteria andGroupingEqualTo(Integer value) {
            addCriterion("grouping =", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingNotEqualTo(Integer value) {
            addCriterion("grouping <>", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingGreaterThan(Integer value) {
            addCriterion("grouping >", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingGreaterThanOrEqualTo(Integer value) {
            addCriterion("grouping >=", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingLessThan(Integer value) {
            addCriterion("grouping <", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingLessThanOrEqualTo(Integer value) {
            addCriterion("grouping <=", value, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingIn(List<Integer> values) {
            addCriterion("grouping in", values, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingNotIn(List<Integer> values) {
            addCriterion("grouping not in", values, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingBetween(Integer value1, Integer value2) {
            addCriterion("grouping between", value1, value2, "grouping");
            return (Criteria) this;
        }

        public Criteria andGroupingNotBetween(Integer value1, Integer value2) {
            addCriterion("grouping not between", value1, value2, "grouping");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidIsNull() {
            addCriterion("devicetypeId is null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidIsNotNull() {
            addCriterion("devicetypeId is not null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidEqualTo(Integer value) {
            addCriterion("devicetypeId =", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidNotEqualTo(Integer value) {
            addCriterion("devicetypeId <>", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidGreaterThan(Integer value) {
            addCriterion("devicetypeId >", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("devicetypeId >=", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidLessThan(Integer value) {
            addCriterion("devicetypeId <", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("devicetypeId <=", value, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidIn(List<Integer> values) {
            addCriterion("devicetypeId in", values, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidNotIn(List<Integer> values) {
            addCriterion("devicetypeId not in", values, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidBetween(Integer value1, Integer value2) {
            addCriterion("devicetypeId between", value1, value2, "devicetypeid");
            return (Criteria) this;
        }

        public Criteria andDevicetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("devicetypeId not between", value1, value2, "devicetypeid");
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