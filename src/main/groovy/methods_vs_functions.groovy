static Point plus(Point that, Point other) {
    new Point(that.x + other.x, that.y + other.y)
}

a = new Point(1, 2)
b = new Point(3, 4)

plus(a, b) == a.plus(b)