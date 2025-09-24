// Base class
open class Vehicle(
    open var id: Int,
    open var name: String,
    open var fuelType: String
)

// Different vehicle types with their own properties
data class Bus(
    override var id: Int,
    override var name: String,
    override var fuelType: String,
    var capacity: Int
) : Vehicle(id, name, fuelType)

data class Truck(
    override var id: Int,
    override var name: String,
    override var fuelType: String,
    var loadLimit: Int
) : Vehicle(id, name, fuelType)

data class Car(
    override var id: Int,
    override var name: String,
    override var fuelType: String,
    var seats: Int
) : Vehicle(id, name, fuelType)

// Vehicle management system
class VehicleManagement {

    // Arrays to hold vehicles of each type (fixed size for simplicity)
    private val buses = Array<Bus?>(10) { null }
    private val trucks = Array<Truck?>(10) { null }
    private val cars = Array<Car?>(10) { null }

    private var busCount = 0
    private var truckCount = 0
    private var carCount = 0

    // Add vehicles
    fun addBus(bus: Bus) {
        buses[busCount++] = bus
    }

    fun addTruck(truck: Truck) {
        trucks[truckCount++] = truck
    }

    fun addCar(car: Car) {
        cars[carCount++] = car
    }

    // Display all vehicle details
    fun displayAll() {
        println("--- Buses ---")
        for (i in 0 until busCount) {
            val b = buses[i]
            println("ID: ${b?.id}, Name: ${b?.name}, Fuel: ${b?.fuelType}, Capacity: ${b?.capacity}")
        }

        println("\n--- Trucks ---")
        for (i in 0 until truckCount) {
            val t = trucks[i]
            println("ID: ${t?.id}, Name: ${t?.name}, Fuel: ${t?.fuelType}, Load Limit: ${t?.loadLimit}")
        }

        println("\n--- Cars ---")
        for (i in 0 until carCount) {
            val c = cars[i]
            println("ID: ${c?.id}, Name: ${c?.name}, Fuel: ${c?.fuelType}, Seats: ${c?.seats}")
        }
    }

    // Perform maintenance action for a bus/truck/car by ID
    fun performMaintenanceBus(id: Int) {
        for (i in 0 until busCount) {
            if (buses[i]?.id == id) {
                println("Performing maintenance on Bus: ${buses[i]?.name}")
            }
        }
    }

    // Apply a discount or special offer using a custom action (lambda)
    fun applyOfferToBus(id: Int, action: (Bus) -> Unit) {
        for (i in 0 until busCount) {
            if (buses[i]?.id == id) {
                buses[i]?.let { action(it) }
            }
        }
    }
}

fun main() {
    val vm = VehicleManagement()

    // Add vehicles
    vm.addBus(Bus(1, "City Bus", "Diesel", 50))
    vm.addTruck(Truck(2, "Cargo Truck", "Diesel", 1500))
    vm.addCar(Car(3, "Sedan", "Petrol", 4))

    // Display all
    vm.displayAll()

    // Perform maintenance on a bus
    vm.performMaintenanceBus(1)

    // Apply a discount or special offer to a bus using a lambda
    vm.applyOfferToBus(1) {
        println("Applying 10% discount to Bus: ${it.name}")
    }
}
