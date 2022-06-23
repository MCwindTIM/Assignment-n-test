import UIKit
class AddRestaurantViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    let resType = ["Fast Food", "Chinese", "Western", "Japanese"]
    var selectedType = "Fast Food"
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var nameTextField: UITextField!
    //Task 1
    //Set the IBOutlet appropriately
    //Connect the dataSource and Connection of picker to this View Controller (Hints: Do it in Storyboard)
    override func viewDidLoad() {
        super.viewDidLoad()
        picker.dataSource = self
        picker.delegate = self 
    }
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        //TASK 2: Return the string to picker for title appropriately
        return resType[row]
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        //TASK 3: Return number of resType array
        return resType.count
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        //TASK 4: assign the selected title to the selectedType variable
        selectedType = resType[row]

    }
    func getRestaurant() -> Restaurant? {
        if let name = nameTextField.text, name.count > 0 {
            let type = selectedType
            //Task 5, create a instance of restaurant and return it
            return Restaurant(name: name, type: type)
        }
        return nil
    }
}
