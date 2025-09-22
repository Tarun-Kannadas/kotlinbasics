fun calc(oper:(Int,Int)->Int,a:Int?,b:Int):Int
{
    return oper(a?:1,b)
}

fun main()
{
    var add = {a:Int,b:Int -> a+b}
    var sub = {a:Int,b:Int -> a-b}
    var mul = {a:Int,b:Int -> a*b}
    var div = {a:Int,b:Int -> a/b}

    val addition = calc(add,null,6)
    val subtraction = calc(add,10,6)
    val multiplication = calc(add,null,6)
    val division = calc(add,12,6)

    println(addition)
    println(subtraction)
    println(multiplication)
    println(division)
}