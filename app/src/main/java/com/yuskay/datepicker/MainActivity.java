package com.yuskay.datepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView tvCalender,tvResultc,tvTime,tvResultt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCalender=findViewById(R.id.tvCalander);
        tvResultc=findViewById(R.id.tvResultc);
        tvTime=findViewById(R.id.tvTime);
        tvResultt=findViewById(R.id.tvResultt);

        tvCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCalander();

            }
        });


        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();

            }
        });

    }

    private void loadCalander(){
        final Calendar c= Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =new DatePickerDialog(this,this,year,month,day);
        datePickerDialog.show();

    }

    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvResultt.setText("Time is :" + hourOfDay + ":" + minute);
            }
        },hour,minute,false);
        timePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date ="Day/Month/Year : " +dayOfMonth+ "/"+month+"/"+year;
        tvResultc.setText(date);
    }
}
