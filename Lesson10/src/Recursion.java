

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
    sum+=n%10;
    int next=n/10;
    if (next==0) return sum;
    return sumN(sum,next);
    }

    public boolean isPalindrome(String s){
        if ((s.length()==1)||(s.length()==0)) return true;
        if (s.charAt(0)!=s.charAt(s.length()-1)) return false;
        return isPalindrome(s.substring(1,s.length()-1));
    }



}
