package com.example.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView SignUp;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignUp=findViewById(R.id.SignUp);
        login=findViewById(R.id.logInButton);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        SpannableString spannableString2 = new SpannableString("SignUp");
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        };
        spannableString2.setSpan(clickableSpan2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        CharSequence finalText = TextUtils.concat( " Don't have an account,  ", spannableString2);
        SignUp.setText(finalText);
        SignUp.setMovementMethod(LinkMovementMethod.getInstance()); // Enables click on links
        SignUp.setHighlightColor(Color.TRANSPARENT); // Removes link underline if needed

    }
}