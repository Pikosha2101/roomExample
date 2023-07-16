package com.example.roomexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.roomexample.R
import com.example.roomexample.ViewModel.registrViewModel
import com.example.roomexample.databinding.AuthorFragmentBinding
import com.example.roomexample.databinding.RegistrFragmentBinding

class registrFragment : Fragment(R.layout.registr_fragment) {
    private var _binding: RegistrFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: registrViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[registrViewModel::class.java]

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegistrFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}