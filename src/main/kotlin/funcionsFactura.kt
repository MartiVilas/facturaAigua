package org.example


fun despesaFixa():Int{
    val manteniment = 6
    return manteniment
}
fun litresMensuals(pMissatgeEntrada:String) : Double {
    println(pMissatgeEntrada)
    var lectorLlitres= llegirInt()
    val primeraCategoria : Double = 0.00
    val segonaCategoria : Double = 0.15
    val tercerCategoria : Double = 0.30
    var calculPreu: Double
    var preuAigua : Double = 0.00


    if (lectorLlitres < 50){
        calculPreu = lectorLlitres * primeraCategoria
       preuAigua +=  calculPreu
    } else if (lectorLlitres > 50 && lectorLlitres < 200){
        calculPreu = lectorLlitres * segonaCategoria
        preuAigua  +=  calculPreu
    } else if (lectorLlitres > 200){
        calculPreu = lectorLlitres * tercerCategoria
        preuAigua  += calculPreu
    }

    println("El preu del teu consum d'aigua ha sigut de $preuAigua")
return preuAigua

}