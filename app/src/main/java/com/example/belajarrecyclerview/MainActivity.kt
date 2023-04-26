package com.example.belajarrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarrecyclerview.adapter.ListHeroAdapter
import com.example.belajarrecyclerview.datasource.Hero

class MainActivity : AppCompatActivity() {

    // ini mmengatur sethasfixed nya
    private lateinit var rvHeroes: RecyclerView

    // Panggil data yg ada di String
    private var list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecyclerList()

    }

    private fun getListHero(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return  listHero
    }


    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }

    // Menu untuk mengatur tampilan layout manager
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }

        return super.onOptionsItemSelected(item)
    }




}