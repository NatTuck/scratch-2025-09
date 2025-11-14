local aa = 5

local function foo(xx)
	local aa = 7
	print(xx + aa)
end

foo(2)
foo(4)
foo(aa)
