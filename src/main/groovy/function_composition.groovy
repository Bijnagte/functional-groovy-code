import org.codehaus.groovy.runtime.DefaultGroovyMethods

input = ['hello', 'there', 'people']

people = ['Jane', 'Dave', 'Wendy']

//closures as referentially transparent functions
nth = { sequence, index -> sequence[index] }
assert nth(input, 2) == 'people'

reverse = { it.reverse() }
assert reverse(input) == ['people', 'there', 'hello']
assert input.collect(reverse) == ['olleh', 'ereht', 'elpoep']

capitalize = { it.toUpperCase() }
assert input.collect(capitalize) == ['HELLO', 'THERE', 'PEOPLE']

//convert method to closure
find = DefaultGroovyMethods.&find //
assert find(input) { it.endsWith('o') } == 'hello'

startsWith = { value, sequence -> sequence[0] == value }
assert find(input) { startsWith 'p', it } == 'people'


//currying (partial application)
nthPerson = nth.curry(people)
assert nthPerson(2) == 'Wendy'

second = nth.rcurry(1)
assert second(people) == 'Dave'

nthInput = nth.curry(input)
assert nthInput(2) == 'people'

third = nth.rcurry(2)
assert third(input) == 'people'

startsWithP = startsWith.curry('p')
assert find (input, startsWithP) == 'people'

findStartsWithP = find.rcurry(startsWithP)
assert findStartsWithP(input) == 'people'


//closure composition
thirdReverse = third >> reverse
assert thirdReverse(input) == 'elpoep'

reverseThird = third << reverse
assert reverseThird(input) == 'hello'

//compose closures into a pipeline
process = third >> reverse >> capitalize
assert process(input) == 'ELPOEP'