package edu.uoc.android.currentweek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pantalla1 extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditTextWeekNumber;
    private Button mButtonCheck;
    private String sKeyCurrentWeek = "currentWeekUser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        // arreguem vistes
        mEditTextWeekNumber = (EditText) findViewById(R.id.et1);
        mButtonCheck = (Button) findViewById(R.id.btCheck);

        // apliquem listeners pels events

        mButtonCheck.setOnClickListener(this);

        if (savedInstanceState != null)
        {
            mEditTextWeekNumber.setText(savedInstanceState.getString(sKeyCurrentWeek));
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString(sKeyCurrentWeek,mEditTextWeekNumber.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onClick(View v)
    {

        if (v == mButtonCheck)
        {
            if (mEditTextWeekNumber.getText().toString().isEmpty())
            {
                mEditTextWeekNumber.setError("Introduce the current week number");
                return;
            }
            startActivityPantalla2();
        }
    }

    private void startActivityPantalla2() {
        Intent intent = new Intent(this,pantalla2.class);
        intent.putExtra(sKeyCurrentWeek,mEditTextWeekNumber.getText());
        startActivity(intent);

    }
}
