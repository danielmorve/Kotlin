///*Abstracción: Mostrar solo la informacion esencial y Ocultar los detalles innecesarios
//*
//* */
//fun main(){
// var circle = Circle(radius=5.0)
//    println("Area del circulo: ${circle.calculateArea()}")
//
//    var rectangle = Rectangle(5.0, 3.0)
//    println("Area del rectangulo: ${rectangle.calculateArea()}")
//}
//
//abstract class Shape{
//    abstract fun calculateArea():Double
//}
//
//class Circle(private val radius:Double):Shape(){
//    override fun calculateArea(): Double {
//        return Math.PI * radius * radius
//    }
//}
//
//class Rectangle(private val width:Double, private val height:Double):Shape(){
//    override fun calculateArea(): Double {
//        return width * height
//    }
//}