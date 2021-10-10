package com.example.pro3_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogDemo extends AppCompatActivity {
    private EditText et_username,et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
    }

    public void login(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        //通过布局填充器获login_layout
        View view = getLayoutInflater().inflate(R.layout.login_layout,null);

        final EditText et_username = (EditText) view.findViewById(R.id.et_username);
        final EditText et_password = (EditText) view.findViewById(R.id.et_password);
        builder.setView(view);
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = et_username.getText().toString().trim();
                String pass = et_password.getText().toString().trim();
                Toast.makeText(AlertDialogDemo.this,name + "正在登录....", Toast.LENGTH_SHORT).show();
            }

        });


        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogDemo.this,"取消登录",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}
