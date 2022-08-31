package controllers;

import models.Gate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class setup {
    public static void main(String[] args) throws IOException {
        System.out.println("Welkom bij Circuitos");
        System.out.println("Configuratie van de poorten wordt nu ingeladen.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CircuitController circuit = new CircuitController(readConfig());
        boolean tobeContinued = true;
        while (tobeContinued) {
            System.out.println("Je kunt het circuit nu runnen door hier een input te geven van uitsluitend 1'en en 0'en (minimaal " + circuit.getInputPins().size() + " karakters):");
            String runline = reader.readLine();
            if (runline.length() > 0) {
                circuit.run(runline);
            }
            else {
                tobeContinued = false;
            }
            System.out.println("Afsluiten kan door op enter te drukken zonder iets in te vullen.");
        }
    }

    public static List<String> readConfig() {
        Path pathToFile = Paths.get("src/main/resources/langcircuit.txt");

        List<String> circuitSpecifications;
        try {
            circuitSpecifications = Files.readAllLines(pathToFile);
        } catch (IOException e) {
            System.out.println("Error importing the Circuit Specification file.");
            throw new RuntimeException(e);
        }
        return circuitSpecifications;
    }
}
