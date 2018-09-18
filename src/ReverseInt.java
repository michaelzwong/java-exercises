
public class ReverseInt {
    public int reverse(int x) {
        int resultNumber = 0;
        for (int i = x; i !=0; i /= 10) {
            if (resultNumber > Integer.MAX_VALUE/10 || (resultNumber == Integer.MAX_VALUE / 10 && (i%10) > 7)) return 0;
            if (resultNumber < Integer.MIN_VALUE/10 || (resultNumber == Integer.MIN_VALUE / 10 && (i%10) < -8)) return 0;
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;  
        
    }
}
