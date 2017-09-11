package dleachproductionscom.Gallery;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by dustin on 2/15/17.
 */


public class viewImages extends AppCompatActivity{

    public SQLiteDatabase db;
    public Cursor cursor;
    public showAdapter custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //create in manifest

        super.onCreate(savedInstanceState);
        //setting content view to enterdata
        setContentView(R.layout.view_images_layout);

        //getting intent value
        final Intent intent=getIntent();

        //creting java id
        GridView listDrinks = (GridView) findViewById(R.id.listDrink);

        try{
            //making db helper
            SQLiteOpenHelper starbuzzDatabaseHelper = new MyDatabaseHelper(this);
            //put db in memory as readable
            db = starbuzzDatabaseHelper.getReadableDatabase();

            //creating a query using the cursor
            cursor = db.rawQuery("select NAME,IMAGESRC from IMAGE; ",null);
            //have cursor move
            cursor.moveToFirst();
            //create object array to populate
            ArrayList<Show>shows = new ArrayList<Show>();
            //create two variable to store class attributes in
            String name;
            byte[] descript;


        //loop through till after last record
            while(!cursor.isAfterLast()){
                //loop through and grab record values
                name=cursor.getString(cursor.getColumnIndex("NAME"));
                descript=cursor.getBlob(cursor.getColumnIndex("IMAGESRC"));
                //adding values to array
                shows.add(new Show(name, descript));
                cursor.moveToNext();
            }
cursor.close();

/*
            //create adapter for query
            CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[] {"NAME", "DESCRIPTION"},
                    new int[] {android.R.id.text1},0);

*/
            //set adapter


            custom = new showAdapter(this, shows) ;

            listDrinks.setAdapter(custom);

        }

        catch(SQLiteException e){
//toast unless db not connected


        }



    }
}







