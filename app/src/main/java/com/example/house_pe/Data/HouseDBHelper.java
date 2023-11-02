package com.example.house_pe.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.house_pe.Models.HouseModel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HouseDBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final  String DATABASE_NAME = "HousePE";
    private static  final int VERSION = 1;

    private static final String TABLE_NAME = "HouseData";
    private static final String COLUMN_HouseID = "HouseId";
    private static final String COLUMN_HouseNo = "HouseNo";
    private static final String COLUMN_NoOfRoom = "NoOfRoom";
    private static final String COLUMN_Owner = "Owner";
    private static final String COLUMN_Price = "Price";
    private static final String COLUMN_Description = "Description";



    public HouseDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +
                "( " + COLUMN_HouseID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HouseNo + " TEXT, " +
                COLUMN_Owner + " TEXT, " +
                COLUMN_NoOfRoom + " TEXT, " +
                COLUMN_Price + " TEXT, " +
                COLUMN_Description + " TEXT);";

        db.execSQL(sql);

        ArrayList<HouseModel> houseModels = new ArrayList<>();
        houseModels.add(new HouseModel(1, "N2334", "Nguyễn Văn Hoàng", 10, new BigDecimal("123"), ""));
        houseModels.add(new HouseModel(2, "H3404", "Nguyễn Văn Hải", 5, new BigDecimal("300"), ""));
        houseModels.add(new HouseModel(3, "P20202", "Hoàng Thị Anh", 3, new BigDecimal("400"), ""));


        for (HouseModel houseModel : houseModels) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_HouseNo, houseModel.getHouseNo());
            values.put(COLUMN_Owner, houseModel.getHouseOwnerName());
            values.put(COLUMN_NoOfRoom, houseModel.getNoOfRoom());
            values.put(COLUMN_Price, houseModel.getHousePrice().toString());
            values.put(COLUMN_Description, houseModel.getHouseDescription());

            db.insert(TABLE_NAME, null, values);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i!=i1){
            db.execSQL("Drop Table If Exists " +  TABLE_NAME);
            onCreate(db);
        }
    }

    // Create
    public long InsertCar(String houseNo, String ownerName, int noOfRoom, BigDecimal price, String description){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_HouseNo, houseNo);
        values.put(COLUMN_Owner, ownerName);
        values.put(COLUMN_NoOfRoom, noOfRoom);
        values.put(COLUMN_Price, String.valueOf(price));

        values.put(COLUMN_Description, description);

        long result = db.insert(TABLE_NAME, null, values);

        return result;
    }

    public ArrayList<HouseModel> getAllHouse(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<HouseModel> houseModels = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int houseId = cursor.getInt(0);
            String houseNo = cursor.getString(1);
            String ownerName = cursor.getString(2);
            int noOfRoom = Integer.parseInt((cursor.getString(3)));
            BigDecimal price = BigDecimal.valueOf(Long.parseLong(cursor.getString(4)));
            String description = cursor.getString(5);

            houseModels.add(new HouseModel(houseId,houseNo,ownerName, noOfRoom,price,description));
            cursor.moveToNext();
        }
        cursor.close();
        return  houseModels;
    }

}
