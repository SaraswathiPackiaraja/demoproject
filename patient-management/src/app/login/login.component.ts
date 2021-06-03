import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;
  data:any;
  check:any;
 
  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }
  ngOnInit() {
         
  }

  userLogin() {
    this.authService.authenticateUser(this.loginForm.value)
      .subscribe(data => {
        this.check = data;
        console.log("success!", data.success)
      });
    console.log(this.check);
    if (this.check === true) {
      this.router.navigateByUrl('/admin');
    }

  }
    
}

