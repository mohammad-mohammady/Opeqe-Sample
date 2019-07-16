package mohammad.mohammadi.opeqesample.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.item_restaurant.view.*
import mohammad.mohammadi.opeqesample.R
import mohammad.mohammadi.opeqesample.model.FoodModel


class FoodAdapter : RecyclerView.Adapter<FoodViewHolder> {

    val items: ArrayList<FoodModel>?
    val context: Context

    constructor(items: ArrayList<FoodModel>?, activity: Context) : super() {
        this.items = items
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(context as Context).inflate(R.layout.item_food, parent, false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Picasso.get()
            .load(items?.get(position)?.image)
            .into(holder.imageViewFood)

        holder.textViewTitle.text = items?.get(position)?.title
        holder.textViewCourseType.text = items?.get(position)?.courseType?.title + ", " + items?.get(position)?.cuisineType?.title
        holder.ratingBar.rating = items?.get(position)?.rate!!.toFloat()
        holder.textViewRate.text = "${items?.get(position)?.rate} ratings"
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

}

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewTitle = view.textViewTitleFoodItem
    val imageViewFood = view.imageViewFoodItem
    val textViewCourseType = view.textViewTypeFoodItem
    val ratingBar = view.ratingBarFoodItem
    val textViewRate = view.textViewRateFoodItem
}
