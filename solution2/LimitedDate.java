/*
 * TASK 5
 * archived at https://git.femboy.science/femsci/ppj/src/branch/task/5
 * by femsci
 */

package dev.meowmeow;

public class LimitedDate {
    public LimitedDate(int day, int month, int year) {
        if (year < 2000 || year > 2127) {
            throw new IllegalArgumentException("year must be within [2000..2127]");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be within [1..12]");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("day must be within [1..31]");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private final int day, month, year;

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    /*
     * the structure (sadly java does not support unsigned integers):
     * | octet 1 .| octet 2. |
     * | 01234567 | 89abcdef |
     * | Yyyyyyym | mmmddddd |
     */
    public short toSillyDatestamp() {
        int yr = year - 2000;
        return (short) ((yr << 9) | (month << 5) | (day));
    }

    public static LimitedDate fromSillyDatestamp(short datestamp) {
        int day = datestamp & 0x1f;
        int month = (datestamp >> 5) & 0xf;
        int year = (datestamp >> 9) & 0x7f;
        return new LimitedDate(day, month, year + 2000);
    }
}
