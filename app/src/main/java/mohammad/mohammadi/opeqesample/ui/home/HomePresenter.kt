package mohammad.mohammadi.opeqesample.ui.home

import android.content.res.AssetManager
import androidx.annotation.Nullable
import mohammad.mohammadi.opeqesample.model.FoodModel
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeRepository
import javax.inject.Inject

class HomePresenter : HomeContract.Presenter {

    var mHomeView: HomeContract.View ? = null
    var mHomeRepository: HomeDataSource

    @Inject
    constructor(homeRepository: HomeRepository) {
        this.mHomeRepository = homeRepository
    }

    override fun loadRestaurant(assetManager: AssetManager) {
        mHomeRepository.loadRestaurnts(object : HomeDataSource.LoadRestaurntsCallback {
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                mHomeView?.updateRestaurantView(response)
            }

            override fun onLoadRestaurntsError(code: String) {

            }

        }, assetManager)
    }

    override fun loadFood(assetManager: AssetManager) {
        mHomeRepository.loadRestaurnts(object : HomeDataSource.LoadRestaurntsCallback {
            override fun onLoadRestaurntsSuccess(response: ArrayList<FoodModel>) {
                mHomeView?.updateFoodView(response)
            }

            override fun onLoadRestaurntsError(code: String) {

            }

        }, assetManager)
    }

    override fun takeView(view: HomeContract.View) {
        mHomeView = view
    }

    override fun dropView() {
        mHomeView = null
    }
}