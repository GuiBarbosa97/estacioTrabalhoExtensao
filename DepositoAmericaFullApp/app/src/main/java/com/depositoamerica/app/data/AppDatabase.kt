package com.depositoamerica.app.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.depositoamerica.app.data.dao.ProductDao
import com.depositoamerica.app.data.dao.SaleDao
import com.depositoamerica.app.data.models.Product
import com.depositoamerica.app.data.models.Sale
@Database(entities = [Product::class, Sale::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun saleDao(): SaleDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "deposito_db"
                ).allowMainThreadQueries().build().also { INSTANCE = it }
            }
    }
}