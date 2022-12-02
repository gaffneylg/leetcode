defmodule Solution do
  @spec find_median_sorted_arrays(nums1 :: [integer], nums2 :: [integer]) :: float
  def find_median_sorted_arrays(nums1, nums2) do

    sorted = Enum.sort(:lists.append(nums1, nums2))
    len = length(sorted)
    midway = div(len, 2)
    case rem(len, 2) do
      0 ->
        first = :lists.nth(midway, sorted)
        second = :lists.nth(midway+1, sorted)
        (first + second) / 2
      1 ->
        {:ok, median} = Enum.fetch(sorted, midway)
        {med_float, _} = Float.parse(Integer.to_string(median))
        med_float
    end
  end
end
