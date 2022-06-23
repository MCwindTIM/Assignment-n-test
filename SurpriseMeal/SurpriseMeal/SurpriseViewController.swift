import UIKit
class SurpriseViewController: UIViewController {

    var restaurant: Restaurant?
    
    @IBOutlet weak var surpriseLabel : UILabel!
    //TASK 1: Define all require IBOutlet
    override func viewDidLoad() {	
        super.viewDidLoad()
    }
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        //TASK 2: Define all require IBOutlet
        
        if restaurant?.name != nil {
            //2b. show "Let's eat \(restaurantName)"
            surpriseLabel.text = "Let's eat \(restaurant!.name)"
        } else {
            //2c. show "No Restaurant
            surpriseLabel.text = "No Restaurant"
        }
    }
}
