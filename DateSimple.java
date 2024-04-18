public class DateSimple {
    public static void main(String[] args) {
        int fromy = 2000, fromm = 1, fromd = 1;
        int toy = 2127, tom = 12, tod = 31;

        System.out.println("**** Original\n" +
                "From " + fromy + "/" + fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod);

        int period = 0;
        // Pack 6 numbers into 'period'
        period |= (fromy - 2000) << 25;  // Year (7 bits)
        System.out.println("Period after packing fromy: " + Integer.toBinaryString(period));
        period |= fromm << 21;           // Month (4 bits)
        System.out.println("Period after packing fromm: " + Integer.toBinaryString(period));
        period |= fromd << 16;           // Day (5 bits)
        System.out.println("Period after packing fromd: " + Integer.toBinaryString(period));
        period |= (toy - 2000) << 9;     // Year (7 bits)
        System.out.println("Period after packing toy: " + Integer.toBinaryString(period));
        period |= tom << 5;              // Month (4 bits)
        System.out.println("Period after packing tom: " + Integer.toBinaryString(period));
        period |= tod;                   // Day (5 bits)
        System.out.println("Period after packing tod: " + Integer.toBinaryString(period));

        System.out.println("\nPacked period: " + period);

        fromy = fromm = fromd = toy = tom = tod = 0;

        // Unpack 6 numbers from 'period'
        tod = period & 0x1F;             // Day (5 bits)
        System.out.println("\nUnpacked tod: " + tod);
        tom = (period >> 5) & 0xF;       // Month (4 bits)
        System.out.println("Unpacked tom: " + tom);
        toy = ((period >> 9) & 0x7F) + 2000;  // Year (7 bits)
        System.out.println("Unpacked toy: " + toy);
        fromd = (period >> 16) & 0x1F;   // Day (5 bits)
        System.out.println("Unpacked fromd: " + fromd);
        fromm = (period >> 21) & 0xF;    // Month (4 bits)
        System.out.println("Unpacked fromm: " + fromm);
        fromy = ((period >> 25) & 0x7F) + 2000;  // Year (7 bits)
        System.out.println("Unpacked fromy: " + fromy);

        System.out.println("\n**** Reconstructed\n" +
                "From " + fromy + "/" + fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod);
    }
}
