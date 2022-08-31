package controllers;

import models.Gate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class setup {
    public static void main(String[] args) throws IOException {
        System.out.println("Welkom bij Circuitos");
        System.out.println("Vul hier de configuratie van de poorten in, in 1 lijn.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = Arrays.asList(reader.readLine().split(";"));
        Map<String, Gate> gates = new HashMap<>();
        Map<String, Gate> gatesWithInputPins = new HashMap<>();
        Map<String, Gate> gatesWithOutputPins = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split("[=|(|,|)|;]");
            String id = "";
            String type = "";
            ArrayList<String> inputs = new ArrayList<>();
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    id = parts[0];
                } else if (i == 1) {
                    type = parts[1];
                } else {
                    inputs.add(parts[i]);
                }
            }
            Gate g = new Gate(id, type, inputs);
            gates.put(id, g);
            for (String input : inputs) {
                if (!input.equals(input.toLowerCase())) {
                    gatesWithInputPins.put(input.trim(), g);
                }
            }
            if (!id.equals(id.toLowerCase())) {
                gatesWithOutputPins.put(id, g);
            }
        }
        System.out.println("total gates: " + gates.size());
        System.out.println("total gates with input pins: " + gatesWithInputPins.size());
        System.out.println("total gates with output pins: " + gatesWithOutputPins.size());
    }
}
