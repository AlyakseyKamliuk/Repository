package com.Lesson8;

/**
 * Created by Alex on 09.12.2019.
 */
public class SortedParClass {
    private int isSorted=0;
    private int isReverse=0;

    public SortedParClass(int isSorted, int isReverse) {
        this.isSorted = isSorted;
        this.isReverse = isReverse;
    }

    public int getIsSorted() {
        return isSorted;
    }

    public void setIsSorted(int isSorted) {
        this.isSorted = isSorted;
    }

    public int getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(int isReverse) {
        this.isReverse = isReverse;
    }
}
