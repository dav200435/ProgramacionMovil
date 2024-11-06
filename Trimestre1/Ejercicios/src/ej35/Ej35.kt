package ej35

data class Articulo(val codigo: Int, val descripcion: String, var precio: Float)

fun imprimir(articulos: Array<Articulo>) {
    for(articulo in articulos)
        println("Código: ${articulo.codigo} - Descripción: ${articulo.descripcion} - Precio: ${articulo.precio}")
}

fun aumentarPrecio(articulos: Array<Articulo>, porcentaje: Float) {
    for(articulo in articulos)
        articulo.precio += (articulo.precio * porcentaje / 100)
}

fun main(parametro: Array<String>) {
    val articulos: Array<Articulo> = arrayOf(
        Articulo(1, "Papas", 7.5f),
        Articulo(2, "Manzanas", 23.2f),
        Articulo(3, "Naranjas", 12f),
        Articulo(4, "Cebolla", 21f)
    )

    println("Listado de precios actual:")
    imprimir(articulos)

    // Aumentar el precio en un 10%
    aumentarPrecio(articulos, 10f)

    println("\nListado de precios con aumento del 10%:")
    imprimir(articulos)
}
