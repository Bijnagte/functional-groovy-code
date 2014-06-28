sizeOfList = { list, counter = 0 ->
	if (list.size() == 0) {
		counter
	} else {
		sizeOfList(list.tail(), counter + 1)
	}
}
