package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "priceStatusCode",
        "priceStatusDesc"
})
public class PriceStatusType {

    @JsonProperty("priceStatusCode")
    public String priceStatusCode;
    @JsonProperty("priceStatusDesc")
    public String priceStatusDesc;


}
