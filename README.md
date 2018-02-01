# Kotlin_Eye
练手学习。

## repeat

循环执行多次block的内容。

```kotlin
	 repeat(3) {        println("Hello world")    }
```

## with

使用参数中的闭包作为返回结果。

```kotlin
	fun testWith() { 
      // fun <T, R> with(receiver: T, f: T.() -> R): R = receiver.f() 
      with(ArrayList<String>()) {  
        add("testWith")  
        add("testWith")   
        add("testWith")   
        println("this = " + this) 
      }.let { println(it) }}
// 运行结果
// this = [testWith, testWith, testWith]
// kotlin.Unit
```

## let

当前对象作为闭包的参数，返回值是最后一行，或者指定return

## apply

在block中可以调用对象本身的方法。最后返回对象本身。

## run

在block中调用对象本身的方法，返回最后一行的。