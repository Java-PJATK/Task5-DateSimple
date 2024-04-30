/*
 * TASK 5
 * archived at https://git.femboy.science/femsci/ppj/src/branch/task/5
 * by femsci
 */

package dev.meowmeow;

public class LimitedDateSpan {
    
    // we still don't account for the transitions and abominable human-made
    // exceptions
    public LimitedDateSpan(LimitedDate from, LimitedDate to) {
        this(from.toSillyDatestamp(), to.toSillyDatestamp());
    }

    LimitedDateSpan(short rawFrom, short rawTo) {
        this((rawFrom << 16) | Short.toUnsignedInt(rawTo));
    }

    LimitedDateSpan(int raw) {
        this.serializedData = raw;
    }

    // let's pretend that we need some weird optimization scheme, despite GC being
    // finally smart enough

    private final int serializedData;

    public LimitedDate dateFrom() {
        return LimitedDate.fromSillyDatestamp((short) ((serializedData >> 16) & 0xffff));
    }

    public LimitedDate dateTo() {
        return LimitedDate.fromSillyDatestamp((short) (serializedData & 0xffff));
    }

    int rawSpan() {
        return serializedData;
    }

    // span calc methods etc...
    // years(), days()...
}
