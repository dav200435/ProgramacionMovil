package proyectos

class Ej4 {
    fun main(argumento: Array<String>) {
        proyecto8()
        proyecto9()
    }

    private fun proyecto8() {
        print("Ingrese primer valor: ")
        val v1 = readln().toInt()
        print("Ingrese segundo valor: ")
        val v2 = readln().toInt()
        print("Ingrese tercer valor: ")
        val v3 = readln().toInt()
        print("Ingrese cuarto valor: ")
        val v4 = readln().toInt()

        val suma = v1 + v2
        println("La suma de $v1 y $v2 es $suma")
        val producto = v3 * v4
        println("El producto de $v3 y $v4 es $producto")
    }

    private fun proyecto9() {
        print("Ingrese primer valor: ")
        val v1 = readln().toInt()
        print("Ingrese segundo valor: ")
        val v2 = readln().toInt()
        print("Ingrese tercer valor: ")
        val v3 = readln().toInt()
        print("Ingrese cuarto valor: ")
        val v4 = readln().toInt()

        val suma = v1 + v2 + v3 + v4
        println("La suma de los cuatro valores es $suma")
        val prom = suma / 4
        println("El promedio de los cuatro valores es $prom")
    }
}
