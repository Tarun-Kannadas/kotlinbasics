open class item(open var title: String? = null)
{
    open var id:Int? = null
    // open fun getDescription():String = "Tile: $title (ID: $id)"

    // init
    // {
    //     println("Title: $title (default id = $id)")
    // }
}

data class book(override var id:Int?, override var title:String?, var author:String? = null):item(title)
{
    // override fun getDescription():String = "Book: $title by $author (ID: $id)"

    constructor(title:String,author:String):this(0,title,author)
    {
        println("Secondary constructor used: created '$title' by $author")
    }
}

data class magazine(override var id:Int?, override var title:String?,var issueNumber:Int? = null):item(title)
{
    // override fun getDescription():String = "Magazine: $title (Issue #$issueNumber, ID: $id)"

    constructor(title:String,issueNumber:Int):this(0,title,0)
    {
        print("Secondary constructor used: created '$title' with ID: '$id' and Issue Number: '$issueNumber'")
    }
}

data class items(var book:book,var magazine:magazine)

class library
{
    fun addItem(book:book,magazine:magazine):items
    {
        return items(book,magazine)
    }

    fun addItem(record:items):items
    {
        return record
    }

    fun showItem(record:items,action:(items)->Unit)
    {
        action(record)
    }
}

fun main()
{
    val book1 = book(25, "Kotlin for You", "Tarun K.")
    val book2 = book("Learning Kotlin", "Jane Doe")
    val book3 = book(null,null,null)

    val magazine1 = magazine(101, "Tech Monthly", 10001)
    val magazine2 = magazine("Auto Car",456)
    val magazine3 = magazine(102,null,null)

    val store = library()

    val record1 = store.addItem(book1,magazine1)
    val record2 = store.addItem(book3,magazine3)

    println("\n--- Book Info ---") //Prints without using showItem()
    println("ID: ${record1.book.id} \nBook Title: ${record1.book.title} \nAuthor: ${record1.book.author}")

    store.showItem(record1)
    {
        println("\n--- Magazine Info ---") //Prints using showItem()
        println("ID: ${it.magazine.id} \nMagazine Title: ${it.magazine.title} \nIssue Number: ${it.magazine.issueNumber}")
    }

    println("\n--- Book Info ---") //Use of Elvis Operator
    println("ID: ${record2.book.id ?: "No ID"} \nBook Title: ${record2.book.title} \nAuthor: ${record2.book.author}")

    println("\n--- Magazine Info ---") //If null it prints null, if containts value then prints the value
    println("ID: ${record2.magazine.id?:""} \nBook Title: ${record2.magazine.title} \nAuthor: ${record2.magazine.issueNumber}")

    println("\n--- Magazine Info ---") //Only prints nullable values
    record2.magazine.id?.let { 
        println("\nID: $it") 
    }
    
    record2.magazine.title?.let { 
        println("Title: $it") 
    }
    
    record2.magazine.$issueNumber?.let { 
        println("Issue Number: $it") 
    }
}