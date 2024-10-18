package com.example.playjuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "PlayJuegos"


        val jugadorBtn = findViewById(R.id.button2) as Button
        jugadorBtn.setOnClickListener{ lanzarNuevoJugador() }

        val preferenciasBtn = findViewById(R.id.button3) as Button
        preferenciasBtn.setOnClickListener{ lanzarPreferencias() }

        val playBtn = findViewById(R.id.button1) as Button
        playBtn.setOnClickListener{ lanzarGames() }

    }
    fun lanzarGames(){
        val i = Intent(this, Games::class.java)
        startActivity(i)
    }

    fun lanzarNuevoJugador(){
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i)
    }

    fun lanzarPreferencias(){
        val i = Intent(this, Preferences::class.java)
        startActivity(i)
    }

    fun lanzarBusqueda(){
        val i = Intent(this, Plataformas::class.java)
        startActivity(i)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.action_search){
            lanzarBusqueda()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}