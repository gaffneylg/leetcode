import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    List<String> brokenUp = new ArrayList<>();

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        List<String> ordering = new ArrayList<>();
        ordering.add("a");
        ordering.add("b");
        ordering.add("c");
        ordering.add("d");
        ordering.add("e");
        ordering.add("f");
        ordering.add("g");
        ordering.add("h");
        ordering.add("i");
        ordering.add("j");
        ordering.add("k");
        ordering.add("l");
        ordering.add("m");
        ordering.add("n");
        ordering.add("o");
        ordering.add("p");
        ordering.add("q");
        ordering.add("r");
        ordering.add("s");
        ordering.add("t");
        ordering.add("u");
        ordering.add("v");
        ordering.add("w");
        ordering.add("x");
        ordering.add("y");
        ordering.add("z");


        for (int i = 0; i < palindrome.length(); i++) {
            brokenUp.add(palindrome.substring(i, i + 1));
        }
        boolean multiplePresent;
        int midpoint = (brokenUp.size() / 2);
        multiplePresent = multipleCharacters(brokenUp);
        if (!multiplePresent) {
            if (ordering.indexOf(brokenUp.get(0)) != 0) {
                brokenUp.set(0, "a");
            } else {
                brokenUp.set(brokenUp.size()-1, ordering.get(1));
            }
        } else {
            for (int j = 0; j <= (midpoint); j++) {
                if ((ordering.indexOf(brokenUp.get(j)) > ordering.indexOf(brokenUp.get(j + 1))) && j == midpoint) {
                    if ((brokenUp.size() % 2) == 1) {
                        int temp = findNext(midpoint+1);
                        replaceCharacter(temp);
                        break;
                    } else {
                        replaceCharacter(j);
                        break;
                    }
                } else if (ordering.indexOf(brokenUp.get(j)) >= ordering.indexOf(brokenUp.get(j + 1)) && ordering.indexOf(brokenUp.get(j)) > 0) {
                    replaceCharacter(j);
                    break;
                } else if ((ordering.indexOf(brokenUp.get(j)) < ordering.indexOf(brokenUp.get(j + 1))) && ordering.indexOf(brokenUp.get(j)) > 0) {
                    replaceCharacter(j);
//                    brokenUp.set(j, ordering.get(ordering.indexOf(brokenUp.get(j)) - 1));
                    break;
                } else if (j == midpoint) {
                    replaceCharacter(midpoint + 1);
                    break;
                }
            }
        }
        return String.join("", brokenUp);
    }

    private void replaceCharacter(Integer value) {
        brokenUp.set(value, "a");
        if (checker(brokenUp)) {
            brokenUp.set(value, "b");
        } else {
            brokenUp.set(value, "a");
        }
    }

    private boolean multipleCharacters(List<String> brokenUp) {
        Set<String> set = new HashSet<>(brokenUp);
        if (set.size() == 1) {
            return false;
        } else {
            return true;
        }
    }

    private Integer findNext(Integer currentIndex) {
        int temp = currentIndex;
        for (int i = currentIndex; i<=(brokenUp.size()-1); i++) {
            if (brokenUp.get(i).equals("a")) {
                temp = i;
            }
            else if (brokenUp.get(i).equals("a") && i == (brokenUp.size()-1)) {
                temp = (brokenUp.size() - 1);
            } else {
                temp = i;
            }
        }
        return temp;
    }

    private boolean checker(List<String> string) {
        String.join("", string);
        boolean palindrome = true;
        int length = string.size();
        for (int i = 0; i <= (length / 2); i++) {
            if (string.get(i).equals(string.get(length - (i + 1)))) {
                continue;
            } else {
                palindrome = false;
            }
        }
        return palindrome;
    }
}