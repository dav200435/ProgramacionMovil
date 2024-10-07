package proyectos

class Ej3 {
    fun main(argumento: Array<String>) {
        proyecto3()
        proyecto4()
    }

    private fun proyecto3() {
        val lado = 50
        val perimetro = lado * 4
        val superficie = lado * lado
        println("El perímetro de un cuadrado de lado $lado es $perimetro y su superficie es $superficie")
    }

    private fun proyecto4() {
        val peso1 = 89.4f
        val peso2 = 67f
        val peso3 = 87.45f
        val promedio = (peso1 + peso2 + peso3) / 3
        println("El promedio de los tres pesos de personas es $promedio")
    }
}

}