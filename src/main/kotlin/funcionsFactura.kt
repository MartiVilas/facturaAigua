package org.example


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */

fun despesaFixa():Int{
   if (comprobacioBoSocial()==true){
       return 6
   } else return 3
}
fun preuLlitresMensuals() : Double {
    println("Cuants litres d'aigua has consumit aquest mes?")
    val lectorLlitres:Int = llegirInt()
    val preuAigua = when {
        lectorLlitres < 50 -> lectorLlitres * 0.00
        lectorLlitres <= 200 -> lectorLlitres * 0.15
        else -> lectorLlitres * 0.30
    }
return preuAigua
}

fun comprobacioBoSocial() : Boolean {
    println("Tens bo social? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET")
    val lecturaBoSocial= llegirChar().uppercaseChar()
    if (lecturaBoSocial=='S'){
        println("Té bo social")
    } else println("No té bo social")
    return lecturaBoSocial =='S'
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
fun calculDescompte(pBoSocial:Boolean, pCarnetFNM:Boolean) : Double {
    val calcDescompte = when {
        comprobacioBoSocial() -> preuLlitresMensuals()*0.80
        comprobacioCarnet() -> preuLlitresMensuals()*0.50
        comprobacioCarnet() -> preuLlitresMensuals()* familiaMonoparental()
        else -> preuLlitresMensuals()*1.0
    }
    return calcDescompte
}
fun facturaCompleta(){
    val calculFactura= despesaFixa() + preuLlitresMensuals()
    println("La teva factura es de $calculFactura")
}