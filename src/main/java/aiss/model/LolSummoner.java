
package aiss.model;

import java.io.Serializable;
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
    "profileIconId",
    "name",
    "summonerLevel",
    "accountId",
    "id",
    "revisionDate"
})
public class LolSummoner implements Serializable
{

    @JsonProperty("profileIconId")
    private Integer profileIconId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("summonerLevel")
    private Integer summonerLevel;
    @JsonProperty("accountId")
    private Integer accountId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("revisionDate")
    private Long revisionDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4587787562712438867L;

    @JsonProperty("profileIconId")
    public Integer getProfileIconId() {
        return profileIconId;
    }

    @JsonProperty("profileIconId")
    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("summonerLevel")
    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    @JsonProperty("summonerLevel")
    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    @JsonProperty("accountId")
    public Integer getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("revisionDate")
    public Long getRevisionDate() {
        return revisionDate;
    }

    @JsonProperty("revisionDate")
    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
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
