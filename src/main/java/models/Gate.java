package models;

import java.util.*;

public class Gate {
    private final String id;
    private Map<String, Boolean> inputValues = new HashMap<>();

    public Gate(String id, String type, ArrayList<String> inputs) {
        this.id = id;
        inputs.forEach(inputId -> inputValues.put(inputId, null));
    }

    public String getId() {
        return id;
    }

    public Map<String, Boolean> getInputs() {
        return inputValues;
    }

    public void setInput(String inputwire, boolean value) {
        inputValues.replace(inputwire, value);
    }
}
