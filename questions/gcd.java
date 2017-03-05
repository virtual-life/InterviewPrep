//gcd of two nums 

//A recursive method would be:

static int gcd(int a, int b){
  
  if(a == 0 || b == 0) return a+b; // base case
  return gcd(b,a%b);
}


//Iterative:

static int gcd(int a, int b){
  
  while(a!=0 && b!=0){ // until either one of them is 0
     int c = b;
     b = a%b;
     a = c;
  }
  return a+b; // either one is 0, so return the non-zero value
}
