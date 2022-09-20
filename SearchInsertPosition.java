class Solution {
  public int searchInsert(int[] nums, int target) {
      if (present(target, nums)) {
          return indexOf(target, nums);
      } else {
          return insertionIndex(nums, target);
      }
  }

  // method to determine the whether the target if present in the array.
  private boolean present(int target, int[] nums) {
      boolean present = false;
      for (int i = 0; i <= (nums.length - 1); i++) {
          if (target == nums[i]) {
              present = true;
          }
      }
      return present;
  }

  // method to determine the index of the target.
  private int indexOf(int target, int[] nums) {
      int index = -1;
      for (int i = 0; i <= (nums.length - 1); i++) {
          if (target == nums[i]) {
              index = i;
          }
      }
      return index;
  }

  // method to find the location of the array which the target would be inserted
  private int insertionIndex(int[] nums, int target) {
      int insertion = 0;
      if (target > (nums[nums.length-1])) {
          insertion = nums.length;
      } else if (target < (nums[0])) {
          insertion = 0;
      } else {
          for (int i=0; i<=(nums.length-1); i++) {
              if (target < nums[i]) {
                  insertion = i;
                  break;
              }                
          }
      }
      return insertion;
  }
}