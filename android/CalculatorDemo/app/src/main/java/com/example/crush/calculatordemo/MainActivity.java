package com.example.crush.calculatordemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import java.util.PriorityQueue;


public class MainActivity implements OnClickListener {

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_equal;
    Button btn_minus;
    Button btn_plus;
    Button btn_clear;
    Button btn_del;
    Button btn_divide;
    Button btn_multiply;
    EditText et_input;
    boolean clearFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_multiply = (Button)findViewById(R.id.btn_multiply);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_point = (Button)findViewById(R.id.btn_point);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_del = (Button)findViewById(R.id.btn_del);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        et_input = (EditText)findViewById(R.id.et_input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_point.setOnClickListener(this);

        return true;
    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if(clearFlag) {
                    clearFlag = false;
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_divide:
            case R.id.btn_multiply:
                et_input.setText(str + " " +((Button)v).getText());
                break;
            case R.id.btn_clear:
                et_input.setText("");
                clearFlag = false;
                break;
            case R.id.btn_del:
                if(clearFlag) {
                    clearFlag = false;
                    et_input.setText("");
                }
                if(str != null && !str.equals("")) {
                    et_input.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }
    private void getResult() {
        String exp = et_input.getText().toString();
        if(exp == null || exp.equals("")) {
            return;
        }

        if(!exp.contains(" ")) {
            return;
        }

        if(clearFlag) {
            clearFlag = false;
            return;
        }

        clearFlag = true;
        String s1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
        String s2 = exp.substring(exp.indexOf(" ")+3);

        double result = 0;
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if(op.equals("+")) {
                result = d1 + d2;
            }
            else if(op.equals("-")) {
                result = d1 - d2;
            }
            else if(op.equals("*")) {
                result = d1 * d2;
            }
            else {
                if(d2 != 0) {
                    result = d1/d2;
                }
                else {
                    result = 0;
                }
            }
            et_input.setText(result+"");
        }
        else if(s1.equals("") && !s2.equals("")) {
            double d1 = 0;
            double d2 = Double.parseDouble(s2);
            if(op.equals("+")) {
                result = d1 + d2;
            }
            else if(op.equals("-")) {
                result = d1 - d2;
            }
            else if(op.equals("*")) {
                result = 0;
            }
            else {
                result = 0;
            }
            et_input.setText(result+"");
        }
        else if(s1.equals("") && s2.equals("")) {
            et_input.setText("");
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
