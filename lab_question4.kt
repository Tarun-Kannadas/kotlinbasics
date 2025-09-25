open class pet(open var name:String="", open var age:Int=0)
{
    open fun description() = "Pet: $name, Age:$age"
}

data class dog(override var name:String, override var age:Int, var breed:String?=null):pet(name,age)
{
    override fun description() = "Dog: $name \nAge: $age \nBreed: $breed"
}

data class cat(override var name:String, override var age:Int, var livesLeft:Int?=null):pet(name,age)
{
    override fun description() = "Cat: $name \nAge: $age \nLives Left: $livesLeft"
}

class clinicManagment
{
    private val pets = mutableListOf<pet>()

    fun addPet(dog:dog):dog
    {
        pets.add(dog)
        println("Dog data stored")
        return dog
    }

    fun addPet(cat:cat):cat
    {
        pets.add(cat)
        println("Cat data stored")
        return cat
    }

    fun showAllPets()
    {
        println("\n___All Pets in Clinic___")

        for (p in pets)
        {
            println(p.description())
            println("-----------")
        }
    }

    fun showPet(pet:pet,action:(pet)->Unit)
    {
        action(pet)
    }
}

fun main()
{
    val dog1 = dog("Jibru", 12, "German Sheperd")
    val dog2 = dog("Gabru", 15, "Rottweiler")

    val cat1 = cat("Chakki",10, 9)
    val cat2 = cat("Munchkin",2, 9)

    val management = clinicManagment()

    val dogDetail = management.addPet(dog1)
    val dogDetail2 = management.addPet(dog2)
    val catDetail1 = management.addPet(cat1)
    val catDetail = management.addPet(cat2)

    println("\n___Dog Info___")
    println("Name: ${dogDetail.name} \nAge: ${dogDetail.age} \nBreed: ${dogDetail.breed}")

    println("\n___2nd Dog Info___")
    println(dogDetail2.description())

    management.showPet(catDetail)
    {
        println("\n___Cat Info___")
        println(it.description())
    }

    println("\n___2nd Cat Info___")
    println("Name: ${catDetail.name} \nAge: ${catDetail.age} \nLives Left: ${catDetail.livesLeft?:"Unknown"}")

    management.showAllPets()
}