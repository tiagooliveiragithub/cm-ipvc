package dev.tiagooliveira.lab_2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.tiagooliveira.lab_2.data.dao.NoteDao
import dev.tiagooliveira.lab_2.data.entities.Note

@Database(entities = [Note :: class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){
    abstract  fun  noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}