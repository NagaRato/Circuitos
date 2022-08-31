package models;

import controllers.CircuitController;

import java.util.*;

public abstract class Gate {
    private final String id;
    private Map<String, Boolean> inputValues = new HashMap<>();
    private Boolean output = null;

    public Gate(String id, ArrayList<String> inputs) {
        this.id = id;
        inputs.forEach(inputId -> inputValues.put(inputId, null));
    }

    public String getId() {
        return id;
    }

    public Map<String, Boolean> getInputs() {
        return inputValues;
    }

    public void setInput(CircuitController controller, String inputwire, boolean value) {
        inputValues.replace(inputwire, value);
        if (inputValues.values().stream().filter(g -> g != null).count() == inputValues.size()) {
            output = calculateOutput(inputValues);
            controller.runConnectedGates(this);
            System.out.println(id + " " + getClass().getName() + "(" + inputValues + ")" + " -> " + output);
        }
    }

    protected abstract Boolean calculateOutput(Map<String, Boolean> inputValues);

    public Boolean getOutput() {
        return output;
    }
}
