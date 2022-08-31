package models;

import java.util.ArrayList;
import java.util.Map;

public class NotGate extends Gate {
    public NotGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    @Override
    protected Boolean calculateOutput(Map<String, Boolean> inputValues) {
        return !inputValues.values().stream().findAny().orElse(true);
    }
}
