package com.depositoamerica.app.repositories
import android.content.Context
import com.depositoamerica.app.data.AppDatabase
import com.depositoamerica.app.data.models.Sale
class SaleRepository(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val saleDao = db.saleDao()
    private val productDao = db.productDao()
    fun makeSale(productId: Int, qtd: Int): Sale? {
        val p = productDao.getById(productId) ?: return null
        if (qtd <= 0 || qtd > p.quantidade) return null
        val total = p.preco * qtd
        val sale = Sale(productId = p.id, quantidadeVendida = qtd, total = total)
        saleDao.insert(sale)
        productDao.update(p.copy(quantidade = p.quantidade - qtd))
        return sale
    }
    fun list(): List<Sale> = saleDao.getAll()
}