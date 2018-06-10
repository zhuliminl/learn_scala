object Main extends App {
  println("你好")
  println(23 % 3)
  println("Hello" + " World")
  val name = "zhuliminl"
  val x1 : Int = 1 + 2
  println(x1)
  println({
    val x1 = 9
    x1 + 1
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
  // case class Point(x: Int, y: Int)

  // val point = Point(1, 2)
  // val anotherPoint = Point(1, 2)
  // val yetAnotherPoint = Point(99, 99)

  // 按值比较
  // if(point == anotherPoint) {
    // println(point + " and " + anotherPoint + "are the same")
  // } else {
    // println(point + " and " + anotherPoint + "are different")
  // }

  // if(point == yetAnotherPoint) {
    // println(point + " and " + yetAnotherPoint + "are the same")
  // } else {
    // println(point + " and " + yetAnotherPoint + "are different")
  // }

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

  // Unified Types
  val list: List[Any] = List(
    "a sring",
    732,
    'c',
    true,
    () => "an anonymous function returning a string"
    )
  list.foreach(element => println((element)))

  // cast
  val x: Long = 983424
  val y: Float = x
  println(y)
  val face: Char = '☺'
  val number: Int = face  // 9786
  println(face)
  println(number)

  class Pos(var x: Int = 0, var y: Int = 0) {
    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }
    override def toString: String = 
      s"($x, $y)"
  }

  val point1 = new Pos(2, 3)
  point1.move(2,3)
  println(point1)
  println(point1.toString())
  //
  val p2 = new Pos(y=3)
  println(p2.toString)

  // private members and Getter/Setter
  class Point {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x = _x
    def x_= (newValue: Int): Unit = {
      if(newValue < bound) _x = newValue else printWarning
    }

    def y = _y
    def y_= (newValue: Int): Unit = {
      if(newValue < bound) _y = newValue else printWarning
    }

    private def printWarning = println("WARNING : OUT OF BOUNDS")
  }

  val po1 = new Point
  po1.x = 99
  po1.y = 102

  trait Iterator[A] {
    def hasNext: Boolean
    def next(): A
  }

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0
    override def hasNext: Boolean = current < to
    override def next(): Int = {
      if(hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

  val iterator = new IntIterator(10)
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())




  // subtyping
  import scala.collection.mutable.ArrayBuffer
  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet
  class Dog(val name: String) extends Pet

  val dog = new Dog("来福")
  val cat = new Cat("喵")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))





}












































