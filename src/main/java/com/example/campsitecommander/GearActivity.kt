package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget. Toast
import androidx.core.view.updatePadding
// STUDENT NAME: libisi chantell nhluvuko
// STUDENT NUMBER: ST10534598
class GearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_gear)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = systemBars.top, bottom = systemBars.bottom)
            insets
        }

        // UI Elements
        val etItemName: EditText = findViewById(R.id.etItemName)
        val spCategory: Spinner = findViewById(R.id.spCategory)
        val etQuantity: EditText = findViewById(R.id.etQuantity)
        val etComment: EditText = findViewById(R.id.etComment)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Save button action
        btnSave.setOnClickListener {
            val name = etItemName.text.toString().trim()
            val category = spCategory.selectedItem.toString()
            val quantityStr = etQuantity.text.toString().trim()
            val comment = etComment.text.toString().trim()

            // Validation
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter item name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (quantityStr.isEmpty()) {
                Toast.makeText(this, "Please enter quantity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val quantity = quantityStr.toIntOrNull()
            if (quantity == null || quantity <= 0) {
                Toast.makeText(this, "Quantity must be a positive number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create new item
            val newItem = GearItem(name, category, quantity, comment)

            // Send back to MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("NEW_GEAR_ITEM", newItem)
            setResult(RESULT_OK, resultIntent)

            Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Back button
        btnBack.setOnClickListener {
            finish()
        }
    }
}