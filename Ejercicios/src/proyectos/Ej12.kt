package proyectos

class Ej12 {

    fun Proyecto63(){
        print("Ingrese un valor entero:")
        val valor = readln().toInt()
        when {
            valor == 0 -> println("Se ingresó el cero")
            valor > 0 -> println("Se ingresó un valor positivo")
            else -> println("Se ingresó un valor negativo")
        }
    }


    fun Proyecto64() {
        var suma = 0
        for(i in 1..5) {
            print("Ingrese primer valor:")
            val valor1 = readln().toInt()
            print("Ingrese segundo valor:")
            val valor2 = readln().toInt()
            print("Ingrese tercer valor:")
            val valor3 = readln().toInt()
            suma += when {
                valor1 > valor2 && valor1 > valor3 -> valor1
                valor2 > valor3 -> valor2
                else -> valor3
            }
        }
        println("El valor acumulado de los mayores de cada lista de 3 valores es : $suma")
    }


    fun Proyecto65 () {
        var cant1 = 0
        var cant2 = 0
        var cant3 = 0
        print("Ingrese la cantidad de triángulos:")
        val n = readln().toInt()
        for(i in 1..n) {
            print("Ingrese lado 1:")
            val lado1 = readln().toInt()
            print("Ingrese lado 2:")
            val lado2 = readln().toInt()
            print("Ingrese lado 3:")
            val lado3 = readln().toInt()
            when {
                lado1 == lado2 && lado1 == lado3 -> {
                    println("Es un triángulo equilatero.")
                    cant1++
                }
                lado1 == lado2 || lado1 == lado3 || lado2 == lado3 -> {
                    println("Es un triángulo isósceles.")
                    cant2++
                }
                else -> {
                    println("Es un triángulo escaleno.")
                    cant3++
                }
            }
        }
        println("Cantidad de triángulos equilateros: $cant1")
        println("Cantidad de triángulos isósceles: $cant2")
        println("Cantidad de triángulos escalenos: $cant3")
    }
    fun ejecutar() {
        do {
            println("Elija el proyecto a ejecutar (63, 64, 65) o ingrese 0 para salir:")
            val opcion = readln().toInt()
            when (opcion) {
                63 -> Proyecto63()
                64 -> Proyecto64()
                65 -> Proyecto65()
                0 -> println("Saliendo...")
                else -> println("Opción no válida, intente de nuevo.")
            }
        } while (opcion != 0)
    }
}

fun main() {
    val ej = Ej12()
    ej.ejecutar()
}