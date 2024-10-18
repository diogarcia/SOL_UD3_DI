package com.example.playjuegos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.games)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "PlayJuegos"

        val fabBtn = findViewById(R.id.fabGames) as FloatingActionButton

        val ch1 = findViewById(R.id.ch1) as CheckBox
        val ch2 = findViewById(R.id.ch2) as CheckBox
        val ch3 = findViewById(R.id.ch3) as CheckBox
        val ch4 = findViewById(R.id.ch4) as CheckBox
        val ch5 = findViewById(R.id.ch5) as CheckBox
        val ch6 = findViewById(R.id.ch6) as CheckBox
        val ch7 = findViewById(R.id.ch7) as CheckBox
        val ch8 = findViewById(R.id.ch8) as CheckBox

        val checkButtons = mutableListOf(ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8);

        fabBtn.setOnClickListener({
            evaluateCheckboxesSelected(checkButtons)
        })

    }

    fun evaluateCheckboxesSelected(checkButtons:List<CheckBox>){
        val selectedCheckTexts = StringBuilder()

        var nChecks = 0

        for(checkBox in checkButtons){
            if(checkBox.isChecked){
                nChecks++
                if(selectedCheckTexts.isNotEmpty()){
                    selectedCheckTexts.append(", ")
                }
                selectedCheckTexts.append(checkBox.text.toString())
            }
        }

        if(nChecks == 0){
            Toast.makeText(getApplicationContext(), "No has elegido ninguna opción", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(getApplicationContext(), "Has elegido: "+selectedCheckTexts.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.action_search){
            Toast.makeText(this, "Búsqueda", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}