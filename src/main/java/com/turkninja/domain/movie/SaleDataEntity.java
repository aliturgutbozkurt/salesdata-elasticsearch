package com.turkninja.domain.movie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class SaleDataEntity {

    @JsonFormat(pattern = "MM/dd/yy HH:mm")
    @JsonProperty(value = "Transaction_date")
    private Date transactionDate;

    @JsonProperty(value = "Product")
    private String product;

    @JsonProperty(value = "Price")
    private BigDecimal price;

    @JsonProperty(value = "Payment_Type")
    private String paymentType;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "City")
    private String city;

    @JsonProperty(value = "State")
    private String state;

    @JsonProperty(value = "Country")
    private String country;

    @JsonFormat(pattern = "MM/dd/yy HH:mm")
    @JsonProperty(value = "Account_Created")
    private Date accountCreated;

    @JsonFormat(pattern = "MM/dd/yy HH:mm")
    @JsonProperty(value = "Last_Login")
    private Date lastLogin;

    @JsonProperty(value = "Latitude")
    private BigDecimal latitude;

    @JsonProperty(value = "Longitude")
    private BigDecimal longitude;
}
