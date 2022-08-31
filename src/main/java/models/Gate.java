package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gate {
    private final String id;
    private List<String> inputs;

    public Gate(String id, String type, ArrayList<String> inputs) {
        this.id = id;
        this.inputs = inputs;
    }

    public String getId() {
        return id;
    }

    public List<String> getInputs() {
        return inputs;
    }
}
