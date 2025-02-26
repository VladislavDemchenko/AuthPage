package com.example.authservice

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.authservice.entity.User

class DbHelper (val context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "auth.db"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "users"
        val COLUMN_ID = "id"
        val COLUMN_LOGIN = "login"
        val COLUMN_EMAIL = "email"
        val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_LOGIN TEXT, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT)"
        db!!.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(user: User) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_LOGIN, user.login)
        values.put(COLUMN_EMAIL, user.email)
        values.put(COLUMN_PASSWORD, user.password)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun authUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_LOGIN = '$login' AND $COLUMN_PASSWORD = '$pass'", null)
        var result = cursor.moveToFirst()
        cursor.close()
        db.close()
        return result
    }
    fun isAuth(login: String): Boolean {
        val db = this.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_LOGIN = '$login'", null)
        var result = cursor.moveToFirst()
        cursor.close()
        db.close()
        return result
    }

}