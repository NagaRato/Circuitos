package controllers;

import models.Gate;

import java.util.*;

public class CircuitController {
    private Map<String, Gate> gates = new HashMap<>();
    private Map<String, Gate> gatesWithInputPins = new HashMap<>();
    private Map<String, Gate> gatesWithOutputPins = new HashMap<>();

    public CircuitController(String inputLine) {
        List<String> lines = Arrays.asList(inputLine.split(";"));
        for (String line : lines) {
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
            Gate g = new Gate(id, type, inputs);
            gates.put(id, g);
            for (String input : inputs) {
                if (!input.equals(input.toLowerCase())) {
                    gatesWithInputPins.put(id, g);
                }
            }
            if (!id.equals(id.toLowerCase())) {
                gatesWithOutputPins.put(id, g);
            }
        }
        gates.forEach((gateID, gate) -> System.out.println(gate.getInputs()));
    }

    public Map<String, Gate> getGates() {
        return gates;
    }
}
