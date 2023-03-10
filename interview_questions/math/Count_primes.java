package interview_questions.math;


// Sieve of Eratosthenes algorithm is using here
public class Count_primes {
    public int countPrimes(int n) {
        if (n < 3){
            return 0;
        }
        // Assume that all the numbers of range are primes.
        //  we will mark the non-prime number with the Sieve of Eratosthenes algorithm later
        // Create an array named notPrime without initializing
        //  it cause all the elements of boolean array are false -> they are primes
        boolean[] notPrimes = new boolean[n];
        // Even numbers are always non-prime numbers obviously
        //  then the numbers should be considered are odd numbers only (n/2)
        // The algorithm will be start at 3rd index
        //  it means number 2 must be added to the primes n/2 + 1
        //  of course, the primes variable (n/2) included number 1 (not a prime) so we ignore number 1
        //  the final sum of primes at the beginning is (n/2 + 1 - 1) = (n/2)
        int primes = n/2;
        for (int i = 3; i * i < n; i += 2){
            if (notPrimes[i]){
                continue;
            }
            for (int j = i * i; j < n; j += i*2){
                // notPrimes stores non-prime number, in the case notPrime[i] return false,
                //  it means the number at the index i is primes 
                // In that case, we set it to true (not prime number) in the notPrime array followed by Sieve of Eratosthenes algorithm
                if (!notPrimes[j]){
                    notPrimes[j] = true;
                    // and get out 1 point from the sum of primes which we have assumed at the beginning.
                    primes--;
                }
            }
        }
        return primes;
    }
}
