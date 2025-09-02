package com.depositoamerica.app.data.dao
import androidx.room.*
import com.depositoamerica.app.data.models.Sale
@Dao
interface SaleDao {
    @Query("SELECT * FROM sales ORDER BY timestamp DESC")
    fun getAll(): List<Sale>
    @Insert fun insert(sale: Sale)
}