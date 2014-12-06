import groovy.transform.Immutable

@Immutable(copyWith = true)
class ImmutableType {
	int integer
	String string
	List list
}
