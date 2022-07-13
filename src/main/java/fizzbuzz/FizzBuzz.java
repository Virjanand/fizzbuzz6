package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(number -> toFizzBuzz(number, number1 -> {
            if (number1 % 3 == 0) {
                return "Fizz";
            }
            return "";
        }, number1 -> {
            if (number1 % 5 == 0) {
                return "Buzz";
            }
            return "";
        })).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number, Function<Integer, String> fizzRule, Function<Integer, String> buzzRule) {
        String result = fizzRule.apply(number);
        result += buzzRule.apply(number);
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }
}
