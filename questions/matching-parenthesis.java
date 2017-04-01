/**
"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).

Time - O(n)
Space - O(1)

*/


  public int getClosingParen(String sentence, int index) {
    int count = 0;

    for (int position = index + 1; position < sentence.length(); position++) {
        char c = sentence.charAt(position);

        if (c == '(') {
            count ++;
        } else if (c == ')') {
            count--;
            if (count == 0) {
                return position;
            }
        }
    }

    throw new IllegalArgumentException("No closing parenthesis :(");
}
