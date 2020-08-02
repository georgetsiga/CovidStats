package com.example.covidstats.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatsResponse {

    @SerializedName("get")
    @Expose
    private String get;
//    @SerializedName("parameters")
//    @Expose
//    private Parameters parameters;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("response")
    @Expose
    private List<Statistics> statistics = null;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

//    public Parameters getParameters() {
//        return parameters;
//    }
//
//    public void setParameters(Parameters parameters) {
//        this.parameters = parameters;
//    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

}