package kr.hs.emirim.young111.reservationsystem;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart, butDone;
    RadioButton radioDate, radioTime;
    CalendarView calView;
    TimePicker timePick;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = (Chronometer)findViewById(R.id.chrono);
        butStart = (Button)findViewById(R.id.but_start);
        butDone = (Button)findViewById(R.id.but_done);
        radioDate = (RadioButton)findViewById(R.id.radio_date);
        radioTime = (RadioButton)findViewById(R.id.radio_time);
        calView=(CalendarView)findViewById(R.id.calendar);
        timePick = (TimePicker)findViewById(R.id.time_pick);
        textResult = (TextView)findViewById(R.id.text_result);
        timePick.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timePick.setVisibility(View.INVISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                timePick.setVisibility(View.VISIBLE);
            }
        });

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        butDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                Calendar car = Calendar.getInstance();
                car.setTimeInMillis(calView.getDate());
                int year = car.get(Calendar.YEAR);
                int month = car.get(Calendar.MONTH)+1;
                int date = car.get(Calendar.DATE);
                //int hour = timePick.getHour();
               // int minute = timePick.getMinute();
                String dateAndTime = year + "년 "+month+"월 "+date+"일";
                textResult.setText(dateAndTime);
            }
        });
    }
}
