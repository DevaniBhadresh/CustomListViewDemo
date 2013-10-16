package com.CustomListView;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class CustListDisp extends Activity
{
	//ListView list;
    CustomAdapter adapter;
    public  CustListDisp CustomListView = null;
    public  ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.custlistdisp);
         
        CustomListView = this;
         
        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();
        Resources res =getResources();
        ListView list=(ListView)findViewById(R.id.list);  // List defined in XML ( See Below )
         
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter(CustomListView,CustomListViewValuesArr,res);
        list.setAdapter(adapter);
         
    }
 
    /****** Function to set data in ArrayList *************/
    public void setListData()
    {
        int per=Integer.parseInt(getIntent().getStringExtra("num".toString())); 
        for (int i = 1; i <=per; i++) {
             
            final ListModel sched = new ListModel();
                 
              /******* Firstly take data in model object ******/
               sched.setCompanyName("Student "+i);
               sched.setImage("image"+i);
               sched.setUrl("Student"+i+"@gmail.com");
               if(i>10)
               {
            	   sched.setImage("un");
               }
                
            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( sched );
        }
         
    }
    

   /*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        ListModel tempValues = ( ListModel ) CustomListViewValuesArr.get(mPosition);


       // SHOW ALERT                  
        Intent i=new Intent(CustListDisp.this,Profile.class);
        i.putExtra("nm",tempValues.getCompanyName().toString());
        i.putExtra("img",tempValues.getImage().toString());
        i.putExtra("ur",tempValues.getUrl().toString());
        startActivity(i);
        //Toast.makeText(CustomListView,""+tempValues.getCompanyName()+"Image:"+tempValues.getImage()+"Url:"+tempValues.getUrl(),Toast.LENGTH_LONG).show();
    }
}