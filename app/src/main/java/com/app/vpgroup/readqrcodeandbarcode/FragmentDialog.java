package com.app.vpgroup.readqrcodeandbarcode;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class FragmentDialog extends DialogFragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        getDialog().setTitle("Infomation");
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.holo_green_dark);
       window.setLogo(R.drawable.barcode);

        return view;
    }


//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//        return new AlertDialog.Builder(getActivity())
//                .setTitle("About Us")
//
//                .setPositiveButton("OKIE", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                }).create();
//
//    }
}
