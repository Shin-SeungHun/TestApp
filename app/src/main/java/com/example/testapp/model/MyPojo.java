package com.example.testapp.model;

public class MyPojo {
    private BoxOfficeResult boxOfficeResult;

    public BoxOfficeResult getBoxOfficeResult ()
    {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult (BoxOfficeResult boxOfficeResult)
    {
        this.boxOfficeResult = boxOfficeResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [boxOfficeResult = "+boxOfficeResult+"]";
    }
}
