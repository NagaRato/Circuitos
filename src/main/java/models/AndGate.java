package models;

import java.util.ArrayList;
import java.util.Map;

public class AndGate extends Gate {

    public AndGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    protected Boolean calculateOutput(Map<String, Boolean> inputValues) {
        return inputValues.values().stream().filter(v -> v == true).count() == inputValues.size();
    }
}
