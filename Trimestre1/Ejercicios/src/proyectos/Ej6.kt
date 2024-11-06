package proyectos

class Ej6 {
    fun main(parametro: Array<String>) {
        print("Ingrese un valor entero comprendido entre 1 y 99:")
        val valor=readln().toInt()
        var cantidad = if (valor <10) 1 else 2
        println("El número $valor tiene $cantidad dígito/s")
    }
}