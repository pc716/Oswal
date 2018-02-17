//
//  ViewController.swift
//  Oswal
//
//  Created by Tommy Lee on 2/17/18.
//  Copyright © 2018 Tommy Lee. All rights reserved.
//

import UIKit
import JSONEncoder

struct Post: Codable {
    let email: String
    let password: String
}

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
            if(loginSuccessful()) {
                let storyBoard : UIStoryboard = UIStoryboard(name: "Main", bundle:nil)
                let nextViewController = storyBoard.instantiateViewController(withIdentifier: "ProfileViewController") as! ProfileViewController
                
                // Go to next view
                self.present(nextViewController, animated:true, completion:nil)
            } else {
                displayAlert(msg:"you suck")
            }
            
            
        }
    }
    
    func loginSuccessful() {
        let user = Post(email: "cheo2@gmu.edu", password: "123456");
        submitPost(post: user) { (error) in
            if let error = error {
                fatalError(error.localizedDescription);
                return false;
            }
        return true;
    }
    
    // We'll need a completion block that returns an error if we run into any problems
    func submitPost(post: Post, completion:((Error?) -> Void)?) {
        var urlComponents = URLComponents()
        urlComponents.scheme = "http"
        urlComponents.host = "10.194.114.209:8080"
        urlComponents.path = "/login"
        guard let url = urlComponents.url else { fatalError("Could not create URL from components") }
        
        // Specify this request as being a POST method
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        // Make sure that we include headers specifying that our request's HTTP body
        // will be JSON encoded
        var headers = request.allHTTPHeaderFields ?? [:]
        headers["Content-Type"] = "application/json"
        request.allHTTPHeaderFields = headers
        
        // Now let's encode out Post struct into JSON data...
        let encoder = JSONEncoder()
        do {
            let jsonData = try encoder.encode(post)
            // ... and set our request's HTTP body
            request.httpBody = jsonData
            print("jsonData: ", String(data: request.httpBody!, encoding: .utf8) ?? "no body data")
        } catch {
            completion?(error)
        }
        
        // Create and run a URLSession data task with our JSON encoded POST request
        let config = URLSessionConfiguration.default
        let session = URLSession(configuration: config)
        let task = session.dataTask(with: request) { (responseData, response, responseError) in
            guard responseError == nil else {
                completion?(responseError!)
                return
            }
            
            // APIs usually respond with the data you just sent in your POST request
            if let data = responseData, let utf8Representation = String(data: data, encoding: .utf8) {
                print("response: ", utf8Representation)
            } else {
                print("no readable data received in response")
            }
        }
        task.resume()
    }
    
    func displayAlert(msg:String) {
        let errAlert = UIAlertController(title: "Alert", message: msg, preferredStyle: .alert)
        let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler:nil)
        errAlert.addAction(okAction)
        self.present(errAlert, animated: true, completion: nil)
        
    }



}

}
