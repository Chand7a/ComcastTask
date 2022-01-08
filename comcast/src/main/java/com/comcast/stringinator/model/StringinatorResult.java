package com.comcast.stringinator.model;


public class StringinatorResult {
    private final String input;
    private final Integer length;
    //private final String input2;


    public StringinatorResult(String input, Integer length) {
        this.input = input;
        this.length = length;
        //this.input2 = input2;
    }

    public Integer getLength() {
        return length;
    }


    public String getInput() {
        return this.input;
    }
}

