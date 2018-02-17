//
//  ViewController.swift
//  Oswal
//
//  Created by Tommy Lee on 2/17/18.
//  Copyright © 2018 Tommy Lee. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var dataLabel: UILabel!
    @IBOutlet weak var email: UITextField!
    @IBOutlet weak var pw: UITextField!
    @IBOutlet weak var button: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated);
        UITextField.appearance().tintColor = .black
        email.borderStyle = UITextBorderStyle.roundedRect
        email.layer.cornerRadius = 5
        pw.borderStyle = UITextBorderStyle.roundedRect
        pw.layer.cornerRadius = 5
        pw.isSecureTextEntry = true
        button.layer.cornerRadius = 5
    }
    
    // Validates Email
    func isValidEmail(testStr:String) -> Bool {
        let emailRegEx = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
        
        let emailTest = NSPredicate(format:"SELF MATCHES %@", emailRegEx)
        return emailTest.evaluate(with: testStr)
    }
    
    @IBAction func loginButtonHandler() {
        let invalidEmail = !isValidEmail(testStr: (email.text)!)
        let invalidPw = pw.text?.isEmpty
        // If empty inputs
        if(invalidEmail || invalidPw!) {
            if(invalidEmail) {
                displayAlert(msg:"Please enter a valid email")
            } else if(invalidPw!) {
                displayAlert(msg:"Please enter a valid password")
            }
        // Successful login
        } else {
            let storyBoard : UIStoryboard = UIStoryboard(name: "Main", bundle:nil)
            let nextViewController = storyBoard.instantiateViewController(withIdentifier: "ProfileViewController") as! ProfileViewController
            
            // Go to next view
            self.present(nextViewController, animated:true, completion:nil)
        }
    }
    
    func displayAlert(msg:String) {
        let errAlert = UIAlertController(title: "Alert", message: msg, preferredStyle: .alert)
        let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler:nil)
        errAlert.addAction(okAction)
        self.present(errAlert, animated: true, completion: nil)
        
    }



}

