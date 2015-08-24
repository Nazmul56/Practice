package practice.nazmul.practice;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by nazmul on 8/13/15.
 */
public class Menue extends ListActivity {
    String classes[] ={"StartingPoint", "TextPlay","Camera","Data","exmple4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(Menue.this, android.R.layout.simple_list_item_1,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("practice.nazmul.practice." + cheese);//This Create the Intent io go different activity
            Intent ourIntent = new Intent(Menue.this, ourClass);
            startActivity(ourIntent);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
       // MenuInflater blowUp = getMenuInflater();
       // blowUp.inflate(R.menu.cool_menu, menu);
        return true;

    }
}
