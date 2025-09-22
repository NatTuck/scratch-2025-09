defmodule LvdWeb.CommentsLive do
  use Phoenix.LiveView
  use LvdWeb, :live_view

  @impl true
  def mount(_params, _session, socket) do
    socket =
      socket
      |> assign(:form, to_form(%{"comment" => ""}))
      |> assign(:comments, [])

    {:ok, socket}
  end

  @impl true
  def handle_event("update", data, socket) do
    {:noreply, assign(socket, form: to_form(data))}
  end

  def handle_event("save", %{"comment" => text}, socket) do
    comments = socket.assigns[:comments]

    socket =
      socket
      |> assign(:form, to_form(%{"comment" => ""}))
      |> assign(:comments, [text | comments])

    {:noreply, socket}
  end
end
