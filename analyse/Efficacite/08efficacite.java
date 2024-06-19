package iut.sae.algo;


public class Algo{
    public static String RLE(String in){
        String message = in;
        char[] toChar = message.toCharArray();
        if (toChar.length == 0) return "";
        String terminal = "";
        char current = toChar[0];
        short amount = 0;
        for (char c : toChar){
            if (c != current){
                terminal = terminal + amount + current;
                amount = 0;
            }else{
                if (amount + 1 > 9){
                    terminal = terminal + amount + current;
                    amount = 0;
                }
            }
            amount += 1;
            current = c;
        }
        terminal = terminal + amount + current;
        return terminal;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        String returnString = in;
        for (int i = 0; i < iteration; i ++){
            returnString = RLE(returnString);
        }
        return returnString;
    }

    public static String unRLE(String in) throws AlgoException{
        String message = in;
        char[] toArray = message.toCharArray();
        String end = "";
        for (int i = 0; i < message.length(); i+=2){
          for (int j = 0; j < (int) toArray[i] - '0'; j++){
            end += toArray[i+1];
          }
        }
        return end;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        String returnString = in;
        for (int i = 0; i < iteration; i ++){
            returnString = unRLE(returnString);
        }
        return returnString;
    }
}

