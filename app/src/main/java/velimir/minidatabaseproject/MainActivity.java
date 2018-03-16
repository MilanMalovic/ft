package velimir.minidatabaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.LogInHelper;
import model.User;

public class MainActivity extends AppCompatActivity {


    private EditText mUsername, mPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.logIn);


    }

    public void onLogInClick(View view) {

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if(username.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "Please, enter username and password", Toast.LENGTH_SHORT).show();
        } else {

            boolean exist = User.hasUser(username, password, getApplicationContext());

            if (exist == true) {

                Toast.makeText(getApplicationContext(), "Successfully Loged In !!!", Toast.LENGTH_LONG).show();

            } else {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        }

    }
}
