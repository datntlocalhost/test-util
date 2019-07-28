package jp.datnt.oxy.util;

/**
 * The Class NumberConversions.
 */
public final class NumberConversions {

    /**
     * Floor.
     *
     * @param num the num
     * @return the int
     */
    public static int floor(double num) {
        final int floor = (int) num;
        return floor == num ? floor : floor - (int) (Double.doubleToRawLongBits(num) >>> 63);
    }

    /**
     * Ceil.
     *
     * @param num the num
     * @return the int
     */
    public static int ceil(final double num) {
        final int floor = (int) num;
        return floor == num ? floor : floor + (int) (~Double.doubleToRawLongBits(num) >>> 63);
    }

    /**
     * Round.
     *
     * @param num the num
     * @return the int
     */
    public static int round(double num) {
        return floor(num + 0.5d);
    }

    /**
     * Square.
     *
     * @param num the num
     * @return the double
     */
    public static double square(double num) {
        return num * num;
    }

    /**
     * To int.
     *
     * @param object the object
     * @return the int
     */
    public static int toInt(Object object) {
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }

        try {
            return Integer.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }

    /**
     * To float.
     *
     * @param object the object
     * @return the float
     */
    public static float toFloat(Object object) {
        if (object instanceof Number) {
            return ((Number) object).floatValue();
        }

        try {
            return Float.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }

    /**
     * To double.
     *
     * @param object the object
     * @return the double
     */
    public static double toDouble(Object object) {
        if (object instanceof Number) {
            return ((Number) object).doubleValue();
        }

        try {
            return Double.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }

    /**
     * To long.
     *
     * @param object the object
     * @return the long
     */
    public static long toLong(Object object) {
        if (object instanceof Number) {
            return ((Number) object).longValue();
        }

        try {
            return Long.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }

    /**
     * To short.
     *
     * @param object the object
     * @return the short
     */
    public static short toShort(Object object) {
        if (object instanceof Number) {
            return ((Number) object).shortValue();
        }

        try {
            return Short.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }

    /**
     * To byte.
     *
     * @param object the object
     * @return the byte
     */
    public static byte toByte(Object object) {
        if (object instanceof Number) {
            return ((Number) object).byteValue();
        }

        try {
            return Byte.valueOf(object.toString());
        } catch (NumberFormatException e) {
        } catch (NullPointerException e) {
        }
        return 0;
    }
}
