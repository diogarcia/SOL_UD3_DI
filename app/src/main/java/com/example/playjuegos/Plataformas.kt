package com.example.playjuegos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Plataformas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.plataformas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomAppBar = findViewById(R.id.bottomAppBar) as BottomAppBar
        setSupportActionBar(bottomAppBar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            // TODO evento FAB
        }

        val buttonsGenre = listOf<MaterialButton>(
            findViewById(R.id.gen1),
            findViewById(R.id.gen2),
            findViewById(R.id.gen3),
            findViewById(R.id.gen4),
            findViewById(R.id.gen5),
            findViewById(R.id.gen6),
            findViewById(R.id.gen7),
            findViewById(R.id.gen8),
            findViewById(R.id.gen9),
        )

        buttonsGenre.forEach { btn ->
            btn.setOnClickListener({
                Toast.makeText(this, btn.text, Toast.LENGTH_SHORT).show()
            })
        }

        val chipGroup = findViewById(R.id.chipGroup) as ChipGroup

        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val selectedChipId = checkedIds[0]
                val selectedChip = findViewById(selectedChipId) as Chip
                val chipText = selectedChip.text

                Toast.makeText(this, chipText.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // TODO
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}