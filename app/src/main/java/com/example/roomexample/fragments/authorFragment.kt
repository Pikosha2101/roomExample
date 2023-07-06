package com.example.roomexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomexample.R
import com.example.roomexample.ViewModel.authorViewModel
import com.example.roomexample.ViewModel.registrViewModel
import com.example.roomexample.databinding.AuthorFragmentBinding
import com.example.roomexample.databinding.RegistrFragmentBinding

class authorFragment : Fragment(R.layout.author_fragment) {
    private var _binding: AuthorFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: authorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[authorViewModel::class.java]
        viewModel.check()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.author_fragment, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        //super.onViewCreated(view, savedInstanceState)
        button2.setOnClickListener(){
            findNavController().navigate(R.id.action_authorFragment_to_registrFragment2)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}