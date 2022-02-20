package com.barbar.chemicalreact;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TasksActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    User user;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        adapter = new ArrayAdapter<>(this, R.layout.task_item, R.id.tasks_item_text, data);
        listView = findViewById(R.id.tasks_list);
        listView.setAdapter(adapter);

        user = new User(this);

        textView = findViewById(R.id.task_text_view);

        initializeData();
        initializeOnClick();
    }

    private void initializeData () {
        dataInit("Water", "H₂O");
        dataInit("Oxides #1", "K₂O", "Li₂O", "Na₂O");
        dataInit("Oxides #2", "CaO", "MgO", "SrO");
        dataInit("Bases #1", "NaOH", "KOH", "LiOH");
        dataInit("Acids #1", "H₂S", "HCl", "HBr");
        dataInit("Oxides #3", "FeO", "Ag₂O", "CuO", "ZnO", "HgO");
        dataInit("Bases #2", "Ca(OH)₂", "Mg(OH)₂", "Sr(OH)₂");
        dataInit("Oxides #4", "CO₂", "NO", "OF₂", "P₂O₅");
        dataInit("Oxides #5", "SO₃", "NO₂");
        dataInit("Oxides #6", "BeO", "BaO", "Mn₂O₇", "MnO₂");
        dataInit("Acids #2", "H₂CO₃", "HNO₂", "HNO₃", "H₂SO₄", "H₂SO₃", "H₃PO₄");
        dataInit("Salt #1", "NaCl");
        dataInit("End?", "Like");

        adapter.notifyDataSetChanged();
    }

    private void dataInit (String name, String... needs) {
        int amount = 0;
        for (String str : needs) {
            if (user.allSet.contains(str)) {
                amount++;
            }
        }

        if (amount == needs.length) {
            data.add(name + "\n" + "Completed");
        } else {
            data.add(name + "\n" + amount + "/" + needs.length);
        }
    }

    private void initializeOnClick () {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String name = data.get(position).split("\n")[0];
            String text;

            switch (name) {
                case "Water": {text = "This reaction will not go by itself, it needs energy"; break;}
                case "Oxides #1": {text = "Here you need all the oxides of the alkali metals, I think you know how to get the oxide (hint: metal + oxygen)"; break;}
                case "Oxides #2": {text = "Ok, since you could do the last group, you can handle earth-alkaline metal oxides too"; break;}
                case "Bases #1": {text = "There are actually two very easy ways to get the base now (hint: you need to add water to something)"; break;}
                case "Acids #1": {text = "Ok, I hope you can figure out how to make the bases. The method is approximately the same with acids, but now I am asking you to make oxygen-free acids. (hint: energy is needed there)"; break;}
                case "Oxides #3": {text = "If you do everything consistently, then you should have just received 5 new metals. Try to create their oxides"; break;}
                case "Bases #2": {text = "If I'm not mistaken, you already made alkali metal hydroxides, now make earth-alkaline hydroxides"; break;}
                case "Oxides #4": {text = "Hey, you used to make metal oxides, but it turns out there are non-metal oxides as well. They are also often called acidic residues. I think you can handle it"; break;}
                case "Oxides #5": {text = "Perhaps you think you created all the oxides you could (although you may really have created them), but I would advise you to think about sulfur and nitrogen"; break;}
                case "Oxides #6": {text = "You may be tired of oxides, but there are only three left, which I will ask you to create (hint: Ba, Be, Mn)"; break;}
                case "Acids #2": {text = "Hmm, acids, for me these are the coolest things in chemistry, and now you need to create all the oxygenated acids that you can"; break;}
                case "Salt #1": {text = "Hurray, we have a new type of substance, this is salt. I will ask you to create the simplest salt I know. It is usually called table salt"; break;}
                case "End?": {text = "I apologize that the tasks are over, but I am sure that you have not completed all the reactions that are in this application yet.\n" +
                        "I'm just a beginner programmer, so if you want to motivate me to continue developing this application, you can rate it in the Play Market (everything is on a voluntary basis, okay?)"; break;}
                default: text = "";
            }

            textView.setText(text);
        });
    }


}