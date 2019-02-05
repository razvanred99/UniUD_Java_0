package ro.razvan.mirolo.first;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

final class Principale {

    private static int fibonacci(final int n) {

        if (n < 2)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static final double s0 = Math.pow(2, 0.25) * 100; //lato maggiore formato A0
    private static final double s1 = Math.pow(2, -0.25) * 100; // lato maggiore formato A1, il lato minore del formato A0

    private static double latoMaggiore(final int a) {
        if (a < 2) {
            return (a == 0) ? s0 : s1;
        }
        return latoMaggiore(a - 2) / 2;
    }

    @Contract(pure = true)
    private static char complementoBit(final char c) throws IllegalArgumentException {
        switch (c) {
            case '0':
                return '1';
            case '1':
                return '0';
        }

        throw new IllegalArgumentException("the input should be only 0 or 1");
    }

    /*
    Il metodo inverte tutti gli 0 e gli 1
     */
    private static String complementoA1(@NotNull final String bin) {

        if (bin.isEmpty()) {
            return bin;
        }

        return complementoBit(bin.charAt(0)) + complementoA1(bin.substring(1));
    }

    /*
    Stringa binaria successiva rispetto a quella data in input
     */
    static String nextBinString(@NotNull final String bin){
        if (bin.isEmpty()){
            return bin;
        }

        if(bin.length() == 1){
            return (bin.charAt(0) == '0') ? "1" : "10";
        }

        if (bin.charAt(bin.length() - 1) == '1'){
            return nextBinString(bin.substring(0, bin.length() - 1)) + '0';
        }

        return bin.substring(0, bin.length() -1) + '1';
    }

    @Contract(pure = true)
    private static int btdVal(final char c) throws IllegalArgumentException{

        switch(c){
            case '+': return 1;
            case '-': return -1;
            case '.': return 0;
        }

        throw new IllegalArgumentException();
    }

    static int btrVal(@NotNull final String btr){

        final char lsd = btr.charAt(btr.length() - 1);

        if (btr.isEmpty()){
            throw new IllegalArgumentException("btr should not be empty");
        }

        if(btr.length() == 1){
            return btdVal(lsd);
        }

        return 3 * btrVal(btr.substring(0, btr.length() - 1)) + btdVal(lsd);
    }

    static int btrValIterative(@NotNull final String btr){

        int sum = 0;

        for(int i = 0; i < btr.length(); i++){
            sum = sum * 3 + btdVal(btr.charAt(i));
        }

        return sum;
    }

}
