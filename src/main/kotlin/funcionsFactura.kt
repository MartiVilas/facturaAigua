package org.example

import java.time.temporal.IsoFields


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */

fun despesaFixa():Int{
    return if (comprobacioBoSocial()){
        3
    } else 6
}

fun cuantitatLlitresMensuals():Int{
    println("Quina es la cuantitat de ${YELLOW_UNDERLINED}llitres${RESET} que has gastat en aquest mes?")
    val cuantitat = llegirInt()
    return cuantitat
}
fun preuLlitresMensuals() : Double {
    println("Cuants litres d'aigua has consumit aquest mes?")
    val preuAigua = when {
        cuantitatLlitresMensuals()< 50 -> cuantitatLlitresMensuals() * 0.00
        cuantitatLlitresMensuals() <= 200 -> cuantitatLlitresMensuals() * 0.15
        else -> cuantitatLlitresMensuals() * 0.30
    }
return preuAigua
}
fun comprobacioCarnet() : Boolean {
    println("Tens carnet de '${YELLOW_UNDERLINED}Familia nombrosa$RESET' o de '${BLUE_UNDERLINED}Familia monoparental$RESET'? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET ")
    val tieneCarnet = llegirSioNo()
    var control = false
    if (tieneCarnet) {
        println("Té carnet")
        control = true
    } else {
        println("No té carnet.")
    }
    return control
}
fun preguntaTipusCarnet(): Boolean {
    println("Quin tipus de carnet tens? 1. Per marcar monoparental 2. Per marcar família nombrosa")
    val tipusCarnet = llegirEntre1o2()

    if (comprobacioCarnet()) {
        return when (tipusCarnet) {
            1 -> {
                familiaMonoparental()
                true
            }

            2 -> {
                familiaNombrosa()
                true
            }

            else -> {
                println("ERROR, has de seleccionar entre 1 o 2")
                false
            }
        }
    } else {
        return false
    }
}
fun familiaNombrosa() :Double {
    var descompte = 0.0
    val familiaNombrosa = llegirSioNo()
    descompte = if (familiaNombrosa){
        0.50
    } else 0.0
    return descompte
}
fun familiaMonoparental() : Double {
    println("Sent part d'una familia monoparental, cuants membres de la familia sou?")
    var descompte = 0.0
    val cuantitatFills= llegirInt()
    var variacioDescompte= when(cuantitatFills) {
        0-> println("ERROR, han d'haber minim 1 integrant de la familia")
        1-> descompte=0.1
        2-> descompte=0.2
        3-> descompte=0.3
        4-> descompte=0.4
        5-> descompte=0.5
        else -> descompte = 0.5
    }
    return descompte
}
fun comprobacioBoSocial() : Boolean {
    println("Tens bo social? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET")
    val lecturaBoSocial= llegirSioNo()
    if (lecturaBoSocial){
        println("Té bo social")
    } else println("No té bo social")
    return lecturaBoSocial
}
fun calculDescompte() : Double {
    val calcDescompte = when {
        comprobacioBoSocial() -> preuLlitresMensuals()*0.80
        preguntaTipusCarnet() -> preuLlitresMensuals()*0.50
        preguntaTipusCarnet() -> preuLlitresMensuals()* familiaMonoparental()
        else -> preuLlitresMensuals()*1.0
    }
    return calcDescompte
}
fun facturaCompleta(){
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}FACTURA DE L'AIGUA${RESET}")
    println("DESPESA FIXA: ${RED_UNDERLINED}${despesaFixa()}${RESET}")
    println("CUANTITAT LLITRES GASTATS ${YELLOW_BOLD}${cuantitatLlitresMensuals()}")
    println("EL COST DE LLITRES HA SIGUT DE ${GREEN_BOLD}${preuLlitresMensuals()}${RESET}")


}

/*
fun mostrarDesglossament(costTotal: Double, quotaFixa: Double, litresConsumits: Int, quotaVariable: Double) {
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}Desglossament de la factura d'aigua:${RESET}")
    println("${GREEN}Quota Fixa: ${RESET}$quotaFixa €")
    println("${GREEN}Consum (${litresConsumits} litres): ${RESET}$quotaVariable €")
    println("${YELLOW}------------------------------------------------------------- $RESET")
    println("${RED}Import Total: ${RESET}$costTotal €")
}*/
