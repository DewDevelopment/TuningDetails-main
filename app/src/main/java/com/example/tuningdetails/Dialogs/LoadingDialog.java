package com.example.tuningdetails.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.view.LayoutInflater;

import com.example.tuningdetails.R;


public class LoadingDialog {
    private Activity activity;
    private AlertDialog dialog;
    private Handler handler;
    private boolean isLoading;

    public LoadingDialog(Activity myActivity){
        activity = myActivity;
        isLoading = false;
        handler = new Handler();
    }
    public void startLoading(){
        if(isLoading) return;
        isLoading = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    public void stopLoading(boolean immediate){
        if(!isLoading) return;
        if(immediate){
            isLoading = false;
            dialog.dismiss();
            return;
        }
        handler.postDelayed(() -> {
            isLoading = false;
            dialog.dismiss();
        }, 1000);
    }
}
