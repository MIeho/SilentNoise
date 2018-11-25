package com.mho.sn.silentnoise.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.PopupWindow;

import com.mho.sn.silentnoise.R;

public class AddSchemePopupDialog extends DialogFragment {

    private Context popUpContext;
    private PopupWindow addSchemePopUp;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_add_scheme, null))
               .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       // sign in the user ...
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       AddSchemePopupDialog.this.getDialog().cancel();
                   }
               });


        return builder.create();
    }


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scheme);
        popUpContext = getApplicationContext();
        addSchemePopUp = new PopupWindow(this);

        LayoutInflater inflater = (LayoutInflater) popUpContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    }*/
}
