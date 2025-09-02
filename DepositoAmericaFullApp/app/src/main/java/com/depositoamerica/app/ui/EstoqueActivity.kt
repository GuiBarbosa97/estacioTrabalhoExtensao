package com.depositoamerica.app.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.depositoamerica.app.R
import com.depositoamerica.app.adapters.ProductAdapter
import com.depositoamerica.app.repositories.ProductRepository
class EstoqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estoque)
        val repo = ProductRepository(this)
        val rv = findViewById<RecyclerView>(R.id.rvProdutos)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = ProductAdapter(repo.list())
    }
}