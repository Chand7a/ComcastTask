package com.comcast.stringinator.model;

import java.util.Map;

public class StatsResult {
    private final Map<String, String> inputs;

    public StatsResult(Map<String, String> inputs) {
        this.inputs = inputs;
    }

    public Map<String, String> getInputs() {
        return inputs;
    }
}

