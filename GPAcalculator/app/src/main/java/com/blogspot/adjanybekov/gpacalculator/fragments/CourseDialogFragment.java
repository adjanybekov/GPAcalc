package com.blogspot.adjanybekov.gpacalculator.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blogspot.adjanybekov.gpacalculator.R;
import com.blogspot.adjanybekov.gpacalculator.provider.DataBase;

import java.util.Date;

/**
 * Created by User on 13/08/2016.
 */
public class CourseDialogFragment extends DialogFragment {



    TextView tv;
    EditText et;
    NumberPicker creditPicker;
    NumberPicker gradePicker;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_courseinfo,null);
        creditPicker = (NumberPicker) v.findViewById(R.id.numberPicker1);
        gradePicker = (NumberPicker) v.findViewById(R.id.numberPicker2);

        tv = (TextView) v.findViewById(R.id.idTv);
        et = (EditText) v.findViewById(R.id.idCourseName);


        creditPicker.setMaxValue(7);
        creditPicker.setMinValue(0);
        gradePicker.setMaxValue(11);
        gradePicker.setMinValue(0);


        creditPicker.setWrapSelectorWheel(false);
//        creditPicker.setOnValueChangedListener(this);
        gradePicker.setWrapSelectorWheel(false);
        gradePicker.setDisplayedValues( new String[] { "AA", "BA", "BB","CB","CC","DC","DD",
                                            "FD","FF","NA","S","U"} );
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        builder.setMessage("Are you sure you want to save task?")
                .setView(v)

//                .setTitle("Are you sure?")
                .setCancelable(true)
                .setPositiveButton("SAVE",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    save();
                            }
                        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }


    public void save(){
        DataBase dataBase = new DataBase(getContext());
        SQLiteDatabase db = dataBase.getWritableDatabase();
        String text = et.getText().toString();
        System.out.println(text);
        ContentValues values = new ContentValues();
        values.put(DataBase.COLUMN_NAME,text);
        values.put(DataBase.COLUMN_CREDIT,2);
        values.put(DataBase.COLUMN_GRADE,3);
        db.insert(DataBase.DATABASE_TABLE,null,values);
    }

}
