package com.yunus.uitest.network.entity;

import com.yunus.uitest.util.Config;

public class SearchRequest {
    public String build(String searchTerm, int page) {
        return Config.apiURL + "?s=" + searchTerm + "&page=" +page + "&apikey=" + Config.apiKey;
    }
}
