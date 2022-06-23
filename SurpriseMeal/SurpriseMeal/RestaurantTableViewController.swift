import UIKit
class RestaurantTableViewController: UITableViewController {
    var restaurantsController = RestaurantsController()
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //Task 1:
        //Return the number of the restaurant array in the controller
        return restaurantsController.restaurantCount
    }
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
    if editingStyle == .delete {
        restaurantsController.remove(at: indexPath.row)
        tableView.deleteRows(at: [indexPath], with: .fade)
    }
}
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "RestaurantCell", for: indexPath)
        //Task 2:
        //Set the textLabel & DetailTextLabel according to the indexPath
        let restaurant = restaurantsController.restaurants[indexPath.row]
        cell.textLabel?.text = restaurant.name
        cell.detailTextLabel?.text = restaurant.type
        return cell
    }
    @IBAction func exit(segue : UIStoryboardSegue){
        //Hints:
        //Check the segue's identifier
        if(segue.identifier == "exitAdd"){
            //Get segue's source and cast it as AddRestaurantViewController
            let source = segue.source as! AddRestaurantViewController
            //Get the new restaurant using source's getRestaurant function (beware of the nil value)
            if let newRestaurant = source.getRestaurant(){
                //Add the restaurant to restaurants controller and reload the table
                restaurantsController.add(restaurant: newRestaurant)
                tableView.reloadData()
            }
        }
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //Show Result for Random
        //Task 3: Segue
        if segue.identifier == "showRandomRestaurant"  {
            //3b: Get the segue's destination & cast it as SurpriseViewController
            let surpriseVC = segue.destination as! SurpriseViewController
                //3c: Make sure the number of restaurant in restaurantsController is > 0
                if restaurantsController.restaurantCount > 0 {
                    //3d: Generate a random number within 0 to restaurant count - 1
                    let randomNumber = Int(arc4random_uniform(UInt32(restaurantsController.restaurantCount - 1)))
                    //3e: Get the restaurant using the random No
                    let restaurant = restaurantsController.restaurant(at: randomNumber)
                    //3f: Pass the restaurant to destination
                    surpriseVC.restaurant = restaurant
                    
                }
            
        }
        //Show Result for Summary, to be completed in Part 6
        if(segue.identifier == "showSummary"){
            let summaryVC = segue.destination as! SummaryViewController
            summaryVC.chineseNo = getRestaurantType(type: "Chinese")
            summaryVC.westernNo = getRestaurantType(type: "Western")
            summaryVC.japaneseNo = getRestaurantType(type: "Japanese")
            summaryVC.fastfoodNo = getRestaurantType(type: "Fast Food")

        }
    }
        func getRestaurantType(type: String) -> Int {
        var count = 0
        for restaurant in restaurantsController.restaurants {
            if restaurant.type == type {
                count = count + 1
            }
        }
        return count
    }
}
