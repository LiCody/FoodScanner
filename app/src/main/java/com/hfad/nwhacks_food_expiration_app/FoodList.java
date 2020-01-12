package com.hfad.nwhacks_food_expiration_app;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class FoodList {
    private final Queue<FoodItem> foods;

    public FoodList() {
        this.foods = new PriorityQueue<>(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem f1, FoodItem f2) {
                return Integer.compare(f1.getExpiryTime(), f2.getExpiryTime());
            }
        });
    }

    public void decAllFood() {
        for (FoodItem food : foods) {
            food.decrementExpiryTime();
        }
    }

    public boolean addFoodItem(FoodItem foodItem) {
        return foods.add(foodItem);
    }

    public boolean removeFoodItem(FoodItem foodItem) { return foods.remove(foodItem); }

    public void clearList() {
        foods.clear();
    }

    public Map<String, String> getStringPairs() {
        Map<String, String> map = new HashMap<>();
        for (FoodItem food : foods) {
            if (food.isExpired()) {
                map.put(food.getItemType(), "EXPIRED");
            } else {
                map.put(food.getItemType(), Integer.toString(food.getExpiryTime()));
            }
        }
        return new HashMap<>(map);
    }


}
