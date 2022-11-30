defmodule Solution do
  @spec sequential_digits(low :: integer, high :: integer) :: [integer]
  def sequential_digits(low, high) do

    low_string = Integer.to_string(low)    
    base = String.to_integer(String.first(low_string))
    sequential_digits(1, low, high, [], 0)
  end
    
  def sequential_digits(10, low, high, result, recent) do
    numbers = Enum.filter(result, fn(n) -> n > low and n < high end)
    result = result ++ numbers
    Enum.dedup(Enum.sort(result))
  end
    
  def sequential_digits(base, low, high, result, recent) do
    fetched = get_new_numbers(base, low, high)
    numbers = Enum.filter(fetched, & &1 != [])
    result = result ++ numbers
    sequential_digits(base+1, low, high, result, List.first(numbers))
  end
    

    
  def get_new_numbers(base, low, high) do
    max_length = String.length(Integer.to_string(high))
    min_length = String.length(Integer.to_string(low))

    all_lens = Enum.to_list(min_length..max_length)
    valid_numbers = []
    valid_numbers = 
      for n <- all_lens do
        new_num_list = Enum.to_list(base..9) |> Enum.take(n)
        new_number = String.to_integer(Enum.join(new_num_list))
        add_to_list(valid_numbers, new_number, low, high)
      end
    
    Enum.dedup(Enum.filter(valid_numbers, & &1 != []))
  end
    
  def add_to_list(result, new, low, high) when new >= low and new <= high do
    result ++ new 
  end
    
  def add_to_list(result, new, low, high), do: result
    
end
