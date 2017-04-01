/*

Your quirky boss found out that you're a programmer and has a weird request about something they've been wondering for a long time.

Write a function that, given:

an amount of money
an array of coin denominations
computes the number of ways to make amount of money with coins of the available denominations.

Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 4¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢

Time -  O(n*m) n -  amount of money &  m -  number of denominations.
Space - O(n)  

*/

// waysOfDoingNCents, where the index is the amount and the value at each index is the number of ways of getting that amount.

  public int changePossibilitiesBottomUp(int amount, int[] denominations) {
    int[] waysOfDoingNCents = new int[amount+1]; // array of zeros from 0..amount
    waysOfDoingNCents[0] = 1;

    for (int coin : denominations) {
        for (int higherAmount = coin; higherAmount < amount + 1; higherAmount++) {
            int higherAmountRemainder = higherAmount - coin;
            waysOfDoingNCents[higherAmount] = waysOfDoingNCents[higherAmount] + waysOfDoingNCents[higherAmountRemainder];
        }
    }

    return waysOfDoingNCents[amount];
}


/**
  ===========
key:
a = higherAmount
r = higherAmountRemainder
===========

============
for coin = 1:
============
[1, 1, 0, 0, 0, 0]
 r  a

[1, 1, 1, 0, 0, 0]
    r  a

[1, 1, 1, 1, 0, 0]
       r  a

[1, 1, 1, 1, 1, 0]
          r  a

[1, 1, 1, 1, 1, 1]
             r  a

============
for coin = 3:
=============
[1, 1, 1, 2, 1, 1]
 r        a

[1, 1, 1, 2, 2, 1]
    r        a

[1, 1, 1, 2, 2, 2]
       r        a

============
for coin = 5:
=============
[1, 1, 1, 2, 2, 3]
 r              a


final answer: 3
*/
