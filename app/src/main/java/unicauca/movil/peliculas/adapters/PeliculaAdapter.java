package unicauca.movil.peliculas.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unicauca.movil.peliculas.R;
import unicauca.movil.peliculas.models.Pelicula;

/**
 * Created by Dario Chamorro on 11/09/2015.
 */
public class PeliculaAdapter extends BaseAdapter {

    Context context;
    List<Pelicula> data;

    public PeliculaAdapter(Context context, List<Pelicula> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = null;

        if(view == null)
            v =  View.inflate(context, R.layout.template_pelicula, null);
        else
            v = view;

        Pelicula p = (Pelicula) getItem(i);

        TextView txt = (TextView) v.findViewById(R.id.txt);

        txt.setText(p.getNombre());

        return v;
    }
}
