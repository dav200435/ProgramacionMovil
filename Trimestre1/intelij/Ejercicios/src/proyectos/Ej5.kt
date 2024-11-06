package proyectos

class Ej5 {
    fun main(argumento: Array<String>) {
        proyecto13()
        proyecto14()
    }

    private fun proyecto13() {
        print("Ingrese primera nota: ")
        val nota1 = readln().toInt()
        print("Ingrese segunda nota: ")
        val nota2 = readln().toInt()
        print("Ingrese tercera nota: ")
        val nota3 = readln().toInt()

        val promedio = (nota1 + nota2 + nota3) / 3
        if (promedio >= 7) {
            println("Promocionado")
        } else {
            println("No promocionado")
        }
    }

    private fun proyecto14() {
        print("Ingrese un valor comprendido entre 1 y 99: ")
        val num = readln().toInt()
        if (num < 10) {
            println("Tiene un dígito")
        } else {
            println("Tiene dos dígitos")
        }
    }
}