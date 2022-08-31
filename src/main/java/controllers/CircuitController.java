package controllers;

import models.AndGate;
import models.Gate;
import models.NotGate;
import models.OrGate;

import java.util.*;

public class CircuitController {
    private Map<String, Gate> gates = new HashMap<>();
    private ArrayList<String> inputPins = new ArrayList<>();
    private Map<String, Gate> gatesWithOutputPins = new HashMap<>();

    public CircuitController(List<String> inputLines) {
        for (String line : inputLines) {
            String[] parts = line.split("[=|(|,|)|;]");
            String id = "";
            String type = "";
            ArrayList<String> inputs = new ArrayList<>();
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    id = parts[0].trim();
                } else if (i == 1) {
                    type = parts[1].trim();
                } else {
                    inputs.add(parts[i].trim());
                }
            }
            Gate g = null;
            switch (type) {
                case "and":
                    g = new AndGate(id, inputs);
                    break;
                case "or":
                    g = new OrGate(id, inputs);
                    break;
                case "not":
                    g = new NotGate(id, inputs);
                    break;
            }
            gates.put(id, g);
            for (String input : inputs) {
                if (!input.equals(input.toLowerCase()) && !inputPins.contains(input)) {
                    inputPins.add(input);
                }
            }
            if (!id.equals(id.toLowerCase())) {
                gatesWithOutputPins.put(id, g);
            }
        }
    }

    public Map<String, Gate> getGates() {
        return gates;
    }

    public ArrayList<String> getInputPins() {
        return inputPins;
    }

    public void run(String s) {
        for (int i = 0; i < s.length(); i++) {
            char finalI = s.charAt(i);
            String finalJ = inputPins.get(i);
            gates.forEach((k, v) -> {
                if (v.getInputs().containsKey(finalJ) && finalI == '1')
                {
                    v.setInput(
                            this,
                            finalJ,
                            true
                    );
                } else if (v.getInputs().containsKey(finalJ) && finalI == '0') {
                    v.setInput(
                            this,
                            finalJ,
                            false
                    );
                }
            }
            );
        }
        gatesWithOutputPins.forEach((k, v) -> System.out.println(k + v.getOutput()));
    }

    public void runConnectedGates(Gate sourceGate) {
        gates.values().stream().filter(v -> v.getInputs().containsKey(sourceGate.getId())).forEach(g -> g.setInput(this, sourceGate.getId(), sourceGate.getOutput()));
    }
}
