package Problems;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(calcPerfectNumber(28));
    }

    private static boolean calcPerfectNumber(int n) {

        if (n == 1)
            return false;

        int sum = 0;
        for (int i = 1; i <= n/2; i++){
            if (n % i == 0)
                sum = sum + i;
        }

        System.out.println(sum);

       return sum == n;
    }
}
