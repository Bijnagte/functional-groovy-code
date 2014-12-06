import groovy.transform.Memoized

@Memoized
int memoizedMultiply(int a, int b) {
    println "$a * $b = ${a * b}" 
    a * b
}
