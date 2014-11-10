/**
 * I chose the java language because java is a widely used language in computer science.  Although,I think Python could be a good alternative
 * due to its use of the Tuple class and speed.
 * 
 * The data set that will be input into Secret will be an integer within a list of integers.  Each set of three integers will correspond to x, y, and x+y.
 * These integers will then be input
 * 
 * ASSUMPTIONS:
 * -The "N" can be input by the user.  This will be done via prompt.
 * -Secret is an external .dll file or packet.  As such, the last step will be to prepare the data that can be input into Secret.
 * -The end user is not expected to see the data set in its raw form or debug it.  This is why there is no 'Pair' class in use that would help organize list of secret inputs.
 *  -I considered a Tuple class for java but scrapped it later in favor of a single list of inputs where every three corresponded to x, y, and x+y.
 */

import java.util.List;
import java.util.ArrayList;
import java.io.*;
//import .dll or package for the Secret function here.

public class MainDriver{
	
	/**
	 * The main loop will prompt the user for 'N'.  
	 * Then, it will find all the prime numbers less than N, generate the Secret input, 
	 * and attempt to determine if Secret is valid for x, y, and x+y.
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Hello!  Please prepare the data to pass into Secret.  Set the 'N' value, and we will find all the prime numbers below that value.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try
			{
				System.out.println("Please set the maximum value (type 'q' to exit): ");
				String entry = br.readLine();
				
				if(entry.equals("q")){
					System.out.println("Goodbye!");
					System.exit(0);
				}
				else
					
				{
				int N = Integer.parseInt(entry);
				List<Integer> inputs = makeSecretInput(getPrimes(N));

				if(validateSecretFunction(inputs))
				{
					System.out.println ("The Secret function is valid for Secret(x+y) = Secret(x) + Secret(y)");
				}
				else
				{
					System.out.println("The Secret function is not valid for Secret(x+y) = Secret(x) + Secret(y)");
				}
				
				}
			}
			catch(IOException e)
			{
				System.out.println("This not a valid input.  Please try again.");
			}
			catch(NumberFormatException e)
			{
				System.out.println("This is not a number.  Please try again.");
			}
			catch(Exception e)
			{
				System.out.println("There was an error with the program.  Please try again.");
			}
		}
		
	}
	
	/**
	 * Returns the list of prime numbers below integer N.
	 * @param N.  The maximum integer value.
	 * @return.  Returns a list of prime integers below N.
	 */
	private static List<Integer> getPrimes(int N)
	{
		List<Integer> primes = new ArrayList<Integer>();
		
			if(N<=1)
			{
				return primes;
			}
			else
			{
				
				//Get all the primes.
				if(N>=2)
				{
					primes.add(2);
					int n = 2;
					while(n < N)
					{
						boolean isPrime = true;
						for(int prime = 0; prime < primes.size(); prime++)
						{
							if(n % primes.get(prime)==0)
							{
								isPrime = false;
								break;
							}
						}
						
						if(isPrime)
						{
							primes.add(n);
						}
						n++;
					}
				}
			}
			return primes;
	}
	
	/**
	 * Creates the list of inputs for the Secret function.
	 * @param allPrimes.  The list of all prime numbers found in the previous step.
	 * @return.  Returns the list of inputs for the Secret function.  Every three entries correspond to 'x', 'y' and 'x+y'.
	 */
	private static List<Integer> makeSecretInput(List<Integer> allPrimes)
	{
		List<Integer> secretInputs = new ArrayList<Integer>();
		for (int i = 0; i<allPrimes.size(); i++)
		{
			int x = allPrimes.get(i);
			for(int j = 0; j<allPrimes.size(); j++)
			{
				int y = allPrimes.get(j);
				secretInputs.add(x);
				secretInputs.add(y);
				secretInputs.add((x+y));
			}
		}
		return secretInputs;
	}

	/**
	 * Attempts to validate the Secret function.
	 * @param inputs.  List of inputs for the Secret function.
	 * @return.  Returns the validation state of the Secret function.
	 */
	private static boolean validateSecretFunction(List<Integer> inputs)
	{
		for(int i =  0; i<inputs.size(); i++)
		{
			int x = -1;
			int y = -1;
			int xy = -1;
			int input = inputs.get(i);
			if(i%3==0)
			{
				x = input;
			}
			else if(i%3 ==1)
			{
				y = input;
			}
			else if(i%3 ==2)
			{
				xy = input;
			}
			
			if(x>0&&y>0&&xy>0)
			{
				//Test the Secret.
				//if Secret(xy) == Secret(x) + Secret(y)
				//Reset x,y, and xy to -1.
					//If one triplet of data fails, then 
				
				//else
				//return false;
			}
		}
		return true;
	}
}