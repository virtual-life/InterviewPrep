/**
N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, 
a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, 
find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.
*/


//O(n^2 ) solution 

public class Solution {
    public int bulbs(ArrayList<Integer> a) {
        int count=0;
        for( int i=0 ;i< a.size();i++){
            if(a.get(i) == 0 ){
                a.set(i,1);
                count ++; 
                for(int j=i+1;j<a.size();j++){
                  a.set(j,1-a.get(j));
                }
                 
            }
        }
        
        return count;
    }
}

// O(n) solution 

public class Solution {
    public int bulbs(ArrayList<Integer> a) {
        int state = 0;
        int switches = 0;
        for (int i=0; i< a.size(); i++){
            if (state == a.get(i)) {
                state = 1 - state;
                switches++;
            }
        }
        return switches;
    }
}
