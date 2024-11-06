package ej29

data class Dado(var valor: Int) {
    override fun toString(): String {
        var cadena = ""
        for (i in 1..valor) {
            cadena += "*"
        }
        return cadena
    }
}

class Ej29 {
    fun mostrarDados() {
        val dado1 = Dado(4)
        val dado2 = Dado(6)
        val dado3 = Dado(1)

        println(dado1)
        println(dado2)
        println(dado3)
    }
}

fun main(parametro: Array<String>) {
    val ej29 = Ej29()
    ej29.mostrarDados()
}
