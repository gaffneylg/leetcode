defmodule Solution do
  @moduledoc """
  Module for the leetcode problem to determine whether a given
  string, converted to lowercase and stripped of it's non-alphanumeric
  characters is a valid palindrome.
  """

  @spec is_palindrome(s :: String.t) :: boolean
  def is_palindrome(s) do
    lower = String.downcase(s)
    len = String.length(lower)

    broken =
      Enum.scan(1..len, [], fn (x, acc) ->
        sub = String.slice(lower, x-1, 1)
        case alpha_char(sub) do
          true ->
            IO.inspect sub
            [sub | acc]
          false -> acc
        end
      end)
    :lists.last(broken)
    |> valid_palindrome()
  end

  @doc """
  Determines whether a character is a valid alphanumeric or not.
  """
  defp alpha_char(val) do
    letters = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"]
    :lists.member(val, letters)
  end

  @doc """
  Determines whether a string is a valid palindrome.
  """
  defp valid_palindrome(valid_chars) do
    string = List.to_string(valid_chars)
    string == String.reverse(string)
  end
end
