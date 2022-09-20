import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    List<String> stringList = Arrays.stream(strs).collect(Collectors.toList());
    int shortestSize = 200;
    String shortestString = "";
    String commonPrefix = "";
    if (stringList.stream().distinct().count() == 1) {
      return strs[0];
    }

    for (String s : stringList) {
      if (s.length() < shortestSize) {
        shortestSize = s.length();
        shortestString = s;
      }
    }
    for (int j = 1; j <= shortestSize; j++) {
      for (String word : stringList) {
        if (!word.substring(0, j).equals(shortestString.substring(0, j))) {
          return commonPrefix;
        }
      }
      commonPrefix = shortestString.substring(0,j);
    }
    return commonPrefix;
  }
}