defmodule LvdWeb.CommentChannel do
  use LvdWeb, :channel

  @impl true
  def join("comments:" <> _name, payload, socket) do
    if authorized?(payload) do
      {:ok, comments} = Lvd.CommentServer.list()
      {:ok, comments, socket}
    else
      {:error, %{reason: "unauthorized"}}
    end
  end

  # Channels can be used in a request/response fashion
  # by sending replies to requests from the client
  @impl true
  def handle_in("comment", %{"text" => text}, socket) do
    {:ok, comments} = Lvd.CommentServer.add(text)

    {:reply, {:ok, comments}, socket}
  end

  # It is also common to receive messages from the client and
  # broadcast to everyone in the current topic (comment:lobby).
  @impl true
  def handle_in("shout", payload, socket) do
    broadcast(socket, "shout", payload)
    {:noreply, socket}
  end

  # Add authorization logic here as required.
  defp authorized?(_payload) do
    true
  end
end
