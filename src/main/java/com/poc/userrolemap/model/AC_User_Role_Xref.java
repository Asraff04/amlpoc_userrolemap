package com.poc.userrolemap.model;

import javax.persistence.*;
import java.io.Serializable;

//Dummy class
//@Entity
//@IdClass(ACUserRoleXrefId.class)
//@Table(name = "AC_USER_ROLE_XREF", schema = "FirstMule")
public class AC_User_Role_Xref {

//    @Id
//    @Column(name = "USER_ID")
    private Integer userId;
//    @Id
//    @Column(name = "Mapped_Role")
    private String mappedRole;

    public AC_User_Role_Xref() {
    }

//    public AC_User_Role_Xref(Integer userId, String mappedRole) {
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

    public String getMappedRole() {
        return mappedRole;
    }

    public void setMappedRole(String mappedRole) {
        this.mappedRole = mappedRole;
    }
}
