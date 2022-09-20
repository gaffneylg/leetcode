import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean isAnagram(String s, String t) {
        List<String> sBrokenUp = breakUpString(s);
        List<String> tBrokenUp = breakUpString(t);
        boolean valid = false;

        if (sBrokenUp.equals(tBrokenUp)) {
            valid = true;
        }
        return valid;
    }

    private List<String> breakUpString(String stringToSeparate) {
        List<String> brokenUp = new ArrayList<>();
        for (int i=0; i<stringToSeparate.length(); i++) {
            brokenUp.add(stringToSeparate.substring(i, i+1));
        }
        return brokenUp.stream().sorted().collect(Collectors.toList());
    }
}