package com.example.catalogfilms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalogfilms.databinding.Fragment1Binding
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract


class Fragment1 : Fragment() {


    private var _binding:Fragment1Binding? = null
    private val binding get() =_binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  = Fragment1Binding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)}




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


