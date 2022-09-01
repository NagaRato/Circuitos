package models;

import controllers.CircuitController;

import java.util.*;

public abstract class Gate {
    private final String id;
    protected Map<String, Boolean> inputValues = new HashMap<>();
    protected Boolean output = null;

    public Gate(String id, ArrayList<String> inputs) {
        this.id = id;
        inputs.forEach(inputId -> inputValues.put(inputId, null));
    }

    public String getId() {
        return id;
    }

    public boolean hasUnknownInputs() {
        boolean hasUnknown = false;
        for (Boolean b : inputValues.values()) {
            if (b == null) {
                hasUnknown = true;
            }
        }
        return hasUnknown;
    }

    public void setInput(CircuitController controller, String inputwire, boolean value) {
        inputValues.replace(inputwire, value);
        if (inputValues.values().stream().filter(g -> g != null).count() == inputValues.size()) {
            calculateOutput();
            System.out.println(id + " " + getClass().getName() + "(" + inputValues + ")" + " -> " + output);
        }
    }

    public abstract void calculateOutput();

    public void getSourceSignals(Map<String, Gate> gates) {

            inputValues.keySet().forEach(
                    (k) -> {
                        if (gates.get(k) != null) {
                            inputValues.replace(k,
                                    gates.get(k).getOutput()
                            );
                        }
                    }
            );
    }

    public Boolean getOutput() {
        return output;
    }

    public Map<String, Boolean> getInputs() {
        return inputValues;
    }

    public void getReportOfCalculation() {
        System.out.println(id + " " + getClass().getName() + inputValues + " -> " + output);
    }
}
