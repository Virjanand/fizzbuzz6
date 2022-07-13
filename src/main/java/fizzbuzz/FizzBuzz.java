package fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(this::toFizzBuzz).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number) {
        String result = applyFizzRule(number);
        result += applyBuzzRule(number, result);
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }

    private String applyBuzzRule(int number, String result) {
        if (number % 5 == 0) {
            return "Buzz";
        }
        return "";
    }

    private String applyFizzRule(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return "";
    }
}
