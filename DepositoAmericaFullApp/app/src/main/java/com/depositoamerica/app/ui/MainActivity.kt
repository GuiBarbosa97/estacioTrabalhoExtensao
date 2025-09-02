package com.depositoamerica.app.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.depositoamerica.app.R
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnEstoque).setOnClickListener {
            startActivity(Intent(this, EstoqueActivity::class.java))
        }
        findViewById<Button>(R.id.btnVendas).setOnClickListener {
            startActivity(Intent(this, VendasActivity::class.java))
        }
    }
}