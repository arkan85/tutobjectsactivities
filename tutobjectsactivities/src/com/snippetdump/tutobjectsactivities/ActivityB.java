package com.snippetdump.tutobjectsactivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.snippetdump.tutobjectsactivities.model.SampleObject;

public class ActivityB extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		TextView textViewClass = (TextView) findViewById(R.id.textViewClass);
		TextView textViewId = (TextView) findViewById(R.id.textViewIdB);
		TextView textViewName = (TextView) findViewById(R.id.textViewNameB);
		TextView textViewDate = (TextView) findViewById(R.id.textViewDateB);
		
		SampleObject sampleObject = new SampleObject();
		sampleObject = sampleObject.fromJson(this.getIntent().getStringExtra("jsonString"));

		textViewClass.setText("Class name: " + sampleObject.getClass().getSimpleName());
		textViewId.setText("Id: " + String.valueOf(sampleObject.getId()));
		textViewName.setText("Name: " + sampleObject.getName());
		textViewDate.setText("Date: " + String.valueOf(String.valueOf(sampleObject.getDate())));
	}
}
