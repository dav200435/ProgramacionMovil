package ej32

open class Dado {
    protected var valor: Int = 1

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    open fun imprimir() {
        println("Valor del dado: $valor")
    }
}

class DadoRecuadro : Dado() {
    override fun imprimir() {
        println("***")
        println("* $valor *") // Espacio agregado alrededor del valor para mejor presentación
        println("***")
    }
}

fun main(parametro: Array<String>) {
    val dado1 = Dado()
    dado1.tirar()
    dado1.imprimir()

    val dado2 = DadoRecuadro()
    dado2.tirar()
    dado2.imprimir()
}
