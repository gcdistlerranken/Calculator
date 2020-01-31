package com.google.distlergrace.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    //Program Constants
    final String INVALIDINPUT         = "INVALID NUMBER INPUTTED!\nRESETTING AND RETURNING.";
    final String INPUTEQUALTOZERO     = "ILLEGAL ATTEMPT TO DIVIDE BY 0.\nRESETTING AND RETURNING.";
    final String CALCULATIONCOMPLETED = "Calculation Completed.";

    //Program Widget Variables
    EditText    editTextFirstInput;
    EditText    editTextSecondInput;
    Button      buttonAdd;
    Button      buttonSubtract;
    Button      buttonMultiply;
    Button      buttonDivide;
    Button      buttonModulus;
    Button      buttonClear;
    TextView    textViewResults;
    DecimalFormat convertFormat = new DecimalFormat("#,##0.00");

    //Program Non-Widget Variables
    int firstNumber  = 0;
    int secondNumber = 0;
    int answer       = 0;
    String resultStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFirstInput  = (EditText) findViewById(R.id.editTextFirstInput);
        editTextSecondInput = (EditText) findViewById(R.id.editTextSecondInput);
        buttonAdd           = (Button)   findViewById(R.id.buttonAdd);
        buttonSubtract      = (Button)   findViewById(R.id.buttonSubtract);
        buttonMultiply      = (Button)   findViewById(R.id.buttonMultiply);
        buttonDivide        = (Button)   findViewById(R.id.buttonDivide);
        buttonModulus       = (Button)   findViewById(R.id.buttonModulus);
        buttonClear         = (Button)   findViewById(R.id.buttonClear);
        textViewResults     = (TextView) findViewById(R.id.textViewResults);

        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateFirstNumber();

                if (keepGoing)
                {
                    keepGoing = validateSecondNumber();
                }

                if (keepGoing)
                {
                    answer = firstNumber + secondNumber;
                    resultStr = "Calculation: " + firstNumber + " + " + secondNumber +
                                " = " + answer;
                    Toast toast = Toast.makeText(getApplicationContext(),
                                                 CALCULATIONCOMPLETED,
                                                 Toast.LENGTH_LONG);
                    toast.show();
                    textViewResults.setText(resultStr);
                }
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateFirstNumber();

                if (keepGoing)
                {
                    keepGoing = validateSecondNumber();
                }

                if (keepGoing)
                {
                    answer = firstNumber - secondNumber;
                    resultStr = "Calculation: " + firstNumber + " - " + secondNumber +
                                " = " + answer;
                    Toast toast = Toast.makeText(getApplicationContext(),
                                                 CALCULATIONCOMPLETED,
                                                 Toast.LENGTH_LONG);
                    toast.show();
                    textViewResults.setText(resultStr);
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateFirstNumber();

                if (keepGoing)
                {
                    keepGoing = validateSecondNumber();
                }

                if (keepGoing)
                {
                    answer = firstNumber * secondNumber;
                    resultStr = "Calculation: " + firstNumber + " * " + secondNumber +
                                " = " + answer;
                    Toast toast = Toast.makeText(getApplicationContext(),
                                                 CALCULATIONCOMPLETED,
                                                 Toast.LENGTH_LONG);
                    toast.show();
                    textViewResults.setText(resultStr);
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateFirstNumber();

                if (keepGoing)
                {
                    keepGoing = validateSecondNumberForDivision();
                }

                if (keepGoing)
                {
                    answer = firstNumber / secondNumber;
                    resultStr = "Calculation: " + firstNumber + " / " + secondNumber +
                                " = " + answer;
                    Toast toast = Toast.makeText(getApplicationContext(),
                                                 CALCULATIONCOMPLETED,
                                                 Toast.LENGTH_LONG);
                    toast.show();
                    textViewResults.setText(resultStr);
                }
            }
        });

        buttonModulus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateFirstNumber();

                if (keepGoing)
                {
                    keepGoing = validateSecondNumber();
                }

                if (keepGoing)
                {
                    answer = firstNumber % secondNumber;
                    resultStr = "Calculation: " + firstNumber + " % " + secondNumber +
                                " = " + answer;
                    Toast toast = Toast.makeText(getApplicationContext(),
                                                 CALCULATIONCOMPLETED,
                                                 Toast.LENGTH_LONG);
                    toast.show();
                    textViewResults.setText(resultStr);
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clearAll();

            }
        });

    }

    private boolean validateFirstNumber()
    {
        try
        {
            //Read Value From editTextFirstInput
            firstNumber = Integer.parseInt(editTextFirstInput.getText().toString());

            //Make Sure  Is Inputted And A Positive Number
            while (firstNumber < -1)
            {
                firstNumber = 0;
                editTextFirstInput.setText("");
                editTextFirstInput.requestFocus();
                throw new NumberFormatException();
            }
            return true;
        }
        catch (NumberFormatException nfe)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                                         INVALIDINPUT,
                                         Toast.LENGTH_LONG);
            toast.show();

            return false;
        }
    }

    private boolean validateSecondNumber()
    {
        try
        {
            //Read Value From editTextSecondInput
            secondNumber = Integer.parseInt(editTextSecondInput.getText().toString());

            //Make Sure  Is Inputted And A Positive Number
            while (secondNumber < -1)
            {
                secondNumber = 0;
                editTextSecondInput.setText("");
                editTextSecondInput.requestFocus();
                throw new NumberFormatException();
            }
            return true;
        }
        catch (NumberFormatException nfe)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    INVALIDINPUT,
                    Toast.LENGTH_LONG);
            toast.show();

            return false;
        }
    }

    private boolean validateSecondNumberForDivision()
    {
        try
        {
            //Read Value From editTextSecondInput
            secondNumber = Integer.parseInt(editTextSecondInput.getText().toString());

            //Make Sure  Is Inputted And Greater Than Zero
            while (secondNumber < 1)
            {
                secondNumber = 0;
                editTextSecondInput.setText("");
                editTextSecondInput.requestFocus();
                throw new NumberFormatException();
            }
            return true;
        }
        catch (NumberFormatException nfe)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                                         INPUTEQUALTOZERO,
                                         Toast.LENGTH_LONG);
            toast.show();

            return false;
        }
    }

    private void clearAll()
    {
        editTextFirstInput.setText("");
        editTextSecondInput.setText("");
        editTextFirstInput.requestFocus();
        textViewResults.setText("");
        firstNumber  = 0;
        secondNumber = 0;
        answer       = 0;
        resultStr    = "";
    }
}
