defmodule Solution do
  @moduledoc """
  Module for the leetcode problem to determine whether a given
  string, converted to lowercase and stripped of it's non-alphanumeric
  characters is a valid palindrome.
  """

  @valid_chars ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"]

  @spec is_palindrome(s :: String.t) :: boolean
  def is_palindrome(string) do
    listed =
      string
      |> String.downcase()
      |> String.codepoints()

    :lists.foldl(fn (x, acc) ->
      case :lists.member(x, @valid_chars) do
        true -> [x | acc]
        false -> acc
      end
    end, [], listed)
    |> valid_palindrome()
  end

  @doc """
  Determines whether a string is a valid palindrome.
  """
  defp valid_palindrome(valid_chars) do
    string = List.to_string(valid_chars)
    string == String.reverse(string)
  end
end
