package org.mifos.mobilewallet.mifospay.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.text.NumberFormat;
import java.util.Currency;

/**
 * Created by naman on 17/6/17.
 */

public class Utils {

    public static void hideSoftKeyboard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) activity.getSystemService(
                            Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static int dp2px(Context context, int dp) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);

        return (int) (dp * displaymetrics.density + 0.5f);
    }

    public static boolean isBlank(String s) {
        if (s == null) return true;
        for (char ch : s.toCharArray()) {
            if (!Character.isWhitespace(ch)) return false;
        }
        return true;
    }

    public static String getFormattedAccountBalance(Double balance, String currencyCode) {
        NumberFormat accountBalanceFormatter = NumberFormat.getCurrencyInstance();
        accountBalanceFormatter.setMaximumFractionDigits(0);
        accountBalanceFormatter.setCurrency(Currency.getInstance(currencyCode));

        return accountBalanceFormatter.format(balance);
    }
}
