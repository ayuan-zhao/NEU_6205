package edu.neu.week03;

/**
 * File Name: DuplicateN.java
 *
 * To Compile: IntUtil.java RandomInt.java DuplicateN.java DuplicateNTest.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

/************************************************************
 Nothing can be changed in class DuplicateN
 *************************************************************/
public class DuplicateN {

    private int[] a; //a[i] guaranteed > 0 && < n-1
    //contents of a should be exactly like the original after your algorithms
    private String algName;
    private int[] numDup;
    private double[] work;
    private boolean show; //show only is show = true

    DuplicateN(int[] a, String algName, int[] numDup, double[] work, boolean show) {
        this.a = a;
        this.algName = algName;
        this.numDup = numDup;
        this.work = work;
        this.show = show;
        AlgduplicateN b = new AlgduplicateN(this, algName, show);
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

    AlgduplicateN(DuplicateN f, String algName, boolean show) {
        //NOTHING CAN BE CHANGED HERE
        this.f = f;
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

    }

    /*
     * Time complexity O(n)
     * Space Complexity O(n)
     */
    private void alg_ntime_n_space() {

    }

    /*
     * Time complexity O(n)
     * Space Complexity O(1)
     */
    private void alg_ntime_constant_space() {

    }


    public static void main(String[] args) {
        System.out.println("Run DuplicateNTest.java");
    }
}



