package mohammad.mohammadi.opeqesample.ui.home.datasource.local

import android.content.res.AssetManager
import com.google.gson.Gson
import mohammad.mohammadi.opeqesample.model.FoodModel
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.util.logMe


class HomeLocalDataSource : HomeDataSource {

    override fun loadRestaurnts(
        loadRestaurntsCallback: HomeDataSource.LoadRestaurntsCallback,
        assetManager: AssetManager
    ) {

        var json: String? = null

        val inputStream = assetManager.open("menu.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, charset("UTF-8"))

        val gson = Gson()
        val foods = gson.fromJson(json, Array<FoodModel>::class.java)
        val foodList = ArrayList<FoodModel>()
        foods.toCollection(foodList)

        logMe("get results, found in local! ")
        loadRestaurntsCallback.onLoadRestaurntsSuccess(foodList)
    }


}