package mohammad.mohammadi.opeqesample.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_restaurant.view.*
import mohammad.mohammadi.opeqesample.R
import mohammad.mohammadi.opeqesample.model.FoodModel


class RestaurantAdapter : RecyclerView.Adapter<RestaurantViewHolder> {

    val items: ArrayList<FoodModel>?
    val context: Context

    constructor(items: ArrayList<FoodModel>?, activity: Context) : super() {
        this.items = items
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(context as Context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        Picasso.get()
            .load(items?.get(position)?.image)
            .into(holder.imageViewFood)

        holder.textViewTitle.text = items?.get(position)?.title
        holder.textViewCourseType.text = items?.get(position)?.courseType?.title
        holder.ratingBar.rating = items?.get(position)?.rate!!.toFloat()
        holder.textViewRate.text = items?.get(position)?.rate.toString()
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

}

class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewTitle = view.textViewTitleRestaurntItem
    val imageViewFood = view.imageViewFoodRestaurntItem
    val textViewCourseType = view.textViewCourseTypeRestaurntItem
    val ratingBar = view.ratingBarRestaurantItem
    val textViewRate = view.textViewRateRestaurantItem
}
