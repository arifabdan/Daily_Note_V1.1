package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText editTextfullname,editTextemail,editTextpassword;
    private TextView log;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        log = (TextView) findViewById(R.id.log);
        log.setOnClickListener(this);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        editTextfullname = (EditText) findViewById(R.id.fullname);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextpassword = (EditText) findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.log:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.btn_register:
                btn_register();
                break;
        }
    }

    private void btn_register() {
        String full_name = editTextfullname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(full_name.isEmpty()){
            editTextfullname.setError("Tolong isi nama lengkap anda");
            editTextfullname.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextemail.setError("Tolong isi email anda");
            editTextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Tolong isi format email dengan benar");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Tolong isi password anda");
            editTextpassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            editTextpassword.setError("Minimal password 6 karakter");
            editTextpassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(full_name, email);

                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        Toast.makeText(Register.this, "User berhasil terdaftar", Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(Register.this, "Gagal untuk registrasi! Silahkan coba lagi", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}