package proyectos

class Ej8 {
    class Proyectos {

        fun proyecto25() {
            print("Ingrese día: ")
            val dia = readln().toInt()
            print("Ingrese mes: ")
            val mes = readln().toInt()
            print("Ingrese año: ")
            val año = readln().toInt()

            if (mes == 12 && dia == 25) {
                println("La fecha ingresada corresponde a Navidad.")
            } else {
                println("La fecha ingresada no corresponde a Navidad.")
            }
        }

        fun proyecto26() {
            print("Ingrese primer valor: ")
            val valor1 = readln().toInt()
            print("Ingrese segundo valor: ")
            val valor2 = readln().toInt()
            print("Ingrese tercer valor: ")
            val valor3 = readln().toInt()

            if (valor1 == valor2 && valor1 == valor3) {
                val cubo = valor1 * valor1 * valor1
                println("El cubo de $valor1 es $cubo")
            } else {
                println("Los valores no son iguales.")
            }
        }

        fun proyecto27() {
            print("Ingrese primer valor: ")
            val valor1 = readln().toInt()
            print("Ingrese segundo valor: ")
            val valor2 = readln().toInt()
            print("Ingrese tercer valor: ")
            val valor3 = readln().toInt()

            if (valor1 < 10 && valor2 < 10 && valor3 < 10) {
                println("Todos los números son menores a diez.")
            }
        }

        fun proyecto28() {
            print("Ingrese primer valor: ")
            val valor1 = readln().toInt()
            print("Ingrese segundo valor: ")
            val valor2 = readln().toInt()
            print("Ingrese tercer valor: ")
            val valor3 = readln().toInt()

            if (valor1 < 10 || valor2 < 10 || valor3 < 10) {
                println("Alguno de los números es menor a diez.")
            }
        }

        fun proyecto29() {
            print("Ingrese coordenada x: ")
            val x = readln().toInt()
            print("Ingrese coordenada y: ")
            val y = readln().toInt()

            when {
                x > 0 && y > 0 -> println("Se encuentra en el primer cuadrante")
                x < 0 && y > 0 -> println("Se encuentra en el segundo cuadrante")
                x < 0 && y < 0 -> println("Se encuentra en el tercer cuadrante")
                x > 0 && y < 0 -> println("Se encuentra en el cuarto cuadrante")
                else -> println("Se encuentra en un eje")
            }
        }

        fun proyecto30() {
            print("Ingrese primer valor: ")
            val valor1 = readln().toInt()
            print("Ingrese segundo valor: ")
            val valor2 = readln().toInt()
            print("Ingrese tercer valor: ")
            val valor3 = readln().toInt()

            val menor = minOf(valor1, valor2, valor3)
            val mayor = maxOf(valor1, valor2, valor3)

            println("El mayor de la lista es $mayor y el menor $menor")
        }
    }

    fun main() {
        val proyectos = Proyectos()

        // Puedes llamar a los métodos aquí para probarlos
        proyectos.proyecto25()
        proyectos.proyecto26()
        proyectos.proyecto27()
        proyectos.proyecto28()
        proyectos.proyecto29()
        proyectos.proyecto30()
    }

}