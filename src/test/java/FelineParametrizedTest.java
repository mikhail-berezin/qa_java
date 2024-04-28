import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int kittenInput;

    private final int kittenOutput;

    public FelineParametrizedTest(int kittenInput, int kittenOutput) {
        this.kittenInput = kittenInput;
        this.kittenOutput = kittenOutput;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][] {
                { 1, 1},
                { 2, 2},
                { 5, 5},
                { 7, 7}
        };
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(kittenInput);
        assertEquals(kittens, kittenOutput);
    }
}