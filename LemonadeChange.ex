defmodule Solution do
  defstruct [five: 0, ten: 0, in_business: true]

  @spec lemonade_change(bills :: [integer]) :: boolean
  def lemonade_change(bills) do

    [result] =
      Enum.scan(bills, [%Solution{}], fn (i, [acc]) ->
        float =
          case acc.in_business do
            false -> acc
            true ->
              acc
              |> bump_float(i)
              |> change_to_give(i)
          end
        [float]
      end)
      |> :lists.last()
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

  def change_to_give(%Solution{} = float, 5), do: %Solution{float | in_business: true}
  def change_to_give(%Solution{} = float, _), do: %Solution{float | in_business: false}

  def bump_float(%Solution{} = float, 5), do: %Solution{float | five: (float.five + 1)}
  def bump_float(%Solution{} = float, 10), do: %Solution{float | ten: (float.ten + 1)}
  def bump_float(%Solution{} = float, 20), do: float

end
