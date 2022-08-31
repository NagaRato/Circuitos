package models;

import java.util.ArrayList;
import java.util.Map;

public class OrGate extends Gate {
    public OrGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    @Override
    protected Boolean calculateOutput(Map<String, Boolean> inputValues) {
        return inputValues.values().stream().filter(v -> v == false).count() != inputValues.size();
    }
}
