greet = { greeting, recipient ->  "$greeting $recipient" }
greet('hello', 'world')

thing = [func: {-> 'called' } ]
thing.func()

capitalize = { string -> string.toUpperCase() }
callWithString = { string, function -> function(string) }
callWithString('hello', capitalize)

callWithString('hello') { it.reverse() }

