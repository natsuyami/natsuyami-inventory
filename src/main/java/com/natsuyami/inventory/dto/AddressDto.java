package com.natsuyami.inventory.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class AddressDto implements Serializable {

    private static final long serialVersionUID = 4628122430762737878L;

    @JsonProperty("address_id")
    private long id;

    private String addressBlock;

    private String baranggay;

    private String city;

    private String region;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }

    public String getBaranggay() {
        return baranggay;
    }

    public void setBaranggay(String baranggay) {
        this.baranggay = baranggay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"addressBlock\" : ");
        builder.append("\"" + addressBlock + "\", ");
        builder.append("\"baranggay\" : ");
        builder.append("\"" + baranggay + "\", ");
        builder.append("\"city\" : ");
        builder.append("\"" + city + "\", ");
        builder.append("\"region\" : ");
        builder.append("\"" + region + "\"");
        builder.append("}");
        return builder.toString();
    }
}
