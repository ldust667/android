package dleachproductionscom.Gallery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dustin on 2/18/17.
 */

public class showAdapter extends ArrayAdapter<Show>{

    //setting database
    public SQLiteDatabase dba;
    TextView textViewName;
    ImageView imageView;
    ArrayList<Show> shows;

    Button delete;
    Context mContext;
    LayoutInflater mLayoutInflater;


    public void remove(int position){
        shows.remove(shows.get(position));
        notifyDataSetChanged();
    }



    public showAdapter(Context context, ArrayList<Show> shows)
    {
        super(context,0,shows);

        this.shows = shows;



    }



    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        SQLiteOpenHelper IMAGES = new MyDatabaseHelper(getContext());
        //put db in memory as writable database
        dba = IMAGES.getReadableDatabase();
//display current object
        final Show showNow=getItem(position);
        //if veiw is being reuseed

        //if not inflate




        if(convertView ==null) {

             convertView = LayoutInflater.from(getContext()).inflate(R.layout.show_list_item, parent, false);
//set java ids for controls
            textViewName = (TextView) convertView.findViewById(R.id.textName);
            imageView = (ImageView) convertView.findViewById(R.id.imageView);
            delete = (Button) convertView.findViewById(R.id.btnDelete);
            delete.setTag(position);


           textViewName.setText(showNow.getName());

            //new way using file path from database


            imageView.setImageBitmap(BitmapFactory.decodeByteArray(showNow.getImgsrc(), 0, showNow.getImgsrc().length));
        }


delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //int pos = (int)delete.getTag();
        //Object toRemove =
        //showAdapter.delete(toRemove);

       // showNow.getId();
        Toast.makeText(getContext(), "Picture deleted", Toast.LENGTH_LONG).show();
        //shows.ge
        dba.execSQL("DELETE FROM IMAGE WHERE NAME = '"+ shows.get(position).getName()+"';");
        showNow.deleteThis();

      //  parent.notifyDataSetChanged();
//dba.close();


        //dba.delete(getItem(position).getId());
        //db.delete("IMAGE","IMAGESRC ="+showNow.getImgsrc(),null,);





    }
});







return convertView;
    }

}
