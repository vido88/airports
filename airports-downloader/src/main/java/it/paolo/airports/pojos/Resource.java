
package it.paolo.airports.pojos;

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
    "id",
    "revision_id",
    "url",
    "description",
    "format",
    "state",
    "revision_timestamp",
    "name",
    "mimetype",
    "size",
    "created",
    "resource_group_id",
    "last_modified"
})
public class Resource {

    @JsonProperty("id")
    private String id;
    @JsonProperty("revision_id")
    private String revisionId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("description")
    private String description;
    @JsonProperty("format")
    private String format;
    @JsonProperty("state")
    private String state;
    @JsonProperty("revision_timestamp")
    private String revisionTimestamp;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mimetype")
    private String mimetype;
    @JsonProperty("size")
    private String size;
    @JsonProperty("created")
    private String created;
    @JsonProperty("resource_group_id")
    private String resourceGroupId;
    @JsonProperty("last_modified")
    private String lastModified;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("revision_id")
    public String getRevisionId() {
        return revisionId;
    }

    @JsonProperty("revision_id")
    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("revision_timestamp")
    public String getRevisionTimestamp() {
        return revisionTimestamp;
    }

    @JsonProperty("revision_timestamp")
    public void setRevisionTimestamp(String revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("mimetype")
    public String getMimetype() {
        return mimetype;
    }

    @JsonProperty("mimetype")
    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("resource_group_id")
    public String getResourceGroupId() {
        return resourceGroupId;
    }

    @JsonProperty("resource_group_id")
    public void setResourceGroupId(String resourceGroupId) {
        this.resourceGroupId = resourceGroupId;
    }

    @JsonProperty("last_modified")
    public String getLastModified() {
        return lastModified;
    }

    @JsonProperty("last_modified")
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
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
