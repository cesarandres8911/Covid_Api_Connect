package com.covid.jxcovidapiconnect;

import javafx.beans.property.SimpleStringProperty;

public class Summary {
    private String country;
    private String newConfirmed;
    private String totalConfirmed;
    private String newDeaths;
    private String totalDeaths;
    private String totalRecovery;
    private String date;

    public Summary(String country, String newConfirmed, String totalConfirmed, String newDeaths, String totalDeaths, String totalRecovery, String date) {
        this.country = country;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.totalRecovery = totalRecovery;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTotalRecovery() {
        return totalRecovery;
    }

    public void setTotalRecovery(String totalRecovery) {
        this.totalRecovery = totalRecovery;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "country='" + country + '\'' +
                ", newConfirmed='" + newConfirmed + '\'' +
                ", totalConfirmed='" + totalConfirmed + '\'' +
                ", newDeaths='" + newDeaths + '\'' +
                ", totalDeaths='" + totalDeaths + '\'' +
                ", totalRecovery='" + totalRecovery + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
