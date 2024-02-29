package com.example.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout


class MainActivity : AppCompatActivity() {
    private lateinit var rvCrew: RecyclerView
    private val list = ArrayList<Crew>()

    private lateinit var appbar : androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        appbar = findViewById(R.id.toolbar)
        setSupportActionBar(appbar)

        rvCrew = findViewById(R.id.rv_crew)
        rvCrew.setHasFixedSize(true)
        list.addAll(getListCrew())
        showRecyclerList()

        val profile: ImageView = findViewById(R.id.foto_about)
        profile.setOnClickListener{
            val intent = Intent(this, Author::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCrew.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvCrew.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCrew(): ArrayList<Crew> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPower = resources.getStringArray(R.array.data_power)
        val dataWeak = resources.getStringArray(R.array.data_weak)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPhotobg = resources.obtainTypedArray(R.array.data_photobg)
        val listCrew = ArrayList<Crew>()

        val size = minOf(
            dataPower.size,
            dataDescription.size,
            dataWeak.size,
            dataName.size,
            dataPhoto.length(),
            dataPhotobg.length()
        )

        for (i in 0 until size) {
            val crew = Crew(
                dataName[i],
                dataDescription[i],
                dataPower[i],
                dataWeak[i],
                dataPhoto.getResourceId(i, -1),
                dataPhotobg.getResourceId(i, -1)
            )
            listCrew.add(crew)
        }

        dataPhoto.recycle()
        dataPhotobg.recycle()

        return listCrew
    }

    private fun showRecyclerList() {
        rvCrew.layoutManager = LinearLayoutManager(this)
        val listCrewAdapter = ListCrewAdapter(getListCrew())
        rvCrew.adapter = listCrewAdapter
    }
}