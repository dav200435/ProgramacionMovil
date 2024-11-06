package proyectos

class Ej21 {

    fun procesarArray() {
        val array = IntArray(8)

        for (i in array.indices) {
            print("Ingrese elemento: ")
            array[i] = readln().toInt()
        }

        var suma = 0
        var sumaMayor36 = 0
        var cantMayor50 = 0

        for (elemento in array) {
            suma += elemento
            if (elemento > 36) {
                sumaMayor36 += elemento
            }
            if (elemento > 50) {
                cantMayor50++
            }
        }

        println("Valor acumulado del array: $suma")
        println("Valor acumulado de los elementos mayores a 36: $sumaMayor36")
        println("Cantidad de elementos mayores a 50: $cantMayor50")
    }

    fun sumarArrays() {
        val array1 = IntArray(4)
        val array2 = IntArray(4)

        println("Carga del primer array")
        for (i in array1.indices) {
            print("Ingrese elemento: ")
            array1[i] = readln().toInt()
        }

        println("Carga del segundo array")
        for (i in array2.indices) {
            print("Ingrese elemento: ")
            array2[i] = readln().toInt()
        }

        val arraySuma = IntArray(4)
        for (i in arraySuma.indices) {
            arraySuma[i] = array1[i] + array2[i]
        }

        println("Array resultante")
        for (elemento in arraySuma) {
            println(elemento)
        }
    }
}

fun main(parametro: Array<String>) {
    val ej21 = Ej21()

    // Procesar el primer array
    ej21.procesarArray()

    // Sumar los dos arrays
    ej21.sumarArrays()
}