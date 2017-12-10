package com.example.katiechen.foodthree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import android.content.res.Resources;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Print {

	public static void main(String[] args) throws JSONException, IOException {
		InputStream in = new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
		FullRecipeList fr=new FullRecipeList(in);
		ArrayList<FullRecipe> rs=fr.getFullRecipes();
//		if(rs.isEmpty())
//			System.out.println(1);
		System.out.println(rs.size());
		double m=0;
		for(FullRecipe r:rs) {
			Double c=r.getFat();
			if(m<c) {
				m=c;
			};
		}
		
		System.out.println(m);
		}
	}


