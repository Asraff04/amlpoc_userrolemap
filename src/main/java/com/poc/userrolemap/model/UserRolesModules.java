package com.poc.userrolemap.model;

import java.util.List;

public class UserRolesModules {

    AcUsersList acUsers;
//    AcRolesList acRolesList
    AcRolesList ac_roles;
//    List<RoleModule> roleModuleList;
    List<AcRolesList> acRolesLists;

    public UserRolesModules() {
    }

    public AcUsersList getAcUsers() {
        return acUsers;
    }

    public void setAcUsers(AcUsersList acUsers) {
        this.acUsers = acUsers;
    }

    public List<AcRolesList> getAcRolesLists() {
        return acRolesLists;
    }

    public void setAcRolesLists(List<AcRolesList> acRolesLists) {
        this.acRolesLists = acRolesLists;
    }

}
