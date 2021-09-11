package com.covid.jxcovidapiconnect;

public class Country {

    private String country;
    private String slug;
    private String iso2;

    public Country(String jCountry, String slug, String iso2) {
        this.country = jCountry;
        this.slug = slug;
        this.iso2 = iso2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "jCountry='" + country + '\'' +
                ", slug='" + slug + '\'' +
                ", iso2='" + iso2 + '\'' +
                '}';
    }
}

