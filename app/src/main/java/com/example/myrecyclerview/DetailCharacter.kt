package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailCharacter : AppCompatActivity() {
    companion object {
        const val extraname = "EXTRA_NAME"
        const val extradesc = "EXTRA_DESC"
        const val extrapower = "EXTRA_POWER"
        const val extraweak = "EXTRA_WEAK"
        const val extrapic = "EXTRA_PIC"
        const val extrabg = "EXTRA_BG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(extraname)
        val desc = intent.getStringExtra(extradesc)
        val power = intent.getStringExtra(extrapower)
        val weak = intent.getStringExtra(extraweak)
        val pic = intent.getIntExtra(extrapic, 0)
        val picbg = intent.getIntExtra(extrabg, 0)

        val nametext: TextView = findViewById(R.id.crew_name)
        val desctext: TextView = findViewById(R.id.crew_desc)
        val powertext: TextView = findViewById(R.id.crew_power)
        val weaktext: TextView = findViewById(R.id.crew_weak)
        val crewpic: ImageView = findViewById(R.id.crew_pic)
        val crewbg: ImageView = findViewById(R.id.crew_bg)

        crewpic.setImageResource(pic)
        crewbg.setImageResource(picbg)

        weaktext.text = weak
        powertext.text = power
        nametext.text = name
        desctext.text = desc

        val shareButton = findViewById<Button>(R.id.share_button)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this character: $name - $desc")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
