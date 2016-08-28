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

     * Time O(n) Space O(n)
     */
    public char[] reverseWordsInPlace(char[] s ) {
        if(s == null)
            return null;
        String str = new String(s);
        String[] words = str.split(" ");
        if (words.length <=1)
            return s;

        s = swap(s, 0, s.length-1);
        int last = 0;
        int i = 0;
        while(i < s.length){
            while(i < s.length && s[i] != ' '){
                i++;
            }
            s = swap(s, last, i-1);
            last = i + 1;
            i = last;
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

