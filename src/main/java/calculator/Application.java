package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int result=0;
        String customSeparator = "";
//        String userInput = "\n";
        String userInput = "";
        try{
            userInput = Console.readLine();
        } catch (Exception e){
            userInput = "";
        }
        // 커스텀 구분자 사용
        if (userInput.startsWith("//") && userInput.contains("\\n1")){
            int customIndex = userInput.indexOf("\\n1");
            customSeparator = userInput.substring(2, customIndex);
            userInput = userInput.substring(customIndex+2);
        }

        // 커스텀 구분자 사용 x
        ArrayList<Integer> resultNum = new ArrayList<Integer>();
        String[] numbers = userInput.split(",");

        if(!userInput.trim().isEmpty()) {
            for (String number : numbers) {
                if (number.length() == 1) {
                    resultNum.add(Integer.valueOf(number));
                } else {
                    String[] numSplitWithComma = number.split(":");
                    for (String s : numSplitWithComma) {
                        if (!customSeparator.isEmpty()) {
                            String[] splittingWithCustomSeparator = s.split(customSeparator);
                            for (String string : splittingWithCustomSeparator) {
                                System.out.println(string);
                                resultNum.add(Integer.valueOf(string));
                            }
                        } else {
                            resultNum.add(Integer.valueOf(s));
                        }
                    }
                }

            }
        }
//        System.out.println(resultNum);
        for (Integer num : resultNum) {
            if (num <0){
                throw new IllegalArgumentException();
            }
            result += num;
        }

        System.out.printf("결과 : "+result);
    }
}
