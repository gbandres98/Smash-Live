
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
    "full",
    "group",
    "sprite",
    "h",
    "w",
    "y",
    "x"
})
public class Image implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("full")
    private String full;
    @JsonProperty("group")
    private String group;
    @JsonProperty("sprite")
    private String sprite;
    @JsonProperty("h")
    private Integer h;
    @JsonProperty("w")
    private Integer w;
    @JsonProperty("y")
    private Integer y;
    @JsonProperty("x")
    private Integer x;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("full")
    public String getFull() {
        return full;
    }

    @JsonProperty("full")
    public void setFull(String full) {
        this.full = full;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("sprite")
    public String getSprite() {
        return sprite;
    }

    @JsonProperty("sprite")
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @JsonProperty("h")
    public Integer getH() {
        return h;
    }

    @JsonProperty("h")
    public void setH(Integer h) {
        this.h = h;
    }

    @JsonProperty("w")
    public Integer getW() {
        return w;
    }

    @JsonProperty("w")
    public void setW(Integer w) {
        this.w = w;
    }

    @JsonProperty("y")
    public Integer getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(Integer y) {
        this.y = y;
    }

    @JsonProperty("x")
    public Integer getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(Integer x) {
        this.x = x;
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
