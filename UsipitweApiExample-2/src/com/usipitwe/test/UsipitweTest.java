package com.usipitwe.test;

import java.io.IOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.usipitwe.api.usipitweAndroidApi.UsipitweAndroidApi;
import com.usipitwe.api.usipitweAndroidApi.model.Item;
import com.usipitwe.api.usipitweAndroidApi.model.ItemCollection;

public class UsipitweTest {
	public static void main(String[] args) throws IOException {
		HttpTransport transport = new NetHttpTransport.Builder().build();
		JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
		
		UsipitweAndroidApi api = new UsipitweAndroidApi.Builder(transport , jsonFactory , null).build();
		ItemCollection result = api.queryTopItems(10).execute();
		if(result.getItems()!=null){
			int i=0;
			for(Item item:result.getItems()){
				i++;
				System.out.println(i+". "+item.getTitle());
			}
		}
	}
}
