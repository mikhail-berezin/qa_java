import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

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
    public static Object[][] getAccordionData() {
        return new Object[][] {
                { 1, 1},
                { 2, 2},
                { 5, 5},
                { 7, 7},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> meat = feline.eatMeat();
        assertEquals(meat, List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals(family, "Кошачьи");
    }

    @Test
    public void testGetKittensWithoutArgs() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(kittens, 1);
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(kittenInput);
        assertEquals(kittens, kittenOutput);
    }
}
