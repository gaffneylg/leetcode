defmodule Solution do
  defstruct [five: 0, ten: 0, twenty: 0, in_business: true, transactions: 0]

  @spec lemonade_change(bills :: [integer]) :: boolean
  def lemonade_change(bills) do
    float = %Solution{}

    output =
      Enum.scan(bills, [float], fn (i, acc) ->
        [up] = acc
        IO.inspect acc

        float =
          if up.in_business do
            up
            |> bump_float(i)
            |> change_to_give(i)
          else
            up
          end
        [float]
    end)
    [result] = :lists.last(output)
    result.in_business
  end

  def change_to_give(%Solution{} = float, 20) when float.ten > 0 and float.five > 0 do
    %Solution{float | five: (float.five - 1), ten: (float.ten - 1), in_business: true}
  end

  def change_to_give(%Solution{} = float, 20) when float.ten == 0 and float.five > 2 do
    %Solution{float | five: (float.five - 3), in_business: true}
  end

  def change_to_give(%Solution{} = float, 10) when float.five > 0 do
    %Solution{float | five: (float.five - 1), in_business: true}
  end

  def change_to_give(%Solution{} = float, 5), do:
    %Solution{float | in_business: true}

  def change_to_give(%Solution{} = float, _), do:
    %Solution{float | in_business: false}

  def bump_float(%Solution{} = float, 5), do:
    %Solution{float | five: (float.five + 1), transactions: (float.transactions + 1)}
  def bump_float(%Solution{} = float, 10), do:
    %Solution{float | ten: (float.ten + 1), transactions: (float.transactions + 1)}
  def bump_float(%Solution{} = float, 20), do:
    %Solution{float | twenty: (float.twenty + 1), transactions: (float.transactions + 1)}

end
