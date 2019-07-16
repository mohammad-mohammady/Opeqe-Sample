package mohammad.mohammadi.opeqesample.ui.home.datasource

import com.mapbox.mapboxsdk.geometry.LatLng
import mohammad.mohammadi.opeqesample.model.FoodModel


interface HomeDataSource
{

    fun loadRestaurnts(reverseGeoCallback: LoadRestaurntsCallback)

    /////////////////////////////////////call backs//////////////////////////////////////
    interface LoadRestaurntsCallback {
        fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>)
        fun onLoadRestaurntsError(code: String)
    }
}