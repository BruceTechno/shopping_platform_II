package com.example.shopping_platform_II.vo;

public class SearchCommodityRequest {
    private String name;
    private String category;
    private String keyword; //could be name or category
//==

    public SearchCommodityRequest() {
    }
//==

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
