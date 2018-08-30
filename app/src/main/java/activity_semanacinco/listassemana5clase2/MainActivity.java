package activity_semanacinco.listassemana5clase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvNoticias;
    NoticiaAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNoticias = findViewById(R.id.lv_noticias);
        customAdapter = new NoticiaAdapter(this);
        lvNoticias.setAdapter(customAdapter);

        Noticias noticia1 = new Noticias("Hoy es diseño", "Va a haber un cambio en el logo", "30/08/2018");
        Noticias noticia2 = new Noticias("Hoy es diseño", "Va a haber un cambio en el logo", "30/08/2018");

        customAdapter.agregarNoticias(noticia1);
        customAdapter.agregarNoticias(noticia2);

        lvNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Noticias noticiaClic = (Noticias) customAdapter.getItem(position);
                Toast.makeText(MainActivity.this, noticiaClic.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
