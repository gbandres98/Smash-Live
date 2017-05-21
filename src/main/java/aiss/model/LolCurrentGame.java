
package aiss.model;

import java.io.Serializable;
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
    "gameId",
    "gameStartTime",
    "platformId",
    "gameMode",
    "mapId",
    "gameType",
    "gameQueueConfigId",
    "observers",
    "participants",
    "gameLength",
    "bannedChampions"
})
public class LolCurrentGame implements Serializable
{

    @JsonProperty("gameId")
    private Long gameId;
    @JsonProperty("gameStartTime")
    private Long gameStartTime;
    @JsonProperty("platformId")
    private String platformId;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("mapId")
    private Integer mapId;
    @JsonProperty("gameType")
    private String gameType;
    @JsonProperty("gameQueueConfigId")
    private Integer gameQueueConfigId;
    @JsonProperty("observers")
    private Observers observers;
    @JsonProperty("participants")
    private List<Participant> participants = null;
    @JsonProperty("gameLength")
    private Integer gameLength;
    @JsonProperty("bannedChampions")
    private List<BannedChampion> bannedChampions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8975285389408038948L;

    @JsonProperty("gameId")
    public Long getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("gameStartTime")
    public Long getGameStartTime() {
        return gameStartTime;
    }

    @JsonProperty("gameStartTime")
    public void setGameStartTime(Long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    @JsonProperty("platformId")
    public String getPlatformId() {
        return platformId;
    }

    @JsonProperty("platformId")
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @JsonProperty("gameMode")
    public String getGameMode() {
        return gameMode;
    }

    @JsonProperty("gameMode")
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    @JsonProperty("mapId")
    public Integer getMapId() {
        return mapId;
    }

    @JsonProperty("mapId")
    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    @JsonProperty("gameType")
    public String getGameType() {
        return gameType;
    }

    @JsonProperty("gameType")
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    @JsonProperty("gameQueueConfigId")
    public Integer getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    @JsonProperty("gameQueueConfigId")
    public void setGameQueueConfigId(Integer gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    @JsonProperty("observers")
    public Observers getObservers() {
        return observers;
    }

    @JsonProperty("observers")
    public void setObservers(Observers observers) {
        this.observers = observers;
    }

    @JsonProperty("participants")
    public List<Participant> getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @JsonProperty("gameLength")
    public Integer getGameLength() {
        return gameLength;
    }

    @JsonProperty("gameLength")
    public void setGameLength(Integer gameLength) {
        this.gameLength = gameLength;
    }

    @JsonProperty("bannedChampions")
    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    @JsonProperty("bannedChampions")
    public void setBannedChampions(List<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
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
