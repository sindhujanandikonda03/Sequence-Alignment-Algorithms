package ccaproject;

public class Enhancement {
    
  
    
    public int[] algB(int m, int n, String a, String b) {
        
        
        int[][] k = new int[2][n+1];
        for( int j=0; j<=n; j++) {
            k[1][j] = 0;
        }
        
        
        for(int i=1; i<=m; i++) {
           
            k[0] = k[1];
            
            
            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    k[1][j] = k[0][j-1] + 1;
                }else{
                    k[1][j] = max(k[1][j-1], k[0][j]);
                }
            }
        }
        
        return k[1];
        
    }
    
    public int max(int x, int y) {
        if(x>y) {
            return x;
        }else{
            return y;
        }
    }
    
    public String algC(int m, int n, String a, String b) {
        int i=0;
        int j=0;
        String c = "";
        if( n==0 ) {
            c = "";
        } else if( m==1 ) {
            for( j=0; j<n; j++ ) {
                if( a.charAt(0)==b.charAt(j) ) {
                    c= ""+a.charAt(0);
                    break;
                } else {
                    c = "";
                }
            }
            
            
        } else {
            i= (int) Math.floor(((double)m)/2);
            
            
            System.out.println(a.substring(0,i));
            System.out.println(reverseString(a.substring(i)));
            System.out.println(b);
            System.out.println(reverseString(b));
            
            int[] l1 = algB(i, n, a.substring(0,i), b);
            int[] l2 = algB(m-i, n, reverseString(a.substring(i)), reverseString(b));
            
           
            int k = findK(l1, l2, n);
            
            
            String c1 = algC(i, k, a.substring(0, i), b.substring(0, k));
            String c2 = algC(m-i, n-k, a.substring(i), b.substring(k));
            
            c = c1+c2;
        }
        
        return c;
    }
    public String reverseString(String in) {
        String out = "";
        int len = in.length();
        
        for(int i=1; i<=len; i++) {
            out = out+in.charAt(len-i);
        }
        
        return out;
    }
    
    
    
    public int findK(int[] l1, int[] l2, int n) {
        int m = 0;
        int k = 0;
        
        for(int j=0; j<=n; j++) {
            
            System.out.println("L1: " + l1[j] + " L2: " + l2[j]);
            
            if(m < (l1[j]+l2[n-j])) {
                m = l1[j]+l2[n-j];
                k = j;
            }
        }
        System.out.println("K: " + k);
        return k;
    }
    
    
       public static void main(String[] args) {
        
            Enhancement alg = new Enhancement();
        
        String a = "ABCBDABJKIDEESWQBVGDDXCEAA";
        String b = "BDCABAMBYUUFCDDESAWQUUGVBN";
           
        long startTime = System.currentTimeMillis();
        String result = alg.algC(a.length(), b.length(), a, b);
        
        System.out.println("Result: " + result);
        Long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time taken = " + elapsedTime + "ms");
    }
    
}