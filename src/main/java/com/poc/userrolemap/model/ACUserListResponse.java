
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
import com.poc.userrolemap.model.AcUsersList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acUsersList"
})
public class ACUserListResponse {

    @JsonProperty("acUsersList")
    private List<AcUsersList> acUsersList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("acUsersList")
    public List<AcUsersList> getAcUsersList() {
        return acUsersList;
    }

    @JsonProperty("acUsersList")
    public void setAcUsersList(List<AcUsersList> acUsersList) {
        this.acUsersList = acUsersList;
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
