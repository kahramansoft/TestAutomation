package com.yunus.uitest.pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private final By searchInput = new By.ByXPath("//input[@data-testid='suggestion']");
    private final By searchResultTitle = new By.ByXPath("//div[@class='dscrptn dscrptn-V2']");

    public void setSearchText(String value) {
        sendKeys(searchInput, value);
    }

    public void clearSearchInput() {
        clear(searchInput);
    }

    public String getSearchResultTitle() {
        return getText(searchResultTitle);
    }
}
