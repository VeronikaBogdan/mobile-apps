package com.example.retrofitsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    val apiService = ApiService.create()
    lateinit var tv:TextView
    var posts = listOf<Post>()
    var comments = listOf<Comments>()
    var users = listOf<Users>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById<TextView>(R.id.tv)
        val btnPosts = findViewById<Button>(R.id.btnPosts)
        val btnComments = findViewById<Button>(R.id.btnComments)
        val btnUsers = findViewById<Button>(R.id.btnUsers)
        btnPosts.setOnClickListener {
            getPosts()
        }
        btnComments.setOnClickListener {
            getComments()
        }
        btnUsers.setOnClickListener {
            getUsers()
        }
    }
    fun getPosts() {
        val call = apiService.getPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("!!!",t.toString())
            }
            override fun onResponse(call: Call<List<Post>>,
                                    response: Response<List<Post>>) {
                posts = response.body()!!
                tv.text = posts.toString()
                Log.d("!!!posts",posts.toString())
            }
        })
    }
    fun getComments() {
        val call = apiService.getComments()
        call.enqueue(object: Callback<List<Comments>> {
            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.d("!!!",t.toString())
            }
            override fun onResponse(call: Call<List<Comments>>,
                                    response: Response<List<Comments>>) {
                comments = response.body()!!
                tv.text = comments.toString()
                Log.d("!!!comments",comments.toString())
            }
        })
    }
    fun getUsers() {
        val call = apiService.getUsers()
        call.enqueue(object: Callback<List<Users>> {
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Log.d("!!!",t.toString())
            }
            override fun onResponse(call: Call<List<Users>>,
                                    response: Response<List<Users>>) {
                users = response.body()!!
                tv.text = users.toString()
                Log.d("!!!users",users.toString())
            }
        })
    }
}