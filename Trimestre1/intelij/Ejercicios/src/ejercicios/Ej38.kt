package ejercicios

class Ej38 {
    fun main(parametro: Array<String>) {
        val array = FloatArray(10)
        for(i in array.indices) {
            print("Ingrese elemento:")
            array[i] = readln().toFloat()
        }
        println("Listado completo del arreglo")
        for(elemento in array)
            print("$elemento ")
        println()
        val cant = array.count { it < 50}
        println("Cantidad de valores ingresados menores a 50: $cant")
        if (array.all {it < 50})
            println("Todos los valores son menores a 50")
        else
            println("No todos los valores son menores a 50")
    }
}