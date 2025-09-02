package com.depositoamerica.app.data.models
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productId: Int,
    val quantidadeVendida: Int,
    val total: Double,
    val timestamp: Long = System.currentTimeMillis()
)