package dev.tiagooliveira.lab1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.tiagooliveira.lab1.databinding.ActivityAt1Binding

class AT1 : AppCompatActivity() {

    private lateinit var binding : ActivityAt1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAt1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGo.setOnClickListener {
            startActivity(Intent(this, AT2::class.java))
        }
    }
}