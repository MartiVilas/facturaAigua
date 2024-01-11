package org.example

import java.awt.CardLayout
import java.time.temporal.IsoFields


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */

fun despesaFixa(comprobacioBoSocial:Boolean):Int{
    return if (comprobacioBoSocial()){
        3
    } else 6
}
fun cuantitatLlitresMensuals(): Int {
    println("Quina és la quantitat de ${YELLOW_UNDERLINED}litres${RESET} que has gastat en aquest mes?")
    return llegirInt()
}
fun preuLlitresMensuals(cuantitatLlitresMensuals:Int) : Double {
    val cuantitat = cuantitatLlitresMensuals()

    val preuAigua = when (cuantitat) {
        50 -> cuantitat * 0.00
        in 50..200 -> cuantitat * 0.15
        else -> cuantitat * 0.30
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
fun preguntaTipusCarnet(comprobacioCarnet:Boolean,familiaMonoparental:Double,familiaNombrosa:Double): Boolean {
    println("Quin tipus de carnet tens? 1. Per marcar monoparental 2. Per marcar família nombrosa")
    val tipusCarnet = llegirEntre1o2()

    if (comprobacioCarnet()) {
        when (tipusCarnet) {
            1 -> {
                familiaMonoparental()
            }
            2 -> {
                familiaNombrosa()
            }
            else -> {
                println("ERROR, has de seleccionar entre 1 o 2")
                return false
            }
        }
        return true
    }
    return false
}
fun familiaNombrosa() :Double {
    var descompte = 0.0
    val familiaNombrosa = llegirSioNo()
    descompte = if (familiaNombrosa){
        0.50
    } else 0.0
    return descompte
}
fun familiaMonoparental(): Double {
    println("Sent part d'una familia monoparental, cuants membres de la familia sou?")
    val cuantitatFills = llegirInt()

    return when (cuantitatFills) {
        0 -> {
            println("ERROR, ha de haber al menys 1 integrant de la familia")
            0.0
        }
        1 -> 0.1
        2 -> 0.2
        3 -> 0.3
        4 -> 0.4
        5 -> 0.5
        else -> 0.5
    }
}
fun comprobacioBoSocial() : Boolean {
    println("Tens bo social? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET")
    val lecturaBoSocial= llegirSioNo()
    if (lecturaBoSocial){
        println("Té bo social")
    } else println("No té bo social")
    return lecturaBoSocial
}
fun calculDescompte(comprobacioCarnet:Boolean, preuLlitresMensuals:Double): Double {
    val tipusCarnet = preguntaTipusCarnet(comprobacioCarnet(), familiaNombrosa(), familiaMonoparental())
    val calcDescompte = when {
        comprobacioBoSocial() -> preuLlitresMensuals(cuantitatLlitresMensuals()) * 0.80
        tipusCarnet -> preuLlitresMensuals(cuantitatLlitresMensuals()) * 0.50
        else -> preuLlitresMensuals(cuantitatLlitresMensuals()) * 1.0
    }
    return calcDescompte
}
fun calculFactura() : Double {
    val resta= preuLlitresMensuals(cuantitatLlitresMensuals())- calculDescompte(comprobacioCarnet(), preuLlitresMensuals(cuantitatLlitresMensuals()))
    return resta
}
fun facturaCompleta() {

    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}FACTURA DE L'AIGUA${RESET}")
    println("DESPESA FIXA: ${RED_UNDERLINED}${despesaFixa(comprobacioBoSocial())}${RESET}")
    println("CUANTITAT LLITRES GASTATS ${YELLOW_BOLD}${cuantitatLlitresMensuals()}${RESET}")
    println("EL COST DE LLITRES HA SIGUT DE ${GREEN_BOLD}${preuLlitresMensuals(cuantitatLlitresMensuals())}${RESET}")
    println("DESCOMPTE APLICAT A LA FACTURA DEL AIGUA ${GREEN_BOLD}${calculDescompte(comprobacioCarnet(), preuLlitresMensuals(cuantitatLlitresMensuals()))}${RESET}")
    println("${CYAN}-----------------------------------------------------${RESET}")
    println("${RED}TOTAL:                                         ${calculFactura()}${RESET}")
}

/*
fun mostrarDesglossament(costTotal: Double, quotaFixa: Double, litresConsumits: Int, quotaVariable: Double) {
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}Desglossament de la factura d'aigua:${RESET}")
    println("${GREEN}Quota Fixa: ${RESET}$quotaFixa €")
    println("${GREEN}Consum (${litresConsumits} litres): ${RESET}$quotaVariable €")
    println("${YELLOW}------------------------------------------------------------- $RESET")
    println("${RED}Import Total: ${RESET}$costTotal €")
}*/
