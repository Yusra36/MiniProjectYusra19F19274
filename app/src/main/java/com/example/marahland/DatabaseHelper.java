package com.example.marahland;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper

{
    public static final String DBName="Visitors.db";
    public static final String TableName="Visitors";
    public static final String Column1="VisitorsID";
    public static final String Column2="Email";
    public static final String Column3="AdultNum";
    public static final String Column4="childrenNum";

    public DatabaseHelper (Context Context1)
    {
        super(Context1,DBName,null,1);
    }

    public void onCreate(SQLiteDatabase SQLDB)
    {
        SQLDB.execSQL("create table " +TableName+ "(VisitorsID INTEGER PRIMARY KEY AUTOINCREMENT, Email TEXT,AdultNum INTEGER,childrenNum INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase SQLDB, int OldVersion, int NewVersion)
    {
        SQLDB.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(SQLDB);
    }

    public boolean insertData(String Email, String AdultNum, String childrenNum)
    {
        SQLiteDatabase SQLDB=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Column2,Email);
        contentValues.put(Column3,AdultNum);
        contentValues.put(Column4,childrenNum);
        long result=SQLDB.insert(TableName,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean updateData(String VisitorsID, String Email, String AdultNum, String childrenNum)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Column1,VisitorsID);
        contentValues.put(Column2,Email);
        contentValues.put(Column3,AdultNum);
        contentValues.put(Column4,childrenNum);
        db.update(TableName,contentValues,"VisitorsID=?",new String[]{VisitorsID});
        return true;
    }

    public Integer deleteData(String VisitorsID)
    {
        SQLiteDatabase SQLDB=this.getWritableDatabase();
        return SQLDB.delete(TableName,"VisitorsID=?",new String[]{VisitorsID});
    }
    public Cursor GetAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor Cursor33=db.rawQuery("select * from " +TableName,null);
        return Cursor33;
    }

}