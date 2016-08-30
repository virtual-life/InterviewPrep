/** Time - O(n) */
class SolutionRS {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

    /**
     *  In Place
     
     a) Reverse all the characters in the entire message, giving us the correct word order but with each word backwards.
     b) Reverse the characters in each individual word.

     * Time O(n) Space O(1)
     */
    public char[] reverseWordsInPlace(char[] s ) {
        if(s == null)
            return null;
        String str = new String(s);
        String[] words = str.split(" ");
        if (words.length <=1)
            return s;

        s = swap(s, 0, s.length-1);

        // we hold the index of the /start/ of the current word
        // as we look for the /end/ of the current word
        int wordStartIndex = 0;
        for (int i = 0; i <= s.length; i++) {
            // found the end of the current word!
            if (i == s.length || s[i] == ' ') {

                // if we haven't exhausted the string our
                // next word's start is one character ahead
                swap(s, wordStartIndex, i - 1);
                wordStartIndex = i + 1;
            }
        }
        return s;
    }

    public char[] swap(char[] ch, int l, int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
        return ch;
    }

}

