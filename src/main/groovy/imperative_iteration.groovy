int addIntegers(int... integers) {
	int result = 0

	for (int i = 0; i < integers.size(); i++) {
		result += integers[i]
	}
	result
}

addIntegers(1, 2, 3) == [1, 2, 3].sum()

List filterEvenNumbers(List integers) {
	List filtered = []
	for (item in integers) {
		if (item % 2 == 0) {
			filtered.add(item)
		}
	}
	filtered
}