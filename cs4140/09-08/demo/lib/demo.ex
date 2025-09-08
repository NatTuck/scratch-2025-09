defmodule Demo do
  @moduledoc """
  Documentation for `Demo`.
  """

  @doc """
  Hello world.

  ## Examples

      iex> Demo.hello()
      :world

  """
  def hello do
    :world
  end

  def fib(0), do: 0
  def fib(1), do: 1

  def fib(x) do
    fib(x - 1) + fib(x - 2)
  end

  def sum([]), do: 0

  def sum([x | xs]) do
    x + sum(xs)
  end

  def add3(x) do
    x = x + 1
    x = x + 1
    x = x + 1
    x
  end
end
