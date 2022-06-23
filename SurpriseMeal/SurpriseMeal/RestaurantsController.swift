//
//  RestaurantsController.swift
//  SurpriseMeal
//
//  Created by stit on 2/12/2021.
//

import Foundation

class RestaurantsController {
    var restaurants : [Restaurant]

    init() {
        self.restaurants = []
    }
    
    var restaurantCount : Int {
        //Task 1:
        //Return the count of the restaurants array

        return restaurants.count
    }

    func restaurant(at index : Int) -> Restaurant {
        //Task 2:
        //Return the restaurant at the given index
        return restaurants[index]
    }

    func add(restaurant : Restaurant) {
        //Task 3:
        //Append the input restaurant instance into the restaurant array
        restaurants.append(restaurant)
    }

    func remove(at index : Int) {
        //Task 4:
        //Remove the restaurant at the given index
        restaurants.remove(at: index)
    }
}
