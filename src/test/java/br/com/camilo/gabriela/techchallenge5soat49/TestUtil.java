package br.com.camilo.gabriela.techchallenge5soat49;

public class TestUtil {
    public static String generateValidCpf() {

        int n = 9;
        int n1 = randomNumber(n);
        int n2 = randomNumber(n);
        int n3 = randomNumber(n);
        int n4 = randomNumber(n);
        int n5 = randomNumber(n);
        int n6 = randomNumber(n);
        int n7 = randomNumber(n);
        int n8 = randomNumber(n);
        int n9 = randomNumber(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String res = null;

        if (d2 >= 10)
            d2 = 0;
        res = "";

        return "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;
    }

    private static int randomNumber(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private static int mod(int n1, int n2) {
        return (int) Math.round(n1 - (Math.floor(n1 / n2) * n2));
    }
}
