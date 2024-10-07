package proyectos

class Ej11 {

    fun proyecto52() {
        var cantidad = 0
        print("Cuantos triángulos procesará: ")
        val n = readln().toInt()
        for (i in 1..n) {
            print("Ingrese el valor de la base: ")
            val base = readln().toInt()
            print("Ingrese el valor de la altura: ")
            val altura = readln().toInt()
            val superficie = base * altura / 2
            println("La superficie es de $superficie")
            if (superficie > 12) cantidad++
        }
        println("La cantidad de triángulos con superficie superior a 12 son: $cantidad")
    }

    fun proyecto53() {
        var suma = 0
        for (i in 1..10) {
            print("Ingrese un valor entero: ")
            val valor = readln().toInt()
            if (i > 5) suma += valor
        }
        println("La suma de los últimos 5 valores es: $suma")
    }

    fun proyecto54() {
        for (tabla5 in 5..50 step 5) println(tabla5)
    }

    fun proyecto55() {
        print("Ingrese un valor entre 1 y 10: ")
        val valor = readln().toInt()
        for (i in valor..valor * 12 step valor) println(i)
    }

    fun proyecto56() {
        var cant1 = 0
        var cant2 = 0
        var cant3 = 0
        print("Ingrese la cantidad de triángulos: ")
        val n = readln().toInt()
        for (i in 1..n) {
            print("Ingrese lado 1: ")
            val lado1 = readln().toInt()
            print("Ingrese lado 2: ")
            val lado2 = readln().toInt()
            print("Ingrese lado 3: ")
            val lado3 = readln().toInt()
            if (lado1 == lado2 && lado1 == lado3) {
                println("Es un triángulo equilátero.")
                cant1++
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                println("Es un triángulo isósceles.")
                cant2++
            } else {
                println("Es un triángulo escaleno.")
                cant3++
            }
        }
        println("Cantidad de triángulos equiláteros: $cant1")
        println("Cantidad de triángulos isósceles: $cant2")
        println("Cantidad de triángulos escalenos: $cant3")
    }

    fun proyecto57() {
        var cant1 = 0
        var cant2 = 0
        var cant3 = 0
        var cant4 = 0
        print("Cantidad de puntos a ingresar: ")
        val cantidad = readln().toInt()
        for (i in 1..cantidad) {
            print("Ingrese coordenada x: ")
            val x = readln().toInt()
            print("Ingrese coordenada y: ")
            val y = readln().toInt()
            when {
                x > 0 && y > 0 -> cant1++
                x < 0 && y > 0 -> cant2++
                x < 0 && y < 0 -> cant3++
                x > 0 && y < 0 -> cant4++
            }
        }
        println("Cantidad de puntos en el primer cuadrante: $cant1")
        println("Cantidad de puntos en el segundo cuadrante: $cant2")
        println("Cantidad de puntos en el tercer cuadrante: $cant3")
        println("Cantidad de puntos en el cuarto cuadrante: $cant4")
    }

    fun proyecto58() {
        var negativos = 0
        var positivos = 0
        var mult15 = 0
        var sumapares = 0
        for (i in 1..10) {
            print("Ingrese valor: ")
            val valor = readln().toInt()
            if (valor < 0) negativos++
            else if (valor > 0) positivos++
            if (valor % 15 == 0) mult15++
            if (valor % 2 == 0) sumapares += valor
        }
        println("Cantidad de valores negativos: $negativos")
        println("Cantidad de valores positivos: $positivos")
        println("Cantidad de valores múltiplos de 15: $mult15")
        println("Suma de los valores pares: $sumapares")
    }

    fun ejecutar() {
        do {
            println("Elija el proyecto a ejecutar (52, 53, 54, 55, 56, 57 o 58) o ingrese 0 para salir:")
            val opcion = readln().toInt()
            when (opcion) {
                52 -> proyecto52()
                53 -> proyecto53()
                54 -> proyecto54()
                55 -> proyecto55()
                56 -> proyecto56()
                57 -> proyecto57()
                58 -> proyecto58()
                0 -> println("Saliendo...")
                else -> println("Opción no válida, intente de nuevo.")
            }
        } while (opcion != 0)
    }
}

fun main() {
    val ej = Ej11()
    ej.ejecutar()
}
