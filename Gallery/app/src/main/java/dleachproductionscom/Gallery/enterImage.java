package dleachproductionscom.Gallery;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


/**
 * Created by dustin on 2/15/17.
 */




public class enterImage extends AppCompatActivity {

    //variables
    public SQLiteDatabase db;
    //public Cursor cursor;
    EditText textName;
    ImageView imgsrc;
    Bitmap imageBitmap;
    final int REQUEST_IMAGE_CAPTURE = 1;
    Button submit;

//comments were used for diffrent approaches to test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //must create in manifest

        //setting veiw to match enterdata
        setContentView(R.layout.enter_images_layout);

        //setting java "ids" for controls instantiation of earlier creation
        textName = (EditText) findViewById(R.id.editName);
        imgsrc = (ImageView) findViewById(R.id.editPic);
        submit = (Button) findViewById(R.id.button3);
        //imgsrc.setTag(R.id.editPic);

        //getting intent value
        final Intent addIntent = getIntent();
        //creating helper to talk to database
        SQLiteOpenHelper IMAGES = new MyDatabaseHelper(this);
        //put db in memory as writable database
        db = IMAGES.getWritableDatabase();




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    //Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    //photoPickerIntent.setType("image/*");
                    //startActivityForResult(photoPickerIntent, 0);

//starting intent

                    // method to create intent for picture capture
                    dispatchTakePictureIntent();


                    // String name;
                    // String descript;
                    //name = textName.getText().toString();
                    //Log.d( null,"name");
                    // descript = textDescript.getText().toString();


                } catch (SQLiteException e) {

                    Toast.makeText(getBaseContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //check to make sure package is being sent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      //      Toast.makeText(getBaseContext(), "dispatchpicture ran", Toast.LENGTH_LONG).show();
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
           // Bundle extras = data.getExtras();
            //Toast.makeText(getBaseContext(), "after extras", Toast.LENGTH_LONG).show();
            //imageBitmap = (Bitmap) extras.get("data");
            //imgsrc.setImageBitmap(imageBitmap);

            //Uri tempUri = getImageUri(getApplicationContext(), imageBitmap);

            // CALL THIS METHOD TO GET THE ACTUAL PATH
            //finalFile = new File(getRealPathFromURI(tempUri));

            if (resultCode != RESULT_OK)
                return;

            switch (requestCode) {
                //switch to check request code
                case REQUEST_IMAGE_CAPTURE:
                    //grabbing bundle sent from camera
                    Bundle extras = data.getExtras();

                    if (extras != null) {
                        Bitmap yourImage = extras.getParcelable("data");
                        // convert bitmap to byte
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                      //compress to png
                        yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        //store stream in byte array
                        byte[] imageInByte = stream.toByteArray();

                        // debugging Log.d("Insert: ", "Inserting ..");

                        ContentValues addedValues = new ContentValues();

                        imgsrc.setImageBitmap(BitmapFactory.decodeByteArray(imageInByte,0, imageInByte.length));
                        addedValues.put("NAME", textName.getText().toString());
                         //debugging: Toast.makeText(getBaseContext(), imageInByte, Toast.LENGTH_LONG).show();
                        addedValues.put("IMAGESRC", imageInByte);
                        db.insert("IMAGE", null, addedValues);


                    }
                    break;
            }


        } else {

            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }
/*

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        //decode stream
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        //compress to file type
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        //get path
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    public String getRealPathFromURI(Uri uri) {
        //query for name
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }



*/

}





/*


    // Handle the result/capture of the image from the camera:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);

        }

    }

}*/






