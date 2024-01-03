
package ar.com.codoacodo.dto.reqres;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "year",
    "color",
    "pantone_value"
})
@Data
public class Datum {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("year")
    public Integer year;
    @JsonProperty("color")
    public String color;
    @JsonProperty("pantone_value")
    public String pantoneValue;

}
