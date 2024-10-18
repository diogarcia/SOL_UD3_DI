package com.example.playjuegos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.preferences)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById(R.id.toolbar) as Toolbar

        val rb = findViewById(R.id.ratingBar) as RatingBar
        val sb = findViewById(R.id.seekBar) as SeekBar
        val radioGr = findViewById(R.id.radioGroup) as RadioGroup
        val fabBtn = findViewById(R.id.fabBtn) as FloatingActionButton

        fabBtn.setOnClickListener({

            val pressedBtn = radioGr.checkedRadioButtonId

            if(pressedBtn == -1){
                Toast.makeText(getApplicationContext(), "Ningún juego seleccionado", Toast.LENGTH_SHORT).show()
            }else{
                val radioChosen = findViewById(pressedBtn) as RadioButton
                Toast.makeText(getApplicationContext(), "Seleccionado: "+radioChosen.text, Toast.LENGTH_SHORT).show()

            }

        })


        setSupportActionBar(toolbar)
        supportActionBar?.title = "PlayJuegos"


        rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ratingBar, rating, fromUser ->
            sb.progress = rating.toInt()
        }

        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rb.rating = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })




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