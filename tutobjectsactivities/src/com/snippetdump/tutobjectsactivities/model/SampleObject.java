package com.snippetdump.tutobjectsactivities.model;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class SampleObject {

	private int id;
	private String name;
	private long date;
	
	public SampleObject(){}
	
	public SampleObject(int id, String name, long date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	public SampleObject fromJson(String json) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(SampleObject.class, new SampleObjectTypeAdapter());
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		return gson.fromJson(json, SampleObject.class);
	}
	
	public String toJson(SampleObject sampleObject) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(SampleObject.class, new SampleObjectTypeAdapter());
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		return gson.toJson(sampleObject);
	}
	
	public class SampleObjectTypeAdapter extends TypeAdapter<SampleObject> {

		@Override
		public SampleObject read(JsonReader in) throws IOException {
			if(in.peek() == JsonToken.NULL) {
				in.nextNull();
				return null;
			}
			String data = in.nextString();
			String[] dataParts = data.split(",");
			return new SampleObject(Integer.parseInt(dataParts[0]), dataParts[1], Long.parseLong(dataParts[2]));
		}

		@Override
		public void write(JsonWriter out, SampleObject value) throws IOException {
			if(value == null) {
				out.nullValue();
				return;
			}
			StringBuffer sb = new StringBuffer("");
			sb.append(value.getId()).append(",").append(value.getName()).append(",").append(value.getDate());
			out.value(sb.toString());
		}
	}
}
