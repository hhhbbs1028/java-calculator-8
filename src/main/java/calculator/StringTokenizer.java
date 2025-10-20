package calculator;

import java.util.ArrayList;
import java.util.List;

class StringTokenizer {

    static List<Integer> parse(String userInput) {
        String input = (userInput == null) ? "" : userInput;

        String customSeparator = "";

        // 커스텀 구분자
        if (input.startsWith("//") && input.contains("\\n1")) {
            int customIndex = input.indexOf("\\n1");
            customSeparator = input.substring(2, customIndex);
            input = input.substring(customIndex + 2);
        }

        ArrayList<Integer> resultNum = new ArrayList<>();

        // 커스텀 구분자 사용 x
        String[] numbers = input.split(",");

        if (!input.trim().isEmpty()) {
            for (String number : numbers) {
                if (number.length() == 1) {
                    resultNum.add(Integer.valueOf(number));
                } else {
                    String[] numSplitWithColon = number.split(":");
                    for (String s : numSplitWithColon) {
                        if (!customSeparator.isEmpty()) {
                            String[] splittingWithCustomSeparator = s.split(customSeparator);
                            for (String string : splittingWithCustomSeparator) {
                                if (!string.isEmpty()) {
                                    resultNum.add(Integer.valueOf(string));
                                }
                            }
                        } else {
                            if (!s.isEmpty()) {
                                resultNum.add(Integer.valueOf(s));
                            }
                        }
                    }
                }
            }
        }

        return resultNum;
    }

    private StringTokenizer() {}
}
