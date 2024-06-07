package iut.sae.algo;


public class Simplicite{


    /* Méthode RLE simplicité
     * 
     * Avec un String builder, plutôt que de concaténer des chaînes de caractères
     */
    public static String RLE(String in) {
        // On vérifie si la chaîne d'entrée est vide
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder chaineFinale = new StringBuilder();
        int cpt = 1;

        // On parcourt la chaîne d'entrée en partant de la deuxième lettre
        for (int i = 1; i < in.length(); i++) {
            // Si le caractère actuel est le même que le précédent on augemente le compteur
            if (in.charAt(i) == in.charAt(i - 1)) {
                cpt++;
            } else {
                // On ajoute le caractère et le nombre de répétitions à la chaîne finale
                chaineFinale.append(cpt);
                chaineFinale.append(in.charAt(i - 1));
                // On réinitialise le compteur
                cpt = 1;
            }
        }

        // On ajoute le dernier groupe de caractères car la boucle s'arrête avant
        chaineFinale.append(cpt);
        chaineFinale.append(in.charAt(in.length() - 1));
        
        // Et on retourne la chaîne finale
        return chaineFinale.toString();
    }
    

    public static String RLE(String in, int iteration) throws AlgoException {
        // On vérifie si la chaîne d'entrée est vide
        if (in == null || in.isEmpty()) {
            return "";
        }

        // On vérifie si l'itération est valide
        if (iteration < 1) {
            throw new AlgoException("L'itération doit être supérieure à 0");
        }

        // On fait l'itération
        for (int i = 0; i < iteration; i++) {
            in = RLE(in);
        }

        return in;
    }

    

    public static String unRLE(String in) throws AlgoException {
        // On vérifie si la chaîne d'entrée est vide ou nulle
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder chaineFinale = new StringBuilder(); // Chaîne finale
        StringBuilder chaineNombre = new StringBuilder(); // Chaîne de nombre
        int cpt = 0; // Compteur de répétitions


        // On parcourt la chaîne d'entrée
        for (int i = 0; i < in.length(); i++) {
            char actuel = in.charAt(i); // Caractère actuel

            // On regarde si le caractère actuel est un chiffre et si oui on l'ajoute à la chaîne de nombre
            if (Character.isDigit(actuel)) {
                chaineNombre.append(actuel);
            } else {
                // Si la chaîne de nombre n'est pas vide
                if (chaineNombre.length() > 0) {
                    // On convertit la chaîne de nombre en entier (le nombre de répétitions)
                    cpt = Integer.parseInt(chaineNombre.toString());

                    // On ajoute le caractère (cpt) fois à la chaîne finale
                    for (int j = 0; j < cpt; j++) {
                        chaineFinale.append(actuel);
                    }

                    // On réinitialise le compteur et la chaîne de nombre
                    cpt = 0;
                    chaineNombre.setLength(0);
                }
            }
        }

        // On retourne la chaîne finale
        return chaineFinale.toString();

    }



    public static String unRLE(String in, int iteration) throws AlgoException {
        // On vérifie si la chaîne d'entrée est vide
        if (in == null || in.isEmpty()) {
            return "";
        }

        // On vérifie si l'itération est valide
        if (iteration < 1) {
            throw new AlgoException("L'itération doit être supérieure à 0");
        }


        StringBuilder chaineFinale = new StringBuilder(); // Chaîne finale
        StringBuilder chaineNombre = new StringBuilder(); 
        int cpt = 0; // Compteur de répétitions

        for (int i = 0; i < in.length(); i++) {
            char actuel = in.charAt(i); // Caractère actuel

            // On regarde si le caractère actuel est un chiffre et si le caractère suivant est un chiffre
            // Si c'est le cas, on augmente i de 1 pour sauter le caractère suivant 
            if (Character.isDigit(actuel) && Character.isDigit(in.charAt(i + 1))) {
                i++;
            } else if (Character.isDigit(actuel)) {
                chaineNombre.append(actuel);
            } else {
                // Si la chaîne de nombre n'est pas vide
                if (chaineNombre.length() > 0) {
                    // On convertit la chaîne de nombre en entier (le nombre de répétitions)
                    cpt = Integer.parseInt(chaineNombre.toString());

                    // On ajoute le caractère (cpt) fois à la chaîne finale
                    for (int j = 0; j < cpt; j++) {
                        chaineFinale.append(actuel);
                    }

                    // On réinitialise le compteur et la chaîne de nombre
                    cpt = 0;
                    chaineNombre.setLength(0);
                }
            }

        }

        return chaineFinale.toString();
    }
}

