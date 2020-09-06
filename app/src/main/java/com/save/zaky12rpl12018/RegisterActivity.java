package com.save.zaky12rpl12018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = RegisterActivity.class.getSimpleName();
    private EditText edtNama, edtNoktp, edtEmail, edtPhone, edtAddress, edtPassword, edtConfirmationPassword;
    private Button btnRegister;
    private TextView loginback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edtNama = findViewById(R.id.txtnama);
        edtNoktp = findViewById(R.id.txtnoktp);
        edtEmail = findViewById(R.id.txtmail);
        edtPhone = findViewById(R.id.txtphone);
        edtAddress = findViewById(R.id.txtalamat);
        edtPassword = findViewById(R.id.txtpass);
//        edtConfirmationPassword = findViewById(R.id.edt_confirmation_password);
        btnRegister = findViewById(R.id.btnregis);
//        txtLogin = findViewById(R.id.txt_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNama= edtNama.getText().toString().trim();
                String inputNoktp= edtNoktp.getText().toString().trim();
                String inputEmail = edtEmail.getText().toString().trim();
                String inputPhone = edtPhone.getText().toString().trim();
                String inputAddress = edtAddress.getText().toString().trim();
                String inputPassword = edtPassword.getText().toString().trim();
//                String inputConfirmationPassword = edtConfirmationPassword.getText().toString().trim();

                boolean isEmpty = false;
                boolean isInvalidPassword = false;

                if (inputNama.isEmpty()) {
                    isEmpty = true;
                    edtNama.setError("Nama lengkap harus diisi");
                }

                if (inputNoktp.isEmpty()) {
                    isEmpty = true;
                    edtNoktp.setError("No KTP harus diisi");
                }

                if (inputEmail.isEmpty()) {
                    isEmpty = true;
                    edtEmail.setError("Email harus diisi");
                }

                if (inputPhone.isEmpty()) {
                    isEmpty = true;
                    edtPhone.setError("Nomor telepon harus diisi");
                }

                if (inputAddress.isEmpty()) {
                    isEmpty = true;
                    edtAddress.setError("Alamat Number harus diisi");
                }

                if (inputPassword.isEmpty()) {
                    isEmpty = true;
                    edtPassword.setError("Password harus diisi");
                }

//                if (inputConfirmationPassword.isEmpty()) {
//                    isEmpty = true;
//                    edtConfirmationPassword.setError("Confirm Password harus diisi");
//                }

//                if (!inputPassword.equals(inputConfirmationPassword)) {
//                    isInvalidPassword = true;
//                    edtConfirmationPassword.setError("Password & Confirm Password don't match");
//                }

                if (!isEmpty && !isInvalidPassword) {
                    AndroidNetworking.post("http://192.168.0.107/api-bike-rental/register.php")
                            .addBodyParameter("nama", inputNama)
                            .addBodyParameter("noktp", inputNoktp)
                            .addBodyParameter("email", inputEmail)
                            .addBodyParameter("nohp", inputPhone)
                            .addBodyParameter("alamat", inputAddress)
                            .addBodyParameter("password", inputPassword)
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        String status = response.getString("status");
                                        String message = response.getString("message");

                                        if (status.equals("success")) {
                                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();

//                                            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//                                            SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                                            editor.putString(ID, "1");
//                                            editor.apply();

                                            Intent intent = new Intent(RegisterActivity.this, berandaActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(ANError error) {
                                    // handle error
                                    Log.e(TAG, "onError: " + error.getLocalizedMessage());
                                }
                            });
                }
            }
        });

//        loginback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
//    public void ting(View View){
//        startActivity(new Intent(this, LoginActivity.class));
//    }
    public void backcuslog(View View){
        startActivity(new Intent(this, LoginActivity.class));
    }
    public void loginback(View View){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
