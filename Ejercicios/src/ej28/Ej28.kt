package ej28

class Empleado(var nombre: String, sueldo: Double) {
    var sueldo: Double = 0.0
        set(valor) {
            field = if (valor < 0) 0.0 else valor
        }

    init {
        this.sueldo = sueldo
    }

    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

class Dado(valor: Int) {
    var valor: Int = 1
        set(valor) {
            field = if (valor in 1..6) valor else 1
        }

    init {
        this.valor = valor
    }

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    fun imprimir() = println("Valor del dado: $valor")
}

class Ej28 {
    fun gestionarEmpleadosYDados() {
        val empleado1 = Empleado("Juan", 12000.50)
        empleado1.imprimir()

        val empleado2 = Empleado("Ana", -1200.0)
        empleado2.imprimir()

        val dado1 = Dado(7)
        dado1.imprimir()
        dado1.tirar()
        dado1.imprimir()
    }
}

fun main(parametro: Array<String>) {
    val ej28 = Ej28()
    ej28.gestionarEmpleadosYDados()
}
