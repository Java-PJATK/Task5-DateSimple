public class DatesSimple {
    public static void main (String[] args) {
        int fromy = 2000, fromm =  2, fromd =  3;
        int   toy = 2127,   tom = 11,   tod = 29;

        System.out.println("**** Original\n" +
                           "From " + fromy + "/" +
                           fromm + "/" + fromd + " to " +
                           toy + "/" + tom + "/" + tod);

        int period = 0;

        // ... (pack 6 numbers into 'period')

        fromy = fromm = fromd = toy = tom = tod = 0;

        // ... (unpack 6 numbers from 'period')

        System.out.println("**** Reconstructed\n" +
                           "From " + fromy + "/" +
                           fromm + "/" + fromd + " to " +
                           toy + "/" + tom + "/" + tod);
    }
}
