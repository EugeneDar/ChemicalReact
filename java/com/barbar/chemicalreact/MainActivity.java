package com.barbar.chemicalreact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();
    GridView gridView;
    ArrayAdapter<String> adapter;

    User user;

    Button simpleElementsButton;
    Button oxideButton;
    Button acidButton;
    Button baseButton;
    Button saltButton;

    Button reactButton;
    Button learnButton;

    TextView catalystTextView;
    TextView firstSelectedElement;
    TextView secondSelectedElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter initialize
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.item_text, data);
        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);

        // Buttons and views initialize
        buttonsInitialize();
        textViewsInitialize();

        //Substances.initialize();
        user = new User(this);
        Reactions.initialize();

        // Start page initialize
        data.addAll(user.simpleElementsSet);
        adapter.notifyDataSetChanged();

        // GridView onClick initialize
        gridView.setOnItemClickListener((parent, v, position, id) -> {
            try {
                String name = data.get(position);
                if (firstSelectedElement.getText().toString().equals("")) {
                    firstSelectedElement.setText(name);
                } else if (secondSelectedElement.getText().toString().equals("")) {
                    secondSelectedElement.setText(name);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, you cannot select more than two substances", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void buttonsInitialize () {
        simpleElementsButton = findViewById(R.id.simple_element_button);
        oxideButton = findViewById(R.id.oxide_button);
        acidButton = findViewById(R.id.acid_button);
        baseButton = findViewById(R.id.base_button);
        saltButton = findViewById(R.id.salt_button);

        reactButton = findViewById(R.id.react_button);
        learnButton = findViewById(R.id.learn_button);

        simpleElementsButton.setOnClickListener(v -> {
            data.clear();
            data.addAll(user.simpleElementsSet);
            Collections.sort(data);
            adapter.notifyDataSetChanged();
        });
        oxideButton.setOnClickListener(v -> {
            data.clear();
            data.addAll(user.oxidesSet);
            Collections.sort(data);
            adapter.notifyDataSetChanged();
        });
        acidButton.setOnClickListener(v -> {
            data.clear();
            data.addAll(user.acidsSet);
            Collections.sort(data);
            adapter.notifyDataSetChanged();
        });
        baseButton.setOnClickListener(v -> {
            data.clear();
            data.addAll(user.basesSet);
            Collections.sort(data);
            adapter.notifyDataSetChanged();
        });
        saltButton.setOnClickListener(v -> {
            data.clear();
            data.addAll(user.saltsSet);
            Collections.sort(data);
            adapter.notifyDataSetChanged();
        });

        reactButton.setOnClickListener(v -> {
            String element_1 = firstSelectedElement.getText().toString();
            String element_2 = secondSelectedElement.getText().toString();
            String catalyst = catalystTextView.getText().toString();

            if (element_1.equals("") && element_2.equals("")) {
                return;
            }

            List<String> resultList;

            if (!element_1.equals("") && !element_2.equals("")) {
                resultList = Reactions.getResult(element_1, element_2, catalyst);
            } else if (!element_1.equals("")) {
                resultList = Reactions.getResult(element_1, catalyst);
            } else {
                resultList = Reactions.getResult(element_2, catalyst);
            }

            if (resultList == null) {
                Toast.makeText(getApplicationContext(), "This reaction does not exist or it will be added to the application later", Toast.LENGTH_SHORT).show();
                return;
            }

            firstSelectedElement.setText(resultList.get(0));
            if (resultList.size() > 1) {
                secondSelectedElement.setText(resultList.get(1));
            } else {
                secondSelectedElement.setText("");
            }

            for (String str : resultList) {
                if (!user.allSet.contains(str)) {
                    Toast.makeText(getApplicationContext(), "You unlocked: " + str, Toast.LENGTH_LONG).show();
                    user.addNew(str);
                }
            }
        });

        learnButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(this, TasksActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void textViewsInitialize () {
        catalystTextView = findViewById(R.id.catalyst_textview);
        firstSelectedElement = findViewById(R.id.first_selected_element);
        secondSelectedElement = findViewById(R.id.second_selected_element);

        catalystTextView.setOnClickListener(v -> {
            String text = catalystTextView.getText().toString();
            if (text.equals("Nothing")) {
                catalystTextView.setText("Heat");
            } else if (text.equals("Heat")) {
                catalystTextView.setText("Electricity");
            } else if (text.equals("Electricity")) {
                catalystTextView.setText("Light");
            } else {
                catalystTextView.setText("Nothing");
            }
        });

        firstSelectedElement.setOnClickListener(v -> {
            firstSelectedElement.setText("");
        });

        secondSelectedElement.setOnClickListener(v -> {
            secondSelectedElement.setText("");
        });
    }

    private int getColorByName (String name) {
        if (name.contains("Li") || name.contains("Na") || name.contains("K")) {
            return Color.rgb(100, 100, 100);
        }
        if (name.contains("Sr") || name.contains("Mg") || name.contains("Ca")) {
            return Color.rgb(150, 100, 125);
        }
        if (name.contains("H") || name.contains("O")) {
            return Color.rgb(88, 88, 88);
        }

        return Color.WHITE;
    }

}