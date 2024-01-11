package org.example
import java.util.Scanner

/**
 * Aquest document està destinat a emmagatzemar funcions generals que puguin ser utilitzades en diferents projectes.
 * @author Martí Vilàs
 */
fun llegirSioNo() : Boolean {
    var scanner=Scanner(System.`in`)
    val resposta=scanner.nextLine().lowercase()

    return when (resposta) {
        "s" -> true
        "n" -> false
        else -> {
            println("Resposta no vàlida la resposta ha de ser S o N")
            llegirSioNo()
        }
    }
}
fun llegirEntre1o2(): Int {
    val scanner = Scanner(System.`in`)
    var numero: Int = 0
    var error = true
    do {
        if (scanner.hasNextInt()) {
            numero = scanner.nextInt()
            if (numero in 1..2) {
                error = false
            } else {
                println("Per favor, ingressa un valor vàlid (1 o 2).")
            }
        } else {
            println("Per favor, ingressa un número enter.")
            scanner.nextLine()
        }
    } while (error)

    return numero
}