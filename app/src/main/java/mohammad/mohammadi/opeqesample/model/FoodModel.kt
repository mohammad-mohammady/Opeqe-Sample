package mohammad.mohammadi.opeqesample.model

data class FoodModel(
    val courseType: CourseType,
    val cuisineType: CuisineType,
    val delivery: Int,
    val description: String,
    val fee: Int,
    val gallery: String,
    val id: String,
    val image: String,
    val ingredients: String,
    val isAcceptingDelivery: Boolean,
    val isAcceptingPickup: Boolean,
    val isAvailable: Boolean,
    val isCatering: Boolean,
    val isFavorite: Boolean,
    val maximumCalorie: Int,
    val mealType: MealType,
    val menuType: MenuType,
    val minimumCalorie: Int,
    val preparation: Int,
    val price: Double,
    val rate: Int,
    val rewards: List<Any>,
    val special: Special,
    val subTitle: String,
    val title: String
)