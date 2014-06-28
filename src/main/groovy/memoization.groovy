counter = 0

fn = { arg -> counter ++ }
(1..10).each { fn(2) }
 
counter
 
counter = 0
 
memoizedFn = fn.memoize()
(1..10).each { memoizedFn(2) }
 
counter