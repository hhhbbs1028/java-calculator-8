package calculator;

import java.util.List;

public class Calculator {

    public static int calculate(String userInput) {
        // 파싱 (기존 알고리즘 유지)
        List<Integer> numbers = StringTokenizer.parse(userInput);

        // 음수 체크 + 합산 (기존 흐름 유지)
        int result = 0;
        for (Integer num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            result += num;
        }
        return result;
    }
}
