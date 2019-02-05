package ro.razvan.mirolo.first;

import org.junit.Test;
import static ro.razvan.mirolo.first.Principale.btrVal;
import static ro.razvan.mirolo.first.Principale.nextBinString;
import static ro.razvan.mirolo.first.Principale.btrValIterative;

public class PrincipaleTest {

    @Test
    public void btrConversion(){

        final int result = 42;
        final int btrVal = btrVal("+---.");

        assert btrVal == result : String.format("comparing %d to %d", btrVal, result);
    }

    @Test
    public void nextBin(){
        assert nextBinString("0").compareTo("1") == 0;
        assert nextBinString("1").compareTo("10") == 0;
        assert nextBinString("10").compareTo("11") == 0;
        assert nextBinString("111").compareTo("1000") == 0;
    }

    @Test
    public void btrConversionIterative(){
        final String input = "-++--..--";
        assert btrVal(input) == btrValIterative(input);
    }

}
