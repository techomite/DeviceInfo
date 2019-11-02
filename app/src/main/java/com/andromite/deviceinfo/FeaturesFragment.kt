package com.andromite.deviceinfo


import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.nfc.NfcAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.features_fragment.view.*



class FeaturesFragment : Fragment() {

    private lateinit var mView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView =inflater.inflate(R.layout.features_fragment, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Bluetooth, gps, nfc, wifi, usb accessory

        //NFC
        var nfcAdapter= NfcAdapter.getDefaultAdapter(activity)
        if(nfcAdapter!==null)mView.tv1.text="Yes"
        else mView.tv1.text="No"

        //Bluetooth
        var bluetooth= BluetoothAdapter.getDefaultAdapter()
        if(bluetooth!==null)mView.tv2.text="Yes"
        else mView.tv2.text="No"

        //wifi
       if(Context.WIFI_SERVICE!==null)
           mView.tv3.text="Yes"
        else mView.tv3.text="No"

        //USB Accessory
        if(Context.USB_SERVICE!==null)
            mView.tv4.text="Yes"
        else mView.tv4.text="No"

        //gps
        if(Context.LOCATION_SERVICE!==null)
            mView.tv5.text="Yes"
        else mView.tv5.text="No"

        //FingerPrint
        if(Context.FINGERPRINT_SERVICE!==null)
            mView.tv6.text="Yes"
        else mView.tv6.text="No"
    }

}
