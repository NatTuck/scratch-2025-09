print("I am a lumberjack")

for i = 1, 5 do
	_, data = turtle.inspect()
	if data.name == "minecraft:oak_log" then
		print("I see a tree")
		turtle.dig()
		turtle.digUp()
		turtle.up()
	end
end
