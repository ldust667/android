package dleachproductionscom.Gallery;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //creating database and placeholder to read it
    public SQLiteDatabase db;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView);



        //on item click listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listView, View v, int position, long id){

                //based onposition start new activity

                if(position == 1){
                    //if second item is clicked start entry of image
                    Intent intent = new Intent(MainActivity.this,enterImage.class);
                    startActivity(intent);


                }

                if(position == 0){
                    //if first item is clicked start intent for view of images
                    Intent addIntent = new Intent(MainActivity.this,viewImages.class);
                    startActivity(addIntent);

                }





            }



        };

        listView.setOnItemClickListener(itemClickListener);
    }
}
