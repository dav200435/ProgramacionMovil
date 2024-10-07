package ej30

enum class Paises(val habitantes: Int) {
    ESTADOS_UNIDOS(331002651),
    CANADA(37742154),
    MEXICO(128932753),
    ARGENTINA(45195777),
    BRASIL(212559417),
    ESPAÑA(46754778),
    ALEMANIA(83783942),
    FRANCIA(65273511),
    ITALIA(60244639)
}

class Ej30 {
    fun mostrarInformacionPais() {
        val pais1 = Paises.ESTADOS_UNIDOS
        println("País: $pais1")
        println("Habitantes: ${pais1.habitantes}")
    }
}

fun main(parametro: Array<String>) {
    val ej30 = Ej30()
    ej30.mostrarInformacionPais()
}
