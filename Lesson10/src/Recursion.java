public class Recursion {

    public void oneToN(int n){
        if (n==0) return;
        oneToN(1,n);
    }

    private void oneToN(int start,int n){
        System.out.println(start);
        start++;
        if (start>n) return;
        oneToN(start,n);
    }

    public void sumN(int n){
        System.out.println(sumN(0,n));
    }

    private int sumN(int sum, int n){
        int next=n-1;
        sum+=n;
        if (next==0) return sum;
        return sumN(sum,next);
    }

    public boolean isPalindrome(String s){
        if (s.length()%2!=0) return false;
        if (s.charAt(0)!=s.charAt(s.length()-1)) return false;
        if (s.length()==2) return true;
        s=s.substring(1,s.length()-1);
        return isPalindrome(s);
    }




}
