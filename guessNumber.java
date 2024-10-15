/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 1;
        while(s<=n){
            int m = s + (n-s)/2;
            int guess = guess(m);
            if(guess==0) return m;
            else if(guess<0) n = m-1;
            else s = m+1;
        }
        return -1;
    }
}
