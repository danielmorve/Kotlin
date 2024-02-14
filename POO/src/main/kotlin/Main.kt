import java.util.UUID

/*Hacer una fabrica de vehiculos
* Coches, motos
* Modelo
* Metodos especificos para cada vehiculo
* Marcas de coches
* */

fun main(){
try {
    val factory = Factory()
    val tesla = factory.produceCar("Tesla", "Model S") as Tesla
    val ferrari = factory.produceCar("Ferrari", "Enzo") as Ferrari
    val tesla2 = factory.produceCar("Tesla", "Model 3") as Tesla
    val ferrari2 = factory.produceCar("Ferrari", "F8") as Ferrari

    factory.addCar(tesla)
    factory.addCar(ferrari)
    factory.addCar(tesla2)
    factory.addCar(ferrari2)
    ferrari2.turbo()
    tesla2.autoPilot()

    val cars = factory.getAllCars()
    cars.forEach { c ->
        println("Marca: ${c.brand}, Modelo: ${c.model}, Velocidad máxima: ${c.maxSpeed}")
    }

}
catch (e:Exception){
println(e)
}
}

abstract class Vehicle(val wheels: Int){
    fun stop(){
        println("El vehiculo se ha detenido")
    }
    fun accelerate(){
        println("El vehiculo ha acelerado")
    }
    open fun brake(){
        println("El vehiculo ha frenado con $wheels ruedas")
    }
}

abstract class Car(val brand: String, val maxSpeed: Double, open val model: String): Vehicle(4){
    private val vin : UUID = UUID.randomUUID()

    fun openDoors(){
        println("Las puertas del vehiculo se han abierto")
    }

    fun enableAC(){
        println("El aire acondicionado se ha encendido")
    }
}

class Tesla(override val model : String) : Car(brand = "Tesla", maxSpeed = 250.0, model = "Model S"){
    fun autoPilot(){
        println("El piloto automático se ha activado")
    }

    fun chargeBattery(){
        println("La batería se está cargando")
    }

    override fun brake(){
        super.brake()
        println("El vehiculo ha frenado con $wheels ruedas y el sistema de frenado regenerativo")
    }
}

class Ferrari(override val model: String) : Car(brand = "Ferrari", maxSpeed = 400.0, model = "Enzo"){
    fun turbo(){
        println("El turbo se ha activado")
    }

    fun drift(){
        println("El vehiculo ha derrapado")
    }
}

class Motorcycle(val brand: String, val maxSpeed: Double, val model: String) : Vehicle(2){
    fun wheelie(){
        println("Wheelie")
    }
}

class Factory{
    private val cars = mutableListOf<Car>()
    fun produceCar(brand: String, model: String) : Car{
        val car = when(brand){
            "Tesla" -> Tesla(model)
            "Ferrari" -> Ferrari(model)
            else -> throw IllegalArgumentException("Marca no encontrada")
        }
        return car
    }

    fun produceMotorcycle(brand: String, model: String, maxSpeed: Double) : Motorcycle{
        return Motorcycle(brand, maxSpeed, model)
    }

    fun addCar(car: Car){
        cars.add(car)
    }

    fun removeCar(car: Car){
        cars.remove(car)
    }

    fun removeCarWithIndex(index: Int){
        cars.removeAt(index)
    }

    fun getCarsByBrand(brand: String) : List<Car>{
        return cars.filter { it.brand == brand }
    }

    fun getAllCars() : List<Car>{
        return cars
    }
}