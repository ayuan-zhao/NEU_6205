package edu.neu.week03;

/**
 * File Name: DuplicateN.java
 *
 * To Compile: IntUtil.java RandomInt.java DuplicateN.java DuplicateNTest.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

import edu.neu.week01.IntUtil;
import java.util.Arrays;

/************************************************************
 Nothing can be changed in class DuplicateN
 *************************************************************/
public class DuplicateN {

    public int[] a; //a[i] guaranteed > 0 && < n-1
    //contents of a should be exactly like the original after your algorithms
    private String algName;
    public int[] numDup;
    private double[] work;
    private boolean show; //show only is show = true

    DuplicateN(int[] a, String algName, int[] numDup, double[] work, boolean show) {
        this.a = a;
        this.algName = algName;
        this.numDup = numDup;
        this.work = work;
        this.show = show;
        AlgduplicateN b = new AlgduplicateN(this, algName, show);
        if (b.res.length > 0) {
            numDup[0] = b.res[0];
        }
    }

    public int size() {
        return a.length;
    }

    public int getI(int i) {
        work[0]++;
        return a[i];
    }

    public void setI(int i, int v) {
        work[0]++;
        a[i] = v;
    }

    public void setnumDup(int v) {
        numDup[0] = v;
    }
}

/************************************************************
 WRITE CLASS AlgduplicateN
 YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS
 *************************************************************/
class AlgduplicateN {

    private DuplicateN f;
    private String algName;
    private boolean show; //show only is show = true
    private int[] arr;
    public int[] res;
    private IntUtil u = new IntUtil();

    public AlgduplicateN() {
    }

    AlgduplicateN(DuplicateN f, String algName, boolean show) {
        //NOTHING CAN BE CHANGED HERE
        this.f = f;
        this.arr = u.copyArray(f.a);
        this.show = show;
        if (algName == "NsquareTimeConstantSpace") {
            alg_nsquare_time_constant_space();
        } else if (algName == "NTimeNSpace") {
            //alg_nsquare_time_constant_space();
            alg_ntime_n_space();
        } else if (algName == "NTimeConstantSpace") {
            //alg_nsquare_time_constant_space();
            alg_ntime_constant_space();
        }
    }

    /*
     * WRITE YOUR CODE BELOW
     */


    /*
     * Time complexity O(n^2)
     * Space Complexity O(1)
     */
    private void alg_nsquare_time_constant_space() {
        int n = arr.length;
        int[] tmp = new int[n];
        int len = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isDup = false;
            if (arr[i] < n) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == arr[i]) {
                        // find duplicate, mark it.
                        arr[j] += n;
                        isDup = true;
                    }
                }
            }
            // if isDup == true, that means it has duplicate, add this value into tmp.
            if (isDup) {
                tmp[len] = arr[i];
                len++;
                arr[i] += n;
            }
        }
//        copy tmp into res
        this.res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = tmp[i];
        }
        Arrays.sort(res);
        printArr("alg_nsquare_time_constant_space", this.res);
    }

    /*
     * Time complexity O(n)
     * Space Complexity O(n)
     */
    private void alg_ntime_n_space() {
        int n = arr.length;
        int[] b = new int[n];
//        printArr(b);
        for (int e : arr) {
            b[e]--;
        }

        int size = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] <= -2) {
                size++;
            }
        }
        res = new int[size];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] <= -2) {
                res[j] = i;
                j++;
            }
        }
        printArr("alg_ntime_n_space", this.res);

    }


    /*
     * Time complexity O(n)
     * Space Complexity O(1)
     */
    private void alg_ntime_constant_space() {
        int n = arr.length;
        for (int e : arr) {
            if (arr[e % n] <= 2 * n) {
                arr[e % n] = arr[e % n] + n;
            }
        }

        int size = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n * 2) {
                size++;
            }
        }

        res = new int[size];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n * 2) {
                res[j] = i;
                j++;
            }
        }
        printArr("alg_ntime_constant_space", this.res);
    }

    private void printArr(String mname, int[] arr1) {
//        System.out.println("-------- " + mname + " --------");
//        Arrays.stream(arr1).forEach((x) -> {
//            System.out.print(x + " ");
//        });
//        System.out.println("\n");
    }


    public static void main(String[] args) {
        System.out.println("Run DuplicateNTest.java");
        AlgduplicateN algduplicateN = new AlgduplicateN();

        algduplicateN.arr = new int[]{1, 1, 1};
        algduplicateN.alg_nsquare_time_constant_space();
    }
}



