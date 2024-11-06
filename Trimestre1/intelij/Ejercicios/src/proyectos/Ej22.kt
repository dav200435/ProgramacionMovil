package proyectos

class Ej22 {

    fun cargar(): IntArray {
        print("¿Cuántos elementos tendrá el array? ")
        val cantidad = readln().toInt()
        val array = IntArray(cantidad)
        for (i in array.indices) {
            print("Ingrese elemento: ")
            array[i] = readln().toInt()
        }
        return array
    }

    fun imprimir(array: IntArray) {
        println("Listado completo del array:")
        for (elemento in array) {
            println(elemento)
        }
    }

    fun sumar(array: IntArray): Int {
        var suma = 0
        for (elemento in array) {
            suma += elemento
        }
        return suma
    }

    fun mayor(array: IntArray): Int {
        var may = array[0]
        for (elemento in array) {
            if (elemento > may) {
                may = elemento
            }
        }
        return may
    }

    fun repite(array: IntArray, buscar: Int): Boolean {
        var cant = 0
        for (elemento in array) {
            if (elemento == buscar) {
                cant++
            }
        }
        return cant > 1
    }
}

fun main(parametro: Array<String>) {
    val ej22 = Ej22()

    val array = ej22.cargar()
    ej22.imprimir(array)
    println("La suma de todos sus elementos es ${ej22.sumar(array)}")
    println("El elemento mayor es ${ej22.mayor(array)}")
    if (ej22.repite(array, ej22.mayor(array))) {
        println("Se repite el mayor en el array")
    } else {
        println("No se repite el mayor en el array")
    }
}
