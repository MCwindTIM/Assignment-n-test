import UIKit
class SummaryViewController: UIViewController {
    var chineseNo = 0
    var westernNo = 0
    var fastfoodNo = 0
    var japaneseNo = 0
    //Set the IBOutlet appropriately
    @IBOutlet weak var fastFoodString: UILabel!
    @IBOutlet weak var jpString: UILabel!
    @IBOutlet weak var westernString: UILabel!
    @IBOutlet weak var chineseString: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        //Show the label appropriately according to Figure 4 (in page 2)
        fastFoodString.text = "fast food shop \(fastfoodNo)"
        jpString.text = "japanese restaurant \(japaneseNo)"
        westernString.text = "western restaurant \(westernNo)"
        chineseString.text = "chinese restaurant \(chineseNo)"

    }
}
