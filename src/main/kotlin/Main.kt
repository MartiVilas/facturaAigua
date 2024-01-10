package org.example

fun main() {

    var litres = preuLlitresMensuals("Cuants litres d'aigua has consumit aquest mes?")
    var boSocial= comprobacioBoSocial("Tens bo social? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET")
    var carnetSocial= comprobacioCarnet("Tens carnet de '${YELLOW_UNDERLINED}Familia nombrosa$RESET' o de '${BLUE_UNDERLINED}Familia monoparental$RESET'? Escriu 'S' per a $GREEN_BOLD_BRIGHT'Sí'$RESET i 'N' per a $RED_BOLD_BRIGHT'No'$RESET ")
    var calcDescompte= calculDescompte(boSocial, carnetSocial)

}