class Solution {
  public boolean isPalindrome(int x) {
      return checker(x);
  }

  private boolean checker(Integer x) {
      String strVersion = x.toString();
      boolean palindrome = true;
      int length = strVersion.length();
      for(int i=0; i<=(length/2); i++) {
          if (strVersion.charAt(i) == strVersion.charAt(length-(i+1))) {
              continue;
          } else {
              palindrome = false;
          }
      }
      return palindrome;
  }
}