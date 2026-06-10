package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import android.widget.TextView
import android.widget.Button

// STUDENT NAME: libisi chantell nhluvuko
// STUDENT NUMBER: ST10534598

class DetailedListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = systemBars.top, bottom = systemBars.bottom)
            insets
        }

        // Get list from MainActivity
        val gearList = intent.getParcelableArrayListExtra<GearItem>("GEAR_LIST") ?: arrayListOf()

        val tvFullList: TextView = findViewById(R.id.tvFullList)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Build display text
        val displayText = StringBuilder("=== CAMPING GEAR LIST ===\n\n")

        for ((index, item) in gearList.withIndex()) {
            displayText.append("Item ${index + 1}:\n")
            displayText.append("Name: ${item.itemName}\n")
            displayText.append("Category: ${item.category}\n")
            displayText.append("Quantity: ${item.quantity}\n")
            if (item.comment.isNotEmpty()) {
                displayText.append("Notes: ${item.comment}\n")
            }
            displayText.append("------------------------------------\n\n")
        }

        tvFullList.text = displayText.toString()

        // Back button
        btnBack.setOnClickListener {
            finish()
        }
    }
}