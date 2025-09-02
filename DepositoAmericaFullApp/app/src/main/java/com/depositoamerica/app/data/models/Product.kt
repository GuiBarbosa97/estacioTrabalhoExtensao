package com.depositoamerica.app.data.models
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val preco: Double,
    var quantidade: Int
)