package proyectos

class Ej14 {

    fun calculaCuadrado() {
        print("Ingrese un entero:")
        val valor = readln().toInt()
        val cuadrado = valor * valor
        println("El cuadrado es $cuadrado")
    }

    fun calcularProducto() {
        print("Ingrese primer valor:")
        val valor1 = readln().toInt()
        print("Ingrese segundo valor:")
        val valor2 = readln().toInt()
        val producto = valor1 * valor2
        println("El producto de los valores es: $producto")
    }

    fun menorValor() {
        print("Ingrese primer valor:")
        val valor1 = readln().toInt()
        print("Ingrese segundo valor:")
        val valor2 = readln().toInt()
        print("Ingrese tercer valor:")
        val valor3 = readln().toInt()
        print("Menor de los tres: ")
        when {
            valor1 < valor2 && valor1 < valor3 -> println(valor1)
            valor2 < valor3 -> println(valor2)
            else -> println(valor3)
        }
    }
}

fun main(parametro: Array<String>) {
    val calculadora = Ej14()

    calculadora.calculaCuadrado()
    calculadora.calcularProducto()
    calculadora.menorValor()
    calculadora.menorValor()
}