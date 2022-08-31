import controllers.CircuitController;
import org.junit.jupiter.api.Test;

public class TestInputConverter {

    @Test
    void TestInput() {
        String lines = "c = or(A, B); d = and(A, B)";
        CircuitController circuitController = new CircuitController(lines);

        assert circuitController.getGates().get("c").getInputs().size() == 2;
    }
}
