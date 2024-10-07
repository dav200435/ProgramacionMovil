package proyectos

class Ej18 {

    fun sumar(v1: Int, v2: Int, v3: Int = 0, v4: Int = 0, v5: Int = 0) = v1 + v2 + v3 + v4 + v5
}

fun main(parametro: Array<String>) {
    val ej18 = Ej18()

    println("La suma de 5 + 6 es ${ej18.sumar(5, 6)}")
    println("La suma de 1 + 2 + 3 es ${ej18.sumar(1, 2, 3)}")
    println("La suma de 1 + 2 + 3 + 4 + 5 es ${ej18.sumar(1, 2, 3, 4, 5)}")
}
