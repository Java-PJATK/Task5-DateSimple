# Task5-DateSimple


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

