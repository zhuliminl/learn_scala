package fpinscala.datastructures

object Main extends App {
  sealed trait List[+A]
  case object Nil extends List[Nothing]   // 表现空情况的 List 数据构造器
  // 表现非空
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  // 伴生对象
  object List {
    // 和
    def sum(ints: List[Int]): Int = ints match {
      // 基线条件
      case Nil => 0
      // 递归条件
      case Cons(x, xs) => x + sum(xs)


    }
    // 乘积
    def product(ds: List[Double]): Double = ds match {
      case Nil => 0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] =
      if(as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

  }

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    // case Cons(h, t) => h + sum(t)
    case _ => 101
  }

  // 删除一个列表的第一个元素
  def tail[A](l: List[A]): List[A] = l match {
    // 从一个空的列表中去第一个值，就应该直接抛出错误
    case Nil => sys.error("tail of empty list")
    case Cons(_, t) => t
  }


  override def main(args :Array[String]): Unit = {
    println("xxx")
  }

}



