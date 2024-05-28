package com.example.reminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class yourInformation extends Fragment {

    TextView nameProfile,emailOrPhoneProfile,dateOfBirthProfile,genderProfile,addressProfile;
    EditText editTextNameF,editTextEmailPhoneF,editTextDateOfBirthProfile,EditTextAddressProfileF;
    LinearLayout linerForRadioProfile;
    Button btnEdit;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_information, container, false);


        nameProfile = view.findViewById(R.id.nameProfile);
        emailOrPhoneProfile = view.findViewById(R.id.emailOrPhoneProfile);
        dateOfBirthProfile = view.findViewById(R.id.dateOfBirthProfile);
        genderProfile = view.findViewById(R.id.genderProfile);
        addressProfile = view.findViewById(R.id.addressProfile);

        editTextNameF = view.findViewById(R.id.editTextNameF);
        editTextEmailPhoneF = view.findViewById(R.id.editTextEmailPhoneF);
        editTextDateOfBirthProfile = view.findViewById(R.id.editTextDateOfBirthProfile);
        EditTextAddressProfileF = view.findViewById(R.id.EditTextAddressProfileF);

        linerForRadioProfile = view.findViewById(R.id.linerForRadioProfile);

        btnEdit = view.findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEdit.setText("Click to update");
                nameProfile.setVisibility(View.GONE);
                emailOrPhoneProfile.setVisibility(View.GONE);
                dateOfBirthProfile.setVisibility(View.GONE);
                genderProfile.setVisibility(View.GONE);
                addressProfile.setVisibility(View.GONE);

                // Show EditTexts
                editTextNameF.setVisibility(View.VISIBLE);
                editTextEmailPhoneF.setVisibility(View.VISIBLE);
                editTextDateOfBirthProfile.setVisibility(View.VISIBLE);
                EditTextAddressProfileF.setVisibility(View.VISIBLE);

                // Show LinearLayout
                linerForRadioProfile.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}