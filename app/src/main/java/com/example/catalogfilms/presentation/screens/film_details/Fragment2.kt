package com.example.catalogfilms.presentation.screens.film_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogfilms.presentation.adapter.CustomAdapter
import com.example.catalogfilms.databinding.Fragment1Binding
import com.example.catalogfilms.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null
    private val binding get() =_binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}