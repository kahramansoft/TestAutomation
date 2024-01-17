package com.yunus.uitest.tests;

import com.yunus.uitest.network.repository.SearchRepository;
import com.yunus.uitest.util.SharedContext;
import io.cucumber.java.en.And;

import java.io.IOException;

public class NetworkTest {

    @And("Fetch {string} search response from api")
    public void fetchSearchResponseFromApi(String arg0) throws IOException {
        SharedContext.movieList = new SearchRepository().search(arg0);
    }
}
