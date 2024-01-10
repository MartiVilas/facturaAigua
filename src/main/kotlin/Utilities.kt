package org.example
import java.util.Scanner

fun llegirSioNo() : Boolean {
    var scanner=Scanner(System.`in`)
    val resposta=scanner.nextLine().lowercase()

    return when (resposta) {
        "si", "sí" -> true
        "no" -> false
        else -> {
            println("Resposta no vàlida la resposta ha de ser Si o No")
            llegirSioNo()
        }
    }
}