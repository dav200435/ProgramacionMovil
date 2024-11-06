package ej31

object MayorNumero {
    fun maximo(x1: Int, x2: Int) = if (x1 > x2) x1 else x2
    fun maximo(x1: Float, x2: Float) = if (x1 > x2) x1 else x2
    fun maximo(x1: Double, x2: Double) = if (x1 > x2) x1 else x2
}

fun main(parametro: Array<String>) {
    println("Máximo entre enteros: ${MayorNumero.maximo(4, 5)}")
    println("Máximo entre flotantes: ${MayorNumero.maximo(10.2f, 23.5f)}")
    println("Máximo entre dobles: ${MayorNumero.maximo(4.5, 5.2)}")
}
