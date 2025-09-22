class Num (var x:Int)
{
    var y:Int = 1
    var add = x+y
    var sub = x-y
    var mul = x*y
    var div = x/y
    
    constructor (x:Int,y:Int):this(x)
    {
        this.y = y
        this.add = x+y
        this.sub = x-y
        this.mul = x*y
        this.div = x/y
    }
}

fun main()
{
    val obj = Num(12,6)
    val obj1 = Num(5,6)
    val obj2 = Num(10,6)
    val obj3 = Num(18,6)
    println("Addition:\nFirstNum: ${obj.x}\nSecondNum: ${obj.y}\nResult:${obj.add}")
    println("\nSubtraction:\nFirstNum: ${obj1.x}\nSecondNum: ${obj1.y}\nResult:${obj1.sub}")
    println("\nMultiplication:\nFirstNum: ${obj2.x}\nSecondNum: ${obj2.y}\nResult:${obj2.mul}")
    println("\nDivision:\nFirstNum: ${obj3.x}\nSecondNum: ${obj3.y}\nResult:${obj3.div}")
}