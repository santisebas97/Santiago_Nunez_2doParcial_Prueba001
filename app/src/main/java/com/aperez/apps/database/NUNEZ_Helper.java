package com.aperez.apps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class NUNEZ_Helper extends SQLiteOpenHelper {

    private String createTable_Usuarios="CREATE TABLE Usuarios(Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre TEXT," +
            "Contrasena TEXT)";

    public NUNEZ_Helper(@Nullable Context context, @Nullable String name,
                        @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
