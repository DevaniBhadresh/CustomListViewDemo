package com.CustomListView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		TextView txtnm=(TextView)findViewById(R.id.txtName);
		TextView txturl=(TextView)findViewById(R.id.txtUrl);
		ImageView imgv=(ImageView)findViewById(R.id.imgImage);
		txtnm.setText(getIntent().getStringExtra("nm"));
		txturl.setText(getIntent().getStringExtra("ur"));
		String imgstr=getIntent().getStringExtra("img");
		int id = getResources().getIdentifier("com.CustomListView:drawable/" + imgstr, null, null);
		imgv.setImageResource(id);
		imgv.getLayoutParams().height = 250;
		imgv.getLayoutParams().width=250;
	}

}
