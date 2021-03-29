package com.example.modernandroid

fun main() {

    var xy = 10 // int 형 변수
    var str = "hello"
    var isMarried = true

    xy = 20
    str = "world"

    var a: Int = 10

    val b = 10 //변경 안 됨
    print("$str world")

    print(myMethod(10, 2))

    val items = listOf<Int>(1, 2, 3, 4, 5) //list는 불변
    val items2 = arrayListOf(1, 2, 3, 4, 5) //변경가능
    items2.add(6)
    items2.remove(1)
    items2[0] = 10

    print(items)

    val x = 2
    if (x % 2 == 0) {
        print("짝수")
    }

    val isEven = if (x % 2 == 0) "짝" else "홀"

    for (i in 0..9) {
        println(i)
    }

    val numbers = listOf(1, 2, 3, 4, 5)
    for (i in numbers) {
        println(i)
    }

    var x2 = 1

    when (x2) {
        1 -> print("1입니다")
        2 -> print("2입니다")
        3,4,5 -> print("그 밖")
        in 6..20 -> print("6부터 20")
        !in 8..20 -> print("")
        else -> print("else")
    }

    val person = Person("홍길동") //클래스 객체 선언
    print(person.name)

    val person2 = Person2("songa",20)
    print(person2)

    val str2 = "hello"

    print(str2.myLength())


}

fun myMethod(a: Int, b: Int): Int = a + b
fun myMethods(a: Int, b: Int) {
    //void면 그냥 하면 됨.
    print(a + b)
}

class Person(var name: String){
    init{
        print(name)

    }
}
data class Person2(val name: String, var age: Int)

//확장함수
//기능을 추가할 수 있다. (메소드 추가)
fun String.myLength(): Int{
    return this.length
}
