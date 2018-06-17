## 什么是函数式编程


### 大前提

> 只用**纯函数**来构造程序 —— 换句话说，函数没有副作用(side effects)

**什么是副作用**

- 修改一个变量
- 直接修改数据结构
- 设置一个对象的成员
- 抛出一个异常或者以一个错误停止
- 打印到终端或者读取用户的输入
- 读取或者写入一个文件
- 在屏幕上绘画

**函数式编程的好处**

- 模块化的特性更容易
  - 被测试
  - 复用
  - 并行化
  - 泛化
  - 推导

### 两个重要概念

**引用透明**

> it means you can replace equals with equals

> An expression is said to be referentially transparent if it can be replaced with its corresponding value without changing the program's behavior. As a result, evaluating a referentially transparent function gives the same value for same arguments. Such functions are called pure functions.

> 为了便于讨论，设定一个程序的任何部分的表达式，都可以计算为一个结果 ———— 在 Scala 解释器下输入的任何内容都会得到结果。<br>
当调用一个函数时所传入的参数是引用透明的，并且函数调用也是引用透明的，那么这个函数是一个纯函数

> 对于程序 p，如果它包含的表达式 e 满足引用透明，所有的 e 都可以替换为它的运算结果而不改变程序 p 的含义。假设存在一个函数 f, <br>
若表达式  f(x) 对所有引用透明的表达式 x 也是引用透明的，那么这个 f 是一个纯函数。

**代换模型**

> 引用透明要求函数不论进行了任何操作都可以用它的返回值（value）来替代。这种限制使得推倒一个程序的求值（evaluation）变得简单而自然，我们称之为代换模型

> 引用透明使得程序具备了**等式推理**的能力

### 高阶函数 `HOF`

```scala
object MyModule {

  def abs(n: Int): Int =
    if(n < 0) -n
    else n

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if(n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "绝对值 %d 是 %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  // HOF
  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit =
    // var acc = factorial(7)
    // println(factorial(7))
    // println(formatAbs(-43))
    println(formatResult("绝对值", -4, abs))
    println(formatResult("阶乘值", 7, factorial))
}
```
### 多态函数

> 多态函数有时也被称之为**泛型函数**。基于类型的抽象化

```scala
  // findFist 泛型
  // A 是类型变量
  def findFirstA[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if(n >= as.length) -1
      // p 是回调函数， as(n) 是参数，这个参数类型可以是任意的
      else if(p(as(n))) n
      else loop(n + 1)
    }
    loop(0)
  }

    val names = Array("saul", "demo", "elena", "queen", "carrie")
    //泛型之后的可能
    val indexA = findFirstA(names,(x: String) => x == "demo")
    println(indexA)
    println(findFirstA(Array(2,3,4,5), (x: Int) => x == 3))
```












