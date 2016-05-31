package com.testing.atul.counter1;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    int count = 0;
    int col = 0;
    private static final List<Integer> randColor = new ArrayList<Integer>(){{
        add(R.color.color1);
        add(R.color.color2);
        add(R.color.color3);
        add(R.color.color4);
        add(R.color.color5);
        add(R.color.color6);
    }};

    TextView t;
    RelativeLayout rl;
    Activity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = this;
        t = (TextView) findViewById(R.id.box1);
        t.setText("0");

        rl = (RelativeLayout)findViewById(R.id.lay1);

        Button up = (Button) findViewById(R.id.button);
        Button r = (Button) findViewById(R.id.button2);

        assert up != null;
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                col = (col+1)%6;
                rl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),randColor.get(col)));
                t.setText(String.format("%d",count));

            }
        });

        assert r != null;
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                t.setText("0");
                act.findViewById(android.R.id.content).setBackgroundColor(Color.GRAY);
                //rl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), Color.GRAY));

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Counter",count);
        outState.putInt("Color", col);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("Counter",0);
        col = savedInstanceState.getInt("Color");
        t.setText(String.format("%d",count));
        rl.setBackgroundColor(ContextCompat.getColor(this,randColor.get(col)));
    }
}
