package com.example.labwork28

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookOpenHelper(context : Context)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + BOOKS_TABLE + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT NOT NULL, "
                + AUTHOR_COL + " TEXT NOT NULL, "
                + YEAR_COL + " SMALLINT NOT NULL, "
                + PAGES_COL + " SMALLINT NOT NULL)")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $BOOKS_TABLE")
    }

    fun insertBook(
        title : String,
        author : String,
        year : Int,
        pages : Int
    ){
        val values = ContentValues()
        values.put(TITLE_COL, title)
        values.put(AUTHOR_COL, author)
        values.put(YEAR_COL, year)
        values.put(PAGES_COL, pages)

        val db = this.writableDatabase
        db.insert(BOOKS_TABLE, null, values)
        db.close()
    }

    fun selectBook() : List<Book>{
        val db = this.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM $BOOKS_TABLE", null)

        val booksArrayList = ArrayList<Book>()

        cursor.use{
            if (cursor.moveToFirst()){
                do{
                    booksArrayList.add(Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4)
                    ))
                }while(cursor.moveToNext())
            }
        }

        db.close()
        return booksArrayList
    }

    fun getBook(bookId : Int) : Book {
        val db = this.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM $BOOKS_TABLE WHERE id = ?", arrayOf("${bookId}"))

        cursor.use {
            if (cursor.moveToFirst()) {
                val book = Book(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4)
                )
                db.close()
                return book
            } else {
                db.close()
                throw IllegalArgumentException("Book with id $bookId not found")
            }
        }
    }

        fun updateBook(book: Book){
            val values = ContentValues()
            values.put(TITLE_COL, book.title)
            values.put(AUTHOR_COL, book.author)
            values.put(YEAR_COL, book.year)
            values.put(PAGES_COL, book.pages)

            val db = this.writableDatabase
            db.update(BOOKS_TABLE, values, "id = ?", arrayOf("${book.id}"))
            db.close()
        }


    fun deleteBook(id: Int){
        val values = ContentValues()

        val db = this.writableDatabase
        db.delete(BOOKS_TABLE, "id = ?", arrayOf("${id}"))
    }

    companion object{
        private const val DB_NAME = "booksdb"
        private const val DB_VERSION = 1
        private const val BOOKS_TABLE = "books"
        private const val ID_COL = "id"
        private const val TITLE_COL = "title"
        private const val AUTHOR_COL = "author"
        private const val YEAR_COL = "year"
        private const val PAGES_COL = "pages"
    }
}