package it.paolo.airports.pojos;

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
    "id",
    "name",
    "title",
    "author_email",
    "maintainer_email",
    "license_url",
    "license_id",
    "notes",
    "state",
    "log_message",
    "revision_timestamp",
    "metadata_created",
    "metadata_modified",
    "creator_user_id",
    "type",
    "resources",
    "tags",
    "organization",
    "extras",
    "_catalog_parent_name",
    "_catalog_source_url"
})
public class Result {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("maintainer_email")
    private String maintainerEmail;
    @JsonProperty("license_url")
    private String licenseUrl;
    @JsonProperty("license_id")
    private String licenseId;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("state")
    private String state;
    @JsonProperty("log_message")
    private String logMessage;
    @JsonProperty("revision_timestamp")
    private String revisionTimestamp;
    @JsonProperty("metadata_created")
    private String metadataCreated;
    @JsonProperty("metadata_modified")
    private String metadataModified;
    @JsonProperty("creator_user_id")
    private String creatorUserId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("resources")
    private List<it.paolo.airports.pojos.Resource> resources = null;
    @JsonProperty("tags")
    private List<Tag> tags = null;
    @JsonProperty("organization")
    private List<it.paolo.airports.pojos.Organization> organization = null;
    @JsonProperty("extras")
    private List<it.paolo.airports.pojos.Extra> extras = null;
    @JsonProperty("_catalog_parent_name")
    private String catalogParentName;
    @JsonProperty("_catalog_source_url")
    private String catalogSourceUrl;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("author_email")
    public String getAuthorEmail() {
        return authorEmail;
    }

    @JsonProperty("author_email")
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @JsonProperty("maintainer_email")
    public String getMaintainerEmail() {
        return maintainerEmail;
    }

    @JsonProperty("maintainer_email")
    public void setMaintainerEmail(String maintainerEmail) {
        this.maintainerEmail = maintainerEmail;
    }

    @JsonProperty("license_url")
    public String getLicenseUrl() {
        return licenseUrl;
    }

    @JsonProperty("license_url")
    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    @JsonProperty("license_id")
    public String getLicenseId() {
        return licenseId;
    }

    @JsonProperty("license_id")
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("log_message")
    public String getLogMessage() {
        return logMessage;
    }

    @JsonProperty("log_message")
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @JsonProperty("revision_timestamp")
    public String getRevisionTimestamp() {
        return revisionTimestamp;
    }

    @JsonProperty("revision_timestamp")
    public void setRevisionTimestamp(String revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    @JsonProperty("metadata_created")
    public String getMetadataCreated() {
        return metadataCreated;
    }

    @JsonProperty("metadata_created")
    public void setMetadataCreated(String metadataCreated) {
        this.metadataCreated = metadataCreated;
    }

    @JsonProperty("metadata_modified")
    public String getMetadataModified() {
        return metadataModified;
    }

    @JsonProperty("metadata_modified")
    public void setMetadataModified(String metadataModified) {
        this.metadataModified = metadataModified;
    }

    @JsonProperty("creator_user_id")
    public String getCreatorUserId() {
        return creatorUserId;
    }

    @JsonProperty("creator_user_id")
    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("resources")
    public List<it.paolo.airports.pojos.Resource> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("organization")
    public List<it.paolo.airports.pojos.Organization> getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }

    @JsonProperty("extras")
    public List<it.paolo.airports.pojos.Extra> getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @JsonProperty("_catalog_parent_name")
    public String getCatalogParentName() {
        return catalogParentName;
    }

    @JsonProperty("_catalog_parent_name")
    public void setCatalogParentName(String catalogParentName) {
        this.catalogParentName = catalogParentName;
    }

    @JsonProperty("_catalog_source_url")
    public String getCatalogSourceUrl() {
        return catalogSourceUrl;
    }

    @JsonProperty("_catalog_source_url")
    public void setCatalogSourceUrl(String catalogSourceUrl) {
        this.catalogSourceUrl = catalogSourceUrl;
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
