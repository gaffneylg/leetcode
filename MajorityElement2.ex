# Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.


defmodule Solution do
  @spec majority_element(nums :: [integer]) :: [integer]
  def majority_element(nums) do
    threshold = Integer.floor_div(length(nums), 3)
    Enum.frequencies(nums)
    |> Map.filter(fn{key, val} -> val > threshold end)
    |> Map.keys()
  end
end
