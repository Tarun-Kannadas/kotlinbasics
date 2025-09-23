open class item(open var title: String="")
{
    open var id:Int = 0
    // open fun getDescription():String = "Tile: $title (ID: $id)"

    init
    {
        println("Title: $title (default id = $id)")
    }
}

data class book(override var id:Int, override var title:String, var author:String=""):item(title)
{
    // override fun getDescription():String = "Book: $title by $author (ID: $id)"

    constructor(title:String,author:String):this(0,title,author)
    {
        println("Secondary constructor used: created '$title' by $author")
    }
}

data class magazine(override var id:Int, override var title:String,var issueNumber:Int=0):item(title)
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

    val magazine1 = magazine(101, "Tech Monthly", 10001)
    val magazine2 = magazine("Auto Car",456)

    val store = library()

    val record1 = store.addItem(book1,magazine1)

    println("\n--- Book Info ---")
    println("ID: ${record1.book.id} \nBook Title: ${record1.book.title} \nAuthor: ${record1.book.author}")

    store.showItem(record1)
    {
        println("\n--- Magazine Info ---")
        println("ID: ${it.magazine.id} \nMagazine Title: ${it.magazine.title} \nIssue Number: ${it.magazine.issueNumber}")
    }  
}