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
import android.widget.EditText;
import android.widget.PopupWindow;

import com.mho.sn.silentnoise.R;
import com.mho.sn.silentnoise.settings.persistence.DatabaseSilentNoise;
import com.mho.sn.silentnoise.settings.persistence.dao.ScheduleDao;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;
import com.mho.sn.silentnoise.utils.ViewUtils;

public class AddSchemePopupDialog extends DialogFragment {

    private Context popUpContext;
    private ScheduleDao scheduleDao;
    private PopupWindow addSchemePopUp;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        popUpContext = getContext();
        scheduleDao = ((DatabaseSilentNoise) DatabaseSilentNoise.getDatabase(popUpContext)).scheduleDao();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_add_scheme, null))
               .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       EditText editText = (EditText) getDialog().findViewById(R.id.enterNewSchemeNameEditText_Id);
                       ScheduleEntity scheduleEntity = new ScheduleEntity();
                       scheduleEntity.setActive(true);
                       scheduleEntity.setScheduleName(editText.getText().toString());
                       scheduleDao.insert(scheduleEntity);

                       ViewUtils.goToView(popUpContext, scheduleEntity);
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
