package com.example.rohitgiri.vibhassignment83;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

//Declaring class which is extending AppCompatActivity class.
public class MainActivity extends AppCompatActivity {

    GridView gridView;       //Creating object of GridView.
    Integer[] imageID;       //Creating array of Integer class to store ID's of images.

    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      //Setting contentView of UI.

        //Initaializing Array of Integer class with ID's of respective images.
        imageID=new Integer[]{ R.drawable.ginger_bread,
                R.drawable.honey_comb,
                R.drawable.ice_cream,
                R.drawable.jelly_bean,
                R.drawable.kitkat,
                R.drawable.lollipop };

        //Setting GridView with its id.
        gridView=(GridView)findViewById(R.id.grid);

        //Setting adapter for GridView instance and "MainActivity.this" context is passed in constructor of UserDefined Adapter.
        gridView.setAdapter(new ImageAdapter(this));

        //Setting onClick event for every grid item.
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item No. "+(position+1)+" is selected",Toast.LENGTH_SHORT).show();
                //Displaying Toast to display which item is clicked.
            }
        });

    }

    //Nested class Which is Extending BaseAdapter class.
    class ImageAdapter extends BaseAdapter
    {
        Context context;     //Creating object of Context class.

        public ImageAdapter(Context c)    //Constructor to Initialize the class variable context with passed parameter in Constructor.
        {
            context=c;
        }


        @Override
        //Method to get number of elements in the Integer class array.
        public int getCount() {
            return imageID.length;
        }

        @Override
        //method to access particular item of Integer class array.
        public Object getItem(int position) {
            return imageID[position];
        }

        @Override
        //Method to get position of certain element.
        public long getItemId(int position) {
            return position;
        }

        @Override
        //When adapter is set to GridView object, this method is automatically called.
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;     //Creatting Object of ImageView class.

            if(convertView==null)    //Checking weather convertView is null or not.
            {
                //Setting imageview for current context.
                imageView=new ImageView(context);
                //Setting layout parameters and giving padding to images.
                imageView.setLayoutParams(new GridView.LayoutParams(500,500));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(16,16,16,16);
            }
            else
            {
                //if convertView is not null then typecasting convertView by ImageView.
                imageView=(ImageView)convertView;
            }

            imageView.setImageResource(imageID[position]);     //Setting Image at the created ImageView by accessing image id from Integer class array.

            return imageView;       //returning imageView object.
        }
    }   //End of ImageAdapter class.
}    //End of class.
