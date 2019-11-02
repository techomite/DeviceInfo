package com.andromite.deviceinfo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.battery_fragment.view.*

class BatteryFragment : Fragment() {

    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.battery_fragment, container, false)
        return mView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_BATTERY_CHANGED)
        activity?.registerReceiver(myBroadcastReceiver,filter)
    }

    private val myBroadcastReceiver = object  : BroadcastReceiver(){
        override fun onReceive(p0: Context?, intent: Intent?) {

            //Battery Tecnology
            var technology = intent!!.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)
                mView.tv1.text="$technology"


            //health of battery
            when (intent?.getIntExtra(BatteryManager.EXTRA_HEALTH, 0)) {

                BatteryManager.BATTERY_HEALTH_OVERHEAT -> mView.tv2.text = "Over Heat"
                BatteryManager.BATTERY_HEALTH_GOOD -> mView.tv2.text = "Good"
                BatteryManager.BATTERY_HEALTH_COLD -> mView.tv2.text = "Cold"
                BatteryManager.BATTERY_HEALTH_DEAD -> mView.tv2.text = "Dead"
                BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> mView.tv2.text = "Over Voltage"
                BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> mView.tv2.text = "Failure"
                else ->mView.tv2.text="Unknown"

            }

            //Battery Temperature
            val temperature = intent!!.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0)/10
            mView.tv3.text="${temperature}\u00B0C"

            //Battery Plugged Status
            when (intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)) {
                BatteryManager.BATTERY_PLUGGED_AC -> mView.tv4.text = "AC Adapter"
                BatteryManager.BATTERY_PLUGGED_USB -> mView.tv4.text = "USB Connection"
                BatteryManager.BATTERY_PLUGGED_WIRELESS -> mView.tv4.text = "Wireless Connection"
                else -> mView.tv4.text="No Power Source"
            }

            //battery percentage
            val batterypercentage = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)
            mView.tv5.text= "${batterypercentage.toString()}%"


            //Battery Charging Status
            when (intent?.getIntExtra(BatteryManager.EXTRA_STATUS, 0)) {
                BatteryManager.BATTERY_STATUS_CHARGING -> mView.tv6.text = "Charging"
                BatteryManager.BATTERY_STATUS_DISCHARGING -> mView.tv6.text = "DisCharging"
                BatteryManager.BATTERY_STATUS_FULL -> mView.tv6.text = "Battery Full"
                BatteryManager.BATTERY_STATUS_NOT_CHARGING-> mView.tv6.text = "Not Charging"
                BatteryManager.BATTERY_STATUS_UNKNOWN -> mView.tv6.text = "Unknown"
                else -> mView.tv6.text = "Unknown"
            }
        }
    }


    override fun onDestroy() {
       activity?.unregisterReceiver(myBroadcastReceiver)
        super.onDestroy()
    }

}
