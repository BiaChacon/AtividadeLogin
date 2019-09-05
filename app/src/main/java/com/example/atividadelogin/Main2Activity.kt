package com.example.atividadelogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonLogin.setOnClickListener {

            if(login.text.toString() == "login" && senha.text.toString() == "senha"){
                var prefs = getSharedPreferences("arquivo", Context.MODE_PRIVATE)
                if(checkBox.isChecked){
                    with(prefs.edit()) {
                        putBoolean("logado", true)
                        commit()
                    }
                }
                var i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }else{
                Toast.makeText(this, getString(R.string.login_falha), Toast.LENGTH_SHORT).show()
            }

        }

    }

}
