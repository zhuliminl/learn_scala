### 函数式数据结构

> 总之，请记住。纯函数一定不能修改原始数据或产生副作用。因此，函数式数据结构被定义为不可变的

#### 关于型变 `variance`

> `trait List[+A] 声明里，类型参数 A 前边的 + 是一个型变符号，标志着 A 是协变的或正向(positive)的参数。意味着假设 Dog 是 Animal 的子类，那么 List[Dog] 是 List[Animal] 的子类