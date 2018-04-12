package velimir.minidatabaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import db.RepositoryManager;
import model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsername, mPassword;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register Page");


        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);




    }

    public void onRegisterClick(View view){

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if(username.equals("") || password.equals("")){
            Toast.makeText(this,"Please, enter username and password", Toast.LENGTH_SHORT).show();
        } else {


            boolean passedInsert = RepositoryManager.getInstance().insert(new User(username,password), this);

            if(passedInsert == true) {

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }

        }
    }



}
