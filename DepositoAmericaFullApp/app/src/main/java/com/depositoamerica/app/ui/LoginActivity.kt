package com.depositoamerica.app.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.depositoamerica.app.R
import com.depositoamerica.app.repositories.AuthRepository
class LoginActivity : AppCompatActivity() {
    private val auth = AuthRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val ok = auth.login(edtUser.text.toString(), edtPass.text.toString())
            if (ok) {
                startActivity(Intent(this, MainActivity::class.java)); finish()
            } else {
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}