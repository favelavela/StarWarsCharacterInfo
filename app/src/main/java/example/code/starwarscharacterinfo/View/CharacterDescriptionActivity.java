package example.code.starwarscharacterinfo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import example.code.starwarscharacterinfo.R;
import example.code.starwarscharacterinfo.Utils.Utils;

public class CharacterDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_description);

        TextView nameTextView = findViewById(R.id.character_name);
        TextView heightTextView = findViewById(R.id.character_height);
        TextView weightTextView = findViewById(R.id.character_mass);
        TextView createdTextView = findViewById(R.id.record_creation_date);

        Intent intent = getIntent();

        String name = intent.getStringExtra(Utils.NAME);
        String height = intent.getStringExtra(Utils.HEIGHT);
        String weight = intent.getStringExtra(Utils.WEIGHT);
        String date = intent.getStringExtra(Utils.DATE);

        if(!name.isEmpty()) nameTextView.setText(name);
        if(!height.isEmpty()) heightTextView.setText(height);
        if(!weight.isEmpty()) weightTextView.setText(weight);
        if(!date.isEmpty()) createdTextView.setText(date);

    }
}
