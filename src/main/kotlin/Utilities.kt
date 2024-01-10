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