local aa = 5

local function foo(xx)
	aa = aa + 1
	xx = xx + 1
	print(aa + xx)
end

foo(aa) -- 12
foo(2) -- 10
foo(4) -- 13
