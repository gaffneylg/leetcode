# Given two binary strings a and b, return their sum as a binary string.

# Example 1:
# Input: a = "11", b = "1"
# Output: "100"

# Example 2:
# Input: a = "1010", b = "1011"
# Output: "10101"

defmodule Solution do
  @spec add_binary(a :: String.t, b :: String.t) :: String.t
  def add_binary(a, b) do
    int_a = String.to_integer(a, 2)
    int_b = String.to_integer(b, 2)
    sum = int_a + int_b
    Integer.to_string(sum, 2)
  end
end
