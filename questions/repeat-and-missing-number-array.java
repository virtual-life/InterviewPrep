/**

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

*/


/**
Let the given array be
int arr[] = {1, 5, 3, 4, 1, 2};
Let us take XOR of all the elements in the array

xor = arr[0] ^ arr[1] ^ arr[2] ^ arr[3] ^ arr[4] ^ arr[5];
Now xor all the elements from 1 to n with the above xor

xor = xor ^ 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6;
The final alue in the xor (after above operations) will be the XOR of the missing number (i.e 6) and repeating number (i.e 1). All other elements will nullify themselves.

Lets call the  
x - missing number 
y - repeating number

 xor = x ^ y;
 
 All the bits that are set in xor will be either set in x or y (but not both - classic xor operation). 
 So if we take any set-bit (lets take the rightmost set-bit for this example, but you can take any) 
 and divide the elements of array in 2 sets A & B

A: Set of elements in the given array for which the bit is set
B: Set of elements in the given array for which the bit is NOT set

A = {1, 5, 3, 1} 
B = {4, 2}


*/

public class Solution {
	
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    int xors = 0; 
	    int i; 
	    int missing = 0; 
	    int repeat = 0; 
	    
	    for(i=0; i<a.size(); i++) 
	        xors = xors ^ a.get(i); // XOR of numbers from 1 to n (with xor) 
	    
	    for(i=1; i<=a.size(); i++) 
	        xors = xors ^ i; 
          
          
       
      /*
      Position of rightmost set bit
      	 -  Take two's complement of the given no
      	 -  Do an bit-wise & with original no
       	 -  Take the log2 of the no, you will get position
      */
      
	    int setBitNum = xors & (~xors +1);  // Number with the same bit set as the rightmost set bit in xor
      
      
      // Dividing the numbers in two sets and also getting the XORs 
	         
	    for(i = 0; i < a.size(); i++) { 
	       if((a.get(i) & setBitNum) > 0 )
	           repeat = repeat ^ a.get(i); // arr[i] belongs to Set A 
	       else 
	           missing = missing ^ a.get(i); // arr[i] belongs to Set B 
	    } 
	       for(i = 1; i <= a.size(); i++) { 
	           if((i & setBitNum)> 0) 
	                repeat = repeat ^ i; // arr[i] belongs to Set A 
	            else 
	                missing = missing ^ i; // arr[i] belongs to Set B 
	       } 
	       
	        result.add(repeat);
	        result.add(missing);
		
	       return result;
	}
}
