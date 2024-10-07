package proyectos

class Ej16 {

    fun retornarPromedio(v1: Int, v2: Int, v3: Int): Int {
        return (v1 + v2 + v3) / 3
    }

    fun retornarPerimetro(lado: Int): Int {
        return lado * 4
    }

    fun retornarSuperficie(lado1: Int, lado2: Int): Int {
        return lado1 * lado2
    }
}

fun main(parametro: Array<String>) {
    val ej16 = Ej16()

    print("Ingrese primer valor: ")
    val valor1 = readln().toInt()
    print("Ingrese segundo valor: ")
    val valor2 = readln().toInt()
    print("Ingrese tercer valor: ")
    val valor3 = readln().toInt()
    println("Valor promedio de los tres números ingresados es ${ej16.retornarPromedio(valor1, valor2, valor3)}")

    print("Ingrese el lado del cuadrado: ")
    val lado = readln().toInt()
    println("El perímetro del cuadrado es: ${ej16.retornarPerimetro(lado)}")

    println("Primer rectángulo")
    print("Ingrese lado menor del rectángulo: ")
    val lado1 = readln().toInt()
    print("Ingrese lado mayor del rectángulo: ")
    val lado2 = readln().toInt()
    println("Segundo rectángulo")
    print("Ingrese lado menor del rectángulo: ")
    val lado3 = readln().toInt()
    print("Ingrese lado mayor del rectángulo: ")
    val lado4 = readln().toInt()

    val superficie1 = ej16.retornarSuperficie(lado1, lado2)
    val superficie2 = ej16.retornarSuperficie(lado3, lado4)

    when {
        superficie1 == superficie2 -> println("Los dos rectángulos tienen la misma superficie")
        superficie1 > superficie2 -> println("El primer rectángulo tiene una superficie mayor")
        else -> println("El segundo rectángulo tiene una superficie mayor")
    }
}
