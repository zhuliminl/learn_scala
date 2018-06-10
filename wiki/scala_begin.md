## Scala 入门

### 如何开始一个 Scala 项目

##### 1 创建模版项目

```
sbt new scala/hello-world.g8
```

##### 2 进入项目，并持续运行

```
cd project_name
sbt
...
~run
```

### 基础知识

##### Block

```
  println({
    val x = 9
    x + 1
    "xxx"
  })
```

##### Anonymous Function

```
val addOne = (x: Int) => x + 1
```

#### Method

```
  def sum(x: Int, y: Int): Int = x + y
```

> 多参数列表

```
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
```

> 默认返回

```
  def getSquarrString(input: Double): String = {
    val square = input * input
    square.toString
  }

```

> Unit 空类型、新建立类

```
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  val greeter = new Greeter("Hello ", " !")
  greeter.greet("Saul")
```












