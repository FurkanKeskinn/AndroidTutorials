package com.nexis.androidtutorials.CustomDialogActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

public class CustomDialogActivity extends AppCompatActivity {
    private Dialog resetPassDialog;
    private Button buttonClose, buttonResetPass;
    private ImageView imageClose;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
    }

    public void showCustomDialog(View v){
        showResetPasswordDialog();

    }

    private void showResetPasswordDialog(){
        resetPassDialog = new Dialog(this);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(resetPassDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        resetPassDialog.setCancelable(false);
        resetPassDialog.setContentView(R.layout.customdialog_resetpass);

        buttonClose = (Button)resetPassDialog.findViewById(R.id.customDialog_resetPass_buttonClose);
        buttonResetPass = (Button)resetPassDialog.findViewById(R.id.customDialog_resetPass_buttonResetPass);
        imageClose = (ImageView)resetPassDialog.findViewById(R.id.customDialog_resetPass_imageViewClose);
        editTextEmail = (EditText)resetPassDialog.findViewById(R.id.customDialog_resetPass_editTextEmail);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassDialog.dismiss();
            }
        });

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassDialog.dismiss();
            }
        });

        buttonResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(editTextEmail.getText().toString()))
                    Toast.makeText(getApplicationContext(),"şifre Sıfırlama Gönderildi", Toast.LENGTH_SHORT).show();
            }
        });

        resetPassDialog.getWindow().setAttributes(params);
        resetPassDialog.show();
    }
}