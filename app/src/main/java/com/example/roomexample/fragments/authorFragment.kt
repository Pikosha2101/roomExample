package com.example.roomexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.roomexample.R
import com.example.roomexample.ViewModel.authorViewModel
import com.example.roomexample.ViewModel.registrViewModel
import com.example.roomexample.databinding.AuthorFragmentBinding
import com.example.roomexample.databinding.RegistrFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



//это фрагмент, тут ты заполняешь контейнер. Логики по минимуму. вся логика в ViewModel
//файлах. Они тут есть, но пустые. ViewModel - обычный класс с написанными тобой функциями.
//фрагменты и вьюмодел создавай в отдельных папках (ПКМ на папку с проектом -> new -> sample data directory)
//фрагменты и вьюмодел: в нужной папке ПКМ -> new -> Kotlin class. создаёшь обычный класс. потом после создания
//определяешь класс как фрагмент/модель(строчка ниже)
class authorFragment : Fragment(R.layout.author_fragment) {

    //это биндинг, прописывается один раз на весь фрагмент. Нужен для того, чтобы
    //сразу обращаться к элементам управления не объявляя их

    //AuthorFragmentBinding создаётся сам(пишешь название класса с большой буквы, потом он сам тебе
    //предложит дописать AuthorFragmentBinding
    private var _binding: AuthorFragmentBinding? = null
    private val binding get() = _binding!!


    //тут просто определяешь ViewModel
    private lateinit var viewModel: authorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //тоже для работы ViewModel
        viewModel = ViewModelProvider(this)[authorViewModel::class.java]
        //вызов функции из ViewModel
        viewModel.check()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //пропиши это для биндинга и забудь
        _binding = AuthorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        //пример биндинга. кнопку не объявлял, но могу к ней обратиться
        //тут перемещение между фрагменами. после r.id. указываешь связь, которую проставляешь в файле navigation(action)
        //там лейауты добавляешь через кнопку контура телефона с зеленым плюсиком
        button3.setOnClickListener(){
            findNavController().navigate(R.id.action_authorFragment_to_registrFragment)
        }
    }


    //нужная фигня. чистит биндинг после смены фрагмента
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}