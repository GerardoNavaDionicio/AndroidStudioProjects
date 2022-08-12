package com.example.codigo_qr4;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;











public class MainActivity extends AppCompatActivity {
    private Button scan;
    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && result.getContents() != null)
        {
            new AlertDialog.Builder(MainActivity.this).setTitle("Resultados de la lectura") .setMessage(result.getContents()) .setPositiveButton("Copiar", new DialogInterface.OnClickListener()
                {
                    @Override public void onClick(DialogInterface dialog, int which)
                        {
                            ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); ClipData data = ClipData.newPlainText("resultado", result.getContents()); manager.setPrimaryClip(data);
                        }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); } }).create().show();
    }
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}