import java.util.ArrayList;
import java.util.List;

class Solution {

    final List<String> two = new ArrayList<>();
    final List<String> three = new ArrayList<>();
    final List<String> four = new ArrayList<>();
    final List<String> five = new ArrayList<>();
    final List<String> six = new ArrayList<>();
    final List<String> seven = new ArrayList<>();
    final List<String> eight = new ArrayList<>();
    final List<String> nine = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        setLettersToNumbers();
        List<String> result = new ArrayList<>();
        List<String> numbers = breakUpString(digits);

        switch (digits.length()) {
            case 1:
                return fetchNumber(digits);
            case 2:
                return combineTwoNumbers(result, numbers.get(0), numbers.get(1));
            case 3:
                return combineThreeNumbers(result, numbers.get(0), numbers.get(1), numbers.get(2));
            case 4:
                return combineFourNumbers(result, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3));
        }
        return result;
    }


    private List<String> combineTwoNumbers(List<String> result, String num1, String num2) {
        List<String> num1Letters = fetchNumber(num1);
        List<String> num2Letters = fetchNumber(num2);
        
        for (int i=0; i<num1Letters.size(); i++) {
            for (int j=0; j<num2Letters.size(); j++) {
                String combo = num1Letters.get(i) + num2Letters.get(j);
                result.add(combo);
            }
        }
        return result;
    }


    private List<String> combineThreeNumbers(List<String> result, String num1, String num2, String num3) {
        List<String> num1Letters = fetchNumber(num1);
        List<String> num2Letters = fetchNumber(num2);
        List<String> num3Letters = fetchNumber(num3);

        for (int i=0; i<num1Letters.size(); i++) {
            for (int j=0; j<num2Letters.size(); j++) {
                for (int k=0; k<num3Letters.size(); k++) {
                    String combo = num1Letters.get(i) + num2Letters.get(j) + num3Letters.get(k);
                    result.add(combo);
                }
            }
        }
        return result;
    }

    private List<String> combineFourNumbers(List<String> result, String num1, String num2, String num3, String num4) {
        List<String> num1Letters = fetchNumber(num1);
        List<String> num2Letters = fetchNumber(num2);
        List<String> num3Letters = fetchNumber(num3);
        List<String> num4Letters = fetchNumber(num4);

        for (int i=0; i<num1Letters.size(); i++) {
            for (int j=0; j<num2Letters.size(); j++) {
                for (int k=0; k<num3Letters.size(); k++) {
                    for (int l=0; l<num4Letters.size(); l++) {
                        String combo = num1Letters.get(i) + num2Letters.get(j) + num3Letters.get(k) + num4Letters.get(l);
                        result.add(combo);
                    }
                }
            }
        }
        return result;
    }


    private List<String> fetchNumber(String number) {
        switch (number) {
            case "2":
                return two;
            case "3":
                return three;
            case "4":
                return four;
            case "5":
                return five;
            case "6":
                return six;
            case "7":
                return seven;
            case "8":
                return eight;
            case "9":
                return nine;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
    }

    private List<String> breakUpString(String stringToSeparate) {
        List<String> brokenUp = new ArrayList<>();
        for (int i=0; i<stringToSeparate.length(); i++) {
            brokenUp.add(stringToSeparate.substring(i, i+1));
        }
        return new ArrayList<>(brokenUp);
    }
    
    private void setLettersToNumbers() {
        two.add("a");
        two.add("b");
        two.add("c");
        three.add("d");
        three.add("e");
        three.add("f");
        four.add("g");
        four.add("h");
        four.add("i");
        five.add("j");
        five.add("k");
        five.add("l");
        six.add("m");
        six.add("n");
        six.add("o");
        seven.add("p");
        seven.add("q");
        seven.add("r");
        seven.add("s");
        eight.add("t");
        eight.add("u");
        eight.add("v");
        nine.add("w");
        nine.add("x");
        nine.add("y");
        nine.add("z");
    }
}