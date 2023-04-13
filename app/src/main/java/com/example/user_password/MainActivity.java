package com.example.user_password;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class User{
    private String user;
    private String password;
    protected static int count_user = 0;
    User(String user, String password){
        this.user = user;
        this.password = password;
        count_user++;
    }
    boolean isAValidAuthentication(String user_input, String password_input){
        if (this.user.equals(user_input) && this.password.equals(password_input)){
            return true;
        }
        return false;
    }
}
public class MainActivity extends AppCompatActivity {
    private EditText user_edittext;
    private EditText password_edittext;
    private Button button;

    private User[] userList = new User[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.buttonLogin);
        user_edittext = (EditText) findViewById(R.id.user_edittext);
        password_edittext = (EditText) findViewById(R.id.password_edittext);

        //
        userList[0] = new User("admin", "admin");
        userList[1] = new User("user", "123456");
        userList[2] = new User("tungnk123", "password");
        //

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = user_edittext.getText().toString();
                String password = password_edittext.getText().toString();
                for (int i = 0; i < User.count_user; i++){
                    if (userList[i].isAValidAuthentication(user, password)){
                        Toast.makeText(getApplicationContext(), "Dang nhap thanh cong!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), "Dang nhap that bai!", Toast.LENGTH_LONG).show();
            }
        });
    }
}