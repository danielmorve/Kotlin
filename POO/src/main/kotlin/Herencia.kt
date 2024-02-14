///*Herencia permite la creación de nuevas clases basadas en clases existentes*/
//
//fun main(){
//val car = Car("Tesla", 2024, "S")
//    println("Brand: ${car.brand}")
//    println("Year: ${car.year}")
//    println("Model: ${car.model}")
//
//}
//
//open class Vehiculo(val brand:String, val year:Int, val model:String){
//    fun acelerar(){
//        println("Acelerando el vehiculo")
//    }
//    fun frenar(){
//        println("Frenando el vehiculo")
//    }
//}
//
//class Car(brand:String, year:Int, val model:String) : Vehiculo(brand, year) {
//    fun autoPilot() {
//        println("Activando el piloto automático")
//
//    }
//}