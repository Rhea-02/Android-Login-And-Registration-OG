package com.example.android_login_and_registration_og;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.app.AlertDialog;
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import java.util.Map;
import java.util.HashMap;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public class Functions {

    // ... (other members and methods)

    public static void showProgressDialog(Context context, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ProgressBar progressBar = new ProgressBar(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        progressBar.setLayoutParams(lp);
        builder.setView(progressBar);
        builder.setTitle(title);
        builder.setCancelable(false); // Optional: Set to false if you want to make it non-cancellable
        AlertDialog dialog = builder.create();
        dialog.show();
        contextMap.put(context, dialog); // Store the dialog instance for later dismissal
    }

    public static void hideProgressDialog(Context context) {
        AlertDialog dialog = contextMap.get(context);
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    // Utility method to store context and dialog mapping
    private static Map<Context, AlertDialog> contextMap = new HashMap<>();
}


