package edu.uoc.android.currentweek;

import java.util.Calendar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class pantalla2 extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextViewResultado;
    private Button mButtonStartOver;
    private Calendar calendario = Calendar.getInstance();
    private String sKeyCurrentWeek = "currentWeekUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        mTextViewResultado = (TextView) findViewById(R.id.tv1);
        mButtonStartOver = (Button) findViewById(R.id.bt1);
        mButtonStartOver.setOnClickListener(this);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        if (getIntent().getExtras().getInt(sKeyCurrentWeek) == diaSemana) {
            mButtonStartOver.setText("START AGAIN");
            mTextViewResultado.setTextColor(Color.GREEN);
            mTextViewResultado.setText("Right!!");
        } else {
            mButtonStartOver.setText("START AGAIN");
            mTextViewResultado.setTextColor(Color.RED);
            mTextViewResultado.setText("You have failed, try again!!");
        }
    }
    public void onClick(View v)
    {
        this.finish();
    }


}
