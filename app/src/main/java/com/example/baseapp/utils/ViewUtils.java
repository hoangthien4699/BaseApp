package com.example.baseapp.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.baseapp.R;

public class ViewUtils {

    public static void setBackGroup(AppCompatTextView textView, int resId) {
        textView.setBackgroundResource(resId);
    }

    public static void showAlertInforDialog(Context context, String message) {
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.view_dialog, null);
            alertDialogBuilder.setView(view);
            alertDialogBuilder.setCancelable(false);
            final AlertDialog dialog = alertDialogBuilder.create();
            AppCompatTextView txtMessage = view.findViewById(R.id.view_dialog_text_message);
            AppCompatTextView txtOK = view.findViewById(R.id.view_dialog_text_ok);
            txtMessage.setText(message);
            txtOK.setOnClickListener(v -> dialog.dismiss());
            dialog.show();
        }

    }

    public static void  showAlertConfirmDialog(Context context, String message, View.OnClickListener listener) {
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.dialog_base_confirm, null);
            alertDialogBuilder.setView(view);
            alertDialogBuilder.setCancelable(false);
            final AlertDialog dialog = alertDialogBuilder.create();
            AppCompatTextView tvContent = view.findViewById(R.id.tv_content);
            AppCompatTextView tvCancel = view.findViewById(R.id.tv_cancel);
            AppCompatTextView tvAccept = view.findViewById(R.id.tv_accept);

            tvContent.setText(message);
            tvCancel.setOnClickListener(v -> dialog.dismiss());
            tvAccept.setOnClickListener(listener);
            dialog.show();
        }

    }
}
