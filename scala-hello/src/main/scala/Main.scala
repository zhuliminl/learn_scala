object MyModule {

  def abs(n: Int): Int =
    if(n < 0) -n
    else n

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if(n <= 0) acc             // 基线条件
      else go(n-1, n*acc)        // 递归条件
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

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  // findFirst
  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if(ss(n) == key) n
      else loop(n + 1)
    }
    loop(0)
  }

  // findFist 泛型
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


  // 实现 isSorted 判断一个数组是否已经排序了
  // 比较前后两项
  // 思路：涉及到数组元素之间的关系，很明显需要用到前后项
  // 于是，应该单独拎出前后项作为一个小问题，来解决
  // 接着，我们在前后项的问题上，得出一个函数。这个函数解决了我们的局部问题
  // 最后，我们递归使用它。定义好它的基线条件和递归条件
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      // 如果能一直满足到底，则是真的排序了
      if(n >= as.length-1) true
      else if (ordered(as(n), as(n+1))) false
      else go(n+1)

    go(0)
  }

  // 柯里化、部分应用、局部套用
  // 一个高阶函数，它接受一个带有两个参数的函数，进行部分应用
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)

  // 注意参数括号的挪移，意味着个数必要的变化
  // 最终的函数可以看到参数的传递可以分两次前后传递了。总之，最后又得到了我们想要的结果 f(a, b)
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  // 反柯里化
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    // f(a)(b) 即代表执行了，并得到 C 这个结果
    (a, b) => f(a)(b)

  // 组合函数。将函数 f 和 函数 g 组合
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))





  def main(args: Array[String]): Unit = {
    val names = Array("saul", "demo", "elena", "queen", "carrie")
    // val newNames = names.reverse
    // newNames.map(println(_))
    // val ages = Array(1,2,5)
    // val index = findFirst(names, "elena")
    // println(index)

    //泛型之后的可能
    // val indexA = findFirstA(names,(x: String) => x == "demo")
    // println(indexA)
    // println(findFirstA(Array(2,3,4,5), (x: Int) => x == 3))
    // 判断是否排序
    println(isSorted(Array(2,7,3,3,6,1), (x: Int, y: Int) => x == y))

    // val numbers = Array(1, 2, 3, 4)

  }

    // val = findFirst()
    // var acc = factorial(7)
    // println(factorial(7))
    // println(formatAbs(-43))
    // println(formatResult("绝对值", -4, abs))
    // println(formatResult("阶乘值", 7, factorial))
}












































