package unicauca.movil.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
}
