
package com.poc.userrolemap.model;

import java.util.HashMap;
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
    "moduleName",
    "roleShortName"
})
public class RoleModuleResponse {

    @JsonProperty("roleId")
    private Integer roleId;
    @JsonProperty("roleName")
    private String roleName;
    @JsonProperty("moduleName")
    private String moduleName;
    @JsonProperty("roleShortName")
    private String roleShortName;
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

    @JsonProperty("moduleName")
    public String getModuleName() {
        return moduleName;
    }

    @JsonProperty("moduleName")
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @JsonProperty("roleShortName")
    public String getRoleShortName() {
        return roleShortName;
    }

    @JsonProperty("roleShortName")
    public void setRoleShortName(String roleShortName) {
        this.roleShortName = roleShortName;
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
