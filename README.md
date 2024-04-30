# Task5-DateSimple

https://github.com/Java-PJATK/Task5-DateSimple/blob/main/ppj05E.pdf

April 18, 2024

# Task 5

A date may be specified by three numbers denoting year, month and day of month.
If we don't need dates from a deep past, we can specify years relative to the year
2000 (e.g., year 2032 as 32). Assuming that we will not consider the future past the
year 2127, we can use numbers from the interval [0, 127] for year; such numbers can
be written on 7 bits. Month number can occupy 4 bits, as it belongs to the interval
[0, 15], and for the day we can spend 5 bits (which is enough to store any number
from the interval [0, 31]). Therefore, full date can be packed in 16 bits and we can
store two such dates in one 32-bit int (e.g., beginning and end of a period).
Write a program which defines two dates (from and to), each as three integers (year,
month, day). Pack them into one integer. Then unpack the integer and recover these
six numbers.

For example, the following program:

```java
public class DatesSimple {
    public static void main (String[] args) {
        int   fromy = 2000, fromm   = 2, fromd  = 3;
        int     toy = 2127,     tom = 11, tod   = 29;

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
```
should print

```
**** Original
From 2000/2/3 to 2127/11/29
**** Reconstructed
From 2000/2/3 to 2127/11/29
```

Deadline: Apr 30 (inclusive)

---

```java
// https://www.geeksforgeeks.org/bitwise-operators-in-java/

public class DateSimple {
    public static void main(String[] args) {
        int fromy = 2024, fromm = 4, fromd = 18;
        int toy = 2024, tom = 4, tod = 30;

        System.out.println("**** Original\n" +
                "From " + fromy + "/" + fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod + "\n");

        int period = 0;

        // Pack 6 numbers into 'period'
        period |= (fromy - 2000) << 25; // Year (7 bits)
        System.out.println("Period after packing fromy: " + Integer.toBinaryString(period));
        period |= fromm << 21; // Month (4 bits)
        System.out.println("Period after packing fromm: " + Integer.toBinaryString(period));
        period |= fromd << 16; // Day (5 bits)
        System.out.println("Period after packing fromd: " + Integer.toBinaryString(period));
        period |= (toy - 2000) << 9; // Year (7 bits)
        System.out.println("Period after packing toy: " + Integer.toBinaryString(period));
        period |= tom << 5; // Month (4 bits)
        System.out.println("Period after packing tom: " + Integer.toBinaryString(period));
        period |= tod; // Day (5 bits)
        System.out.println("Period after packing tod: " + Integer.toBinaryString(period));

        System.out.println("\nPacked period: " + period);

        fromy = fromm = fromd = toy = tom = tod = 0;

        // Unpack 6 numbers from 'period'
        tod = period & 0x1F; // Day (5 bits)
        System.out.println("\nUnpacked tod: " + tod);

        tom = (period >> 5) & 0xF; // Month (4 bits)
        System.out.println("Unpacked tom: " + tom);

        toy = ((period >> 9) & 0x7F) + 2000; // Year (7 bits)
        System.out.println("Unpacked toy: " + toy);

        fromd = (period >> 16) & 0x1F; // Day (5 bits)
        System.out.println("Unpacked fromd: " + fromd);

        fromm = (period >> 21) & 0xF; // Month (4 bits)
        System.out.println("Unpacked fromm: " + fromm);

        fromy = ((period >> 25) & 0x7F) + 2000; // Year (7 bits)
        System.out.println("Unpacked fromy: " + fromy);

        System.out.println("\n**** Reconstructed\n" +
                "From " + fromy + "/" + fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod);
    }
}
```

Explanation:

We start by defining the original dates using six integers: fromy, fromm, fromd, toy, tom, tod.

To pack the dates into a single integer period, we use bitwise operations:

For the "from" date, we shift the year (minus 2000) by 25 bits, the month by 21 bits, and the day by 16 bits, and then OR them with period.

For the "to" date, we shift the year (minus 2000) by 9 bits, the month by 5 bits, and directly OR the day with period.

After packing, we reset the original date variables to 0.

To unpack the dates from period, we again use bitwise operations:

We extract the day of the "to" date by ANDing period with 0x1F (5 bits).

We extract the month of the "to" date by right-shifting period by 5 bits and then ANDing with 0xF (4 bits).

We extract the year of the "to" date by right-shifting period by 9 bits, ANDing with 0x7F (7 bits), and then adding 2000.

Similarly, we extract the day, month, and year of the "from" date by right-shifting period by appropriate amounts and ANDing with the respective bit masks.

Finally, we print the reconstructed dates to verify that they match the original date.
