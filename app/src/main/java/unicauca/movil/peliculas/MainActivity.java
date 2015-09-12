package unicauca.movil.peliculas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.peliculas.adapters.PeliculaAdapter;
import unicauca.movil.peliculas.models.Pelicula;
import unicauca.movil.peliculas.util.AppUtil;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    ListView list;
    int pos;
    AlertDialog delete;

    PeliculaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        AppUtil.data = new ArrayList<>();
        adapter = new PeliculaAdapter(this, AppUtil.data);
        list.setAdapter(adapter);

        registerForContextMenu(list);

        delete = new AlertDialog.Builder(this)
                .setTitle("Eliminar")
                .setMessage("Desea eliminar la pelicula?")
                //.setView()
                .setPositiveButton("Aceptar",this)
                .setNegativeButton("Cancelar",this)
                .create();

        loadData();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();

    }

    private void loadData() {
        String peliculas[] = getResources().getStringArray(R.array.peliculas);
        for(int i = 0 ;i<peliculas.length;i++){
            Pelicula p =  new Pelicula(peliculas[i]);
            AppUtil.data.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    //region Metodos de Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_add:

                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);

                break;
            case R.id.action_other:
                Toast.makeText(this,"otros",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"Acerca De",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_info:
                Toast.makeText(this,"Informacion",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Metodos de Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_ctx_list, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;

        switch(item.getItemId()){
            case R.id.action_edit:
                Intent intent =  new Intent(this, AddActivity.class);
                intent.putExtra(AddActivity.KEY_POS,pos);
                startActivity(intent);
                break;
            case R.id.action_delete:
                delete.show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    //endregion


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            AppUtil.data.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }



}
