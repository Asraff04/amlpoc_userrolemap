package com.poc.userrolemap.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ACUserRoleXrefId.class)
@Table(name = "AC_USER_ROLE_XREF", schema = "FirstMule")
public class ACUserRoleXref implements Serializable {

    @Id
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "Mapped_Role")
    private String mappedRole;
    @Id
    @Column(name = "ROLE_ID")
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public ACUserRoleXref() {
    }

//    public AC_User_Role_Xref_Temp(Integer userId, String mappedRole) {
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
