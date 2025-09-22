defmodule LvdWeb.PageController do
  use LvdWeb, :controller

  def home(conn, _params) do
    render(conn, :home)
  end

  def form(conn, %{"comment" => comment}) do
    comments = [comment]
    render(conn, :form, comments: comments)
  end

  def form(conn, _params) do
    comments = []
    render(conn, :form, comments: comments)
  end

  def chan(conn, _params) do
    render(conn, :chan)
  end
end
