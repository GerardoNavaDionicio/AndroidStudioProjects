package com.example.crud_sqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tv_codigo, tv_descripcion, tv_precio;
    Button pb_insertar, pb_actualizar, pb_eliminar, pb_consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_codigo=(EditText) findViewById(R.id.tv_codigo);
        tv_descripcion=(EditText) findViewById(R.id.tv_descripcion);
        tv_precio=(EditText) findViewById(R.id.tv_precio);
        pb_insertar=(Button) findViewById(R.id.pb_registrar);
        pb_actualizar=(Button) findViewById(R.id.pb_actualizar);
        pb_eliminar=(Button) findViewById(R.id.pb_eliminar);
        pb_consultar=(Button) findViewById(R.id.pb_consultar);
    }
    public void REGISTRAR(View V){
        DBHELPER admin=new DBHELPER(this, "Producto", null, 1);//Creación de BD
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String codi=tv_codigo.getText().toString();
        String des=tv_descripcion.getText().toString();
        String pre=tv_precio.getText().toString();
        if(!codi.isEmpty() && !des.isEmpty() && !pre.isEmpty()){
            ContentValues articulo=new ContentValues();
            articulo.put("codigo", codi);
            articulo.put("descripcion", des);
            articulo.put("precio",pre);
            BaseDatos.insert("productos",null,articulo);
            BaseDatos.close();
            tv_codigo.setText("");
            tv_descripcion.setText("");
            tv_precio.setText("");
            Toast texto=Toast.makeText(getApplicationContext(),"Producto Registrado con Éxito",Toast.LENGTH_SHORT);
            texto.show();
        }
        else{
            Toast texto2=Toast.makeText(getApplicationContext(),"esta vacio, meeh!",Toast.LENGTH_SHORT);
            texto2.show();
        }
    }

    public void CONSULTAR(View V){
        DBHELPER admin=new DBHELPER(this, "Producto", null, 1);
        SQLiteDatabase BaseDatos=admin.getReadableDatabase();
        String codi=tv_codigo.getText().toString();
        if(!codi.isEmpty()){
            Cursor join=BaseDatos.rawQuery("Select descripcion,precio from productos where codigo="+codi,null);
            if(join.moveToFirst()){
                tv_descripcion.setText(join.getString(0));
                tv_precio.setText(join.getString(1));
                BaseDatos.close();
            }
            else{
                Toast texto=Toast.makeText(getApplicationContext(),"no existe ",Toast.LENGTH_SHORT);
                texto.show();
            }
        }
        else{
            Toast texto2=Toast.makeText(getApplicationContext(),"Ingrese Código",Toast.LENGTH_SHORT);
            texto2.show();
        }
    }
    public void ELIMINAR(View V){
        DBHELPER admin=new DBHELPER(this, "Producto", null, 1);
        SQLiteDatabase BaseDatos=admin.getReadableDatabase();
        String codi=tv_codigo.getText().toString();
        if(!codi.isEmpty()){
            Cursor join=BaseDatos.rawQuery("Delete from productos where codigo="+codi,null);
            if(join.moveToFirst()){
                Toast texto=Toast.makeText(getApplicationContext(),"no hay nada ",Toast.LENGTH_SHORT);
                texto.show();
            }
            else{
                tv_codigo.setText("");
                tv_descripcion.setText("");
                tv_precio.setText("");
                Toast texto=Toast.makeText(getApplicationContext(),"Eliminacion satisfactoria",Toast.LENGTH_SHORT);
                texto.show();
                BaseDatos.close();
            }
        }
        else{
            Toast texto=Toast.makeText(getApplicationContext(),"Ingrese el Código",Toast.LENGTH_SHORT);
            texto.show();
        }
    }

    public void ACTUALIZAR(View V){
        DBHELPER admin=new DBHELPER(this, "Producto", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String codi=tv_codigo.getText().toString();
        String des=tv_descripcion.getText().toString();
        String pre=tv_precio.getText().toString();
        ContentValues values = new ContentValues();
        values.put("descripcion", des);
        values.put("precio",pre);
        BaseDatos.update("productos",values,"codigo="+codi,null);
        tv_codigo.setText("");
        tv_descripcion.setText("");
        tv_precio.setText("");
        Toast texto=Toast.makeText(getApplicationContext(),"La Base de datos ha sido Actualizada",Toast.LENGTH_SHORT);
        texto.show();
        BaseDatos.close();
    }





}