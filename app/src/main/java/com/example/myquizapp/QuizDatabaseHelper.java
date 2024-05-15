package com.example.myquizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTIONS = "questions";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_CHOICE_A = "choiceA";
    private static final String COLUMN_CHOICE_B = "choiceB";
    private static final String COLUMN_CHOICE_C = "choiceC";
    private static final String COLUMN_CHOICE_D = "choiceD";
    private static final String COLUMN_CORRECT_ANSWER = "correctAnswer";

    private static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE " + TABLE_QUESTIONS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_QUESTION + " TEXT,"
            + COLUMN_CHOICE_A + " TEXT,"
            + COLUMN_CHOICE_B + " TEXT,"
            + COLUMN_CHOICE_C + " TEXT,"
            + COLUMN_CHOICE_D + " TEXT,"
            + COLUMN_CORRECT_ANSWER + " TEXT"
            + ")";

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
        db.execSQL(CREATE_TABLE_QUESTIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);


        onCreate(db);
    }
}
