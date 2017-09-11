package dleachproductionscom.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE="com.example.Register.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //widgets for java
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        final TextView editEmail = (TextView) findViewById(R.id.editEmail);
        final TextView editPhone = (TextView) findViewById(R.id.editPhone);
        final TextView editPassword = (TextView) findViewById(R.id.editPassword);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                //grabbing text
                String email = editEmail.getText().toString();
                String phone=editPhone.getText().toString();
                String password=editPassword.getText().toString();
                String info=email+"\n"+phone+"\n"+password;
                //adding message to extra
                intent.putExtra(EXTRA_MESSAGE, info);
                startActivity(intent);


            }


        });
    }
}
