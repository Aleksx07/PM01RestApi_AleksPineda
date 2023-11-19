package hn.uth.pm01restapi_alekspineda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import hn.uth.pm01restapi_alekspineda.Config.Personas;
import hn.uth.pm01restapi_alekspineda.Config.ResApiMethods;


public class ActivityList extends AppCompatActivity {

    private RequestQueue requestQueue;

    List<Personas> listperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listperson = new ArrayList<>();
        SendDat();

    }

    private void SendDat() {
        requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET,
                ResApiMethods.EndpointGet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {


                    String mensaje = response.toString();
                    //Toast.makeText(getApplicationContext(), mensaje,Toast.LENGTH_LONG).show();

                    JSONArray arreglo = new JSONArray(response);

                    for(int i=0; i < arreglo.length(); i++){
                        JSONObject arrayperson = arreglo.getJSONObject(i);

                        Personas persona = new Personas();
                        persona.setId(arrayperson.getString("id"));
                        persona.setNombres(arrayperson.getString("nombres"));
                        persona.setApellidos(arrayperson.getString("apellidos"));
                        persona.setCorreo(arrayperson.getString("correo"));
                        persona.setFechanac(arrayperson.getString("fechanac"));
                        persona.setId(arrayperson.getString("foto"));

                        listperson.add(persona);

                    }

                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );

        requestQueue.add(request);


    }
    }
