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
