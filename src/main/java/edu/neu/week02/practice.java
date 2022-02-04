package edu.neu.week02;

public class practice {

    public String countAndsay(int n) {
        String ans = alg(n);
        return ans;
    }

    private String alg(String s) {
        if (s.length() == 0) {
            return "";
        }
        int i = 0;
        int cnt = 0;
        char des = s.charAt(i);//s在哪定义的？传进来的s
        StringBuilder sb = new StringBuilder();//字符串拼接
        while (i < s.length()) {
            char curr = s.charAt(i);//s[i]
            if (curr != des) {
                sb.append(cnt);
                sb.append(des);
                des = curr;
                cnt = 1;
            } else {
                cnt++;
            }
            i++;
        }
        sb.append(cnt);
        sb.append(des);
        return sb.toString();

    }

    private String alg(int n) {
        if (n < 1) {
            System.out.println("n must be larger than 1");
            return "Error";
        }
        String res = "1";
        for (int i = 2; i<= n;i++){
            res = alg(res);
        }
        return res;
    }
}


