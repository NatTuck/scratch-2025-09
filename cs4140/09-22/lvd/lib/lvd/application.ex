defmodule Lvd.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  @impl true
  def start(_type, _args) do
    children = [
      LvdWeb.Telemetry,
      Lvd.Repo,
      {Ecto.Migrator, repos: Application.fetch_env!(:lvd, :ecto_repos), skip: skip_migrations?()},
      {DNSCluster, query: Application.get_env(:lvd, :dns_cluster_query) || :ignore},
      {Phoenix.PubSub, name: Lvd.PubSub},
      # Start a worker by calling: Lvd.Worker.start_link(arg)
      # {Lvd.Worker, arg},
      Lvd.CommentServer,
      # Start to serve requests, typically the last entry
      LvdWeb.Endpoint
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: Lvd.Supervisor]
    Supervisor.start_link(children, opts)
  end

  # Tell Phoenix to update the endpoint configuration
  # whenever the application is updated.
  @impl true
  def config_change(changed, _new, removed) do
    LvdWeb.Endpoint.config_change(changed, removed)
    :ok
  end

  defp skip_migrations?() do
    # By default, sqlite migrations are run when using a release
    System.get_env("RELEASE_NAME") == nil
  end
end
