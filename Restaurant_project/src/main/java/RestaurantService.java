import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantService(){
        restaurants.add(new Restaurant("Royal Dhaba", "Delhi",LocalTime.parse("10:00:00"), LocalTime.parse("22:00:00")));
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{

        for(Restaurant res: restaurants ){
            if(res.getName().equals(restaurantName)){
                return res;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName)throws restaurantNotFoundException{
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);

        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
