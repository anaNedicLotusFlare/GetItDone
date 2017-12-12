package com.example.lotusflareadmin.myapplication.PresentationViewPart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.lotusflareadmin.myapplication.R;

/**
 * Created by Ana Nedic.
 */

public class ShowAboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        String dialogTitle = getString(R.string.aboutTitle);
        String dialogMessage = getString(R.string.aboutText);

//        //Optional requires API 24
//        if (savedInstanceState.get("dialogTitle") != null) {
//            dialogTitle = getString(savedInstanceState.get("dialogTitle").toString();
//        }
//        if (savedInstanceState.get("dialogMessage") != null) {
//            dialogMessage = savedInstanceState.get("dialogMessage").toString();
//        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(dialogTitle).setMessage(dialogMessage)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
