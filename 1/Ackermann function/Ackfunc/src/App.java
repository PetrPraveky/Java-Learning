public class App {
    public static void main(String[] args) throws Exception {
        int maxC = 5;
        for (int i=0; i<maxC; i++) {
            for (int j=0; j<maxC; j++) {
                System.out.println("Zadani funkce ["+i+"; "+j+"] | Vysledek funkce: ["+ack(i,j)+"]");
            }
        }
    }
    private static long ack(long m, long n) {
        long ans = 0;
        if (m==0) {
            ans = n+1;
        } else if (n==0) {
            ans = ack(m-1, 1);
        } else {
            ans = ack(m-1, ack(m, n-1));
        }
        return ans;
    }
}
