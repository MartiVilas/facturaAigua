package org.example


/**
 * Document kt dedicat a les funcions que s'utilitzaran per que el programa funcioni correctament, son totes les
 * funcions que hi ha en el document Main.kt
 * @author Martí Vilàs
 */
fun facturaCompleta(){
    var calculFactura= despesaFixa()+ litresMensuals()
}
fun despesaFixa():Int{
    val manteniment = 6
    return manteniment
}
fun litresMensuals() : Double {
    println("Cuants litres d'aigua has consumit aquest mes?")
    var lectorLlitres= llegirInt()
    val primeraCategoria : Double = 0.00
    val segonaCategoria : Double = 0.15
    val tercerCategoria : Double = 0.30
    var calculPreu : Double
    var preuAigua : Double = 0.00

    if (lectorLlitres < 50){
        calculPreu = lectorLlitres * primeraCategoria
    } else if (lectorLlitres >= 50 && lectorLlitres <= 200){
        calculPreu = lectorLlitres * segonaCategoria
    } else{
        calculPreu = lectorLlitres * tercerCategoria
    }
    preuAigua  += calculPreu
    println("El preu del teu consum d'aigua ha sigut de $preuAigua")
return preuAigua

}


fun tipusCarnet(){
    println("Tens carnet de '${YELLOW_UNDERLINED}Familia nombrosa$RESET' o de '${BLUE_UNDERLINED}Familia monoparental$RESET'? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET ")
    var tipusCarnet = llegirChar().uppercaseChar()
    if (tipusCarnet=='S'){
        println("En concret quin tipus de carnet tens? Escriu '${YELLOW_UNDERLINED}N$RESET' per '${YELLOW_UNDERLINED}Familia nombrosa$RESET' i '${BLUE_BOLD_BRIGHT}M$RESET' per '${BLUE_UNDERLINED}Familia monoparental$RESET'")
        var tipusConcretCarnet= llegirChar().uppercaseChar()
    }else if (tipusCarnet=='N'){
        println("")

    } else
        println("ERROR")
}
fun calculFamliaNombrosa(){

}