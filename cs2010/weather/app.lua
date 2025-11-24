local lapis = require("lapis")
local json = require("dkjson")

local app = lapis.Application()
app:enable("etlua")

app:get("/", function()
	return { render = "index" }
end)

app:post("/weather", function(self)
	local zip = self.POST["zip"]
	local noaa = "https://forecast.weather.gov/zipcity.php?inputstring=" .. zip
	return 'Your weather:<br><a href="' .. noaa .. '">Here</a>'
end)

return app
