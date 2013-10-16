package com.CustomListView;


import com.CustomListView.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomListViewActivity extends Activity {
    /** Called when the activity is first created. */
   
        EditText txtnum;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            Button btnList=(Button)findViewById(R.id.btnListView);
            txtnum=(EditText)findViewById(R.id.txtNum);
            btnList.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				if(txtnum.getText().toString().length()==0)
    				{
    					Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG).show();
    					
    				}
    				else
    				{
    					Intent ilist=new Intent(CustomListViewActivity.this,CustListDisp.class);
        				ilist.putExtra("num", txtnum.getText().toString());
        				startActivity(ilist);
    				}
    			}
    		});
        }
    }
