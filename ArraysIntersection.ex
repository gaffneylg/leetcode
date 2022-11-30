defmodule Solution do

  @spec intersection(nums1 :: [integer], nums2 :: [integer]) :: [integer]
  def intersection(nums1, nums2) do
    nums1_uniq = Enum.uniq(nums1)
    nums2_uniq = Enum.uniq(nums2)

    Enum.filter(nums1_uniq, fn(x) -> Enum.member?(nums2_uniq, x) end)
  end
end
