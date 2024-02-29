package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Author : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}