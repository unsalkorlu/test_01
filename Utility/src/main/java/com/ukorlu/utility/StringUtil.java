package com.ukorlu.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Encoder;

public class StringUtil {

    public static final String EMPTY_STRING = "";
    public static final String BLANK = " ";
   
    /**
     * Returns a trimmed value of the given string.
     *
     * @param str given string
     * @return trimmed value of the given string
     */
    public static String trim(String str) {
        if (str != null) {
            str = str.trim();
        }
        return str;
    }

    /**
     * Returns a trimmed value of the given string or null if the trimmed value
     * is empty.
     *
     * @param str given string
     * @return trimmed value of the given string or null if the trimmed value is
     * empty
     */
    public static String trimAndSetNullIfBlank(String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() == 0) {
                str = null;
            }
        }
        return str;
    }

    public static void trimAndSetNullIfBlank(String[] str) {
        if (str != null) {
            for (int i = 0; i < str.length; i++) {
                str[i] = trimAndSetNullIfBlank(str[i]);
            }
        }
    }

    public static boolean isNullOrZeroLength(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotNullAndNotZeroLength(String str) {
        return !isNullOrZeroLength(str);
    }

    /**
     * Checks elements whether they are all null or zero length.
     *
     * @param strArray
     * @return true if all elements of specified array are null or zero length
     * if strArray is null or zero length, returns true.
     */
    public static boolean areNullOrZeroLength(String... strArray) {
        if (strArray != null && strArray.length > 0) {
            for (String str : strArray) {
                if (!isNullOrZeroLength(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks array whether it has null or zero length element.
     *
     * @param strArray
     * @return true if string array has null or zero length element and returns
     * false if strArray is null or zero length
     */
    public static boolean hasNullOrZeroLengthElement(String... strArray) {
        if (strArray != null && strArray.length > 0) {
            for (String str : strArray) {
                if (isNullOrZeroLength(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getSHA1Text(String text) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

        return (new BASE64Encoder()).encode(sha1.digest(text.getBytes("UTF-8")));
    }

    public static String getSHA1Text(String text, String encoding) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

        return (new BASE64Encoder()).encode(sha1.digest(text.getBytes(encoding)));
    }

    public static String getSHA256Text(String text) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

        return (new BASE64Encoder()).encode(sha256.digest(text.getBytes("UTF-8")));
    }

    /*
      * \u011F g \u011E G \u00FC u \u00DC U \u015F s \u015E S \u00F6 o \u00D6 O
      * \u00E7 c \u00C7 C \u0131 i \u0130 I
      */
    public static String toHtmlAscii(String str) {
        if (!isNullOrZeroLength(str)) {
            str = str.replaceAll("\u011F", "&#287;");
            str = str.replaceAll("\u011E", "&#286;");
            str = str.replaceAll("\u00FC", "&#252;");
            str = str.replaceAll("\u00DC", "&#220;");
            str = str.replaceAll("\u015F", "&#351;");
            str = str.replaceAll("\u015E", "&#350;");
            str = str.replaceAll("\u00F6", "&#246;");
            str = str.replaceAll("\u00D6", "&#214;");
            str = str.replaceAll("\u00E7", "&#231;");
            str = str.replaceAll("\u00C7", "&#199;");
            str = str.replaceAll("\u0131", "&#305;");
            str = str.replaceAll("\u0130", "&#304;");
        }
        return str;
    }

    public static String toAscii(String str) {
        if (!isNullOrZeroLength(str)) {
            str = str.replaceAll("\u011F", "g");
            str = str.replaceAll("\u011E", "G");
            str = str.replaceAll("\u00FC", "u");
            str = str.replaceAll("\u00DC", "U");
            str = str.replaceAll("\u015F", "s");
            str = str.replaceAll("\u015E", "S");
            str = str.replaceAll("\u00F6", "o");
            str = str.replaceAll("\u00D6", "O");
            str = str.replaceAll("\u00E7", "c");
            str = str.replaceAll("\u00C7", "C");
            str = str.replaceAll("\u0131", "i");
            str = str.replaceAll("\u0130", "I");
        }
        return str;
    }

    public static String shortenLength(String str, int length) {
        if (str != null && str.length() > length) {
            str = str.substring(0, length);
        }
        return str;
    }

    private static List<Double> removeNotNumbersAndGetAsList(String[] strArray) {
        List<Double> list = new ArrayList<>();

        if (strArray != null && strArray.length > 0) {
            for (String str : strArray) {
                if (!isNullOrZeroLength(str)) {
                    try {
                        double number = Double.parseDouble(str);
                        list.add(number);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }

        return list;
    }

    public static Double[] getAsDoubleArray(String[] strArray) {
        Double[] array = null;

        List<Double> list = removeNotNumbersAndGetAsList(strArray);

        if (list != null && list.size() > 0) {
            array = new Double[list.size()];
            list.toArray(array);
        }

        return array;
    }

    public static Integer[] getAsIntegerArray(String[] strArray) {
        Integer[] array = null;

        List<Double> list = removeNotNumbersAndGetAsList(strArray);

        if (list != null && list.size() > 0) {
            array = new Integer[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = ((Double) list.get(i)).intValue();
            }
        }

        return array;
    }

    public static int[] getAsIntArray(String[] strArray) {
        int[] array = null;

        List<Double> list = removeNotNumbersAndGetAsList(strArray);

        if (list != null && list.size() > 0) {
            array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = ((Double) list.get(i)).intValue();
            }
        }

        return array;
    }

    public static Long[] getAsLongArray(String[] strArray) {
        Long[] array = null;

        List<Double> list = removeNotNumbersAndGetAsList(strArray);

        if (list != null && list.size() > 0) {
            array = new Long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = ((Double) list.get(i)).longValue();
            }
        }

        return array;
    }

    public static int[] getAsIntArray(String diyezSeparatedString, String separator) {
        if (diyezSeparatedString != null) {
            String[] strArray = diyezSeparatedString.split(separator);
            return getAsIntArray(strArray);
        }
        return null;
    }

    public static Integer[] getAsIntegerArray(String diyezSeparatedString, String separator) {
        if (diyezSeparatedString != null) {
            String[] strArray = diyezSeparatedString.split(separator);
            return getAsIntegerArray(strArray);
        }
        return null;
    }

    public static Long[] getAsLongArray(String diyezSeparatedString, String separator) {
        if (diyezSeparatedString != null) {
            String[] strArray = diyezSeparatedString.split(separator);
            return getAsLongArray(strArray);
        }
        return null;
    }

    public static Double[] getAsDoubleArray(String diyezSeperatedString, String separator) {
        if (diyezSeperatedString != null) {
            String[] strArray = diyezSeperatedString.split(separator);
            return getAsDoubleArray(strArray);
        }
        return null;
    }

    public static String[] getAsStringArray(String diyezSeperatedString, String separator) {
        if (diyezSeperatedString != null) {
            return diyezSeperatedString.split(separator);
        }
        return null;
    }

    public static String getAsCommaSeperatedString(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.toString().replace("[", "").replace("]", "");
        }
        return null;
    }

    public static String getServerIpAddress() {
        String address = "";

        try {
            address = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return address;
    }

    public static String maskCardNumberAndShowOnlyFirstAndLastFour(String ccNumber) {
        StringBuilder mask = new StringBuilder();

        ccNumber = trimAndSetNullIfBlank(ccNumber);

        if (ccNumber != null) {
            mask.append(ccNumber.substring(0, 4));
            if (ccNumber.length() >= 14) {
                for (int i = 0; i < ccNumber.length() - 8; i++) {
                    mask.append("*");
                }
                mask.append(ccNumber.substring(ccNumber.length() - 4));
            } else {
                for (int i = 0; i < ccNumber.length() - 6; i++) {
                    mask.append("*");
                }
                mask.append(ccNumber.substring(ccNumber.length() - 2));
            }
        }

        return mask.toString();
    }

    public static String maskCreditCardNumber(String ccNumber) {
        StringBuilder mask = new StringBuilder();

        ccNumber = trimAndSetNullIfBlank(ccNumber);

        if (ccNumber != null) {
            mask.append(ccNumber.substring(0, 6));
            if (ccNumber.length() >= 14) {
                for (int i = 0; i < ccNumber.length() - 10; i++) {
                    mask.append("*");
                }
                mask.append(ccNumber.substring(ccNumber.length() - 4));
            } else {
                for (int i = 0; i < ccNumber.length() - 8; i++) {
                    mask.append("*");
                }
                mask.append(ccNumber.substring(ccNumber.length() - 2));
            }
        }

        return mask.toString();
    }

    public static String maskAndShowLastFourCardNumber(String ccNumber) {
        StringBuilder mask = new StringBuilder();

        ccNumber = trimAndSetNullIfBlank(ccNumber);

        if (ccNumber != null) {
            for (int i = 0; i < ccNumber.length() - 4; i++) {
                mask.append("*");
            }
            mask.append(ccNumber.substring(ccNumber.length() - 4));
        }

        return mask.toString();
    }

    public static String[] generateRandomAlphaNumericStrings(int numberOfSamples, int strLength) {
        if (numberOfSamples < 0 || strLength < 0) {
            throw new IllegalArgumentException("numberOfSamples:" + numberOfSamples + " or strLength:" + strLength + " is negative!");
        }

        String[] array = new String[numberOfSamples];

        Set<String> sampleSet = new HashSet<String>();
        Random random = new Random(System.currentTimeMillis() * 121);

        while (sampleSet.size() < numberOfSamples) {
            StringBuffer buffer = new StringBuffer();
            while (buffer.length() < strLength) {
                char ch = Character.forDigit(random.nextInt() % Character.MAX_RADIX, Character.MAX_RADIX);
                if (Character.isLetterOrDigit(ch)) {
                    buffer.append(ch);
                }
            }
            if (buffer.toString().trim().length() != 0) {
                sampleSet.add(buffer.toString().toUpperCase());
            }
        }

        sampleSet.toArray(array);

        return array;
    }

    public static String[] slice(String str, int maxLength) {
        Pattern p = Pattern.compile(".{1," + maxLength + "}");
        Matcher m = p.matcher(str);
        List<String> result = new ArrayList<String>();

        while (m.find()) {
            result.add(m.group());
        }

        return result.toArray(new String[result.size()]);
    }

    public static String getNameOrSurnameAsFilteredText(String nameOrSurname) {
        StringBuffer buffer = new StringBuffer();

        nameOrSurname = nameOrSurname.replaceAll("[^a-zA-Z&&[^ ]&&[^\u011F\u011E\u00FC\u00DC\u015F\u015E\u00F6\u00D6\u00E7\u00C7\u0131\u0130]]", "");

        String[] strings = nameOrSurname.split(" ");
        for (String string : strings) {
            if (!StringUtil.isNullOrZeroLength(string)) {
                buffer.append(Character.toUpperCase(string.charAt(0)));
                if (string.length() > 1) {
                    buffer.append(string.substring(1).toLowerCase());
                } else {
                    buffer.append(".");
                }
                buffer.append(" ");
            }
        }

        return buffer.toString().trim();
    }

    public static String trimCapitalizeFirstLettersAndSetNullIfBlank(String str, Locale locale) {
        str = trimAndSetNullIfBlank(str);
        if (str != null && str.length() > 0) {
            StringBuffer buffer = new StringBuffer();

            String[] split = str.split(" ");
            for (String string : split) {
                if (string.equals("") || string.equals(" ")) {
                    continue;
                }
                buffer.append(string.substring(0, 1).toUpperCase(locale) + string.substring(1).toLowerCase(locale));
                buffer.append(" ");
            }

            str = buffer.toString().trim();
        }
        return str;
    }

    public static String trimCapitalizeFirstLettersAndSetNullIfBlank(String str) {
        return trimCapitalizeFirstLettersAndSetNullIfBlank(str, new Locale("tr"));
    }

    public static String generateContent(String content, Map<String, String> valueMap) {
        if (valueMap != null && valueMap.size() > 0) {
            for (String key : valueMap.keySet()) {
                String value = valueMap.get(key);

                if (value != null) {
                    content = content.replace("{" + key + "}", value);
                }
            }
        }

        return content;
    }

    public static String generateContent(String content, List<Map<String, String>> valueMapList) {
        StringBuffer buffer = new StringBuffer();

        if (valueMapList != null && valueMapList.size() > 0) {
            for (Map<String, String> valueMap : valueMapList) {
                buffer.append(generateContent(content, valueMap));
            }
        }
        return buffer.toString();
    }

    public static String padRight(String s, int desiredLength) {
        return String.format("%1$-" + desiredLength + "s", s);
    }

    public static String padLeft(String s, int desiredLength) {
        return String.format("%1$" + desiredLength + "s", s);
    }

    public static String replaceTurkishCharacterWithEnglishOnes(String originalText) {
        originalText = originalText.replace("ü", "u");
        originalText = originalText.replace("ı", "i");
        originalText = originalText.replace("ö", "o");
        originalText = originalText.replace("ü", "u");
        originalText = originalText.replace("ş", "s");
        originalText = originalText.replace("ğ", "g");
        originalText = originalText.replace("ç", "c");
        originalText = originalText.replace("Ü", "U");
        originalText = originalText.replace("İ", "I");
        originalText = originalText.replace("Ö", "O");
        originalText = originalText.replace("Ü", "U");
        originalText = originalText.replace("Ş", "S");
        originalText = originalText.replace("Ğ", "G");
        originalText = originalText.replace("Ç", "C");
        return originalText;
    }

    public static String replaceNonAlphaNumericCharacters(String originalText) {
        return originalText.replaceAll("\\W", "");
    }

    public static String generateAlphaNumericFixLengthWithEnglishCharacters(String originalText, int desiredLength) {
        originalText = replaceTurkishCharacterWithEnglishOnes(originalText);
        originalText = replaceNonAlphaNumericCharacters(originalText);
        originalText = padRight(originalText.substring(0, originalText.length() > desiredLength ? desiredLength : originalText.length()), desiredLength);
        return originalText;
    }

    public static boolean includesInvalidCharacters(String originalText) throws Exception {
        if (originalText.contains("<") || originalText.contains(">")) {
            return true;
        }
        return false;
    }

    public static String escapeInvalidCharacters(String originalText) throws Exception {
        return originalText.replaceAll("<", "").replaceAll(">", "").replaceAll("[\\r\\n]", "");
    }

    public static String escapeJavaScriptCharacters(String originalText) throws Exception {
        return originalText.replaceAll("<", "").replaceAll(">", "").replaceAll("[\\r\\n]", "").replace("(", "").replace(")", "");
    }

    public static String concat(String[] values) {
        String hashParams = StringUtil.EMPTY_STRING;
        for (String s : values) {
            if (!StringUtil.isNullOrZeroLength(s)) {
                hashParams += s;
            } else {
                hashParams += StringUtil.EMPTY_STRING;
            }
        }
        return hashParams;
    }

    public static String concatStrings(Collection<String> strings, String delimiter) {
        StringBuilder sb = new StringBuilder();
        boolean addDelimiter = false;
        for (String s : strings) {
            if (addDelimiter) {
                sb.append(delimiter);
            } else {
                addDelimiter = true;
            }
            sb.append(s);
        }
        return sb.toString();
    }
    
    public static Integer safeParseInteger(String text) {
        if (isNullOrZeroLength(text))
            return null;
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Long safeParseLong(String text) {
        if (isNullOrZeroLength(text))
            return null;
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String safeToString(Object object) {
        return object != null ? object.toString() : null;
    }

    public static Double safeParseDouble(String text) {
        if (isNullOrZeroLength(text))
            return null;
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isNullOrHasZeroElement(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotNullOrHasZeroElement(List<?> list) {
        return !isNullOrHasZeroElement(list);
    }

}