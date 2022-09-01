package models;

import java.util.ArrayList;
import java.util.Map;

public class OrGate extends Gate {
    public OrGate(String id, ArrayList<String> inputs) {
        super(id, inputs);
    }

    @Override
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
        } else if (inputsTrue > 0) {
            output = true;
        } else if (inputsFalse == inputValues.size()) {
            output = false;
        }
        if (output != null) {getReportOfCalculation();}
    }
}
