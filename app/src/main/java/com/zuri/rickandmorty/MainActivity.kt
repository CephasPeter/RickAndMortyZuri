package com.zuri.rickandmorty

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var adapter: DataRecycleView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context: Context = this
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetInfoService::class.java)
        val call = service.allRickAndMortyData
        val progressBar:ProgressBar = findViewById(R.id.progressBar)

        call!!.enqueue(object : Callback<com.zuri.rickandmorty.Response?>{
            override fun onResponse(call: Call<com.zuri.rickandmorty.Response?>,response: Response<com.zuri.rickandmorty.Response?>) {
                val res : com.zuri.rickandmorty.Response? = response.body()
                if (res != null) {
                    generateDataList(res.list)
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<com.zuri.rickandmorty.Response?>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun generateDataList(data: List<Model?>?) {
        val recyclerView: RecyclerView = findViewById(R.id.recycle_view)
        adapter = DataRecycleView(this, data)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}