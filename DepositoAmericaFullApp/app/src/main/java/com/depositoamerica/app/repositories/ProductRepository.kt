package com.depositoamerica.app.repositories
import android.content.Context
import com.depositoamerica.app.data.AppDatabase
import com.depositoamerica.app.data.models.Product
class ProductRepository(context: Context) {
    private val dao = AppDatabase.getInstance(context).productDao()
    fun list(): List<Product> = dao.getAll()
    fun decreaseStock(productId: Int, qtd: Int): Product? {
        val p = dao.getById(productId) ?: return null
        if (qtd <= 0 || qtd > p.quantidade) return null
        val updated = p.copy(quantidade = p.quantidade - qtd)
        dao.update(updated); return updated
    }
}