import controllers.CircuitController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestInputConverter {

    @Test
    void TestInput() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("C = or(A, B);");
        lines.add("D = and(A, B)");
        CircuitController circuitController = new CircuitController(lines);

        assert circuitController.getGates().get("C").getInputs().size() == 2;
    }

    @Test
    void TestRun() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("c = or(A, B)");
        lines.add("d = and(A, B)");
        lines.add("e = not(A)");
        lines.add("f = not(B)");
        lines.add("g = or(e, f)");
        lines.add("h = and(e, f)");
        lines.add("I = and(c, g)");
        lines.add("J = or(d, h)");
        CircuitController circuitController = new CircuitController(lines);
        circuitController.run("01");

        assert circuitController.getResult().equals("10");
    }
}