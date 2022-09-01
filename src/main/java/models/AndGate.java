package models;

import java.util.ArrayList;
import java.util.Map;

public class AndGate extends Gate {

    public AndGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    public void calculateOutput() {
        int inputsNull = 0;
        int inputsTrue = 0;
        int inputsFalse = 0;
        for (Boolean b : inputValues.values()) {
            if (b == null) {
                inputsNull++;
            }
        }
        for (Boolean b : inputValues.values()) {
            if (b != null) {
                if (b) {
                    inputsTrue++;
                } else {
                    inputsFalse++;
                }
            }
        }
        if (inputsNull > 0) {
            output = null;
        } else if (inputsFalse > 0) {
            output = false;
        } else if (inputsTrue == inputValues.size()) {
            output = true;
        }
    }
}
