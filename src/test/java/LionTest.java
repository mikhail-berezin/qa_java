import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static constants.LionTestConstants.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                { "Самец", true},
                { "Самка", false},
                { "Заведомо плохие данные", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = generateLion(sex, feline);
        if (lion == null) return;

        Mockito.when(feline.getKittens()).thenReturn(FELINE_MOCK_KITTENS_RESULT);
        int kittens = lion.getKittens();
        assertEquals(kittens, CORRECT_KITTENS);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = generateLion(sex, feline);
        if (lion == null) return;

        boolean doesHaveMane = lion.doesHaveMane();
        assertEquals(doesHaveMane, hasMane);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = generateLion(sex, feline);
        if (lion == null) return;

        Mockito.when(feline.getFood(FELINE_MOCK_GET_FOOD_ARGUMENT)).thenReturn(FELINE_MOCK_GET_FOOD_RESULT);
        List<String> food = lion.getFood();
        assertEquals(food, CORRECT_FOOD);
    }

    private Lion generateLion(String sex, Feline feline) throws Exception {
        if (CORRECT_SEX.contains(sex)) {
            return new Lion(sex, feline);
        } else {
            try {
                new Lion(sex, feline);
                fail(); // if we get here, class Lion works incorrect
            } catch (Exception e) {
                String message = e.getMessage();
                assertEquals(message, SEX_EXCEPTION_CORRECT_MESSAGE);
            }
        }
        return null;
    }
}