package edu.neu.finala;
import edu.neu.IntUtil;
import java.util.ArrayList;
import java.util.Collections;

/**
 * File Name: TestExam.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */

class TestExam {

    private int[] a; // array {8,1,2}
    private int[] work = {0};
    private int[] maxWeight = {0};
    private boolean show;
    private ArrayList answerList;
    protected static final IntUtil u = new IntUtil();

    TestExam() {
        test1();
    }

    private void p() {
        if (show && answerList.size() > 0) {
            for (int i = 0; i < answerList.size(); ++i) {
                if (i == 0) {
                    System.out.print("{");
                } else {
                    System.out.print(",");
                }
                int pos = (int) (answerList.get(i));
                System.out.print(pos);
            }
            System.out.println("}");
            for (int i = 0; i < answerList.size(); ++i) {
                if (i == 0) {
                    System.out.print("{");
                } else {
                    System.out.print(",");
                }
                int pos = (int) (answerList.get(i));
                int x = a[pos];
                System.out.print(x);
            }
            System.out.println("}");

            //Make sure of distance
            Collections.sort(answerList);
            for (int i = 0; i < answerList.size() - 1; i = i + 2) {
                int pos1 = (int) (answerList.get(i));
                int pos2 = (int) (answerList.get(i + 1));
                assert (pos2 >= (pos1 + 1));
            }
        }
        System.out.println("Weight = " + maxWeight[0]);
        System.out.println("work =   " + work[0]);
    }

    private void assertSum() {
        int t = 0;
        for (int i = 0; i < answerList.size(); ++i) {
            int pos = (int) (answerList.get(i));
            int x = a[pos];
            t = t + x;
        }
        if (t != maxWeight[0]) {
            System.out.println("You said sum is " + maxWeight[0] + ". But when I add sum =" + t);
            u.myassert(false);
        }
    }

    private void test1(String t, int[] a) {
        if (show) {
            System.out.println("------------ " + t + " ---------------------");
            if (a.length > 0) {
                u.pLn(a.length);
                u.pLn(a);
            }
        }
        this.a = a;
        this.answerList = new ArrayList();
        this.maxWeight[0] = 0;
        this.work[0] = 0;
        Exam b = new Exam(a, answerList, maxWeight, work);

        p();
        assertSum();
    }

    private void test1() {
        show = false;
        {
            String s = "test1";
            int[] w = {1, 2, 4};
            test1(s, w);
//            w = new int[]{20, 100, 70};
//            test1(s, w);
//            w = new int[]{2, 80, 91};
//            test1(s, w);
//            w = new int[]{1, 2, 3, 4};
//            test1(s, w);
//            w = new int[]{8, 1, 5, 13};
//            test1(s, w);
        }
    }


    public static void main(String[] args) {
        System.out.println("Test.java EXAM STARTS");
        TestExam t = new TestExam();
        System.out.println("MY NAME AS SHOWN ON CANVAS iS : FILL");
        System.out.println("Time  complexity OF MY CODE is : O(n)");
        System.out.println("Space complexity OF MY CODE is : O(n)");
        System.out.println("NOTE REAL TEST BENCH WILL BE POSTED AFTER EXAM.");
        System.out.println("RUN ON YOUR OWN TO SEE WHERE YOU STAND.");
        System.out.println("Test.java EXAM ENDS");
    }
}
