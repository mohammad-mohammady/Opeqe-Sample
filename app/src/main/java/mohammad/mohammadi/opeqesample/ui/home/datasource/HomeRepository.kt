package mohammad.mohammadi.opeqesample.ui.home.datasource

import mohammad.mohammadi.opeqesample.model.FoodModel


class HomeRepository: HomeDataSource {

    var mHomeRemoteDataSource: HomeDataSource
    var mHomeLocalDataSource: HomeDataSource

    constructor(mHomeRemoteDataSource: HomeDataSource, mHomeLocalDataSource: HomeDataSource) {
        this.mHomeRemoteDataSource = mHomeRemoteDataSource
        this.mHomeLocalDataSource = mHomeLocalDataSource
    }

    override fun loadRestaurnts(roadRestaurntsCallback: HomeDataSource.LoadRestaurntsCallback) {
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

                })
            }
        })
    }
}