package com.pinaluri.TNote.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pinaluri.TNote.NoteApp.Companion.ctx
import com.pinaluri.TNote.local.entities.Note

@Database(entities = [Note::class], version = 2)
@TypeConverters(Converter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO

    companion object {
        private var instance: NoteDatabase? = null
        private val context = ctx

        @Synchronized
        fun getInstance(): NoteDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java,
                "note_database")
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!
        }
    }
}