add = { a, b ->
    println "$a * $b = ${a * b}" 
    a * b
}

memoizedAdd = add.memoize()
