package org.rev317.min.runique;

/**
 * @author JKetelaar
 */
public class ArrayTransformer {
    public static int[] copyFromLongArray(long[] source) {
        int[] dest = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            dest[i] = (int) source[i];
        }
        return dest;
    }

}
