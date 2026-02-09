# Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

# You must implement a solution with a linear runtime complexity and use only constant extra space.

# Example 1:
# Input: nums = [2,2,3,2]
# Output: 3

# Example 2:
# Input: nums = [0,1,0,1,0,1,99]
# Output: 99

defmodule Solution do
  @spec single_number(nums :: [integer]) :: integer
  def single_number(nums) do
    [key] =
      nums
      |> Enum.frequencies()
      |> Map.filter(fn{_key, val} -> val == 1 end)
      |> Map.keys
    key
  end
end
