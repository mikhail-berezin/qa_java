import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static constants.FelineTestConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittenInput;

    private final int kittenOutput;

    public FelineTest(int kittenInput, int kittenOutput) {
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
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> meat = feline.eatMeat();
        assertEquals(meat, CORRECT_MEAT);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals(family, CORRECT_FAMILY);
    }

    @Test
    public void testGetKittensWithoutArgs() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(kittens, CORRECT_KITTENS);
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(kittenInput);
        assertEquals(kittens, kittenOutput);
    }
}