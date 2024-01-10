package org.example


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */

fun despesaFixa():Int{
    val manteniment = 6
    return manteniment
}
/*fun tipusCarnet() {
    do {
        var control:Boolean = true
        println("Tens carnet de '${YELLOW_UNDERLINED}Familia nombrosa$RESET' o de '${BLUE_UNDERLINED}Familia monoparental$RESET'? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET ")
        var tipusCarnet = llegirChar().uppercaseChar()
        if (tipusCarnet == 'S') {
            println("En concret quin tipus de carnet tens? Escriu '${YELLOW_UNDERLINED}N$RESET' per '${YELLOW_UNDERLINED}Familia nombrosa$RESET' i '${BLUE_BOLD_BRIGHT}M$RESET' per '${BLUE_UNDERLINED}Familia monoparental$RESET'")
            var tipusConcretCarnet = llegirChar().uppercaseChar()
            control = false
        } else if (tipusCarnet == 'N') {
            println("Gracies per la informació! ${BLUE_BOLD_BRIGHT}=)$RESET ")
            control = false
        } else
            println("ERROR")
    }while (control)
}*/
fun preuLlitresMensuals(pMissatgeEntrada:String) : Double {
    println(pMissatgeEntrada)
    var lectorLlitres:Int = llegirInt()
    var preuAigua = when {
        lectorLlitres < 50 -> lectorLlitres * 0.00
        lectorLlitres <= 200 -> lectorLlitres * 0.15
        else -> lectorLlitres * 0.30
    }
return preuAigua
}

fun comprobacioBoSocial(pMissatgeEntrada:String) : Boolean {
    println(pMissatgeEntrada)
    var lecturaBoSocial= llegirChar().uppercaseChar()
    return lecturaBoSocial =='S'
}

fun comprobacioCarnet(pMissatgeEntrada: String) : Boolean {
    println(pMissatgeEntrada)
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
fun calculDescompte(pBoSocial:Boolean, pCarnetFNM:Boolean){

}
fun facturaCompleta(){
    var calculFactura= despesaFixa() + preuLlitresMensuals("Cuants litres d'aigua has consumit aquest mes?")
    println("La teva factura es de $calculFactura")
}