package com.poc.userrolemap.model;

import java.io.Serializable;

public class ACUserRoleXrefId implements Serializable {


    private Integer userId;
    private Integer roleId;

    public ACUserRoleXrefId() {
    }

//    public ACUserRoleXrefId(Integer userId, String mappedRole) {
//        super();
//        UserId = userId;
//        MappedRole = mappedRole;
//    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
