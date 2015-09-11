package unicauca.movil.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Toast.makeText(this,"Agregar",Toast.LENGTH_SHORT).show();
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


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_ctx_list, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_edit:
                Toast.makeText(this,"Editar !",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this,"Eliminar !",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
