package edu.neu.finala;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

    public int xxx(int[] nums) {
        //Nothing can be changed below
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        if (l == 1) {
            return nums[0];
        }
        {
            ArrayList answerList = new ArrayList();
            int[] work = {0};
            int[] w = {0};
            Exam b = new Exam(nums, answerList, w, work);
            int t = 0;
            for (int i = 0; i < answerList.size(); ++i) {
                int pos = (int) (answerList.get(i));
                int x = nums[pos];
                t = t + x;
            }
            //Make sure of distance
            Collections.sort(answerList);
            for (int i = 0; i < answerList.size() - 1; i = i + 2) {
                int pos1 = (int) (answerList.get(i));
                int pos2 = (int) (answerList.get(i + 1));
                assert (pos2 >= (pos1 + 1));
            }

            return t;
        }
    }
}

/************************************************************
 Nothing can be changed in class Exam
 *************************************************************/
class Exam {

    private int[] a;
    private int[] maxWeight = {0};
    private ArrayList answerList;
    private int[] work = {0};

    Exam(int[] a, ArrayList answerList, int[] maxWeight, int[] work) {
        this.a = a;
        this.answerList = answerList;
        this.maxWeight = maxWeight;
        this.maxWeight[0] = 0;
        this.work = work;
        this.work[0] = 0;
        Alg alg = new Alg(this);
    }

    public int size() {
        return a.length;
    }

    public int getI(int i) {
        work[0] = work[0] + 1;
        return a[i];
    }

    public void appendAnswer(int i) {
        answerList.add(i);
    }

    public void setmaxWeight(int i) {
        maxWeight[0] = i;
    }
}

/************************************************************
 WRITE CLASS Alg
 YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS
 *************************************************************/
class Alg {

    private Exam e;


    //You can add any number of private variables and private Functions
    Alg(Exam e) {
        this.e = e;
        alg();
    }

    /* Write Your code below */

    private void alg() {
        int n = e.size();
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            this.e.appendAnswer(0);
            this.e.setmaxWeight(this.e.getI(0));
            return;
        }
        if (n == 2) {
            int a0 = e.getI(0);
            int a1 = e.getI(1);
            if (a0 >= a1) {
                e.appendAnswer(0);
                e.setmaxWeight(a0);
            } else {
                e.appendAnswer(1);
                e.setmaxWeight(a1);
            }
            return;
        }
        int[] dp = new int[n];
        int[] parents = new int[n];
        dp[0] = e.getI(0);
        parents[0] = 0;
        if (e.getI(0) >= e.getI(1)) {
            dp[1] = e.getI(0);
            parents[1] = 0;
        } else {
            dp[1] = e.getI(1);
            parents[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            int curr = e.getI(i) + dp[i - 2];
            int prev = dp[i - 1];
            if (curr >= prev) {
                // curr >= prev, using current
                parents[i] = i - 2;
                dp[i] = curr;
            } else {
                parents[i] = -1;
                dp[i] = prev;
            }
        }
        e.setmaxWeight(dp[n - 1]);
        // add path from parents
        int idx = n - 1;
        while (idx >= 0) {
            if (idx == 0 || idx == 1) {
                e.appendAnswer(parents[idx]);
                break;
            }
            if (parents[idx] >= 0) {
                e.appendAnswer(idx);
                idx = parents[idx];
            } else {
                idx = idx - 1;
            }
        }
    }

}