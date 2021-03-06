package com.example.katiechen.foodthree;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katiechen.foodthree.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlankFragment extends Fragment {

    public static final String KEY_PAGE = "page";
    public static ArrayList<FullRecipe> res = new ArrayList<>();

    private TextView title;
    private TextView date;
    private TextView cal;
    private TextView rating;
    private TextView protein;
    private TextView description;
    private TextView ingredients;
    private TextView fat;

    @NonNull
    public static BlankFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(KEY_PAGE, page);

        BlankFragment pageFragment = new BlankFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        title = (TextView) view.findViewById(R.id.title);
        //date = (TextView) view.findViewById(R.id.date);
        fat = (TextView) view.findViewById(R.id.Fat);
        rating = (TextView) view.findViewById(R.id.rating);
        cal = (TextView) view.findViewById(R.id.Calories);
        protein = (TextView) view.findViewById(R.id.Protein);
        ingredients = (TextView) view.findViewById(R.id.ingredients);
        description = (TextView) view.findViewById(R.id.description);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        int page = getArguments().getInt(KEY_PAGE);
        System.out.println("888");
        System.out.println(res.size());
        if(res.size()==0) {
            title.setText("Ooops!\nCannot Find Any Recipe Based On Your Selected Ingredients!\nPlease Go Back to Creat Your Random Recipe! ");
            return;
        }
        title.setText((page+1) + " Title: " + res.get(page).getTitle());
<<<<<<< HEAD
=======
        //date.setText("Date: "+res.get(page).getDate());
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410
        rating.setText("Rating: " + res.get(page).getRating().toString());
        fat.setText("Fat: " + res.get(page).getFat().toString());
        cal.setText("Calories: " + res.get(page).getCalories().toString());
        protein.setText("Protein: " + res.get(page).getProtein().toString());
        ingredients.setText("Ingredients: " + res.get(page).getIngredients().toString());
        if(res.get(page).getDescription()!=null && res.get(page).getDescription().length() > 0) {
            description.setText("Description: " + res.get(page).getDescription().toString());
        }


    }
}
