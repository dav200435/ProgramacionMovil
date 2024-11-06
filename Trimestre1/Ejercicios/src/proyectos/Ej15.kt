package proyectos

class Ej15 {

    fun verificarClaves(clave1: String, clave2: String) {
        if (clave1 == clave2)
            println("Se ingresaron las dos veces la misma clave")
        else
            println("No se ingresó las dos veces con el mismo valor")
    }

    fun ordenarMayorMenor(valor1: Int, valor2: Int, valor3: Int) {
        when {
            valor1 < valor2 && valor1 < valor3 -> {
                if (valor2 < valor3)
                    println("$valor3 $valor2 $valor1")
                else
                    println("$valor2 $valor3 $valor1")
            }
            valor2 < valor3 -> {
                if (valor1 < valor3)
                    println("$valor3 $valor1 $valor2")
                else
                    println("$valor2 $valor3 $valor1")
            }
            else -> {
                if (valor1 < valor2)
                    println("$valor3 $valor2 $valor1")
                else
                    println("$valor3 $valor1 $valor2")
            }
        }
    }
}

fun main(parametro: Array<String>) {
    val ej15 = Ej15()

    print("Ingrese primer clave: ")
    val clave1 = readln()
    print("Repita el ingreso de la misma clave: ")
    val clave2 = readln()
    ej15.verificarClaves(clave1, clave2)

    print("Ingrese primer valor: ")
    val valor1 = readln().toInt()
    print("Ingrese segundo valor: ")
    val valor2 = readln().toInt()
    print("Ingrese tercer valor: ")
    val valor3 = readln().toInt()
    ej15.ordenarMayorMenor(valor1, valor2, valor3)
}

