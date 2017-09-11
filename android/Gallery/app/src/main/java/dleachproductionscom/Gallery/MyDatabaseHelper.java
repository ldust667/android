package dleachproductionscom.Gallery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dustin on 2/6/17.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
public static final int DB_VERSION = 1;

    private static final String DB_NAME="IMAGES";

public MyDatabaseHelper(Context context){
    super(context,DB_NAME,null,DB_VERSION);

}

/*
wrong sonctructor
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);



    }*/

    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table IMAGE ("
        +"_id integer primary key autoincrement,"
        + "NAME TEXT,"
        +"IMAGESRC byte[]) ;");


        //adding and updating db
       /* ContentValues addedValues= new ContentValues();

        addedValues.put("NAME","Latte");
        addedValues.put("imgsrc", "R.drawable");
        //addedValues.put("IMAGE_RESOURCE_ID",R.drawable.)

        // db.update();

        db.insert("DRINK",null,addedValues);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }





}
