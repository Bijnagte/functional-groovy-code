import groovy.transform.ToString

random = new Random()

@ToString()
class MutableType {
	String state
}

class MutableService {
	def state
	
	def post(data) {
		state = data
		/{"result": "success"}/
	}
	
	def get() {
		/{"state":"$state"}/ 
	}
}

data = new MutableType(state: 'initial')

service = new MutableService(state: 'started')

service.post(data)

String result = service.get()

data.state = 'changed'

String result2 = service.get()

println result
println result2

println result2 != result


client1 = alteringClient(service)
client2 = alteringClient(service)

def getResults = { qty ->
	 (0..qty).collect {
		 long waitTime = random.nextInt(10)
		 Thread.sleep(waitTime)
		 service.get()
	 }
 }

def readClientResults1 = getResults(30)

def readClientResults2 = getResults(30)

assert readClientResults1 != readClientResults2
println readClientResults1
println readClientResults2

client1.interrupt()
client2.interrupt()

Thread alteringClient(MutableService service) {

	Thread.start {
		def name = Thread.currentThread().name
		try {
			while(true) {
				long waitTime = random.nextInt(10)
				Thread.sleep(waitTime)
				service.post("{$name: $waitTime}")
			}
		} catch (any) {
			println "$name stopped with $any.message"
		}
	}
}


//2 mutable objects
obj1 = [test: 1]
obj2 = [test: 2]
assert obj2.hashCode() != obj1.hashCode()
assert obj1 != obj2

//used as keys in a map
map = [(obj1): 'first', (obj2): 'second']
assert map.size() == 2
assert map[obj2] == 'second'

//mutate one object so that it matches the other
obj2['test'] = 1
assert obj2.hashCode() == obj1.hashCode()
assert obj1 == obj2

//the map still has 2 entries
assert map.size() == 2
assert map[obj2] == 'first'
assert map[obj1] == 'first'

//what about the key to second?
entry = map.find { it.value == 'second' }
assert entry.key.is(obj2)
