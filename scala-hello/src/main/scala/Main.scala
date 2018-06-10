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

  class Greeter1(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  val greeter1 = new Greeter1("Hello ", " !")
  greeter1.greet("Saul")
  // println(greeter1.greet())

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

  // object
  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }

  val newId: Int = IdFactory.create()
  println(newId)
  val newerId: Int = IdFactory.create()
  println(newerId)

  // traits
  trait Greeter {
    // def greet(name: String): Unit
    def greeting(name: String): Unit = {
      println("Hello  " + name + "  !")
    }
  }
  // 默认继承
  class DefaultGreeter extends Greeter
  val greeter = new DefaultGreeter()
  greeter.greeting("Scala Developer")

  // 覆盖继承
  class CustomizableGreeter(prefix: String, profix: String) extends Greeter {
    override def greeting(name: String): Unit = {
      println(prefix + name + profix)
    }
  }

  val customGreeter = new CustomizableGreeter("你觉得 Scala 怎么样 ", " ?")
  customGreeter.greeting("Saul")

}



















