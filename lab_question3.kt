open class vehicle(open var id:Int=0, open var name:String="", open var fuelType: String="")

data class bus(override var id:Int, override var name:String,override var fuelType:String,var capacity:Int=0):vehicle(id, name, fuelType)

data class truck(override var id:Int, override var name:String,override var fuelType:String,var loadLimit:Int=0):vehicle(id, name, fuelType)

data class car(override var id:Int, override var name:String,override var fuelType:String,var seats:Int=0):vehicle(id, name, fuelType)

data class storage1(val bus:bus)

data class storage2(val truck:truck)

data class storage3(val car:car)

class VehicleManagement {
    var bus: bus? = null
    var truck: truck? = null
    var car: car? = null

    fun addBus(newBus: bus) {
        bus = newBus
        println("Bus added: $newBus")
    }

    fun addTruck(newTruck: truck) {
        truck = newTruck
        println("Truck added: $newTruck")
    }

    fun addCar(newCar: car) {
        car = newCar
        println("Car added: $newCar")
    }

    fun displayAllVehicles() {
        println("All Vehicles:")
        bus?.let { println("Bus -> ID: ${it.id}, Name: ${it.name}, Fuel: ${it.fuelType}, Details: $it") }
        truck?.let { println("Truck -> ID: ${it.id}, Name: ${it.name}, Fuel: ${it.fuelType}, Details: $it") }
        car?.let { println("Car -> ID: ${it.id}, Name: ${it.name}, Fuel: ${it.fuelType}, Details: $it") }
    }
}

fun main() {
    val vm = VehicleManagement()

    val bus = bus(1, "City Bus", "Diesel", 50)
    val truck = truck(2, "Cargo Truck", "Diesel", 1500)
    val car = car(3, "Sedan", "Petrol", 4)

    vm.addBus(bus)
    vm.addTruck(truck)
    vm.addCar(car)

    vm.displayAllVehicles()
}