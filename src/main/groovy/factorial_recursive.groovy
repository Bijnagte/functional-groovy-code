factorial = { int n, BigInteger accumulator = 1 ->
	if (n > 1) {
		factorial(n - 1, n * accumulator)
	} else {
		accumulator
	}
}

factorial(10000)