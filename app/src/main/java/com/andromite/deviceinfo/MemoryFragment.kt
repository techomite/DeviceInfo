package com.andromite.deviceinfo


import android.app.ActivityManager
import android.content.Context.ACTIVITY_SERVICE
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.memory_fragment.view.*


class MemoryFragment : Fragment() {

    private lateinit var mView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.memory_fragment, container, false)
        return mView
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var mi=ActivityManager.MemoryInfo()
        var activityManager = activity?.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)

        val freeMemory = mi.availMem / 1048576L
        val totalMemory = mi.totalMem / 1048576L
        val usedMemory = totalMemory - freeMemory

        mView.tv1.setText("$totalMemory MB")
        mView.tv2.setText("$usedMemory MB")
        mView.tv3.setText("$freeMemory MB")
    }

}
