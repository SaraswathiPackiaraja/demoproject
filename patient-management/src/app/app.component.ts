import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loginForm: FormGroup;
  registerForm: FormGroup;
  constructor(private readonly fb: FormBuilder) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', Validators.required]
    });
    this.registerForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(5)]]
    });
  }
  submitForm() {
    if (this.loginForm.valid) {
        console.log(this.loginForm.getRawValue());
    } else {
        console.log('There is a problem with the form');
    }
  }
  register()
  {
    
  }
}