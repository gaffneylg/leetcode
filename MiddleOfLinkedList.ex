# Example 1
# Input: head = [1,2,3,4,5]
# Output: [3,4,5]
# Explanation: The middle node of the list is node 3.

# Example 2
# Input: head = [1,2,3,4,5,6]
# Output: [4,5,6]
# Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


# Definition for singly-linked list.

defmodule ListNode do
  @type t :: %__MODULE__{
          val: integer,
          next: ListNode.t() | nil
        }
  defstruct val: 0, next: nil
end

defmodule Solution do
  @spec middle_node(head :: ListNode.t | nil) :: ListNode.t | nil
  def middle_node(head) do
    simplified = simplifier(head, [])
    middle_index = div(length(simplified), 2)
    mid = Enum.at(simplified, middle_index)
    fetch_node(head, mid, middle_index, 0)
  end

  defp simplifier(nil, res), do: Enum.reverse(res)

  defp simplifier(full, res) when full != nil do
    res = [full.val | res]
    simplifier(full.next, res)
  end

  defp fetch_node(linked, mid, middle_index, index_count) when linked.val == mid do
    matching_index(middle_index, index_count, linked, mid)
  end
  defp fetch_node(linked, mid, middle_index, index_count) do
    fetch_node(linked.next, mid, middle_index, index_count + 1)
  end

  defp matching_index(middle, count, linked, _mid) when middle == count, do: linked
  defp matching_index(middle, count, linked, mid) do
    fetch_node(linked.next, mid, middle, count + 1)
  end
end
