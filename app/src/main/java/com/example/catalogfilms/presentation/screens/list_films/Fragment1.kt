package com.example.catalogfilms.presentation.screens.list_films

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogfilms.presentation.adapter.CustomAdapter
import com.example.catalogfilms.databinding.Fragment1Binding

import com.example.catalogfilms.data.retrofit.Retrofit


class Fragment1 : Fragment() {


    private var _binding: Fragment1Binding? = null
    private val binding get() =_binding!!

    private lateinit var recyclerView: RecyclerView
    private var adapter = CustomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted { //Нельзя делать на главном потоке, выделяем во второстепенном потоке
            val moviesAPI = Retrofit().getMoviesApiInterface().getMovies().body()!! // так как в разных классах, create не нужен
                adapter.submitList(moviesAPI.results)
            }

        }
//        moviesAPI.enqueue(object: Callback<List<KinopoiskData>>{
//            override
//             fun onResponse(
//                call: Call<List<KinopoiskData>>,
//                response: Response<List<KinopoiskData>>) {
//                response.body()
//                adapter.submitList(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<List<KinopoiskData>>, t: Throwable) {
//
//            }
//        })




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }}



