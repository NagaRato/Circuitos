package models;

import java.util.ArrayList;
import java.util.Map;

public class NotGate extends Gate {
    public NotGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    @Override
    public void calculateOutput() {
        for (Boolean b : inputValues.values()) {
            if (b == null) {
                output = null;
            } else {
                output = !b;
            }
        }
    }
}
