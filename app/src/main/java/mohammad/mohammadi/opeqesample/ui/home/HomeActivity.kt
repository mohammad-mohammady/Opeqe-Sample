package mohammad.mohammadi.opeqesample.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_home.*
import mohammad.mohammadi.opeqesample.R
import mohammad.mohammadi.opeqesample.model.FoodModel
import javax.inject.Inject

class HomeActivity : DaggerActivity,HomeContract.View {

    @Inject
    lateinit var mPresenter: HomeContract.Presenter
    @Inject
    constructor(): super()

    override fun updateRestaurantView(foods: ArrayList<FoodModel>) {
        recyclerViewRestaurant.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewRestaurant.adapter = RestaurantAdapter(foods, this)
    }

    override fun updateFoodView(foods: ArrayList<FoodModel>) {
        recyclerViewFoods.layoutManager = LinearLayoutManager(this)

        recyclerViewFoods.adapter = FoodAdapter(foods, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setup()
    }

    fun setup()
    {
        txtvRefine.setOnClickListener {
            changeFoodOrientation()
        }
    }

    fun changeFoodOrientation()
    {
        if((recyclerViewFoods.layoutManager as LinearLayoutManager).orientation == LinearLayoutManager.HORIZONTAL)
            recyclerViewFoods.layoutManager = LinearLayoutManager(this)
        else
            recyclerViewFoods.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)//LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewFoods.adapter = recyclerViewFoods.adapter
    }

    override fun onResume() {
        super.onResume()
        mPresenter.takeView(this)
        mPresenter.loadRestaurant()
        mPresenter.loadFood()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }
}
