package proyectos

class Ej9 {
    fun main(argumento: Array<String>) {
        proyecto35()
        proyecto36()
        proyecto37()
        proyecto38()
        proyecto39()
        proyecto40()
        proyecto41()
    }

    private fun proyecto35() {
        var x = 1
        var conta1 = 0
        var conta2 = 0
        while (x <= 10) {
            print("Ingrese nota: ")
            val nota = readln().toInt()
            if (nota >= 7)
                conta1++
            else
                conta2++
            x++
        }
        println("Cantidad de alumnos con notas mayores o iguales a 7: $conta1")
        println("Cantidad de alumnos con notas menores a 7: $conta2")
    }

    private fun proyecto36() {
        print("¿Cuántas alturas ingresará?: ")
        val n = readln().toInt()
        var x = 1
        var suma = 0.0
        while (x <= n) {
            print("Ingrese la altura de la persona (Ej: 1.76): ")
            val altura = readln().toDouble()
            suma += altura
            x++
        }
        val promedio = suma / n
        println("Altura promedio: $promedio")
    }

    private fun proyecto37() {
        print("¿Cuántos empleados tiene la empresa?: ")
        val n = readln().toInt()
        var x = 1
        var conta1 = 0
        var conta2 = 0
        var gastos = 0.0
        while (x <= n) {
            print("Ingrese el sueldo del empleado: ")
            val sueldo = readln().toDouble()
            if (sueldo <= 300)
                conta1++
            else
                conta2++
            gastos += sueldo
            x++
        }
        println("Cantidad de empleados con sueldos menores o iguales a 300: $conta1")
        println("Cantidad de empleados con sueldos mayores a 300: $conta2")
        println("Gastos total de la empresa en sueldos: $gastos")
    }

    private fun proyecto38() {
        var termino = 11
        var x = 1
        while (x <= 25) {
            println(termino)
            termino += 11
            x++
        }
    }

    private fun proyecto39() {
        var mult8 = 8
        while (mult8 <= 500) {
            print("$mult8 - ")
            mult8 += 8
        }
        println() // Para un salto de línea al final
    }

    private fun proyecto40() {
        var x = 1
        var suma1 = 0
        println("Ingreso de la primera lista de valores")
        while (x <= 5) {
            print("Ingrese valor: ")
            val valor = readln().toInt()
            suma1 += valor
            x++
        }
        println("Ingreso de la segunda lista de valores")
        x = 1
        var suma2 = 0
        while (x <= 5) {
            print("Ingrese valor: ")
            val valor = readln().toInt()
            suma2 += valor
            x++
        }
        when {
            suma1 > suma2 -> println("Lista 1 mayor.")
            suma2 > suma1 -> println("Lista 2 mayor.")
            else -> println("Listas iguales.")
        }
    }

    private fun proyecto41() {
        var pares = 0
        var impares = 0
        print("¿Cuántos números ingresará?: ")
        val n = readln().toInt()
        var x = 1
        while (x <= n) {
            print("Ingrese el valor: ")
            val valor = readln().toInt()
            if (valor % 2 == 0)
                pares++
            else
                impares++
            x++
        }
        println("Cantidad de pares: $pares")
        println("Cantidad de impares: $impares")
    }
}
