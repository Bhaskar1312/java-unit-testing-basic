package org.example.coding;

public class RomanToIntClass {
    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        for(int i=0;i<len;i++) {
            if(s.charAt(i) == 'M') res += 1000;
            else if(s.charAt(i)=='D') res += 500;
            else if(s.charAt(i)=='C') {
                if(i+1 < len && (s.charAt(i+1)=='M' || s.charAt(i+1)=='D')) {
                    res -= 100;
                } else {
                    res += 100;
                }
            } else if(s.charAt(i)=='L') {
                res += 50;
            } else if(s.charAt(i)=='X') {
                if(i+1 < len && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')) {
                    res -= 10;
                } else {
                    res += 10;
                }
            }else if(s.charAt(i)=='V') {
                res += 5;
            } else if(s.charAt(i)=='I') {
                if(i+1 < len && (s.charAt(i+1)=='X' || s.charAt(i+1)=='V')) {
                    res -= 1;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToIntClass ob = new RomanToIntClass();
        System.out.println(ob.romanToInt("III")); // 3
        System.out.println(ob.romanToInt("LVIII")); // 58
        System.out.println(ob.romanToInt("MCMXCIV")); //1994

        ob.print("LVIII");
    }

    public void print(String s) {
        int ans = romanToInt(s);
        System.out.println(ans);
//        return ans;
    }
}
