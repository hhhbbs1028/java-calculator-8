package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String userInput = "";
        try {
            userInput = Console.readLine();
        } catch (Exception ignored) {
        }

        int result = Calculator.calculate(userInput);
        System.out.printf("결과 : " + result);
    }
}
