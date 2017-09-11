package dleachproductionscom.cutsomadaptertwopiecdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dustin on 1/12/17.
 */

public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context context, ArrayList<User> users)
    {
        super(context,0,users);


    }



    public View getView(int position, View convertView, ViewGroup parent)
    {

//display current object

        User user=getItem(position);

        //if veiw is being reuseed
        //if not inflate
        if(convertView ==null){

            convertView= LayoutInflater.from(getContext()).inflate(R.layout.user_list_item,parent,false);

            //populate each textView
            TextView textViewName=(TextView) convertView.findViewById(R.id.textViewName);
            TextView textViewHometown=(TextView) convertView.findViewById(R.id.textViewHometown);

            textViewName.setText(user.name);
            textViewHometown.setText(user.homeTown);



        }

        return convertView;
    }

}
