package com.codingthrough.sort;

import java.util.Comparator;

/**
 * The <tt>Shell</tt> class provides static methods to sort an array
 * using Shell sort algorithm with Knuth's increment sequence (1, 4, 13, 40, ...).
 *
 * @author Katherine Tregubova
 */
public class Shell {
    /**
     * This class should not be instantiated.
     */
    private Shell() {
    }

    /**
     * Rearranges the specified array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static <T extends Comparable<T>> void sort(final T[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Rearranges the specified array in ascending order, using the natural order.
     *
     * @param a  the array to be sorted
     * @param lo index of first element in subarray
     * @param hi index of last element in subarray
     */
    public static <T extends Comparable<T>> void sort(final T[] a, int lo, int hi) {
        final int n = hi - lo + 1;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = lo + h; i <= hi; i++) {
                for (int j = i; j > lo && less(a, j, j - h); j -= h) {
                    exchange(a, j, j - h);
                }
            }

            h /= 3;
        }
    }

    /**
     * Rearranges the specified array in ascending order, using a comparator.
     *
     * @param a the array to be sorted
     * @param c the comparator specifying the order
     */
    public static <T extends Comparable<T>> void sort(final T[] a, final Comparator<T> c) {
        sort(a, 0, a.length, c);
    }

    /**
     * Rearranges the specified array in ascending order, using a comparator.
     *
     * @param a  the array to be sorted
     * @param lo index of first element in subarray
     * @param hi index of last element in subarray
     * @param c  the comparator specifying the order
     */
    public static <T extends Comparable<T>> void sort(final T[] a, int lo, int hi, final Comparator<T> c) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a, j, j - 1, c); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

    /**
     * @param a the array of items
     * @param i index of left item
     * @param j index of right item
     * @param c the comparator specifying the order
     * @return true if left item is less than right item, otherwise - false.
     * @throws NullPointerException if left item is null.
     * @throws ClassCastException   if left item's type prevents it
     *                              from being compared to right item.
     */
    public static <T extends Comparable<T>> boolean less(final T[] a, int i, int j, final Comparator<T> c) {
        return less(a[i], a[j], c);
    }

    /**
     * @param a left item to compare
     * @param b right item to compare
     * @param c the comparator specifying the order
     * @return true if left item is less than right item, otherwise - false.
     * @throws NullPointerException if left item is null.
     * @throws ClassCastException   if left item's type prevents it
     *                              from being compared to right item.
     */
    public static <T extends Comparable<T>> boolean less(final T a, final T b, final Comparator<T> c) {
        return c.compare(a, b) < 0;
    }

    /**
     * @param a the array of items
     * @param i index of left item
     * @param j index of right item
     * @return true if left item is less than right item, otherwise - false.
     * @throws NullPointerException if left item is null.
     * @throws ClassCastException   if left item's type prevents it
     *                              from being compared to right item.
     */
    public static <T extends Comparable<T>> boolean less(final T[] a, int i, int j) {
        return less(a[i], a[j]);
    }

    /**
     * @param a left item to compare
     * @param b right item to compare
     * @return true if left item is less than right item, otherwise - false
     * @throws NullPointerException if left item is null.
     * @throws ClassCastException   if left item's type prevents it
     *                              from being compared to right item.
     */
    public static <T extends Comparable<T>> boolean less(final T a, final T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * Exchanges items by specified indexes.
     *
     * @param a array of items
     * @param i index of left item
     * @param j index of right item
     */
    public static <T extends Comparable<T>> void exchange(final T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Checks whether the specified array is sorted in ascending order, using the natural order.
     *
     * @param a the array of items
     */
    public static <T extends Comparable<T>> boolean sorted(final T[] a) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            if (less(a, i, i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether the specified array is sorted in ascending order, using the natural order.
     *
     * @param a the array of items
     * @param h the step during Shell sort
     */
    public static <T extends Comparable<T>> boolean hSorted(final T[] a, final int h) {
        final int n = a.length;
        for (int i = h; i < n; i++) {
            if (less(a, i, i - h)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether the specified array is sorted in ascending order, using the natural order.
     *
     * @param a the array of items
     * @param c the comparator specifying the order
     */
    public static <T extends Comparable<T>> boolean sorted(final T[] a, final Comparator<T> c) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            if (less(a, i, i - 1, c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether the specified array is sorted in ascending order, using the natural order.
     *
     * @param a the array of items
     * @param h the step during Shell sort
     * @param c the comparator specifying the order
     */
    public static <T extends Comparable<T>> boolean sorted(final T[] a, final int h, final Comparator<T> c) {
        final int n = a.length;
        for (int i = h; i < n; i++) {
            if (less(a, i, i - h, c)) {
                return false;
            }
        }

        return true;
    }
}
