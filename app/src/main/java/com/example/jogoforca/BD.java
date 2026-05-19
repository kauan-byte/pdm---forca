package com.example.jogoforca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BD extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "banco.db";
    public BD(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS palavra("+
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "palavra TEXT,"+
                        "categoria TEXT"+
                        ")"
        );
    }
    public void salvarPalavra(Palavra p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("palavra", p.getNome());
        content.put("categoria", p.getCategoria());
        db.insert("palavra", null, content);
        db.close();
    }
    public ArrayList<Palavra> listarPalavras(){
       ArrayList<Palavra> lista = new ArrayList<Palavra>();
       SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("palavra", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String palavra = cursor.getString(cursor.getColumnIndexOrThrow("palavra"));
            String categoria = cursor.getString(cursor.getColumnIndexOrThrow("categoria"));
            Palavra p = new Palavra();
            p.setNome(palavra);
            p.setCategoria(categoria);
            lista.add(p);
        }
        cursor.close();
        db.close();
        return lista;
    }
    public boolean existe(String p){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("palavra", null, "palavra=?", new String[]{p}, null, null, null);
        boolean existe = c.getCount()>0;
        c.close();
        db.close();
        return existe;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
