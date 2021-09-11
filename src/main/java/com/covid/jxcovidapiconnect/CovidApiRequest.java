package com.covid.jxcovidapiconnect;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CovidApiRequest {

    public Country[] countries;

    public String Connection(String urlConn) throws IOException {
        // Returns all countries and associated provinces. The country_slug variable is used for country specific data

        URL url = null;
        HttpURLConnection urlConnection = null;
        int responseCode = 0;
        String result = "";

        try {
            // Connecting to api covid-19 portal, for example: "https://api.covid19api.com/"
            url = new URL(urlConn);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Getting the response code
            responseCode = urlConnection.getResponseCode();
        } catch (IOException err) {
            //TODO;
        }

        if (urlConnection != null && responseCode == 200) {
            try {
                // Parsing json object to String object.
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                result = new String(in.readAllBytes());
            } finally {
                urlConnection.disconnect();
            }
        }
        return result;
    }

    public void countryConnect() throws IOException {
        // Recover string with Country json data.
        String jsonCountry = Connection("https://api.covid19api.com/countries");

        // Using the JSON simple library parse the string array into a json object
        Object jsonObj = JSONValue.parse(jsonCountry);
        JSONArray arrayCountries = (JSONArray)jsonObj;

        // Defining the size of the array according to the json data obtained.
        countries = new Country[arrayCountries.size()];

        // Filling the Country Class array with the countries found into json object data.
        // {"Country": "Lithuania", "Slug": "lithuania", "ISO2": "LT"},
        // {"Country": "Maldives", "Slug": "maldives","ISO2": "MV"},
        for (int i = 0; i < arrayCountries.size(); i++) {
            JSONObject new_obj = (JSONObject) arrayCountries.get(i);
            countries[i] = new Country(new_obj.get("Country").toString(), new_obj.get("Slug").toString(), new_obj.get("ISO2").toString());
        }
    }

    public String[] CountrySuggestion(){
        int i = 0;
        String [] countrySuggestion = new String[this.countries.length];
        // Fill String array with the suggesting possible country names.
        for (Country country: this.countries){
            countrySuggestion[i] = country.getCountry();
            i++;
        }
        return countrySuggestion;
    }
    
    public Summary summaryConnect(String country) throws IOException, ParseException {

        Summary summary = null;
        // Recover string with summary json data.
        String jsonSummary = Connection("https://api.covid19api.com/summary");

        //Using the JSON simple library parse the string into a json object
        JSONParser parse = new JSONParser();
        JSONObject data_obj = (JSONObject) parse.parse(jsonSummary);

        //Get the required object from the above created object
        JSONObject obj = (JSONObject) data_obj.get("Global");

        //Get the required data using its key
        System.out.println(obj.get("TotalRecovered"));


        JSONArray arr = (JSONArray) data_obj.get("Countries");
        for (Object o : arr) {
            JSONObject new_obj = (JSONObject) o;
            if (new_obj.get("Slug").equals(country.toLowerCase())) {
                summary = (new Summary(new_obj.get("Country").toString(), new_obj.get("NewConfirmed").toString(), new_obj.get("TotalConfirmed").toString(),
                        new_obj.get("NewDeaths").toString(), new_obj.get("TotalDeaths").toString(), new_obj.get("TotalRecovered").toString(), new_obj.get("Date").toString()));
                break;
            }
        }
        return summary;
        }

}
