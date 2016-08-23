package com.example.user.calculate;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mInfoText;
    private List<Button> mNumberButtons = new ArrayList<>();
    private String mVar = "";
    private double mLeft;
    private int mOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInfoText = (TextView)findViewById(R.id.tex);
        mNumberButtons.add((Button)findViewById(R.id.button0));
        mNumberButtons.add((Button)findViewById(R.id.button1));
        mNumberButtons.add((Button)findViewById(R.id.button2));
        mNumberButtons.add((Button)findViewById(R.id.button3));
        mNumberButtons.add((Button)findViewById(R.id.button4));
        mNumberButtons.add((Button)findViewById(R.id.button5));
        mNumberButtons.add((Button)findViewById(R.id.button6));
        mNumberButtons.add((Button)findViewById(R.id.button7));
        mNumberButtons.add((Button)findViewById(R.id.button8));
        mNumberButtons.add((Button)findViewById(R.id.button9));

    }


    public void onClickClear(View view) {
        mVar = "";
        mInfoText.setText("0");
        mOperation = 0;
    }

    public void onClickOperation(View view) {
        try {
            if (mOperation != 0) {
                double mRight = Double.parseDouble(mVar);
                mVar = "";
                switch (mOperation) {
                    case R.id.buttonPlus: mLeft += mRight; break;
                    case R.id.buttonMinus: mLeft -= mRight; break;
                    case R.id.buttonMult: mLeft *= mRight; break;
                    case R.id.buttonDiv: mLeft /= mRight; break;
                }
                mInfoText.setText(Double.toString(mLeft));
            }
            else {
                mLeft = Double.parseDouble(mVar);
                mVar = "";
            }
            mOperation = view.getId();
        }
        catch (NumberFormatException e) {}

    }

    public void onClickEqually(View view) {
        try {
            double mRight = Double.parseDouble(mVar);
            mVar = "";
            switch (mOperation) {
                case R.id.buttonPlus: mLeft += mRight; break;
                case R.id.buttonMinus: mLeft -= mRight; break;
                case R.id.buttonMult: mLeft *= mRight; break;
                case R.id.buttonDiv: mLeft /= mRight; break;
            }
            mOperation = 0;
            mInfoText.setText(Double.toString(mLeft));
        }
        catch (NumberFormatException e)  { }
    }

    public void onClickDot(View view) {
        if (!mVar.contains(".")) {
            mVar += ".";
        }
    }

    public void onClickDigit(View view) {
        if (mVar.length() < 10) {
            if (mVar.equals("0")) {
                mVar = "";
            }
            mVar += Integer.toString(mNumberButtons.indexOf(view));
            mInfoText.setText(mVar);

        }
    }

    public void onClickSelect(View view) {
    }
}

