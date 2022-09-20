import java.util.ArrayList;
import java.util.List;

class Solution {
    protected List<String> initialValues = new ArrayList<>();

    public int titleToNumber(String columnTitle) {
        populateArrays();
        int titleSize = columnTitle.length();
        int columnNumber = 0;
        List<String> brokenUp = new ArrayList<>();
        for (int i=titleSize; i>0; i--) {
            brokenUp.add(columnTitle.substring(i-1, i));
        }
        if (brokenUp.size() == 1) {
            return initialValues.indexOf(columnTitle);
        }
        for (int j = 0; j<brokenUp.size(); j++) {
            int letterValue = initialValues.indexOf(brokenUp.get(j));
            if (j == 0) {
                columnNumber = columnNumber + letterValue;
            } else if (j > 1) {
                columnNumber = columnNumber + (26 * letterValue * (int) (Math.pow(26, j-1)));
            } else {
                columnNumber = columnNumber + (26 * letterValue);
            }
        }
        return columnNumber;
    }

    private void populateArrays() {
        initialValues.add("0");
        initialValues.add("A");
        initialValues.add("B");
        initialValues.add("C");
        initialValues.add("D");
        initialValues.add("E");
        initialValues.add("F");
        initialValues.add("G");
        initialValues.add("H");
        initialValues.add("I");
        initialValues.add("J");
        initialValues.add("K");
        initialValues.add("L");
        initialValues.add("M");
        initialValues.add("N");
        initialValues.add("O");
        initialValues.add("P");
        initialValues.add("Q");
        initialValues.add("R");
        initialValues.add("S");
        initialValues.add("T");
        initialValues.add("U");
        initialValues.add("V");
        initialValues.add("W");
        initialValues.add("X");
        initialValues.add("Y");
        initialValues.add("Z");
    }
}