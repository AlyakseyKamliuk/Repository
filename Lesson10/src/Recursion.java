

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
        String tmp=""+n;
        String str=tmp.substring(tmp.length()-1,tmp.length());
        sum+=Integer.parseInt(str);
        String next="";
        next=tmp.substring(0,tmp.length()-1);
        if (next.length()==0) return sum;
        return sumN(sum,Integer.parseInt(next));
    }
 /*   private int sumN2(int sum, int n){
        String tmp=""+n;
        char[] ints=tmp.toCharArray();
        

        return sumN(sum,Integer.parseInt(next));
    } */

    public boolean isPalindrome(String s){
        if (s.charAt(0)!=s.charAt(s.length()-1)) return false;
        if ((s.length()==2)||(s.length()==3)) return true;
        s=s.substring(1,s.length()-1);
        return isPalindrome(s);
    }

    public void test(){

    }


}
