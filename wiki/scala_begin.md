Scala 入门

## 如何开始一个 Scala 项目

**创建模版项目**

```
sbt new scala/hello-world.g8
```

**进入项目，并持续运行**

```
cd project_name
sbt
...
~run
```

## 基础知识

### Block

```scala
  println({
    val x = 9
    x + 1
    "xxx"
  })
```

### Anonymous Function

```scala
val addOne = (x: Int) => x + 1
```

### Method

```scala
  def sum(x: Int, y: Int): Int = x + y
```

**多参数列表**

```scala
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
```

**默认返回**

```scala
  def getSquarrString(input: Double): String = {
    val square = input * input
    square.toString
  }

```

### Unit 空类型、新建立类

```scala
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  val greeter = new Greeter("Hello ", " !")
  greeter.greet("Saul")
```

### Case Classes

**不需要 New 构造**

**按值比较**

```scala
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

```

### Object

**对象可以看成类的一个单例**

> Objects are single instances of their own definitions. You can think of them as singletons of their own classes.

```scala
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
```

### Traits 特质

> Traits are types containing certain fields and methods. Multiple traits can be combined.

```scala
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
```

### Main 入口

```scala
  object Main {
    def main(args: Array[String]): Unit = {
      println("Hello, Scala developer")
    }
  }
```

## 类型系统

- Any
  - AnyVal
    - Double
    - Float
    - Long
    - Int
    - Short
    - Byte
    - Unit
    - Boolean
    - Boolean
    - Chart
  - AnyRef(java.lang.Object)
    - List
    - Option
    - YourClass


```scala
  val list: List[Any] = List(
    "a sring",
    732,
    'c',
    true,
    () => "an anonymous function returning a string"
    )
  list.foreach(element => println((element)))
```

### 转型

**Byte > Short > Int > Long > Float > Double**

### Class

> Unlike many other languages, the primary constructor is in the class signature (var x: Int, var y: Int)

```scala
  class Pos(var x: Int, var y: Int) {
    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }
    override def toString: String =
      s"($x, $y)"
  }
```

**private and GETTER/SETTER**

> Notice the special syntax for the setters: the method has _= appended to the identifier of the getter and the parameters come after.<br>
Parameters without val or var are private values, visible only within the class.



```scala
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
```

### trait [共性，限制]

> Classes and objects can extend traits but traits cannot be instantiated and therefore have no parameters.

> This IntIterator class takes a parameter to as an upper bound. It extends Iterator[Int] which means that the next method must return an Int.

```scala
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
```

**Subtyping**

```scala
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
```











