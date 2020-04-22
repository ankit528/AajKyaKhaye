package example.android.aajkyakhaye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> breakfastMenu = new ArrayList<>(Arrays.asList("Poha", "Upma", "Aloo Paratha", "Maggie", "Ready to Eat Pasta", "Onion Utthapa", "Sandwich"));
    ArrayList<String> lunchMenu = new ArrayList<>(Arrays.asList("Dal Rice", "Masala Khichdi", "Roti, Sukhi Sabji & Dal", "Paratha & Gravy Sabji", "Gobi Paratha & Gravy Sabji", "Muli Paratha & Gravy Sabji", "Palak Paratha & Gravy Sabji", "Chhole Naan"));
    ArrayList<String> eveningSnacksMenu = new ArrayList<>(Arrays.asList("Maggie", "Geela Bhel", "Sevpuri", "Ready to Eat Pasta", "Bread-Butter", "Sandwich", "Vada Paav"));
    ArrayList<String> dinnerMenu = new ArrayList<>(Arrays.asList("Masala Dosa", "Masala Khichdi", "Roti, Sukhi Sabji & Dal", "Paratha & Gravy Sabji", "Gobi Paratha & Gravy Sabji","Muli Paratha & Gravy Sabji", "Palak Paratha & Gravy Sabji","Chhole Naan","Missal Paav","Dal Rice","Bread Vada","Pakode"));

    List<String> temp_DishList = new ArrayList<>();

    String dishName, breakfast, lunch, eveningSnacks, dinner, todaysMenu;
    CheckBox breakfastCheckbox, lunchCheckbox, eveningSnacksCheckbox, dinnerCheckbox;
    boolean hasBreakfast, hasLunch, hasEveningSnacks, hasDinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToKnow(View view) {
        temp_DishList.clear();

        breakfastCheckbox = findViewById(R.id.breakfast);
        hasBreakfast = breakfastCheckbox.isChecked();
        breakfast = getDishName(hasBreakfast, breakfastMenu);

        lunchCheckbox = findViewById(R.id.lunch);
        hasLunch = lunchCheckbox.isChecked();
        lunch = getDishName(hasLunch, lunchMenu);

        eveningSnacksCheckbox = findViewById(R.id.evening_snacks);
        hasEveningSnacks = eveningSnacksCheckbox.isChecked();
        eveningSnacks = getDishName(hasEveningSnacks, eveningSnacksMenu);

        dinnerCheckbox = findViewById(R.id.dinner);
        hasDinner = dinnerCheckbox.isChecked();
        dinner = getDishName(hasDinner, dinnerMenu);

        todaysMenu = displayTodaysMenu(breakfast, lunch, eveningSnacks, dinner);

        displayMessage(todaysMenu);
    }

    public String getDishName(boolean mealType, ArrayList mealList) {
        dishName = "NA";
        if (mealType) {
            do {
                dishName = (String) mealList.get((int) (Math.random() * mealList.size()));
            } while (isDishNameAlreadyExist(dishName));
            temp_DishList.add(dishName);
        }
        return dishName;
    }

    public boolean isDishNameAlreadyExist(String dishName) {
        if (temp_DishList.size() == 0) {
            return false;
        } else if (!temp_DishList.contains(dishName)) {
            return false;
        } else
            return true;
    }

    private void displayMessage(String message) {
        TextView displayTodayMenu = findViewById(R.id.display_today_menu);
        displayTodayMenu.setText(message);
    }

    private String displayTodaysMenu(String breakfast, String lunch, String eveningSnacks, String dinner) {
        todaysMenu = "Today's Menu :\n";
        todaysMenu += "\nBreakfast : " + breakfast;
        todaysMenu += "\nLunch : " + lunch;
        todaysMenu += "\nEvening Snacks : " + eveningSnacks;
        todaysMenu += "\nDinner : " + dinner;

        return todaysMenu;
    }
}