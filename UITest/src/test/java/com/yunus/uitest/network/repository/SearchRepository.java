package com.yunus.uitest.network.repository;

import com.yunus.uitest.network.entity.SearchRequest;
import com.yunus.uitest.network.entity.SearchResponse;
import com.yunus.uitest.network.manager.NetworkManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SearchRepository {

    private final NetworkManager networkManager = new NetworkManager();

    public List<SearchResponse.Movie> search(String searchTerm) throws IOException {
        int page = 1;
        List<SearchResponse.Movie> movieList = new ArrayList<>();

        while (true) {
            String request = new SearchRequest().build(searchTerm, page);
            String response = networkManager.fetchData(request);

            try {
                List<SearchResponse.Movie> newMovieList = new SearchResponse().parse(response).getSearch();
                if (newMovieList.isEmpty() ) {
                    break;
                }
                movieList.addAll(newMovieList);
            } catch (Exception e) {
                break;
            }
            page++;
        }

        return movieList;
    }

}
