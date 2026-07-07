package com.cognizant.springlearn;

/**
 * Represents a country entity with a two-character ISO code and full name.
 * Jackson serialises this POJO to JSON automatically when returned
 * from a @RestController method.
 */
public class Country {

    private String code;
    private String name;

    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
