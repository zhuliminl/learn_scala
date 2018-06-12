object MyModule {

  def abs(n: Int): Int =
    if(n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "绝对值 %d 是 %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if(n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }

  def main(args: Array[String]): Unit =
    // var acc = factorial(7)
    println(factorial(3))
    println(formatAbs(-43))
}












































