package dleachproductionscom.cutsomadaptertwopiecdata;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cretae the data source
        ArrayList <User> users=new ArrayList<User>();

//create adapter used to convert array to individual vaiews
        UsersAdapter adapter=new UsersAdapter(this,users);

        //attaching adapter to list view
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //create data model
        User newuser=new User("Dustin","Elgin");
        adapter.add(newuser);

        //anon
        adapter.add(new User("Fred","lebanon"));






    }
}
