package com.set.ultimax.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Success extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        //Attaching to views
        TextView goHome = (TextView) findViewById(R.id.home);
        TextView goSignUp = (TextView) findViewById(R.id.sign);
        //Underlining TextView
        goHome.setPaintFlags(goHome.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        goSignUp.setPaintFlags(goSignUp.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        //Onclick to navigate to other .classes.
        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent toMain = new Intent(Success.this, Main.class);
                startActivity(toMain);
            }
        });
        goSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent toSuc = new Intent(Success.this, Main.class);
                startActivity(toSuc);
            }
        });
    }
}
