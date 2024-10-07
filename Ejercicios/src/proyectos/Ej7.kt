package proyectos

class Ej7 {
    fun main(argumento: Array<String>) {
        proyecto19()
        proyecto20()
        proyecto21()
        proyecto22()
    }

    private fun proyecto19() {
        print("Ingrese primer valor: ")
        val valor1 = readln().toInt()
        print("Ingrese segundo valor: ")
        val valor2 = readln().toInt()
        print("Ingrese tercer valor: ")
        val valor3 = readln().toInt()

        val maxValor = if (valor1 > valor2) {
            if (valor1 > valor3) valor1 else valor3
        } else {
            if (valor2 > valor3) valor2 else valor3
        }
        println("El valor máximo es: $maxValor")
    }

    private fun proyecto20() {
        print("Ingrese un valor entero: ")
        val valor = readln().toInt()
        when {
            valor == 0 -> println("Se ingresó el cero")
            valor > 0 -> println("Se ingresó un valor positivo")
            else -> println("Se ingresó un valor negativo")
        }
    }

    private fun proyecto21() {
        print("Ingrese un valor entero con 1, 2 o 3 cifras: ")
        val valor = readln().toInt()
        when {
            valor < 10 -> println("Tiene un dígito")
            valor < 100 -> println("Tiene dos dígitos")
            valor < 1000 -> println("Tiene tres dígitos")
            else -> println("Error en la entrada de datos.")
        }
    }

    private fun proyecto22() {
        print("Ingrese la cantidad total de preguntas del examen: ")
        val totalPreguntas = readln().toInt()
        print("Ingrese la cantidad total de preguntas contestadas correctamente: ")
        val totalCorrectas = readln().toInt()
        val porcentaje = totalCorrectas * 100 / totalPreguntas

        when {
            porcentaje >= 90 -> println("Nivel máximo")
            porcentaje >= 75 -> println("Nivel medio")
            porcentaje >= 50 -> println("Nivel regular")
            else -> println("Fuera de nivel")
        }
    }
}
