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

public class MainActivity extends AppCompatActivity {


    private EditText mUsername, mPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername =  findViewById(R.id.username);
        mPassword =  findViewById(R.id.password);
        buttonLogin =  findViewById(R.id.logIn);


    }

    public void onLogInClick(View view) {

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if(username.equals("") || password.equals("")) {
           infoToast("Please, enter username and password");
        } else {

          boolean exist = RepositoryManager.getInstance().hasUser(new User(username,password), this);


            if (exist == true) {

               infoToast("Succesfully loged in!!!");

            } else {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        }

    }

    public void infoToast(String messege){
        Toast.makeText(this, messege, Toast.LENGTH_LONG).show();
    }
}
