defmodule Solution do

  @moduledoc """
  Given an integer num, repeatedly add all its digits 
  until the result has only one digit, and return it.
  """

  @spec add_digits(num :: integer) :: integer
  def add_digits(num) do
    add_digits(num, length(Integer.digits(num)))
  end
    
  def add_digits(num, 1) do
    num
  end
    
  def add_digits(number, _) do
    sum = Enum.sum(Integer.digits(number))
    add_digits(sum, length(Integer.digits(sum)))
  end
end
