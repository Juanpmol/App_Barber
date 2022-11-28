package com.example.ejemplonav.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class AuthResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("result")
    private Map<String, String> result;

    public AuthResponse(String status, Map<String, String> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }
}
