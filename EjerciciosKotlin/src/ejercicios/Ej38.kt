package ejercicios

class Ej38 {
    fun main(parametro: Array<String>) {
        val arreglo = FloatArray(10)
        for (i in arreglo.indices) {
            print("Ingrese elemento:")
            arreglo[i] = readln().toFloat()
        }
        println("Listado completo del arreglo")
        for (elemento in arreglo)
            print("$elemento ")
        println()
        val cant = arreglo.count { it < 50 }
        println("Cantidad de valores ingresados menores a 50: $cant")
        if (arreglo.all { it < 50 })
            println("Todos los valores son menores a 50")
        else
            println("No todos los valores son menores a 50")
    }
}