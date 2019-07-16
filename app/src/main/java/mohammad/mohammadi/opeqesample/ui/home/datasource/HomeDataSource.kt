package mohammad.mohammadi.opeqesample.ui.home.datasource

import android.content.res.AssetManager
import mohammad.mohammadi.opeqesample.model.FoodModel


interface HomeDataSource
{

    fun loadRestaurnts(
        reverseGeoCallback: LoadRestaurntsCallback,
        assetManager: AssetManager
    )

    /////////////////////////////////////call backs//////////////////////////////////////
    interface LoadRestaurntsCallback {
        fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>)
        fun onLoadRestaurntsError(code: String)
    }
}