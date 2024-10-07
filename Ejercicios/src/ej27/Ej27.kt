package ej27

class Vector {
    private val vec = IntArray(5)

    init {
        cargar()
    }

    private fun cargar() {
        for (i in vec.indices)
            vec[i] = ((Math.random() * 11)).toInt()  // Carga el vector con números aleatorios del 0 al 10
    }

    fun imprimir() {
        println("Listado completo del vector:")
        for (i in vec.indices)
            print("${vec[i]} - ")
        println()
    }

    fun mostrarMayor() {
        var mayor = vec[0]
        for (i in vec.indices)
            if (vec[i] > mayor)
                mayor = vec[i]
        println("El elemento mayor del vector es $mayor")
    }

    fun mostrarMenor() {
        var menor = vec[0]
        for (i in vec.indices)
            if (vec[i] < menor)
                menor = vec[i]
        println("El elemento menor del vector es $menor")
    }
}

class Ej27 {
    fun gestionarVector() {
        val vector1 = Vector()
        vector1.imprimir()
        vector1.mostrarMayor()
        vector1.mostrarMenor()
    }
}

fun main(parametro: Array<String>) {
    val ej27 = Ej27()
    ej27.gestionarVector()
}
