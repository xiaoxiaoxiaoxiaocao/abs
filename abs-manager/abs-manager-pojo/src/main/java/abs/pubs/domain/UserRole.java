package abs.pubs.domain;
/**
 *对应了用户角色表，包含用户id和角色id
 * @author 曹起坤
 *
 */
public class UserRole {
    private Integer userid;

    private Integer roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}