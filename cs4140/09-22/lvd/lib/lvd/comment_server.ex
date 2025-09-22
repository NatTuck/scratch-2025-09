defmodule Lvd.CommentServer do
  use GenServer

  def start_link(_) do
    GenServer.start_link(__MODULE__, [], name: __MODULE__)
  end

  def list() do
    GenServer.call(__MODULE__, :list)
  end

  def add(item) do
    GenServer.call(__MODULE__, {:add, item})
  end

  @impl true
  def init(xs) do
    {:ok, xs}
  end

  @impl true
  def handle_call(:list, _from, state) do
    {:reply, {:ok, state}, state}
  end

  def handle_call({:add, item}, _from, state) do
    state = [item | state]
    {:reply, {:ok, state}, state}
  end
end
