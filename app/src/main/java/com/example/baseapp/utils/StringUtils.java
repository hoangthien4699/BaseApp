package com.example.baseapp.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils {

    public static String convertToCurrency(int price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        return currencyVN.format(price);
    }

    public static int convertCurrencyToInt(String price) {
        return Integer.parseInt(price.replaceAll("[^\\d]", ""));
    }
}
