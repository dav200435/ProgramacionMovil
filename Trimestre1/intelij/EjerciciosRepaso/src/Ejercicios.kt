class ejercicios {
    fun calculadoraBasica() {
        print("Ingresa el primer número: ")
        val num1 = readLine()?.toIntOrNull() ?: return
        print("Ingresa el segundo número: ")
        val num2 = readLine()?.toIntOrNull() ?: return
        print("Elige una operación (+, -, *, /): ")
        val operacion = readLine()

        val resultado = when (operacion) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0) num1 / num2 else "Error: División entre cero"
            else -> "Operación no válida"
        }
        println("Resultado: $resultado")
    }

    fun clasificacionPorEdades() {
        print("Ingresa tu edad: ")
        val edad = readLine()?.toIntOrNull() ?: return

        val categoria = when {
            edad < 12 -> "Infantil"
            edad in 12..17 -> "Adolescente"
            edad in 18..64 -> "Adulto"
            else -> "Mayor"
        }
        println("Categoría de edad: $categoria")
    }

    fun generadorNumerosPares() {
        print("Ingresa un número: ")
        val numero = readLine()?.toIntOrNull() ?: return

        var contador = 0
        while (contador <= numero) {
            if (contador % 2 == 0) {
                println(contador)
            }
            contador++
        }
    }

    fun clasificarCalificacion() {
        print("Ingresa una calificación entre 0 y 10: ")
        val calificacion = readLine()?.toIntOrNull() ?: return

        val resultado = when {
            calificacion !in 0..10 -> "Calificación fuera de rango"
            calificacion < 5 -> "Suspenso"
            calificacion in 5..6 -> "Aprobado"
            calificacion in 7..8 -> "Notable"
            else -> "Sobresaliente"
        }
        println("Resultado: $resultado")
    }
    fun calcularFactorial(numero: Int): Int {
        return if (numero == 0) 1 else numero * calcularFactorial(numero - 1)
    }

    fun factorial() {
        print("Ingresa un número para calcular su factorial: ")
        val numero = readLine()?.toIntOrNull() ?: return
        val resultado = calcularFactorial(numero)
        println("El factorial de $numero es $resultado")
    }
    import kotlin.random.Random

    fun juegoAdivinanza() {
        val numeroAleatorio = Random.nextInt(1, 101)
        var intento: Int
        do {
            print("Adivina el número (entre 1 y 100): ")
            intento = readLine()?.toIntOrNull() ?: continue
            when {
                intento < numeroAleatorio -> println("El número es mayor")
                intento > numeroAleatorio -> println("El número es menor")
                else -> println("¡Correcto! Adivinaste el número.")
            }
        } while (intento != numeroAleatorio)
    }


}