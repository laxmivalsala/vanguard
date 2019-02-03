package models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pricePeriodCode",
        "pricePeriodDesc"
})
public class PricePeriodType {

    @JsonProperty("pricePeriodCode")
    public String pricePeriodCode;
    @JsonProperty("pricePeriodDesc")
    public String pricePeriodDesc;


}

