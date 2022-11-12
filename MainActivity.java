package www.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewByid(R.id.etName);
        Password = (EditText) findViewByid(R.id.etPassword);
        Info = (TextView) findViewByid(R.id.tvInfo);
        Login = (Button)findViewByid(R.id.btnLogin);

        Info.setText("No of attempts reamining: 5");
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(),Password.getText().toString());


            }
        });
}

    private Object findViewByid(int etName) {
        return null;
    }

    private void validate(String userEmail,String userPassword){
        if((userEmail == "Admin@gmail.com") && (userPassword == "1234")){
            Intent itent = new Intent(MainActivity.this,SecondActivity.class);
            Intent intent = null;
            startActivity(intent);
        }
        else{
            counter--;

            Info.setText("No of attempts remaining: "+String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
