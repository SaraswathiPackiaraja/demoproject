import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, Validator, ValidatorFn } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: FormGroup;
  passwordMatch: any = true;
  isSubmitted = false;
  data: any;
  error: any;
  check: boolean = true;

  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) {
    this.registerForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
      email: new FormControl('', Validators.required),
      mobileNumber: new FormControl('', Validators.required),
      registrationNumber: new FormControl('', Validators.required),
      address: new FormControl('')
    });
  }

  passwordValidation() {

    let psword = this.registerForm.value.password;
    let conpsword = this.registerForm.value.confirmPassword;
    if (psword !== conpsword) {

      this.passwordMatch = false;
    }
    else {
      this.passwordMatch = true
    }
  }

  userRegister() {
    this.authService.registerNewUser(this.registerForm.value)
      .subscribe(data => {
        this.check = data.success;
        if (this.check === true) {
          this.router.navigateByUrl('/login');
        }
        
      });
  }
}
