import groovy.transform.Immutable

@Immutable
class Point {
	int x
	int y
	Point plus(Point other) {
		new Point(this.x + other.x, this.y + other.y)
	}
}
