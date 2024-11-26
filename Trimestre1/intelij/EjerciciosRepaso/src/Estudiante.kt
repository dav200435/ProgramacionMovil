class Estudiante(var nombre: String, var nota: Int) {
    fun actualizarNota(nuevaNota: Int) {
        nota = nuevaNota
    }

    fun obtenerCalificacion(): String {
        return when {
            nota < 5 -> "Suspenso"
            nota in 5..6 -> "Aprobado"
            nota in 7..8 -> "Notable"
            else -> "Sobresaliente"
        }
    }
}

fun gestionDeNotas() {
    val estudiantes = listOf(
        Estudiante("Ana", 7),
        Estudiante("Luis", 5),
        Estudiante("Carlos", 8),
        Estudiante("Maria", 9)
    )

    estudiantes.forEach {
        println("Estudiante: ${it.nombre}, Nota: ${it.nota}, Calificación: ${it.obtenerCalificacion()}")
    }
}

fun main(){
    gestionDeNotas()

}