package edu.neu.week02;


import java.util.Arrays;

/**
 * File Name: L0066.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */

public class L0066 {

    private int[] a;
    private int[][] ans;
    private int[] work;
//    private int work1;
    //YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS

    L0066(int[] a, int[][] ans, int[] work) {
        this.a = a;
        this.ans = ans;
        this.work = work;
//        this.work1 = work1;
        int[] res = alg();
        ans[0] = res;
    }


    /*-----------------  WRITE CODE BELOW ---------------------------------*/
    private int[] alg() {

        //WRITE CODE
        int n = a.length;
        for (int i = a.length - 1; i >= 0; i--) {
            work[0]++;
            if (a[i] != 9) {
                a[i]++;
                return a;
            }
            a[i] = 0;
        }
        // every number is 9.
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        work[0]++;

        return newNumber;
    }


    public static void main(String[] args) {
        System.out.println("Run L0066Test.java");
//        int[] newNumber = new int[5];
//        newNumber[0] = 1;
//        for (int i = 0; i < 5; i++) {
//            System.out.print(" " + newNumber[i]);
//        }
//        Arrays.asList(newNumber).forEach((x)-> System.out.println(x));
//        System.out.println(Arrays.asList(newNumber));

        int[][] a = new int[2][];
        a[0]= new int[]{0,1,2};
        a[1]= new int[]{0,1,2};
//        a[1][0] = 1;
    }
}


