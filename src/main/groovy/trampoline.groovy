sizeOfList = { list, counter = 0 ->
	if (list.size() == 0) {
		counter
	} else {
		sizeOfList.trampoline(list.tail(), counter + 1)
	}
}.trampoline()

sizeOfList(1..10000)