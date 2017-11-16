package com.example.frander.alquilersoft.Apartamentos;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.example.frander.alquilersoft.Canton.Canton;
import com.example.frander.alquilersoft.Distric.Distric;
import com.example.frander.alquilersoft.InterfaceRetrofit.ConexionApiEasyRent;
import com.example.frander.alquilersoft.InterfaceRetrofit.ContenedorUrlApi;
import com.example.frander.alquilersoft.Login;
import com.example.frander.alquilersoft.Province.Province;
import com.example.frander.alquilersoft.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.jar.Manifest;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApartamentosFragment extends Fragment {

    ArrayList<Province> provincias;
    ArrayList<Canton> Cantones;
    ArrayList<Distric> Distritos;

    private static Retrofit retrofit;
    Spinner provinciasList;
    Spinner cantonesList;
    Spinner districList;

    String provinciaAparta = "";
    String cantonAparta ="";
    int distrito_id;
    String distritoAparta="";
    Activity activity;

    EditText nombre;
    EditText descripcion;
    EditText cantidadOPersonas;
    EditText direccion;
    ImageView imagen;
    EditText precio;
    CheckBox disponible;

    Button cargarImagen;
    Button cancelar;
    Button guardarPublicar;
    Button guardar;

    String imgDecodableString="";
    public ApartamentosFragment() {
        // Required empty public constructor
    }

    public void crearConexionRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(ContenedorUrlApi.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void get_Provinces(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Province>> listaProvincias = conexion.get_Provinces();
        listaProvincias.enqueue(new Callback<ArrayList<Province>>() {
            @Override
            public void onResponse(Call<ArrayList<Province>> call, Response<ArrayList<Province>> response) {
                if(response.isSuccessful()){
                    provincias = response.body();
                    ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                    provinciasList.setAdapter(adapter);
                }else {
                    provincias = new ArrayList<Province>();
                    provincias.add(new Province(0,"Vacio",0));
                    Log.i("Prueba2",provincias.size()+"" );
                    ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                    provinciasList.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Province>> call, Throwable t) {
                Log.i("Prueba5", t+"");
                provincias = new ArrayList<Province>();
                provincias.add(new Province(0,"Vacio",0));
                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,getProvinceArray(provincias));
                provinciasList.setAdapter(adapter);
            }
        });
    }
    private String[] getProvinceArray(ArrayList<Province> provincias) {
        String[] lista = new String[provincias.size()];
        for(int i = 0; i<provincias.size();i++){
            lista[i] = provincias.get(i).getName();
        }
        return lista;
    }
    private void get_Cantones(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Canton>> listaCantones = conexion.get_Cantones();
        listaCantones.enqueue(new Callback<ArrayList<Canton>>() {
            @Override
            public void onResponse(Call<ArrayList<Canton>> call, Response<ArrayList<Canton>> response) {
                if(response.isSuccessful()){
                    Cantones = response.body();
                }else {
                    Cantones = new ArrayList<Canton>();
                    Cantones.add(new Canton(0,"Vacio",0,0));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Canton>> call, Throwable t) {
                Cantones = new ArrayList<Canton>();
                Cantones.add(new Canton(0,"Vacio",0,0));
            }
        });
    }
    private void get_Distric(){

        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<ArrayList<Distric>> listaDistritos = conexion.get_Distric();
        listaDistritos.enqueue(new Callback<ArrayList<Distric>>() {
            @Override
            public void onResponse(Call<ArrayList<Distric>> call, Response<ArrayList<Distric>> response) {
                if(response.isSuccessful()){
                    Distritos = response.body();
                }else {
                    Distritos = new ArrayList<Distric>();
                    Distritos.add(new Distric(0,"Vacio",0,0));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Distric>> call, Throwable t) {
                Distritos = new ArrayList<Distric>();
                Distritos.add(new Distric(0,"Vacio",0,0));
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartamentos, container, false);
        provinciasList = (Spinner) view.findViewById(R.id.spProvincia);
        cantonesList = (Spinner) view.findViewById(R.id.spCanton);
        districList = (Spinner) view.findViewById(R.id.spDistrito);
        imagen = (ImageView) view.findViewById(R.id.imgApartamento);
        cargarImagen = (Button) view.findViewById(R.id.btnCargarImagen);
        obtenerPermisosLectura();
        nombre= (EditText) view.findViewById(R.id.edtNombre);
        descripcion =(EditText) view.findViewById(R.id.edtDescripcion);
        cantidadOPersonas = (EditText) view.findViewById(R.id.edtCantidadPersonas);
        direccion = (EditText) view.findViewById(R.id.edtDireccion);
        cargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
            }
        });
        guardar = (Button) view.findViewById(R.id.button);
        precio = (EditText) view.findViewById(R.id.edtPrecio);
        disponible = (CheckBox)view.findViewById(R.id.cbDisponible);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ApartaNombre = nombre.getText().toString();
                String ApartDescripcion=descripcion.getText().toString();
                int ApartaCantidadPersonas = Integer.parseInt(cantidadOPersonas.getText().toString());
                String ApartaDireccion = direccion.getText().toString();
                float ApartaPrecio = Float.parseFloat(precio.getText().toString());
                int status;
                if(disponible.isChecked()){
                    status = 1;
                }else{
                    status = 2;
                }
               Apartamentos apartamento = new Apartamentos(ApartaCantidadPersonas,1,status,distrito_id,0,ApartaPrecio,ApartaNombre,ApartDescripcion,ApartaDireccion,imgDecodableString);
                add_apartament(apartamento);
                Log.i("objetocreado", "onClick: "+ apartamento.toString());
            }
        });

        provinciasList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provinciaAparta = (String) parent.getItemAtPosition(position);
                llenarSpinnerCantones(provincias,provinciaAparta,Cantones,cantonesList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cantonesList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cantonAparta = (String) parent.getItemAtPosition(position);
                llenarSpinnerDistrict(Cantones,cantonAparta,Distritos,districList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        districList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distritoAparta= (String)parent.getItemAtPosition(position);
                distrito_id = obtenerIdDistrito(distritoAparta,Distritos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        crearConexionRetrofit();
        get_Distric();
        get_Cantones();
        get_Provinces();

        activity = getActivity();
        return view;
    }

    private void add_apartament(Apartamentos apartamento) {
        ConexionApiEasyRent conexion = retrofit.create(ConexionApiEasyRent.class);
        Call<Boolean> isCreated = conexion.add_apartament(apartamento);
        isCreated.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(),"Se incerto correctamente",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(),"No se incerto correctamente",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(getActivity(),"Problema de conexion: "+t,Toast.LENGTH_LONG).show();
            }
        });

    }

    private int obtenerIdDistrito(String distritoAparta, ArrayList<Distric> distritos) {
        int id=0;
        for(int i = 0; i<distritos.size();i++){
            if(distritoAparta.equalsIgnoreCase(distritos.get(i).getName())){
                id = distritos.get(i).getId();
                i=distritos.size();
            }
        }
        return id;
    }


    private boolean obtenerPermisosLectura() {
        if(Build.VERSION.SDK_INT >= 23 ){
            if(ActivityCompat.checkSelfPermission(getActivity(),android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(),"Hay permiso",Toast.LENGTH_LONG).show();
                return true;
            }else{
                ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},1);
                Toast.makeText(getContext(),"Se dieron los permisos",Toast.LENGTH_LONG).show();
                return false;
            }

        }else{
            Toast.makeText(getContext(),"tienes permiso 2",Toast.LENGTH_LONG).show();
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getContext(),"Permission"+permissions[0]+" was "+grantResults[0],Toast.LENGTH_LONG).show();
        }
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicación"),10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            try {
                if (resultCode == Activity.RESULT_OK) {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    imgDecodableString = encodeImage(selectedImage);

                    Uri selectedImages = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    // Get the cursor
                    Cursor cursor = getContext().getContentResolver().query(selectedImages,filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imgDecodableString = cursor.getString(columnIndex);
                    Log.i("sayayin",imgDecodableString);
                    imgDecodableString = encodeImages(imgDecodableString);

                    cursor.close();




                    Bitmap myBitmapAgain = decodeBase64(imgDecodableString);
                    imagen.setImageBitmap(myBitmapAgain);


                } else {
                    Toast.makeText(getContext(),"No haz escogido una imagen",Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Log.i("Error",e+"");
                Toast.makeText(getContext(), "Algo salio mal", Toast.LENGTH_LONG)
                        .show();
            }
       // }
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT);

        return imgDecodableString;
    }

    private String encodeImages(String path) {
        File imagefile = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(imagefile);

        }catch(FileNotFoundException e){
            e.printStackTrace();
            Log.i("leermensaje", "encodeImages: "+e);
        }

        Bitmap bm = BitmapFactory.decodeStream(fis);
        Log.i("imagen1gg", "encodeImages: "+bm);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT);
        Log.i("Base64prueba", "encodeImages: "+imgDecodableString);
        //Base64.de
        return imgDecodableString;

    }
    private void llenarSpinnerDistrict(ArrayList<Canton> cantones, String opcion, ArrayList<Distric> distritos, Spinner districList) {
        Canton canton =new Canton();
        ArrayList<Distric> distritosSeleccionados = new ArrayList<>();
        String[] lista;
        if(!cantones.isEmpty() && !distritos.isEmpty()){
            for(int i=0;i<cantones.size();i++){
                if(cantones.get(i).getName().equalsIgnoreCase(opcion)){
                    canton.setId(cantones.get(i).getId());
                    canton.setName(cantones.get(i).getName());
                    canton.setIs_active(cantones.get(i).getIs_active());
                    i=cantones.size();
                }
            }


            for(int j=0;j<distritos.size();j++){
                if(distritos.get(j).getId_canton() == canton.getId()){
                    distritosSeleccionados.add(distritos.get(j));
                }
            }

            if(!distritosSeleccionados.isEmpty()){
                lista = new String[distritosSeleccionados.size()];
                for(int m=0; m<distritosSeleccionados.size();m++){
                    lista[m]= distritosSeleccionados.get(m).getName();
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,lista);
                districList.setAdapter(adapter);
            }

        }
    }

    private void llenarSpinnerCantones(ArrayList<Province> provincias, String opcion, ArrayList<Canton> cantones, Spinner spCanton) {
        Province provincia =new Province();
        ArrayList<Canton> cantonesSeleccionados = new ArrayList<>();
        String[] lista;
        if(!provincias.isEmpty() && !cantones.isEmpty()){
            for(int i=0;i<provincias.size();i++){
                if(provincias.get(i).getName().equalsIgnoreCase(opcion)){
                    provincia.setId(provincias.get(i).getId());
                    provincia.setName(provincias.get(i).getName());
                    provincia.setIs_active(provincias.get(i).getIs_active());
                    i=provincias.size();
                }
            }


            for(int j=0;j<cantones.size();j++){
                if(cantones.get(j).getProvince_id() == provincia.getId()){
                    cantonesSeleccionados.add(cantones.get(j));
                }
            }

            if(!cantonesSeleccionados.isEmpty()){
                lista = new String[cantonesSeleccionados.size()];
                for(int m=0; m<cantonesSeleccionados.size();m++){
                    lista[m]= cantonesSeleccionados.get(m).getName();
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_dropdown_item,lista);
                spCanton.setAdapter(adapter);
            }

        }
    }


}
