package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
    public Database(@Nullable Context context)
    {
        super(context, "foody.sqlite", null, 1);
    }

    // Truy vấn không trả kết quả: CREATE, INSERT, UPDATE, DELETE...
    public void QueryData(String sql)
    {
        // Ghi dữ liệu
        SQLiteDatabase db = getWritableDatabase();
        //Thực thi
        db.execSQL(sql);
    }

    // Truy vấn có trả kết quả: SELECT
    public Cursor GetData(String sql)
    {
        // Chỉ đọc dữ liệu
        SQLiteDatabase db = getReadableDatabase();
        // Thực thi và trả về Cursor
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}