package abs.pubs.domain;

import java.util.Date;

public class Device {
    private Integer id;

    private String devicename;

    private String mac;

    private String ip;

    private String status;

    private String outputresolution;

    private String firmwareversion;

    private String appversion;

    private String subnetmask;

    private String defaultgateway;

    private String harddiskfreespace;

    private Date updatetime;

    private String systemtype;

    private String totalphysicalmemory;

    private String loginusername;

    private String cpuid;

    private String diskid;

    private Integer grouping;

    private Integer devicetypeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOutputresolution() {
        return outputresolution;
    }

    public void setOutputresolution(String outputresolution) {
        this.outputresolution = outputresolution == null ? null : outputresolution.trim();
    }

    public String getFirmwareversion() {
        return firmwareversion;
    }

    public void setFirmwareversion(String firmwareversion) {
        this.firmwareversion = firmwareversion == null ? null : firmwareversion.trim();
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion == null ? null : appversion.trim();
    }

    public String getSubnetmask() {
        return subnetmask;
    }

    public void setSubnetmask(String subnetmask) {
        this.subnetmask = subnetmask == null ? null : subnetmask.trim();
    }

    public String getDefaultgateway() {
        return defaultgateway;
    }

    public void setDefaultgateway(String defaultgateway) {
        this.defaultgateway = defaultgateway == null ? null : defaultgateway.trim();
    }

    public String getHarddiskfreespace() {
        return harddiskfreespace;
    }

    public void setHarddiskfreespace(String harddiskfreespace) {
        this.harddiskfreespace = harddiskfreespace == null ? null : harddiskfreespace.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSystemtype() {
        return systemtype;
    }

    public void setSystemtype(String systemtype) {
        this.systemtype = systemtype == null ? null : systemtype.trim();
    }

    public String getTotalphysicalmemory() {
        return totalphysicalmemory;
    }

    public void setTotalphysicalmemory(String totalphysicalmemory) {
        this.totalphysicalmemory = totalphysicalmemory == null ? null : totalphysicalmemory.trim();
    }

    public String getLoginusername() {
        return loginusername;
    }

    public void setLoginusername(String loginusername) {
        this.loginusername = loginusername == null ? null : loginusername.trim();
    }

    public String getCpuid() {
        return cpuid;
    }

    public void setCpuid(String cpuid) {
        this.cpuid = cpuid == null ? null : cpuid.trim();
    }

    public String getDiskid() {
        return diskid;
    }

    public void setDiskid(String diskid) {
        this.diskid = diskid == null ? null : diskid.trim();
    }

    public Integer getGrouping() {
        return grouping;
    }

    public void setGrouping(Integer grouping) {
        this.grouping = grouping;
    }

    public Integer getDevicetypeid() {
        return devicetypeid;
    }

    public void setDevicetypeid(Integer devicetypeid) {
        this.devicetypeid = devicetypeid;
    }
}