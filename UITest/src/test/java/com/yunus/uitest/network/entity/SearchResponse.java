package com.yunus.uitest.network.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("Search")
    private List<Movie> search;

    public SearchResponse parse(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, SearchResponse.class);
    }

    public List<Movie> getSearch() {
        return search;
    }

    public static class Movie {
        @SerializedName("Title")
        private String title;

        public String getTitle() {
            return title;
        }
    }
}