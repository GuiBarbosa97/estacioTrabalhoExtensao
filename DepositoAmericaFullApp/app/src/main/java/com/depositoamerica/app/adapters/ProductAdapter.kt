package com.depositoamerica.app.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.depositoamerica.app.R
import com.depositoamerica.app.data.models.Product
class ProductAdapter(private val items: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.VH>() {
    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val nome: TextView = v.findViewById(R.id.txtNome)
        val preco: TextView = v.findViewById(R.id.txtPreco)
        val qtd: TextView = v.findViewById(R.id.txtQtd)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return VH(v)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = items[position]
        holder.nome.text = p.nome
        holder.preco.text = "R$ %.2f".format(p.preco)
        holder.qtd.text = "Estoque: ${p.quantidade}"
    }
    override fun getItemCount(): Int = items.size
}