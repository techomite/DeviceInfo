package com.andromite.deviceinfo


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.device_fragment.view.*



class DeviceFragment : Fragment() {

    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.device_fragment, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //brand, model, os version,sdk, display: resoulution, refresh rate, software density
        mView.tv1.text="${Build.BRAND}"
        mView.tv2.text="${Build.MODEL}"
        mView.tv3.text="${Build.DISPLAY}"
        mView.tv4.text="${Build.FINGERPRINT}"
        mView.tv5.text="${Build.VERSION.SDK_INT}"
        mView.tv6.text="${Build.TIME}"



    }

}
