/**
"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).

Time - O(n)
Space - O(1)

*/


  public int getClosingParen(String sentence, int openingParenIndex) {
    int openNestedParens = 0;

    for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
        char c = sentence.charAt(position);

        if (c == '(') {
            openNestedParens += 1;
        } else if (c == ')') {
            if (openNestedParens == 0) {
                return position;
            } else {
                openNestedParens -= 1;
            }
        }
    }

    throw new IllegalArgumentException("No closing parenthesis :(");
}
