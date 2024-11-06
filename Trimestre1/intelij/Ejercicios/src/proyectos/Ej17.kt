package proyectos

class Ej17 {

    fun retornarPromedio(v1: Int, v2: Int, v3: Int) = (v1 + v2 + v3) / 3

    fun retornarPerimetro(lado: Int) = lado * 4

    fun retornarSuperficie(lado1: Int, lado2: Int) = lado1 * lado2

    fun largo(nombre: String) = nombre.length
}

fun main(parametro: Array<String>) {
    val ej17 = Ej17()

    print("Ingrese primer valor: ")
    val valor1 = readln().toInt()
    print("Ingrese segundo valor: ")
    val valor2 = readln().toInt()
    print("Ingrese tercer valor: ")
    val valor3 = readln().toInt()
    println("Valor promedio de los tres números ingresados es ${ej17.retornarPromedio(valor1, valor2, valor3)}")

    print("Ingrese el lado del cuadrado: ")
    val lado = readln().toInt()
    println("El perímetro del cuadrado es: ${ej17.retornarPerimetro(lado)}")

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

    val superficie1 = ej17.retornarSuperficie(lado1, lado2)
    val superficie2 = ej17.retornarSuperficie(lado3, lado4)

    when {
        superficie1 == superficie2 -> println("Los dos rectángulos tienen la misma superficie")
        superficie1 > superficie2 -> println("El primer rectángulo tiene una superficie mayor")
        else -> println("El segundo rectángulo tiene una superficie mayor")
    }

    print("Ingrese un nombre: ")
    val nombre1 = readln()
    print("Ingrese otro nombre: ")
    val nombre2 = readln()

    if (ej17.largo(nombre1) == ej17.largo(nombre2))
        println("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    else if (ej17.largo(nombre1) > ej17.largo(nombre2))
        println("$nombre1 es más largo")
    else
        println("$nombre2 es más largo")
}
