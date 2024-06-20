package iut.sae.algo;

public class Sobriete {
    public static String RLE(String in) {
        if (in.isEmpty())
            return "";
        StringBuilder result = new StringBuilder();
        int iteration = 1;
        for (int i = 1; i < in.length() && iteration < 9; i++) {
            if (in.charAt(i) == in.charAt(i - 1))
                iteration++;
            else {
                result.append(iteration).append(in.charAt(i - 1));
                iteration = 1;
            }
        }
        return result.append(iteration).append(in.charAt(in.length() - 1)).toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException {
        while (iteration > 0) {
            in = RLE(in);
            iteration--;
        }
        return in;
    }

    public static String unRLE(String in) throws AlgoException {
        StringBuilder result = new StringBuilder();
        int count;
        for (int i = 0; i < in.length(); i += 2) {
            count = in.charAt(i) - '0';
            result.append(String.valueOf(in.charAt(i + 1)).repeat(count));
        }
        return result.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException {
        while (iteration > 0) {
            in = unRLE(in);
            iteration--;
        }
        return in;
    }
}
