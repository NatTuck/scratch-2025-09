defmodule Lvd.Repo do
  use Ecto.Repo,
    otp_app: :lvd,
    adapter: Ecto.Adapters.SQLite3
end
