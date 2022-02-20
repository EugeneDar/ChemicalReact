package com.barbar.chemicalreact;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class User {

    SharedPreferences sPref;

    Set<String> allSet = new HashSet<>();
    Set<String> simpleElementsSet = new HashSet<>();
    Set<String> oxidesSet = new HashSet<>();
    Set<String> acidsSet = new HashSet<>();
    Set<String> basesSet = new HashSet<>();
    Set<String> saltsSet = new HashSet<>();

    Activity activity;

    public User(Activity activity) {
        this.activity = activity;
        sPref = activity.getSharedPreferences("MyPref", MODE_PRIVATE);

        // start initialize
        simpleElementsSet.addAll(Arrays.asList("H₂", "O₂"));

        String[] strings = sPref.getString("simple_elements", "#").split("#");
        simpleElementsSet.addAll(Arrays.asList(strings));

        strings = sPref.getString("oxides", "#").split("#");
        oxidesSet.addAll(Arrays.asList(strings));

        strings = sPref.getString("bases", "#").split("#");
        basesSet.addAll(Arrays.asList(strings));

        strings = sPref.getString("acids", "#").split("#");
        acidsSet.addAll(Arrays.asList(strings));

        strings = sPref.getString("salts", "#").split("#");
        saltsSet.addAll(Arrays.asList(strings));

        allSet.addAll(oxidesSet);
        allSet.addAll(simpleElementsSet);
        allSet.addAll(acidsSet);
        allSet.addAll(basesSet);
        allSet.addAll(saltsSet);
    }

    public void addNew (String str) {
        // Select type
        switch (typeOfSubstance(str)) {
            case ACID: acidsSet.add(str); break;
            case BASE: basesSet.add(str); break;
            case OXIDE: oxidesSet.add(str); break;
            case SALT: saltsSet.add(str); break;
            default: simpleElementsSet.add(str); break;
        }

        allSet.add(str);

        // Unlock new elements
        checkPrize(str, "H₂O", "H₂O", "H₂O", "Na", "Li", "K");
        checkPrize(str, "Na₂O", "K₂O", "Li₂O", "Ca", "Mg", "Sr");
        checkPrize(str, "NaOH", "KOH", "LiOH", "Br₂", "Cl₂", "S");
        checkPrize(str, "H₂S", "HCl", "HBr", "Fe", "Cu", "Zn", "Hg", "Ag");
        checkPrize(str, "Ag₂O", "FeO", "CuO", "C", "N₂", "F₂", "P");
        checkPrize(str, "SO₃", "NO₂", "CO₂", "Be", "Ba", "Mn");
        checkPrize(str, "NaCl", "NaCl", "NaCl", "B", "Al", "Si");

        // Updating and saving
        allSet.add(str);
        save();
    }

    public void save () {
        // Initialize
        sPref = activity.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        // Simple elements
        StringBuilder simpleElementsString = new StringBuilder();
        for (String str : simpleElementsSet) {
            simpleElementsString.append(str).append("#");
        }
        ed.putString("simple_elements", simpleElementsString.toString());

        // Oxides
        StringBuilder oxidesString = new StringBuilder();
        for (String str : oxidesSet) {
            oxidesString.append(str).append("#");
        }
        ed.putString("oxides", oxidesString.toString());

        // Acids
        StringBuilder acidsString = new StringBuilder();
        for (String str : acidsSet) {
            acidsString.append(str).append("#");
        }
        ed.putString("acids", acidsString.toString());

        // Bases
        StringBuilder basesString = new StringBuilder();
        for (String str : basesSet) {
            basesString.append(str).append("#");
        }
        ed.putString("bases", basesString.toString());

        // Salts
        StringBuilder saltsString = new StringBuilder();
        for (String str : saltsSet) {
            saltsString.append(str).append("#");
        }
        ed.putString("salts", saltsString.toString());

        // Apply
        ed.apply();
    }

    private void checkPrize (String str, String a, String b, String c, String... prizes) {
        if ((str.equals(a) || str.equals(b) || str.equals(c)) && (allSet.contains(a) && allSet.contains(b) && allSet.contains(c))) {
            for (String element : prizes) {
                simpleElementsSet.add(element);
                Toast.makeText(activity.getApplicationContext(), "You unlocked: " + element, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static Type typeOfSubstance (String name) {

        if (name.startsWith("H") && !name.equals("H₂O")) {
            return Type.ACID;
        } else if (name.equals("OF₂") || name.endsWith("O") || name.endsWith("O₂") || name.endsWith("O₃") || name.endsWith("O₄") || name.endsWith("O₅")) {
            return Type.OXIDE;
        } else if (name.contains("OH")) {
            return Type.BASE;
        } else if (name.contains("NaCl")) {
            return Type.SALT;
        } else {
            return Type.SIMPLE_ELEMENT;
        }
    }

}
