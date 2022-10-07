package com.example.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val persons = mutableListOf<Person>()
    lateinit var personsList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons.add(Person("John", "Bilts", 25, 1))
        persons.add(Person("Alex", "Sailz", 18, 2))
        persons.add(Person("Nick", "Folder", 30, 3))
        persons.add(Person("John", "Wilder", 28, 4))
        persons.add(Person("John", "Owne", 23, 5))
        persons.add(Person("John", "List", 20, 6))

        personsList = findViewById(R.id.recyclerView)
        personsList.layoutManager = LinearLayoutManager(this)
        personsList.adapter = PersonAdapter(persons)

    }
}