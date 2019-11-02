package com.andromite.deviceinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //device, battery, memory, features(nfc, bluetooth, wifi, gps, wifi direct),
        val adapter= ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(DeviceFragment(), "Device")
        adapter.addFragment(MemoryFragment(), "Memory")
        adapter.addFragment(BatteryFragment(), "Battery")
        adapter.addFragment(FeaturesFragment(), "Features")
        vpager.adapter=adapter
        tabs.setupWithViewPager(vpager)

    }

    class ViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){

        private val fragmentList: MutableList<Fragment> = ArrayList() // storing fragment in a list
        private val titleList: MutableList<String> = ArrayList()      // storing title in a list


        //need to return the fragment
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        //need to return size of adapter
        override fun getCount(): Int {
            return fragmentList.size
        }


        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }

}
