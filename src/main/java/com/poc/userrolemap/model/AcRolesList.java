
package com.poc.userrolemap.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "roleId",
    "roleName",
    "roleShortName",
        "createdDate",
        "modifiedDate"
})
public class AcRolesList {

    @JsonProperty("roleId")
    private Integer roleId;
    @JsonProperty("roleName")
    private String roleName;
    @JsonProperty("roleShortName")
    private String roleShortName;

    @JsonProperty("roleModuleList")
    List<RoleModule> roleModuleList;

    @JsonProperty("createdDate")
    private Object createdDate;
    @JsonProperty("modifiedDate")
    private Object modifiedDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("roleId")
    public Integer getRoleId() {
        return roleId;
    }

    @JsonProperty("roleId")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @JsonProperty("roleName")
    public String getRoleName() {
        return roleName;
    }

    @JsonProperty("roleName")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonProperty("roleShortName")
    public String getRoleShortName() {
        return roleShortName;
    }

    @JsonProperty("roleShortName")
    public void setRoleShortName(String roleShortName) {
        this.roleShortName = roleShortName;
    }

    @JsonProperty("createdDate")
    public Object getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("modifiedDate")
    public Object getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Object modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<RoleModule> getRoleModuleList() {
        if(roleModuleList == null){
            roleModuleList = new ArrayList<>();
        }
        return roleModuleList;
    }

    public void setRoleModuleList(List<RoleModule> roleModuleList) {
        this.roleModuleList = roleModuleList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
