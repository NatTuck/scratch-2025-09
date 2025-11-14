local function make_counter()
	local count = 0

	local function inc()
		count = count + 1
		return count
	end

	return inc
end

local aa = make_counter()
--           seq A       seq B
print(aa()) -- 1           1
print(aa()) -- 2           2
local bb = make_counter()
print(bb()) -- 1           3
print(aa()) -- 3           3
print(bb()) -- 2           4
