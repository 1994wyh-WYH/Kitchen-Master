package com.example.katiechen.foodthree;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all carbs for future use.
 * @author Yihan
 *
 */
public class Carb {
	private static ArrayList<String> carbs;
	
	public Carb(InputStream inp) {
		carbs=new ArrayList<>();
		try {
//			File file=new File("./carbs.txt");
//			Scanner in=new Scanner(file);
			//Context mContext = getApplicationContext();
			Scanner in  = new Scanner(inp);
			while(in.hasNextLine()) {
				carbs.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the carbs list.
	 * @return an arraylist of carbs
	 */
	public static ArrayList<String> getCarbs() {
		return carbs;
	}
	
	
}
