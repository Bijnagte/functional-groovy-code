
def letters = ['d', 'b', 'a', 'c']
def sorted = letters.sort()

println letters
println sorted
assert sorted.is(letters)

//referentially transparent
def letters2 =  ['d', 'b', 'a', 'c']
def sorted2 = letters.sort(false)

println letters2
println sorted2
assert !sorted2.is(letters2)



class StateHidden {
	private int state
	
}


 