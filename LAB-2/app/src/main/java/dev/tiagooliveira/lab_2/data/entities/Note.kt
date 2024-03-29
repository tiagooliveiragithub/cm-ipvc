package dev.tiagooliveira.lab_2.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date
import java.util.Locale

@Entity(tableName = "notes")
@Parcelize
class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: String = getCurrentDateTime()
) : Parcelable {
    companion object {
        fun getCurrentDateTime(): String {
            val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = Date()
            return dateFormat.format(date)
        }
    }
}