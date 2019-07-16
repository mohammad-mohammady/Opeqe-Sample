package mohammad.mohammadi.opeqesample.ui.home.datasource

import android.content.res.AssetManager
import mohammad.mohammadi.opeqesample.data.Local
import mohammad.mohammadi.opeqesample.data.Remote
import mohammad.mohammadi.opeqesample.model.FoodModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository: HomeDataSource {

    var mHomeRemoteDataSource: HomeDataSource
    var mHomeLocalDataSource: HomeDataSource

    @Inject
    constructor(@Remote mHomeRemoteDataSource: HomeDataSource, @Local mHomeLocalDataSource: HomeDataSource) {
        this.mHomeRemoteDataSource = mHomeRemoteDataSource
        this.mHomeLocalDataSource = mHomeLocalDataSource
    }

    override fun loadRestaurnts(
        roadRestaurntsCallback: HomeDataSource.LoadRestaurntsCallback,
        assetManager: AssetManager
    ) {
        mHomeLocalDataSource?.loadRestaurnts(object: HomeDataSource.LoadRestaurntsCallback {
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                roadRestaurntsCallback.onLoadRestaurntsSuccess(response)
            }

            override fun onLoadRestaurntsError(code: String) {
                mHomeRemoteDataSource?.loadRestaurnts(object: HomeDataSource.LoadRestaurntsCallback {
                    override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                        roadRestaurntsCallback.onLoadRestaurntsSuccess(response)
                    }

                    override fun onLoadRestaurntsError(code: String) {
                        roadRestaurntsCallback.onLoadRestaurntsError(code)
                    }

                },assetManager)
            }
        },assetManager)
    }
}