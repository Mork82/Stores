package com.example.codigonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Toast.makeText(this,"Estas en otro Activity",Toast.LENGTH_LONG).show()
    }
}