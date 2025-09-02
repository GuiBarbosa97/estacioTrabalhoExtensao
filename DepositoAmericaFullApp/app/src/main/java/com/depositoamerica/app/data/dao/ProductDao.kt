package com.depositoamerica.app.data.dao
import androidx.room.*
import com.depositoamerica.app.data.models.Product
@Dao
interface ProductDao {
    @Query("SELECT * FROM products ORDER BY nome")
    fun getAll(): List<Product>
    @Query("SELECT COUNT(*) FROM products")
    fun count(): Int
    @Query("SELECT * FROM products WHERE id = :id LIMIT 1")
    fun getById(id: Int): Product?
    @Insert fun insert(product: Product)
    @Update fun update(product: Product)
    @Delete fun delete(product: Product)
}