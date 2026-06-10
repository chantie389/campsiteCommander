package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

// STUDENT NAME: libisi chantell nhluvuko
// STUDENT NUMBER: ST10534598

class MainActivity : AppCompatActivity() {
    private lateinit var gearList: MutableList<GearItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize list with sample data
        gearList = mutableListOf()
        gearList.add(GearItem("Tent", "Shelter", 1, "4-person waterproof"))
        gearList.add(GearItem("Marshmallows", "Food", 3, "For s'mores"))
        gearList.add(GearItem("Flashlight", "Safety", 2, "Check batteries before leaving"))

        // UI Elements
        val tvTotalItems: TextView = findViewById(R.id.tvTotalItems)
        val btnAddGear: Button = findViewById(R.id.btnAddGear)
        val btnViewList: Button = findViewById(R.id.btnViewList)

        // Calculate total quantity using loop
        var totalQuantity = 0
        for (item in gearList) {
            totalQuantity += item.quantity
        }
        tvTotalItems.text = "Total Items: $totalQuantity"

        // Navigate to Add Gear screen
        btnAddGear.setOnClickListener {
            val intent = Intent(this, GearActivity::class.java)
            startActivityForResult(intent, 100)
        }

        // Navigate to View List screen
        btnViewList.setOnClickListener {
            val intent = Intent(this, DetailedListActivity::class.java)
            intent.putParcelableArrayListExtra("GEAR_LIST", ArrayList(gearList))
            startActivity(intent)
        }
    }

    // Receive new item from AddGearActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            val newItem = data?.getParcelableExtra<GearItem>("NEW_GEAR_ITEM")
            newItem?.let {
                gearList.add(it)

                // Update total
                var totalQuantity = 0
                for (item in gearList) {
                    totalQuantity += item.quantity
                }
                val tvTotalItems: TextView = findViewById(R.id.tvTotalItems)
                tvTotalItems.text = "Total Items: $totalQuantity"
            }
        }
    }
}
