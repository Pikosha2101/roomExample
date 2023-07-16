package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.roomexample.fragments.authorFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*фрагменты нужны для снижения нагрузки на мобилке.
          должно быть 1-2 activity на всё приложение, остальное - фрагменты.
          в одной книге(приложении) одна обложка(контейнер в активити) и много страниц(фрагментов)
        */




        //для того, чтобы в контейнер помещать фрагменты, необходимо объявить контейнер
        val fragmentContainerView = findViewById<FragmentContainerView>(R.id.mainContainerView)

        //затем объявляется сам фрагмент
        val myFragment = authorFragment()
        //который передаётся в контейнер
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerView.id, myFragment)
            .commit()
    }
}