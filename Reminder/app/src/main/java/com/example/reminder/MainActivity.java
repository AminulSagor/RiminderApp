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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView learnMore;
    Button goToLogIn,setReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         learnMore= findViewById(R.id.learnMore);
         goToLogIn=findViewById(R.id.goToLogIn);

        goToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });


        SpannableString spannableString2 = new SpannableString("learn more");
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        };
        spannableString2.setSpan(clickableSpan2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        CharSequence finalText = TextUtils.concat( " To be accountable with your close person. ", spannableString2, " about our mission.");
        learnMore.setText(finalText);
        learnMore.setMovementMethod(LinkMovementMethod.getInstance()); // Enables click on links
        learnMore.setHighlightColor(Color.TRANSPARENT); // Removes link underline if needed








    }
}