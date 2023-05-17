package com.example.testapp.model;

import java.util.ArrayList;

public class BoxOfficeResult {
    private ArrayList<DailyBoxOfficeList> dailyBoxOfficeList;

    private String boxofficeType;

    private String showRange;

    public ArrayList<DailyBoxOfficeList> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(ArrayList<DailyBoxOfficeList> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    @Override
    public String toString() {
        return "ClassPojo [dailyBoxOfficeList = " + dailyBoxOfficeList + ", boxofficeType = " + boxofficeType + ", showRange = " + showRange + "]";
    }
}
			