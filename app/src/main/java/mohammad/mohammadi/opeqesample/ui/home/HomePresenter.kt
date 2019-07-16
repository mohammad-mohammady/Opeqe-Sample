package mohammad.mohammadi.opeqesample.ui.home

import android.app.Activity
import android.content.Context
import dagger.android.DaggerActivity
import mohammad.mohammadi.opeqesample.model.FoodModel
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeRepository
import mohammad.mohammadi.opeqesample.ui.home.datasource.local.HomeLocalDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.remote.HomeRemoteDataSource
import javax.inject.Inject

class HomePresenter: HomeContract.Presenter {

    lateinit var mHomeView: HomeContract.View
    lateinit var mHomeRepository: HomeDataSource

    @Inject
    constructor() {

    }

    override fun loadRestaurant() {
        mHomeRepository.loadRestaurnts(object: HomeDataSource.LoadRestaurntsCallback {
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                mHomeView.updateRestaurantView(response)
            }

            override fun onLoadRestaurntsError(code: String) {

            }

        })
    }

    override fun loadFood() {
        mHomeRepository.loadRestaurnts(object: HomeDataSource.LoadRestaurntsCallback {
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                mHomeView.updateFoodView(response)
            }

            override fun onLoadRestaurntsError(code: String) {

            }

        })
    }

    override fun takeView(view: HomeContract.View) {
        mHomeView = view
        mHomeRepository = HomeRepository(HomeRemoteDataSource(), HomeLocalDataSource(mHomeView as Activity))
        mHomeRepository.loadRestaurnts(object: HomeDataSource.LoadRestaurntsCallback{
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {

            }

            override fun onLoadRestaurntsError(code: String) {

            }

        })
    }

    override fun dropView() {

    }
}