defmodule Solution do
  @spec is_happy(n :: integer) :: boolean
  def is_happy(number) do
    is_happy(number, 0)
  end

  def is_happy(number, count) do
    nums = Integer.digits(number)
    sum =
      for n <- nums do
        n * n 
      end
      |> Enum.sum
    
    checker(sum, count)
  end
    
  def checker(1, count) do
    true
  end
    
  def checker(n, 50) do
    false
  end
    
  def checker(n, count) do
    is_happy(n, count+1)
  end
end
