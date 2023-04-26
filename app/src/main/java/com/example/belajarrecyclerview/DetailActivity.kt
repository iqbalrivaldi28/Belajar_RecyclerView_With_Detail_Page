package com.example.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.belajarrecyclerview.datasource.Hero


class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_HERO = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataHero = intent.getParcelableExtra<Hero>(KEY_HERO)
        findViewById<ImageView>(R.id.img_item_photo).setImageResource(dataHero?.photo!!)
        findViewById<TextView>(R.id.tv_item_name).text = dataHero.name
        findViewById<TextView>(R.id.tv_item_description).text = dataHero.description
    }
}