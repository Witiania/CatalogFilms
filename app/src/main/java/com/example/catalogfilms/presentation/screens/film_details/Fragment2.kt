package com.example.catalogfilms.presentation.screens.film_details

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogfilms.data.models.Result
import com.example.catalogfilms.data.models.ResultX
import com.example.catalogfilms.data.retrofit.Retrofit
import com.example.catalogfilms.presentation.adapter.CustomAdapter
import com.example.catalogfilms.databinding.Fragment1Binding
import com.example.catalogfilms.databinding.Fragment2Binding
import com.squareup.picasso.Picasso

class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null
    private val binding get() =_binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    lateinit var currentMovie: Result


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2Binding.inflate(inflater,container,false)
        currentMovie = arguments?.getSerializable("movie") as Result
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        lifecycleScope.launchWhenStarted { //Нельзя делать на главном потоке, выделяем во второстепенном потоке
            val trailersApi = Retrofit().getMoviesApiInterface().getTrailers(currentMovie.id)
                .body()!! // так как в разных классах, create не нужен
                binding.detailsVideo.setVideoPath("https://www.youtube.com/watch?v=" + trailersApi.results[0].key)

                  }

    }



    fun init(){
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2${currentMovie.backdrop_path}").into(binding.detailsImg)
        binding.detailsTvDate.text = currentMovie.release_date
        binding.detailsTvTitle.text = currentMovie.original_title
        binding.detailsTvDescription.text = currentMovie.overview

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}