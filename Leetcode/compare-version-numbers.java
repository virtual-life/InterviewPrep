/**
 *
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37

 */

/** v1 = 1.0.0, v2 = 1, => so they should be the same version */

public class Solution {
    public int compareVersion(String version1, String version2) {
        String delim = "[.]";
        String[] v1 = version1.split(delim);
        String[] v2 = version2.split(delim);

        int i = 0;
        int j = 0;

        while (i < v1.length && j < v2.length) {
            int seg1 = Integer.parseInt(v1[i]);
            int seg2 = Integer.parseInt(v2[j]);

            if (seg1 > seg2) {
                return 1;
            } else if (seg1 < seg2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        while (i < v1.length) {
            int seg1 = Integer.parseInt(v1[i]);
            if (seg1 != 0) {
                return 1;
            } else {
                i++;
            }
        }

        while (j < v2.length) {
            int seg2 = Integer.parseInt(v2[j]);
            if (seg2 != 0) {
                return -1;
            } else {
                j++;
            }
        }

        return 0;
    }
}