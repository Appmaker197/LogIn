package com.set.ultimax.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button logIn = (Button) findViewById(R.id.btn);
        TextView signUp = (TextView) findViewById(R.id.textView2);

        signUp.setPaintFlags(signUp.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        logIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                DatabaseHandler db = new DatabaseHandler(v.getContext());
                EditText user = (EditText) findViewById(R.id.username);
                EditText pass = (EditText) findViewById(R.id.password);
                String userValue = user.getText().toString();
                String passValue = pass.getText().toString();
                boolean accountMatch = db.validateUser(userValue,passValue);
                int charUserLength = userValue.length();
                int charPassLength = passValue.length();

                if(accountMatch){
                    Intent toSuc = new Intent(Main.this, Success.class);
                    startActivity(toSuc);
                }
                else if(userValue.equals("") && passValue.equals("")){
                    Toast.makeText(Main.this,"Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else if(charUserLength < 5 && charPassLength < 5){ // At least 6 characters anything less is too short
                    Toast.makeText(Main.this,"Characters Too Short", Toast.LENGTH_SHORT).show();
                }
                else{Toast.makeText(Main.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();}
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent toSign = new Intent(Main.this, SignUp.class);
                startActivity(toSign);
            }
        });

    }
}
