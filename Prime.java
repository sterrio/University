//A2 - Algorithm Complexity Analysis, September 18th 2017, Stephen Terrio B00755443.


public class Prime {
	public static void main(String args[]){
		
		long startTime, endTime, executionTime; startTime = System.currentTimeMillis();
		//include the code snippet (or call to the method) here
		
		
		int prime_index = 4; //setting to 4 because i skip all single digit primes.
		int count = -1; // to be used in an array of primes found.
		int primes = 10002; // used to make sure i stop after 10 001th prime.
		int [] found = new int[4];// making array to store all needed prime values
		
		//looping through all odd numbers to look for primes (0 and 1 aren't prime) 
		for (int i =1; prime_index < primes; i+=2){

			boolean checked = false; //to know if it returned an even remainder
			boolean isPrime = false;// to know if the current integer i is prime.
			
			//checking every odd multiple up to the square root of the number
			for(int j = 3; j <= (int)Math.sqrt(i); j+=2){
				
				//checking if current number is prime, breaking if not and increasing index if it is.
				if(i !=j && i%j == 0 && checked == false){checked = true; break;}
				//need to check one below math.sqrt for certain cases like 19 and 17.
				else if(checked ==false && (j == (int)Math.sqrt(i) || j == (int)Math.sqrt(i) -1)){
					isPrime = true;
				}
				//if the number is prime then increase index, if index is a needed value store i in the found array.
				if(isPrime){
					prime_index++;
					// if the current prime is the 11th, 101st 1001th or 10 001th prime, store the value.
					if(prime_index == 11 || prime_index == 101 || prime_index == 1001 || prime_index == 10001){
						count++;
						found[count] = i;
						endTime = System.currentTimeMillis(); executionTime = endTime - startTime;
						//display executionTime
						System.out.println(executionTime);
					}
					// if over last prime value needed, break the loop.
				if (prime_index == 10001){break;}
				}
			}
		}
		//printing answer.
		System.out.println("(" + found[0] + "," + found[1] + "," + found[2] + "," + found[3] + ")");
		
	}
}
