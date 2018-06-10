object Main extends App {
  println("你好")
  println(23 % 3)
  println("Hello" + " World")
  val name = "zhuliminl"
  val x : Int = 1 + 2
  println(x)
  println({
    val x = 9
    x + 1
    "xxx"
  })
  println(name)

  //
  val addOne = (x: Int) => x + 1
  println(addOne(3))

  //
  val add = (x: Int, y: Int) => x + y
  println(add(2, 4))

  var getTheAnswer = () => 23334333
  println(getTheAnswer())

  // method
  def sum(x: Int, y: Int): Int = x + y
  println(sum(4, 5))

  // multiply params
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(2, 6)(2))   // 16

  def getName: String = System.getProperty("user.email")
  println("hello" + getName)

  //
  def getSquarrString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquarrString(22))

  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  val greeter = new Greeter("Hello ", " !")
  greeter.greet("Saul")
  // println(greeter.greet())

  // case class
  case class Point(x: Int, y: Int)

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(99, 99)

  // 按值比较
  if(point == anotherPoint) {
    println(point + " and " + anotherPoint + "are the same")
  } else {
    println(point + " and " + anotherPoint + "are different")
  }

  if(point == yetAnotherPoint) {
    println(point + " and " + yetAnotherPoint + "are the same")
  } else {
    println(point + " and " + yetAnotherPoint + "are different")
  }
}



















