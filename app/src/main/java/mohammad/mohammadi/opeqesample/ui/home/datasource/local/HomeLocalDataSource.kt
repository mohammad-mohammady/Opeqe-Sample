package mohammad.mohammadi.opeqesample.ui.home.datasource.local

import android.app.PendingIntent.getActivity
import android.content.Context
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.util.Statics
import mohammad.mohammadi.opeqesample.util.Statics.jsonFile
import mohammad.mohammadi.opeqesample.util.logMe
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import com.google.gson.Gson
import mohammad.mohammadi.opeqesample.model.FoodModel
import mohammad.mohammadi.opeqesample.util.loadJSONFromAssets
import okio.Okio
import java.nio.charset.Charset


class HomeLocalDataSource: HomeDataSource
{
    val context: Context

    constructor(context: Context){
        this.context = context
    }
    override fun loadRestaurnts(loadRestaurntsCallback: HomeDataSource.LoadRestaurntsCallback) {

        jsonFile =   loadJSONFromAssets(context)
        val gson = Gson()
        val foods = gson.fromJson(jsonFile, Array<FoodModel>::class.java)
        val foodList = ArrayList<FoodModel>()
        foods.toCollection(foodList)

        logMe("get results, found in local! ")
        loadRestaurntsCallback.onLoadRestaurntsSuccess(foodList)
    }



}