package com.aquino.contactos.activities;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.aquino.contactos.R;
import com.aquino.contactos.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactosList;
    Contacto n1= new Contacto("Raul Ramos","raul.ramos@tecsup.edu.pe", "D15", 991671234);
    Contacto n2= new Contacto("Maria Castro","maria.castro@tecsup.edu.pe", "D10", 918649234);
    Contacto n3= new Contacto("Diego Flores","diego.flores@tecsup.edu.pe", "C18", 912631789);
    Contacto n4= new Contacto("Martha Merino","martha.merino@tecsup.edu.pe", "C12", 925714489);
    Contacto n5= new Contacto("Ana Rios","ana.rios@tecsup.edu.pe", "A12", 918631261);
    List<Contacto> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactosList = (ListView)findViewById(R.id.contactos_list);

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        contactosList.setAdapter(adap);

        contactos.add(n1);
        contactos.add(n2);
        contactos.add(n3);
        contactos.add(n4);
        contactos.add(n5);

        directorio();
    }

    private void directorio() {

        ArrayAdapter<String> adapter = (ArrayAdapter<String>) contactosList.getAdapter();

        for(Contacto contacto : contactos) {
            adapter.add(contacto.getNombre());
        }

        adapter.notifyDataSetChanged();

        contactosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Contacto cont = contactos.get(position);

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.detalle_dialog);
                TextView contenido = dialog.findViewById(R.id.info_text);

                contenido.setText("Correo: "+ cont.getCorreo()+"\nOficina: " +cont.getOficina()+"\nTelefono: "+cont.getTelefono());

                Button llamar_button = dialog.findViewById(R.id.llamar_button);
                Button mensaje_button = dialog.findViewById(R.id.mensaje_button);

                llamar_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+cont.getTelefono()));
                        startActivity(callIntent);
                        dialog.dismiss();
                    }
                });

                mensaje_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        startActivity(intent);

                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });
    }
}
