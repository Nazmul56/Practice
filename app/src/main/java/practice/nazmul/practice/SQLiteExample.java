package practice.nazmul.practice;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nazmul on 11/5/15.
 */
public class SQLiteExample extends Activity implements View.OnClickListener {
    Button sqlUpdate, sqlView;
    EditText sqlName, sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);

        sqlUpdate = (Button) findViewById(R.id.bUpdate);
        sqlName = (EditText) findViewById(R.id.etName);
        sqlHotness = (EditText)findViewById(R.id.etScale);

        sqlView =  (Button)findViewById(R.id.bView);
        sqlView.setOnClickListener(this);
        sqlUpdate.setOnClickListener(this);
    }

    public void onClick(View arg0){
        switch(arg0.getId()){
            case R.id.bUpdate:
                boolean didItWork = true;
                try {
                    String name = sqlName.getText().toString();

                    String hotness = sqlHotness.getText().toString();
                    HotOrNot entry = new HotOrNot(SQLiteExample.this);
                    entry.open();
                    entry.createEntry(name, hotness);
                    entry.close();
                }catch (Exception e){
                    didItWork = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Dong it");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(didItWork){
                        Dialog d = new Dialog(this);
                        d.setTitle("Heck Yea! ");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }


                break;
            case R.id.bView:

                Intent i = new Intent(SQLiteExample.this, SQLView.class);
                startActivity(i);
                break;

        }
    }
}
