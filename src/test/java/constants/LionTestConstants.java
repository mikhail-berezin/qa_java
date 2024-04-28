package constants;

import java.util.List;

public class LionTestConstants {

    public final static int FELINE_MOCK_KITTENS_RESULT = 1;
    public final static int CORRECT_KITTENS = 1;

    public final static String FELINE_MOCK_GET_FOOD_ARGUMENT = "Хищник";
    public final static List<String> FELINE_MOCK_GET_FOOD_RESULT = List.of("Животные", "Птицы", "Рыба");

    public final static List<String> CORRECT_FOOD = List.of("Животные", "Птицы", "Рыба");

    public final static List<String> CORRECT_SEX = List.of("Самец", "Самка");

    public final static String SEX_EXCEPTION_CORRECT_MESSAGE =
            "Используйте допустимые значения пола животного - самец или самка";
}
