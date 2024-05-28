package com.example.reminder;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    TextView Terms;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Terms=findViewById(R.id.terms);
        SignUp=findViewById(R.id.signUpButton);



        SpannableString spannableString2 = new SpannableString("terms and conditions");
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        };
        spannableString2.setSpan(clickableSpan2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        CharSequence finalText = TextUtils.concat( "By clicking SignUp you are agreeing with our ", spannableString2);
        Terms.setText(finalText);
        Terms.setMovementMethod(LinkMovementMethod.getInstance()); // Enables click on links
        Terms.setHighlightColor(Color.TRANSPARENT); // Removes link underline if needed



        TextInputLayout dateOfBirthTextInputLayout = findViewById(R.id.dateOfBirth);
        EditText dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);

        dateOfBirthEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, OtpActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to show a date picker dialog
    private void showDatePickerDialog() {
        // Get the current date to use as the initial date in the DatePickerDialog
        Calendar calendar = Calendar.getInstance();
        int initialYear = calendar.get(Calendar.YEAR);
        int initialMonth = calendar.get(Calendar.MONTH);
        int initialDay = calendar.get(Calendar.DAY_OF_MONTH);

        // Implement your date picker dialog logic here
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle selected date
                        // Update the EditText with the selected date
                        String selectedDate = (month + 1) + "/" + dayOfMonth + "/" + year;
                        EditText dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);
                        dateOfBirthEditText.setText(selectedDate);
                    }
                }, initialYear, initialMonth, initialDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

    }

}