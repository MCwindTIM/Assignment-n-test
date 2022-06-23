import UIKit

class ViewController: UIViewController {

    @IBOutlet var answerPegs : [UIButton]!
    @IBOutlet var inputPegs : [UIButton]!
    @IBOutlet var pins : [UIImageView]!
    
    @IBOutlet weak var turnLabel: UILabel!
    @IBOutlet weak var messageLabel: UILabel!
    
    var logic : MastermindLogic = MastermindLogic()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.resetGame()
    }
    
    @IBAction func resetClicked(_ sender: Any) {
        self.resetGame()
        print(logic.answerPegs)
        print(logic.inputPegs)
    }
    
    @IBAction func pegClicked(_ peg: UIButton) {
        
        let tag = peg.tag
        let turn = tag / 10
        let index = tag % 10
        
        guard turn == logic.turn else {
            return
        }
        
        var pegValue = logic.inputPegs[turn][index]
        pegValue += 1
        if pegValue > 5 {
            pegValue = -1
        }
        
        peg.backgroundColor = self.getColor(code: pegValue)
        logic.inputPegs[turn][index] = pegValue
    }
    
    @IBAction func nextClicked(_ sender: Any) {
        if logic.canNextTurn() == true {
            let resultPins = logic.check()
            let win = logic.checkWin(resultPins: resultPins)
            if(win) {
                return self.messageLabel.text = "You Win!"
            }
            for pin in pins {
                let tag = pin.tag
                let turn = tag / 10
                let index = tag % 10
                
                if index < resultPins.count && turn == logic.turn {
                    pin.backgroundColor = getColor(code: resultPins[index])
                }
            }
            logic.nextTurn()
            self.turnLabel.text = "Turn: \(logic.turn + 1)"
            self.messageLabel.text = ""
        } else {
            self.messageLabel.text = "Didn't fill in all the pegs"
        }
    }
    
    func resetGame(){
        self.logic = MastermindLogic()
        for answerPeg in answerPegs {
            let index = answerPeg.tag
            let code = logic.answerPegs[index]
            answerPeg.backgroundColor = self.getColor(code: code)
            answerPeg.layer.cornerRadius = 20
        }
        for peg in inputPegs {
            peg.backgroundColor  = self.getColor(code: -1)
            peg.layer.cornerRadius = 20
        }
        for pin in pins {
            pin.backgroundColor =  self.getColor(code: -1)
            pin.layer.cornerRadius = 8
            pin.clipsToBounds = false
            pin.layer.shadowOpacity = 0.7
            pin.layer.shadowColor = UIColor.darkGray.cgColor
            pin.layer.shadowOffset = CGSize(width: 0, height:1)
            pin.layer.shadowRadius = 1
        }
        self.turnLabel.text = "Turn: \(logic.turn + 1)"
    }
     
    func getColor(code : Int) -> UIColor {
        switch(code){
        case 0:
            return .white
        case 1:
            return .black
        case 2:
            return .blue
        case 3:
            return .yellow
        case 4:
            return .red
        case 5:
            return .green
        default:
            return .lightGray
        }
    }
}

