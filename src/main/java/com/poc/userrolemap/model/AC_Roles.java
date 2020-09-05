package com.poc.userrolemap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

//Dummmy

//@Table(name="AC_ROLES", schema="FirstMule")
public class AC_Roles implements Serializable {


    private Integer roleId;
    private String roleName;
    private String roleShortName;
    List<RoleModule> roleModuleList;

    public AC_Roles() {
    }

//    public AC_Roles(Integer roleId, String roleName, String roleShortName) {
//        super();
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.roleShortName = roleShortName;
//    }


    public List<RoleModule> getRoleModuleList() {
        return roleModuleList;
    }

    public void setRoleModuleList(List<RoleModule> roleModuleList) {
        this.roleModuleList = roleModuleList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleShortName() {
        return roleShortName;
    }

    public void setRoleShortName(String roleShortName) {
        this.roleShortName = roleShortName;
    }

}

