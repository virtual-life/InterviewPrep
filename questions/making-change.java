/*

Your quirky boss found out that you're a programmer and has a weird request about something they've been wondering for a long time.

Write a function that, given:

an amount of money
an array of coin denominations
computes the number of ways to make amount of money with coins of the available denominations.

Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output 44—the number of ways to make 44¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢

Time -  O(n*m) n -  amount of money &  m -  number of denominations.
Space - O(n)  

*/

  public int changePossibilitiesBottomUp(int amount, int[] denominations) {
    int[] waysOfDoingNCents = new int[amount+1]; // array of zeros from 0..amount
    waysOfDoingNCents[0] = 1;

    for (int coin : denominations) {
        for (int higherAmount = coin; higherAmount < amount + 1; higherAmount++) {
            int higherAmountRemainder = higherAmount - coin;
            waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
        }
    }

    return waysOfDoingNCents[amount];
}

