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

public class BlankFragment2 extends Fragment {

    public static final String KEY_PAGE = "page";
    public static ArrayList<FullRecipe> res = new ArrayList<>();

    private TextView title;
    private TextView cal;
    private TextView rating;
    private TextView protein;
    private TextView description;
    private TextView ingredients;
    private TextView fat;

    @NonNull
    public static BlankFragment2 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(KEY_PAGE, page);

        BlankFragment2 pageFragment = new BlankFragment2();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
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
        title.setText((page+1) + " Title: First Random Recipe Recommendation");
        ingredients.setText("Ingredients: This is random ingredient: " + res.get(page).getIngredients().toString());
        if(res.get(page).getDescription()!=null && res.get(page).getDescription().length() > 0) {
            description.setText("Description: This is random Description " + res.get(page).getDescription().toString());
        }
    }
}
