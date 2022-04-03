package edu.neu.week8; /**
 * File Name: GraphType.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

/*********************************************************************
 NOTHING CAN BE CHANGED IN THIS FILE
 **********************************************************************/
class GraphType {

    public enum Type {
        NONE, UNDIRECTED, DIRECTED, WEIGHTED_UNDIRECTED, WEIGHTED_DIRECTED
    }

    static String gtype(Type t) {
        if (t == Type.UNDIRECTED) {
            return "UNDIRECTED";
        }
        if (t == Type.DIRECTED) {
            return "DIRECTED";
        }
        if (t == Type.WEIGHTED_UNDIRECTED) {
            return "WEIGHTED_UNDIRECTED";
        }
        if (t == Type.WEIGHTED_DIRECTED) {
            return "WEIGHTED_DIRECTED";
        }
        return "NONE";
    }
}