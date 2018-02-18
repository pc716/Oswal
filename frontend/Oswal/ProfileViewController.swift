//
//  ProfileViewController.swift
//  Oswal
//
//  Created by Tommy Lee on 2/17/18.
//  Copyright © 2018 Tommy Lee. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {

    @IBOutlet weak var customView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        //self.viewHeightConstraint.constant = self.view.bounds.height / 2
    }
    
    @IBAction func onShowHideButtonPress(_ sender: UIBarButtonItem) {
        self.customView.isHidden = !self.customView.isHidden
        self.view.layoutIfNeeded()
        print(self.customView.isHidden)
    }
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
