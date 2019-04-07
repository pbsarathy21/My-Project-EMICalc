package com.example.chitcalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {

    EditText loanAmount,interestAmount,daysEditText;
    Button calculateInterest;
    TextView result;


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);


        loanAmount = view.findViewById(R.id.loanAmount);
        interestAmount= view.findViewById(R.id.interestAmount);
        daysEditText = view.findViewById(R.id.daysEditText);

        calculateInterest = view.findViewById(R.id.calculateInterest);

        result = view.findViewById(R.id.interest_result);

        result.setVisibility(View.GONE);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = loanAmount.getText().toString().trim();
                String interest = interestAmount.getText().toString().trim();
                String days = daysEditText.getText().toString().trim();

                boolean valid = checkValidation(amount, interest, days);

                if (valid)
                    calculateInterest(amount, interest, days);
            }
        });

        return view;
    }

    private void calculateInterest(String amount, String interest, String days) {

        int amt = Integer.parseInt(amount);
        int intrst = Integer.parseInt(interest);
        int day = Integer.parseInt(days);

        double res = (amt/1000)*(intrst/3)*day;

        result.setText(String.valueOf(res));
        result.setVisibility(View.VISIBLE);
    }

    private boolean checkValidation(String amount, String interest, String days) {

        if (amount.isEmpty())
        {
            loanAmount.setError("required");
            loanAmount.requestFocus();
            return false;
        }

        if (interest.isEmpty())
        {
            interestAmount.setError("required");
            interestAmount.requestFocus();
            return false;
        }

        if (days.isEmpty())
        {
            daysEditText.setError("required");
            daysEditText.requestFocus();
            return false;
        }

        return true;
    }

}
