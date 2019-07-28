package jp.datnt.oxy.util;

import org.apache.commons.lang3.Validate;

/**
 * The Class StringUtil.
 */
public final class StringUtil {

    /**
     * Checks if is null.
     *
     * @param str the str
     * @return true, if is null
     */
    public static boolean isNull(final String str) {
        return str == null;
    }

    /**
     * Checks if is empty.
     *
     * @param str the str
     * @return true, if is empty
     */
    public static boolean isEmpty(final String str) {
        return str != null && str.length() == 0;
    }

    /**
     * Checks if is null or empty.
     *
     * @param str the str
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(final String str) {
        return isNull(str) || isEmpty(str);
    }

    /**
     * This method uses a region to check case-insensitive equality.
     * This means the internal array does not need to be copied like a
     * toLowerCase() call would.
     *
     * @param string String to check
     * @param prefix Prefix of string to compare
     * @return true if provided string starts with, ignoring case, the prefix provided
     * @throws IllegalArgumentException if string is null
     * @throws NullPointerException if prefix is null
     */
    public static boolean startsWithIgnoreCase(final String string, final String prefix)
        throws IllegalArgumentException, NullPointerException {
        Validate.notNull(string, "Cannot check a null string for a match");
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
