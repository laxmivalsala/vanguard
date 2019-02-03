package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "portId",
        "navPriceArray"
})
public class RootProperty {

    @JsonProperty("portId")
    public String portId;
    @JsonProperty("navPriceArray")
    public List<NavPriceArray> navPriceArray = null;


}
