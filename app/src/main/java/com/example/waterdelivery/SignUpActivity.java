package com.example.waterdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextMobileNo;

    ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMobileNo = (EditText) findViewById(R.id.editTextMobileNo);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

        public void signupButtonClicked(View v) {

            String txtUserName = editTextUserName.getText().toString().trim();
            String txtEmail = editTextEmail.getText().toString().trim();
            String txtPassword = editTextPassword.getText().toString().trim();
            String txtMobileNo = editTextMobileNo.getText().toString().trim();

            if (txtUserName.isEmpty()) {
                editTextUserName.setError("Enter User name");
                editTextUserName.requestFocus();
            }

            if (txtEmail.isEmpty()) {
                editTextEmail.setError("Enter Email");
                editTextEmail.requestFocus();
            }

            if (txtPassword.isEmpty() || txtPassword.length()< 10) {
                editTextPassword.setError("Enter Password");
                editTextPassword.requestFocus();
            }

            if (txtMobileNo.isEmpty()) {
                editTextMobileNo.setError("Enter MobileNo");
                editTextMobileNo.requestFocus();
            }

            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(txtEmail, txtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                User user = new User(txtUserName, txtEmail, txtPassword, txtMobileNo);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {

                                            Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                        else {
                                            Toast.makeText(SignUpActivity.this, "User Failed to Register ", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            }

                            else {
                                Toast.makeText(SignUpActivity.this, "User Failed to Register ", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }

                        }

                    });
        }

}