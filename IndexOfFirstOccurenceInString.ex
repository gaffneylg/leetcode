# Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
# or -1 if needle is not part of haystack.

# Example 1:
# Input: haystack = "sadbutsad", needle = "sad"
# Output: 0
# Explanation: "sad" occurs at index 0 and 6.
# The first occurrence is at index 0, so we return 0.

# Example 2:
# Input: haystack = "leetcode", needle = "leeto"
# Output: -1
# Explanation: "leeto" did not occur in "leetcode", so we return -1.


# Constraints:

# 1 <= haystack.length, needle.length <= 104
# haystack and needle consist of only lowercase English characters.


defmodule Solution do
  @unfound -1

  @spec str_str(haystack :: String.t, needle :: String.t) :: integer
  def str_str(haystack, needle) do
    case String.contains?(haystack, needle) do
      true ->
        IO.inspect("needle found in haystack.")
        case :string.find(haystack, needle) do
          found ->
            (String.length(haystack) - String.length(found))
          _ ->
            :ok
        end

      false ->
        IO.inspect("needle can't be found in haystack.")
        @unfound
    end
  end
end
