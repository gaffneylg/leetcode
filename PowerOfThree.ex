# Given an integer n, return true if it is a power of three. Otherwise, return false.
# An integer n is a power of three, if there exists an integer x such that n == 3x.

# Example 1:
# Input: n = 27
# Output: true
# Explanation: 27 = 33

# Example 2:
# Input: n = 0
# Output: false
# Explanation: There is no x where 3x = 0.

# Example 3:
# Input: n = -1
# Output: false
# Explanation: There is no x where 3x = (-1).


defmodule Solution do
  @spec is_power_of_three(num :: integer) :: boolean
  def is_power_of_three(num) do
    divisible_by_three(num)
  end

  def divisible_by_three(num) when num > 3 do
    case rem(num, 3) do
      0 ->
        divisible_by_three(div(num, 3))
      _ ->
        false
    end
  end

  def divisible_by_three(num) when (num < 1) do false end
  def divisible_by_three(3), do: true
  def divisible_by_three(2), do: false
  def divisible_by_three(1), do: true

end
