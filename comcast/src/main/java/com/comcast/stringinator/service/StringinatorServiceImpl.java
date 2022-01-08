package com.comcast.stringinator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import com.comcast.stringinator.model.StatsResult;
import com.comcast.stringinator.model.StringinatorInput;
import com.comcast.stringinator.model.StringinatorResult;

import org.springframework.stereotype.Service;

@Service
public class StringinatorServiceImpl implements StringinatorService {

    private Map<String, String> seenStrings = new HashMap<>();

    @Override
    public StringinatorResult stringinate(StringinatorInput input) {
        seenStrings.compute(input.getInput(), (k, v) -> (v == null) ? String.valueOf(Integer.valueOf(1)) : String.valueOf(v) + 1);
        seenStrings.compute("Length", (k, v) -> (v == null) ? String.valueOf(input.getInput().length()) :v);
        seenStrings.compute("Occur", (k, v) -> (v == null) ? input.getOccur() :v);
        seenStrings.compute("OccurCount", (k, v) -> (v == null) ? String.valueOf(input.GetCount()) :v);
        seenStrings.compute("most_popular", (k, v) -> (v == null) ? input.getWord() :v);
        seenStrings.compute("longest_input_received ", (k, v) -> (v == null) ? input.getLongest() :v);

        StringinatorResult result = new StringinatorResult(input.getInput(), Integer.valueOf(input.getInput().length()));
        return result;
    }

    @Override
    public StatsResult stats() {
        return new StatsResult(seenStrings);
    }
}
