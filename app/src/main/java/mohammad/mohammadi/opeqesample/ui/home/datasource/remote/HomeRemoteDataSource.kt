package mohammad.mohammadi.opeqesample.ui.home.datasource.remote

import android.content.res.AssetManager
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.util.logMe


class HomeRemoteDataSource: HomeDataSource {

    override fun loadRestaurnts(
        loadRestaurntsCallback: HomeDataSource.LoadRestaurntsCallback, assetManager: AssetManager) {
        logMe("can't get results, NetWork error!")
        loadRestaurntsCallback.onLoadRestaurntsError("can't get results, NetWork error!")
    }
}