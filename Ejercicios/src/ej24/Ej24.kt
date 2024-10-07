class Alumno(val nombre: String, val nota: Int) {
    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    fun mostrarEstado() {
        if (nota >= 4) {
            println("$nombre se encuentra en estado REGULAR")
        } else {
            println("$nombre no está REGULAR")
        }
    }
}

class Punto(val x: Int, val y: Int) {
    fun retornarCuadrante() = when {
        x > 0 && y > 0 -> "Primer cuadrante"
        x < 0 && y > 0 -> "Segundo cuadrante"
        x < 0 && y < 0 -> "Tercer cuadrante"
        x > 0 && y < 0 -> "Cuarto cuadrante"
        else -> "En un eje"
    }
}

class Ej23 {
    fun gestionarAlumnos() {
        // Creación de alumnos con parámetros
        val alumno1 = Alumno("Ana", 7)
        alumno1.imprimir()
        alumno1.mostrarEstado()

        val alumno2 = Alumno("Carlos", 2)
        alumno2.imprimir()
        alumno2.mostrarEstado()
    }

    fun gestionarPuntos() {
        val punto1 = Punto(12, 3)
        println("La coordenada ${punto1.x}, ${punto1.y} se encuentra en ${punto1.retornarCuadrante()}")

        val punto2 = Punto(-4, 3)
        println("La coordenada ${punto2.x}, ${punto2.y} se encuentra en ${punto2.retornarCuadrante()}")

        val punto3 = Punto(-2, -2)
        println("La coordenada ${punto3.x}, ${punto3.y} se encuentra en ${punto3.retornarCuadrante()}")

        val punto4 = Punto(12, -5)
        println("La coordenada ${punto4.x}, ${punto4.y} se encuentra en ${punto4.retornarCuadrante()}")

        val punto5 = Punto(0, -5)
        println("La coordenada ${punto5.x}, ${punto5.y} se encuentra en ${punto5.retornarCuadrante()}")
    }
}

fun main(parametros: Array<String>) {
    val ej23 = Ej23()
    println("Gestión de Alumnos:")
    ej23.gestionarAlumnos()

    println("\nGestión de Puntos:")
    ej23.gestionarPuntos()
}
