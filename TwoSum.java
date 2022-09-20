import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] answer = new int[2];
    List<Integer> numArray = Arrays.stream(nums).boxed().collect(Collectors.toList());

    for (int i=0; i< (numArray.size()-1); i++) {
      answer[0] = i;

      if ((numArray.indexOf(target-numArray.get(i)) != -1) && (numArray.indexOf(target-numArray.get(i)) != i)) {
        answer[1] = numArray.indexOf(target-numArray.get(i));
        return answer;
      }
      else if ((target/2) == numArray.get(i) && (numArray.lastIndexOf(numArray.get(i)) > i)) {
        answer[1] = numArray.lastIndexOf(numArray.get(i));
        return answer;
      }
    }
    return answer;
  }
}