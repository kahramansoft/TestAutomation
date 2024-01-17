package com.yunus.uitest.tests;

import com.yunus.uitest.network.entity.SearchResponse;
import com.yunus.uitest.pages.SearchPage;
import com.yunus.uitest.util.SharedContext;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class SearchTest {

    private final SearchPage searchPage = new SearchPage();

    @And("Check search titles with api result")
    public void checkSearchTitlesWithApiResult() throws UnsupportedEncodingException {
        for (SearchResponse.Movie movie : SharedContext.movieList) {
            searchPage.setSearchText(movie.getTitle());
            searchPage.setSearchText(Keys.ENTER.toString());
            String decodedCurrentUrl = URLDecoder.decode(searchPage.getCurrentUrl(), "UTF-8");

            String maxLengthTitle = movie.getTitle().length() < 50 ? movie.getTitle() : movie.getTitle().substring(0, 50);
            Assert.assertTrue("Title values not equals", decodedCurrentUrl.contains(maxLengthTitle));
            searchPage.clearSearchInput();
        }
    }
}
