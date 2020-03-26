package com.apror.ssf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apror.ssf.getjsonlibrary.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btnGenerateOTP, btnSignIn,btn_id;
    EditText etOTP,et_id;
    int count=0;
    String etPhoneNumber,id;
    String phoneNumber, otp;
    FirebaseAuth auth;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_id.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);

        btn_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get the Data and Use it
                id = et_id.getText().toString();
                if (id.equals("A-1")){
                    etPhoneNumber="+919177520882";
                    Toast.makeText(MainActivity.this, "Welcome Mr.Abhishek", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("P-1")){
                    etPhoneNumber="+919381596810";
                    Toast.makeText(MainActivity.this, "Welcome Mr.Prateek", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("R-1")){
                    etPhoneNumber="+916304767227";
                    Toast.makeText(MainActivity.this, "Welcome Mr.Rehan", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("O-1")){
                    etPhoneNumber="+917893853651";
                    Toast.makeText(MainActivity.this, "Welcome Omer", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("R-2")){
                    etPhoneNumber="+916281547906";
                    Toast.makeText(MainActivity.this, "Welcome Mr.Rohit", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("A-2")){
                    etPhoneNumber="+916302393563";
                    Toast.makeText(MainActivity.this, "Welcome Miss.Aishwarya", Toast.LENGTH_SHORT).show();
                }
                if (id.equals("V-1")){
                    etPhoneNumber="+918464816309";
                    Toast.makeText(MainActivity.this, "Welcome Miss.Vaishnavi", Toast.LENGTH_SHORT).show();
                }


            }
        });


        StartFirebaseLogin();
        btnGenerateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber=etPhoneNumber;
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        phoneNumber,                     // Phone number to verify
                        60,                           // Timeout duration
                        TimeUnit.SECONDS,                // Unit of timeout
                        MainActivity.this,        // Activity (for callback binding)
                        mCallback);                      // OnVerificationStateChangedCallbacks
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp=etOTP.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                SigninWithPhone(credential);
            }
        });
        et_id.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // do something, e.g. set your TextView here via .setText()
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });


    }
    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) {
            mPattern= Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?");
            //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            Matcher matcher=mPattern.matcher(dest);
            if(!matcher.matches())
                return "";
            return null;
        }

    }
    private void SigninWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this,second.class));
                            finish();
                        } else {
                            if (count==0){
                                Toast.makeText(MainActivity.this,"Incorrect OTP 1 Attempt Remaining",Toast.LENGTH_SHORT).show();
                                count=count+1;

                            }
                            else {
                                Toast.makeText(MainActivity.this,"App Stopped Contact Ministry",Toast.LENGTH_SHORT).show();
                                int k=25/0;
                                //throw new RuntimeException("App Crashed Contact Ministry");

                            }

                        }
                    }
                });
    }
    private void findViews() {
        et_id = findViewById(R.id.et1);
        btn_id = findViewById(R.id.btn1);
        btnGenerateOTP = findViewById(R.id.btn_generate_otp);
        btnSignIn = findViewById(R.id.btn_sign_in);
        etOTP = findViewById(R.id.et_otp);
        etOTP.setCursorVisible(false);
        etOTP.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});


    }

    private void StartFirebaseLogin() {
        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(MainActivity.this,"verification completed",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(MainActivity.this,"verification failed",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(MainActivity.this,"Code sent",Toast.LENGTH_SHORT).show();
            }
        };
    }


}
