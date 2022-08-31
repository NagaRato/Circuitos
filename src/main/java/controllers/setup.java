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

        CircuitController circuit = new CircuitController(reader.readLine());
    }
}
