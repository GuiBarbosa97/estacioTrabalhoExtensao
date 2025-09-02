package com.depositoamerica.app.ui
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.depositoamerica.app.R
import com.depositoamerica.app.repositories.ProductRepository
import com.depositoamerica.app.repositories.SaleRepository
class VendasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendas)
        val productRepo = ProductRepository(this)
        val saleRepo = SaleRepository(this)
        val produtos = productRepo.list().toMutableList()
        val spinner = findViewById<Spinner>(R.id.spinnerProdutos)
        val edtQtd = findViewById<EditText>(R.id.edtQtd)
        val btnVender = findViewById<Button>(R.id.btnVender)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            produtos.map { "${it.nome} (R$ %.2f)".format(it.preco) }
        )
        btnVender.setOnClickListener {
            val idx = spinner.selectedItemPosition
            val p = produtos[idx]
            val qtd = edtQtd.text.toString().toIntOrNull() ?: 0
            val sale = saleRepo.makeSale(p.id, qtd)
            if (sale != null) {
                txtResultado.text = "Venda: ${qtd}x ${p.nome} = R$ %.2f".format(sale.total)
                produtos[idx] = produtos[idx].copy(quantidade = produtos[idx].quantidade - qtd)
            } else {
                Toast.makeText(this, "Quantidade inválida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}