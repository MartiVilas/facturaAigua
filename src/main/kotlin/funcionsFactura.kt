package org.example


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */

fun despesaFixa(boSocial:Boolean):Int{
    return if (boSocial){
        3
    } else 6
}
fun cuantitatLlitresMensuals(): Int {
    println("Quina és la quantitat de ${YELLOW_UNDERLINED}litres${RESET} que has gastat en aquest mes?")
    return llegirInt()
}
fun preuLlitresMensuals(cuantitatLlitres:Int) : Double {

    val preuAigua = when (cuantitatLlitres) {
        50 -> cuantitatLlitres * 0.00
        in 50..200 -> cuantitatLlitres * 0.15
        else -> cuantitatLlitres * 0.30
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
fun familiaNombrosa() :Double {
    println("Ets part d'una familia nombrosa? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET\"")
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
fun preguntaTipusCarnet(comprobacioCarnet:Boolean): Boolean {
    println("Quin tipus de carnet tens? 1. Per marcar monoparental 2. Per marcar família nombrosa")
    val tipusCarnet = llegirEntre1o2()

    if (comprobacioCarnet) {
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

fun comprobacioBoSocial() : Boolean {
    println("Tens bo social? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET")
    val lecturaBoSocial= llegirSioNo()
    if (lecturaBoSocial){
        println("Té bo social")
    } else println("No té bo social")
    return lecturaBoSocial
}
fun calculDescompte(comprobacioCarnet:Boolean, preuLlitres:Double, familiaNombrosa: Double,familiaMonoparental: Double): Double {
    val tipusCarnet = preguntaTipusCarnet(comprobacioCarnet)
    val calcDescompte = when {
        comprobacioCarnet -> preuLlitres * 0.80
        tipusCarnet -> preuLlitres * 0.50
        else -> preuLlitres * 1.0
    }
    return calcDescompte
}
fun calculFactura(preuLlitres: Double, calculDescompte : Double) : Double {
    val resta = preuLlitres - calculDescompte
    return resta
}
fun facturaCompleta() {
    val boSocial= comprobacioBoSocial()
    val despesaFixa= despesaFixa(boSocial)
    val cuantitatLlitres= cuantitatLlitresMensuals()
    val nombrosa= familiaNombrosa()
    val monoparental= familiaMonoparental()
    val preuLlitres= preuLlitresMensuals(cuantitatLlitres)
    val carnet= comprobacioCarnet()
    val descompte= calculDescompte(carnet, preuLlitres, monoparental, nombrosa)
    val factura= calculFactura(preuLlitres,descompte)


    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}FACTURA DE L'AIGUA${RESET}")
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}DESPESA FIXA:${RESET} ${RED_UNDERLINED}${despesaFixa}${RESET}")
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}CUANTITAT LLITRES GASTATS${RESET} ${YELLOW_BOLD}${cuantitatLlitres}${RESET}")
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}EL COST DE LLITRES HA SIGUT DE: ${RESET} ${GREEN_BOLD}${preuLlitres}${RESET}")
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}DESCOMPTE APLICAT A LA FACTURA DEL AIGUA${RESET} ${GREEN_BOLD}${descompte}${RESET}")
    println("${CYAN}--------------------------------------------------${RESET}")
    println("${RED_BOLD}TOTAL:                                         ${factura}${RESET}")
}

/*
fun mostrarDesglossament(costTotal: Double, quotaFixa: Double, litresConsumits: Int, quotaVariable: Double) {
    println("${WHITE_BACKGROUND_BRIGHT}${BLACK_BOLD}Desglossament de la factura d'aigua:${RESET}")
    println("${GREEN}Quota Fixa: ${RESET}$quotaFixa €")
    println("${GREEN}Consum (${litresConsumits} litres): ${RESET}$quotaVariable €")
    println("${YELLOW}------------------------------------------------------------- $RESET")
    println("${RED}Import Total: ${RESET}$costTotal €")
}*/
