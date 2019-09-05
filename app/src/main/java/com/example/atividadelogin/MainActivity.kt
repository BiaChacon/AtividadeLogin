package com.example.atividadelogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS = "arquivo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val logado =  prefs.getBoolean("logado", false)

        if (!logado){
            var i = Intent(this, Main2Activity::class.java)
            startActivity(i)
            finish()
        }

        buttonLogout.setOnClickListener {
            with(prefs.edit()){
                putBoolean("logado", false)
                commit()
            }
            var i = Intent(this, Main2Activity::class.java)
            startActivity(i)
            finish()
        }

    }

}
