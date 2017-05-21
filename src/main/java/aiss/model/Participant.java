
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
    "profileIconId",
    "championId",
    "summonerName",
    "runes",
    "bot",
    "masteries",
    "spell2Id",
    "teamId",
    "spell1Id",
    "summonerId"
})
public class Participant implements Serializable
{

    @JsonProperty("profileIconId")
    private Integer profileIconId;
    @JsonProperty("championId")
    private Integer championId;
    @JsonProperty("summonerName")
    private String summonerName;
    @JsonProperty("runes")
    private List<Rune> runes = null;
    @JsonProperty("bot")
    private Boolean bot;
    @JsonProperty("masteries")
    private List<Mastery> masteries = null;
    @JsonProperty("spell2Id")
    private Integer spell2Id;
    @JsonProperty("teamId")
    private Integer teamId;
    @JsonProperty("spell1Id")
    private Integer spell1Id;
    @JsonProperty("summonerId")
    private Integer summonerId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3609538055107000903L;

    @JsonProperty("profileIconId")
    public Integer getProfileIconId() {
        return profileIconId;
    }

    @JsonProperty("profileIconId")
    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

    @JsonProperty("championId")
    public Integer getChampionId() {
        return championId;
    }

    @JsonProperty("championId")
    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    @JsonProperty("summonerName")
    public String getSummonerName() {
        return summonerName;
    }

    @JsonProperty("summonerName")
    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    @JsonProperty("runes")
    public List<Rune> getRunes() {
        return runes;
    }

    @JsonProperty("runes")
    public void setRunes(List<Rune> runes) {
        this.runes = runes;
    }

    @JsonProperty("bot")
    public Boolean getBot() {
        return bot;
    }

    @JsonProperty("bot")
    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    @JsonProperty("masteries")
    public List<Mastery> getMasteries() {
        return masteries;
    }

    @JsonProperty("masteries")
    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    @JsonProperty("spell2Id")
    public Integer getSpell2Id() {
        return spell2Id;
    }

    @JsonProperty("spell2Id")
    public void setSpell2Id(Integer spell2Id) {
        this.spell2Id = spell2Id;
    }

    @JsonProperty("teamId")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("spell1Id")
    public Integer getSpell1Id() {
        return spell1Id;
    }

    @JsonProperty("spell1Id")
    public void setSpell1Id(Integer spell1Id) {
        this.spell1Id = spell1Id;
    }

    @JsonProperty("summonerId")
    public Integer getSummonerId() {
        return summonerId;
    }

    @JsonProperty("summonerId")
    public void setSummonerId(Integer summonerId) {
        this.summonerId = summonerId;
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
