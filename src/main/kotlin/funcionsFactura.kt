package org.example


fun despesaFixa():Int{
    val manteniment = 6
    return manteniment
}
fun litresMensuals(pMissatgeEntrada:String) : Double {
    val primeraCategoria : Double = 0.00
    val segonaCategoria : Double = 0.15
    val tercerCategoria : Double = 0.30
    var calculPreu: Double
    var preuAigua : Double = 0.00

    if (llegirInt()<50){
        calculPreu= llegirInt() * primeraCategoria
        calculPreu += preuAigua
    } else if (llegirInt()>50 && llegirInt()>200){
        calculPreu= llegirInt() * segonaCategoria
        calculPreu += preuAigua
    } else if (llegirInt()>200){
        calculPreu= llegirInt() * tercerCategoria
        calculPreu += preuAigua
    }

return preuAigua
}