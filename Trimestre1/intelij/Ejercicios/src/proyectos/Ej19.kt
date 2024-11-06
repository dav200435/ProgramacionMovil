package proyectos

class Ej19 {

    fun tabla(numero: Int, terminos: Int = 10) {
        for (i in numero..numero * terminos step numero) {
            println(i)
        }
    }
}

fun main(parametro: Array<String>) {
    val ej19 = Ej19()

    println("Tabla del 3")
    ej19.tabla(3)

    println("Tabla del 3 con 5 términos")
    ej19.tabla(3, 5)

    println("Tabla del 3 con 20 términos")
    ej19.tabla(terminos = 20, numero = 3)
}
