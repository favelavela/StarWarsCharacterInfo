package example.code.starwarscharacterinfo.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.code.starwarscharacterinfo.Model.StarWarsCharacters;
import example.code.starwarscharacterinfo.R;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder>{

    private final StarWarsCharacters charactersList;

    public CharacterListAdapter(StarWarsCharacters charactersList) {
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.character_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.characterName.setText(charactersList.getResults().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return charactersList.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView characterName;

        ViewHolder(View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.character_name);
        }
    }
}
