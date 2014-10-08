package com.snippetdump.tutobjectsactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.snippetdump.tutobjectsactivities.model.SampleObject;

public class ActivityA extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
		
		Button button = (Button) findViewById(R.id.btn);
		TextView textView = (TextView) findViewById(R.id.textViewA);
		TextView textViewId = (TextView) findViewById(R.id.textViewId);
		TextView textViewName = (TextView) findViewById(R.id.textViewName);
		TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
		textView.setText("Values");
		textViewId.setText("Id: 1");
		textViewName.setText("Name: Name");
		textViewDate.setText("Date: 100L");
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SampleObject sampleObject = new SampleObject();
				sampleObject.setId(1);
				sampleObject.setName("Name");
				sampleObject.setDate(100L);

				String jsonString = sampleObject.toJson(sampleObject);
				
				Intent intent= new Intent(ActivityA.this,ActivityB.class);
				intent.putExtra("jsonString", jsonString);
				
				ActivityA.this.startActivity(intent);
			}
			
		});
	}

}
