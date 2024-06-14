package iut.sae.algo;

public class Simplicite {
    
    /* Méthode RLE simplicité
     * 
     */
    public static String RLE(String in) {
        // On vérifie si la chaîne d'entrée est vide ou null
        if (in == null || in.isEmpty()) {
            return "";
        }
    
        // Initialiser les variables
        char currentChar = in.charAt(0); 
        int cpt = 1;
        String result = "";
    
        // Parcourir le reste de la chaîne 
        for (int i = 1; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == currentChar) {
                // Même caractère, on incrémente le compteur
                cpt++;
                if (cpt == 10) {
                    // Limite de 9 atteinte, on écrit le bloc de 9
                    result += "9" + currentChar;
                    cpt = 1;
                }
            } else {
                // Caractère différent, on écrit le bloc précédent
                result += cpt + "" + currentChar;
                currentChar = c;
                cpt = 1;
            }
        }
    
        // Écrire le dernier bloc
        result += cpt + "" + currentChar;
        return result;
    }
    


    public static String RLE(String in, int iterations) throws AlgoException {
        // Vérifier les cas de base
        if (in == null || in.isEmpty()) {
            return "";
        }
    
        // Vérifier la validité des itérations
        if (iterations < 1) {
            throw new AlgoException("Le nombre d'itérations doit être supérieur à 0");
        }
    
        // Appliquer l'algorithme RLE autant de fois que le nombre d'itérations
        String result = in;
        for (int i = 0; i < iterations; i++) {
            result = RLE(result);
        }
    
        return result;
    }



    public static String unRLE(String in) throws AlgoException {
    // Vérifier les cas de base
    if (in == null || in.isEmpty()) {
        return "";
    }

    // Initialiser les variables
    char[] strTab = in.toCharArray(); // Convertir la chaîne en tableau de caractères
    String result = "";
    int cpt = 0;

    // Parcourir la chaîne d'entrée
    for (int i = 0; i < strTab.length; i++) {
        char c = strTab[i]; // Caractère courant
        if (Character.isDigit(c)) { // Vérifier si le caractère est un chiffre
            // Nombre de répétitions
            cpt = c - '0'; 
            i++; // Passer au caractère suivant
            char repeatChar = strTab[i];
            // Ajouter le caractère répété
            for (int j = 0; j < cpt; j++) {
                result += repeatChar;
            }
        }
    }

        return result;
    }

    public static String unRLE(String in, int iteration) throws AlgoException {
        // Appliquer l'algorithme unRLE autant de fois que le nombre d'itérations
        for (int i = 0; i < iteration; i++) {
            in = unRLE(in);
        }

        return in;
    }

}
