class Solution {
  public int[] searchRange(int[] nums, int target) {
      List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
      int start = -1;
      int end = -1;
      int[] locations = new int[2];
      start = intList.indexOf(target);
      end = intList.lastIndexOf(target);
      locations[0] = start;
      locations[1] = end;
      return locations;
  }
}