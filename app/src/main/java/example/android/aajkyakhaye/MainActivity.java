package example.android.aajkyakhaye;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> menuBreakfast = new ArrayList<>(Arrays.asList("Poha", "Upma", "Aloo Paratha", "Maggie", "Ready to Eat Pasta", "Onion Utthapa", "Sandwich"));
    ArrayList<String> menuLunch = new ArrayList<>(Arrays.asList("Dal Rice", "Masala Khichdi", "Roti, Sukhi Sabji & Dal", "Parata & Gravy Sabji", "Gobi Paratha & Gravy Sabji", "Muli Parata & Gravy Sabji", "Palak Paratha & Gravy Sabji", "Chhole Naan"));
    ArrayList<String> menuEveningSnacks = new ArrayList<>(Arrays.asList("Maggie", "Geela Bhel", "Sevpuri", "Ready to Eat Pasta", "Bread-Butter", "Sandwich", "Vada Paav"));
    ArrayList<String> menuDinner = new ArrayList<>(Arrays.asList("Masala Dosa", "Masala Khichdi", "Roti, Sukhi Sabji & Dal", "Parata & Gravy Sabji"));
    //ArrayList<String> test = new ArrayList<>(Arrays.asList(@st));

    String dishName, breakfast, lunch, eveningSnacks, dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToKnow(View view) {
        CheckBox breakfastCheckbox = findViewById(R.id.breakfast);
        boolean hasBreakfast = breakfastCheckbox.isChecked();
        if (hasBreakfast) {
            breakfast = getDishName(menuBreakfast);
        } else {
            breakfast = "NA";
        }

        CheckBox lunchCheckbox = findViewById(R.id.lunch);
        boolean hasLunch = lunchCheckbox.isChecked();
        if (hasLunch) {
            lunch = getDishName(menuLunch);
        } else {
            lunch = "NA";
        }

        CheckBox eveningSnacksCheckbox = findViewById(R.id.evening_snacks);
        boolean hasEveningSnacks = eveningSnacksCheckbox.isChecked();
        if (hasEveningSnacks) {
            eveningSnacks = getDishName(menuEveningSnacks);
        } else {
            eveningSnacks = "NA";
        }

        CheckBox dinnerCheckbox = findViewById(R.id.dinner);
        boolean hasDinner = dinnerCheckbox.isChecked();
        if (hasDinner) {
            dinner = getDishName(menuDinner);
        } else {
            dinner = "NA";
        }

//        String.valueOf(!breakfast.equals(eveningSnacks));
//        String.valueOf(!lunch.equals(dinner));

        String todaysMenu = displayTodaysMenu(breakfast, lunch, eveningSnacks, dinner);
        displayMessage(todaysMenu);
    }

    public String getDishName(ArrayList mealList) {
//        int number = (int) (Math.random() * mealList.size());
//        return dishName = (String) mealList.get(number);
        return dishName = (String) mealList.get((int) (Math.random() * mealList.size()));
    }

    private void displayMessage(String message) {
        TextView displayTodayMenu = findViewById(R.id.display_today_menu);
        displayTodayMenu.setText(message);
    }

    private String displayTodaysMenu(String breakfast, String lunch, String eveningSnacks, String dinner) {
        String todaysMenu = "Today's Menu :\n";
        todaysMenu += "\nBreakfast : " + breakfast;
        todaysMenu += "\nLunch : " + lunch;
        todaysMenu += "\nEvening Snacks : " + eveningSnacks;
        todaysMenu += "\nDinner : " + dinner;

        return todaysMenu;
    }
}