/*
 * TASK 5
 * archived at https://git.femboy.science/femsci/ppj/src/branch/task/5
 * by femsci
 */

package dev.meowmeow;

public class Kitku {

    public static void main(String[] args) {
        // let's play with silly datestamps and serialization
        // 2127 + 10

        LimitedDate from = new LimitedDate(3, 2, 2000),
                to = new LimitedDate(29, 11, 2127);

        System.out.printf("**Original**\n%s -> %s\n\n", from, to);
        
        // for more explicitness let's stress test the system by redundant serde ops
        int spanRaw = new LimitedDateSpan(from, to).rawSpan();

        LimitedDateSpan theActualSpanAbstraction = new LimitedDateSpan(spanRaw);

        // here we perform the another batch of deserialization operations :3
        LimitedDate fromde = theActualSpanAbstraction.dateFrom(),
                tode = theActualSpanAbstraction.dateTo();
        
        System.out.printf("**Reconstructed**\n%s -> %s\n", fromde, tode);
    }
}
