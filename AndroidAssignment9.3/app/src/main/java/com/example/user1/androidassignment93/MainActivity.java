package com.example.user1.androidassignment93;
/*
This assignment is a example of Listview with context menu
 */

// imported required class
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


// class starts here
public class MainActivity extends AppCompatActivity {

    // some refrence variables
    TextView name;
    TextView phonenumber;

    //array list
    String [] nameArray={"Aftab","Ashraf","Mac","Mark","Leo"};
    String [] phnumArray={"4578765687","56875659","4578586867","969780980978","67878989809"};

    ListView list;

    @Override
    // oncreat method starts here
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Id assigned
        name= (TextView) findViewById(R.id.textView1);
        phonenumber=(TextView) findViewById(R.id.textView2);
        list= (ListView) findViewById(R.id.list);

        // customadaptor class obj
        CustomAdaptor customAdaptor=new CustomAdaptor(this);


        // adaptor setup on list view
        list.setAdapter(customAdaptor);
        //register for context menu
        registerForContextMenu(list);

    }


    @Override
    // context menu creator method
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select Options");
        menu.add(0,101,1,"Call");
        menu.add(0,102,2,"SMS");
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    // context menu item clicking method
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==101 && item.getGroupId()==0){



            startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phnumArray[4])));

        }
        if(item.getItemId()==102 && item.getGroupId()==0){

            Uri uri = Uri.parse("smsto:"+phnumArray[4]);
            Intent it = new Intent(Intent.ACTION_SENDTO, uri);
            it.putExtra("hiii","hello");
            startActivity(it);

        }


        return super.onContextItemSelected(item);
    }
}



