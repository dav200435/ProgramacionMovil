package proyectos;
class Ej10 {

    fun proyecto45() {
        var suma = 0
        do {
            print("Ingrese un valor (finalizar con 9999): ")
            val valor = readln().toInt()
            if (valor != 9999)
                suma += valor
        } while (valor != 9999)
        println("El valor acumulado es $suma")
        if (suma == 0) {
            println("El valor acumulado es cero.")
        } else if (suma > 0) {
            println("El valor acumulado es positivo.")
        } else {
            println("El valor acumulado es negativo.")
        }
    }

    fun proyecto46() {
        var suma = 0.0
        do {
            print("Ingrese número de cuenta: ")
            val cuenta = readln().toInt()
            if (cuenta >= 0) {
                print("Ingrese saldo: ")
                val saldo = readln().toDouble()
                if (saldo > 0) {
                    println("Saldo Acreedor.")
                    suma += saldo
                } else if (saldo < 0) {
                    println("Saldo Deudor.")
                } else {
                    println("Saldo Nulo.")
                }
            }
        } while (cuenta >= 0)
        println("Total de saldos Acreedores: $suma")
    }

    fun ejecutar() {
        do {
            println("Elija el proyecto a ejecutar (45 o 46) o ingrese 0 para salir:")
            val opcion = readln().toInt()

            when (opcion) {
                45 -> proyecto45()
                46 -> proyecto46()
                0 -> println("Saliendo...")
                else -> println("Opción no válida, intente de nuevo.")
            }
        } while (opcion != 0)
    }
}

fun main() {
    val ej = Ej10()
    ej.ejecutar()
}
