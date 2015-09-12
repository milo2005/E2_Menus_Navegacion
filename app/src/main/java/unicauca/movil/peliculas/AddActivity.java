package unicauca.movil.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import unicauca.movil.peliculas.models.Pelicula;
import unicauca.movil.peliculas.util.AppUtil;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_POS="pos";

    Button btn;
    EditText edit;
    int pos = -1;
    Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.name);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            pos = extras.getInt(KEY_POS);
            getSupportActionBar().setTitle("Editar Pelicula");
            pelicula = AppUtil.data.get(pos);
            edit.setText(pelicula.getNombre());
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btn.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String name =edit.getText().toString();
        if(pos==-1) {
            Pelicula p = new Pelicula(name);
            AppUtil.data.add(p);
        }else{
            pelicula.setNombre(name);
        }
        finish();
    }
}
