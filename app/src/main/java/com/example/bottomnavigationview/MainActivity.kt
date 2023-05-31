package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var BottomNavigation :BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigation=findViewById(R.id.bottomNavigationView)
        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()

        setCurrentFragment(firstFragment)
        BottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.m1home -> setCurrentFragment(firstFragment)
                R.id.m1messages -> setCurrentFragment(secondFragment)
                R.id.m1profile -> setCurrentFragment(thirdFragment)
            }
            true
        }
        BottomNavigation.getOrCreateBadge(R.id.m1messages).apply{
            number =10
            isVisible=true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flfragment,fragment)
            commit()
        }
}