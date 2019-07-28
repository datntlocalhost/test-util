package jp.datnt.oxy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

import com.google.common.base.Charsets;

import jp.datnt.oxy.commons.Constants;

/**
 * The Class FileUtil.
 * 
 * @author DatNT
 */
public final class FileUtil {

    /**
     * This method copies one file to another location.
     *
     * @param inFile the source filename
     * @param outFile the target filename
     * @return true on success
     */
    @SuppressWarnings("resource")
    public static boolean copy(File inFile, File outFile) {
        if (inFile == null || outFile == null || !inFile.exists()) {
            return false;
        }

        FileChannel in = null;
        FileChannel out = null;

        try {
            in = new FileInputStream(inFile).getChannel();
            out = new FileOutputStream(outFile).getChannel();

            long pos = 0;
            long size = in.size();

            while (pos < size) {
                pos += in.transferTo(pos, 10 * 1024 * 1024, out);
            }
        } catch (IOException ioe) {
            return false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
                return false;
            }
        }

        return true;

    }

    /**
     * This method copies one file to another location.
     *
     * @param inFile the source filename
     * @param outFile the target filename
     * @return true on success
     */
    public static boolean copy(String inFile, String outFile) {
        if (StringUtil.isNullOrEmpty(inFile) || StringUtil.isNullOrEmpty(outFile)) {
            return false;
        }

        File in = new File(inFile);
        File out = new File(outFile);

        return copy(in, out);
    }

    /**
     * This method delete a file.
     *
     * @param file the file
     * @return true, if successful
     */
    public static boolean delete(File file) {
        return file == null || !file.canWrite() ? false : file.delete();
    }

    /**
     * This method delete a file.
     *
     * @param file the file
     * @return true, if successful
     */
    public static boolean delete(String file) {
        return StringUtil.isNullOrEmpty(file) ? false : delete(new File(file));
    }

    /**
     * This method truncat a file.
     *
     * @param file the file
     * @return true, if successful
     */
    @SuppressWarnings("resource")
    public static boolean truncat(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }

        FileChannel out = null;

        try {
            out = new FileOutputStream(file, true).getChannel();
            out.truncate(0);
        } catch (IOException ioe) {
            return false;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method truncat a file.
     *
     * @param file the file
     * @return true, if successful
     */
    public static boolean truncat(String file) {
        return StringUtil.isNullOrEmpty(file) ? false : truncat(new File(file));
    }

    /**
     * Read string file.
     *
     * @param file the file
     * @param breakLine the break line
     * @return the string
     */
    public static String readStringFile(File file, char separatorLine) {
        StringBuilder builder = new StringBuilder();
        if (file == null || !file.exists() || !file.canRead()) {
            builder.toString();
        }

        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            isr = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null) {
                builder.append(line);
                builder.append(separatorLine);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception e) {
            }
        }

        return builder.toString();
    }

    /**
     * Read string file.
     *
     * @param file the file
     * @param breakLine the break line
     * @return the string
     */
    public static String readStringFile(String file, char separatorLine) {
        return StringUtil.isNullOrEmpty(file) ? Constants.STR_BLANK : readStringFile(new File(file), separatorLine);
    }
}
