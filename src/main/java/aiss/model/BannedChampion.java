
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
    "teamId",
    "championId",
    "pickTurn"
})
public class BannedChampion implements Serializable
{

    @JsonProperty("teamId")
    private Integer teamId;
    @JsonProperty("championId")
    private Integer championId;
    @JsonProperty("pickTurn")
    private Integer pickTurn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2522825168845216303L;

    @JsonProperty("teamId")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("championId")
    public Integer getChampionId() {
        return championId;
    }

    @JsonProperty("championId")
    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    @JsonProperty("pickTurn")
    public Integer getPickTurn() {
        return pickTurn;
    }

    @JsonProperty("pickTurn")
    public void setPickTurn(Integer pickTurn) {
        this.pickTurn = pickTurn;
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
