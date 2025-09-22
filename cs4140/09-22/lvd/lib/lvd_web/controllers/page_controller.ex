defmodule LvdWeb.PageController do
  use LvdWeb, :controller

  def home(conn, _params) do
    render(conn, :home)
  end

  def form(conn, %{"comment" => comment}) do
    {:ok, comments} = Lvd.CommentServer.add(comment)
    render(conn, :form, comments: comments)
  end

  def form(conn, _params) do
    {:ok, comments} = Lvd.CommentServer.list()
    render(conn, :form, comments: comments)
  end

  def chan(conn, _params) do
    render(conn, :chan)
  end
end
