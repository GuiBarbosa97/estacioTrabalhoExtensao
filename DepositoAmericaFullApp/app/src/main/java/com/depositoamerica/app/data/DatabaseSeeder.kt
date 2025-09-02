package com.depositoamerica.app.data
import android.content.Context
import com.depositoamerica.app.data.models.Product
object DatabaseSeeder {
    fun seed(context: Context) {
        val db = AppDatabase.getInstance(context)
        if (db.productDao().count() == 0) {
            db.productDao().insert(Product(nome = "Lápis HB", preco = 1.50, quantidade = 100))
            db.productDao().insert(Product(nome = "Caneta Azul", preco = 2.50, quantidade = 80))
            db.productDao().insert(Product(nome = "Caderno 96 folhas", preco = 15.00, quantidade = 50))
            db.productDao().insert(Product(nome = "Cola Branca 90g", preco = 5.00, quantidade = 30))
            db.productDao().insert(Product(nome = "Régua 30cm", preco = 3.00, quantidade = 40))
        }
    }
}