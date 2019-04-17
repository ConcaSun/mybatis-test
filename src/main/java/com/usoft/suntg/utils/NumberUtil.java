package com.usoft.suntg.utils;

import java.util.Arrays;

/**
 * Created by ConcaSun on 2019/4/17.
 */
public class NumberUtil {

    public static double add(double... vars) {
        return Arrays.stream(vars).sum();
    }

    public static double minus(double var1, double var2) {
        return var1 - var2;
    }
}
