# Given a string s, check if it can be constructed by taking a
# substring of it and appending multiple copies of the substring together.

# Example 1:
# Input: s = "abab"
# Output: true
# Explanation: It is the substring "ab" twice.

# Example 2:
# Input: s = "aba"
# Output: false

# Example 3:
# Input: s = "abcabcabcabc"
# Output: true
# Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

defmodule Solution do
  @spec repeated_substring_pattern(string :: String.t) :: boolean
  def repeated_substring_pattern(string) do
    generate_substrings(String.length(string), string)
  end

  def generate_substrings(0, _), do: false
  def generate_substrings(1, _), do: false
  def generate_substrings(len, string) do
    res =
      for val <- viable_lens(len) do
        viable_substring(val, string, len)
      end
    :lists.member(true, res)
  end

  def viable_substring(val, string, len) do
    String.slice(string, 0, val)
    |> String.duplicate(Kernel.div(len, val))
    |> String.equivalent?(string)
  end

  def viable_lens(len) do
    for n <- 1..div(len, 2), rem(len, n) == 0, do: n
  end
end
