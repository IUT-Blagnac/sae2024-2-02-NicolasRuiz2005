# Attention le nom de la seconde méthode récursive change car la surcharge de méthode n'est pas possible en python

def RLE(input):
    if input == "":
        return input
    
    cpt = 1
    chaine_compressee = ""
    length = len(input)

    i = 0
    
    while i < length:
        if i != length - 1:
            if input[i] == input[i + 1]:
                cpt += 1
                if cpt == 9:
                    chaine_compressee += str(cpt) + input[i]
                    cpt = 1
                    i += 1
            else:
                chaine_compressee += str(cpt) + input[i]
                cpt = 1
        else:
            chaine_compressee += str(cpt) + input[i]
        i += 1
    
    return chaine_compressee




def RLE_recursive(input, iteration):

    if input == "" or iteration == 0:
        return input
    
    if iteration <= 0:
        raise "Le nombre d'itérations ne peut pas être négatif ou nul !"

    

    cpt = 1
    chaine_compressee = ""
    length = len(input)

    i = 0
    
    while i < length:
        if i != length - 1:
            if input[i] == input[i + 1]:
                cpt += 1
                if cpt == 9:
                    chaine_compressee += str(cpt) + input[i]
                    cpt = 1
                    i += 1
            else:
                chaine_compressee += str(cpt) + input[i]
                cpt = 1
        else:
            chaine_compressee += str(cpt) + input[i]
        i += 1
    
    return RLE_recursive(chaine_compressee, iteration - 1)
