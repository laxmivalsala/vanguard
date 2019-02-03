package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amountChange",
        "asOfDate",
        "currency",
        "isFinal",
        "measureType",
        "percentChange",
        "price",
        "pricePeriodType",
        "priceStatusType",
        "yield",
        "final"
})
public class NavPriceArray {

    @JsonProperty("amountChange")
    public Double amountChange;
    @JsonProperty("asOfDate")
    public String asOfDate;
    @JsonProperty("currency")
    public Currency currency;
    @JsonProperty("isFinal")
    public Boolean isFinal;
    @JsonProperty("measureType")
    public MeasureType measureType;
    @JsonProperty("percentChange")
    public Double percentChange;
    @JsonProperty("price")
    public Double price;
    @JsonProperty("pricePeriodType")
    public PricePeriodType pricePeriodType;
    @JsonProperty("priceStatusType")
    public PriceStatusType priceStatusType;
    @JsonProperty("yield")
    public Object yield;
    @JsonProperty("final")
    public Boolean _final;

}