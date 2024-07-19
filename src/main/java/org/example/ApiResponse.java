package org.example;

import java.util.List;

public class ApiResponse {
    private List<Match> data;

    //getter
    public List<Match> getData() {

        return data;
    }

    //setter
    public void setData(List<Match> data) {

        this.data = data;
    }
}
