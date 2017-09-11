package dleachproductionscom.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent=getIntent();

        String information=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        TextView textView=new TextView(this);

        //set the text
        textView.setText("You have been successfully registered: "+information);

        //set size
        textView.setTextSize(20);

        //add the text view widget to the activity
        ViewGroup form=(ViewGroup) findViewById(R.id.activity_display_message);
        form.addView(textView);

    }
}
