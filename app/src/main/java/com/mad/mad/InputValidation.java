package com.mad.mad;



import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.widget.Toast.*;

public class InputValidation
{
    private Context context;

    public InputValidation(Context context)
    {
        this.context = context;

    }




    public boolean isEditTextFilled(EditText editText, String message)
    {
        if (editText.getText().toString().trim().isEmpty())
        {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }

        return true;
    }


    // for student
    public boolean isEditTextIndexNo(EditText editText, String message)
    {


        String expression ="^\\w{3}?\\d{4}?\\w{3}?\\d{4}$";
        String inputStr = editText.getText().toString().trim();
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(!matcher.matches())
        {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }
        return true;
    }

    // Fr lecturer
    public boolean isLectEditTextIndexNo(EditText editText, String message)
    {


    String expression ="^\\w{4}?\\d{3}$";
    String inputStr = editText.getText().toString().trim();
    Pattern pattern = Pattern.compile(expression);
    Matcher matcher = pattern.matcher(inputStr);
    if(!matcher.matches())
    {
        editText.setError(message);
        hideKeyboardFrom(editText);
        return false;
    }
    return true;
}







    public boolean isEditTextEmail(EditText editText, String message)
    {
        String value = editText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches())
        {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }

        return true;
    }

    public boolean isEditTextPhoneNo(EditText editText, String message)
    {
        String value = editText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.PHONE.matcher(value).matches())
        {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }

        return true;
    }

    public boolean isEditTextMatches(EditText editText,EditText editText2, String message)
    {
        String value1 = editText.getText().toString().trim();
        String value2 = editText2.getText().toString().trim();
        if(!value1.equals(value2))
        {
            editText2.setError(message);
            hideKeyboardFrom(editText2);
            return false;
        }

        return true;
    }




    private void hideKeyboardFrom(EditText editText)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


}
