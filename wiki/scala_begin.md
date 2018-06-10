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












