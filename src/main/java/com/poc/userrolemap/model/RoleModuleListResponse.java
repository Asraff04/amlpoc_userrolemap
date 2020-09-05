
package com.poc.userrolemap.model;

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
    "roleModuleList"
})
public class RoleModuleListResponse {

    @JsonProperty("roleModuleList")
    private List<RoleModule> roleModuleList = null;

//    @JsonProperty("roleModuleList")
//    private List<RoleModuleList> roleModuleList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<RoleModule> getRoleModuleList() {
        return roleModuleList;
    }

    public void setRoleModuleList(List<RoleModule> roleModuleList) {
        this.roleModuleList = roleModuleList;
    }

    //    @JsonProperty("roleModuleList")
//    public List<RoleModuleList> getRoleModuleList() {
//        return roleModuleList;
//    }
//
//    @JsonProperty("roleModuleList")
//    public void setRoleModuleList(List<RoleModuleList> roleModuleList) {
//        this.roleModuleList = roleModuleList;
//    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
