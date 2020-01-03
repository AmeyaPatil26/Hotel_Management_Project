import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error = null;
  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit() {
  }

  loginUser(loginForm: NgForm) {
    console.log(loginForm.value);
    this.error = null;
    this.auth.login(loginForm.value).subscribe(
      response => {
        console.log('error message', response.description);
        this.error = response.description;
        loginForm.reset();
        if (response.statusCode === 200 && response.type === 'Admin') {
          console.log('inside if');
          const user = JSON.stringify(response);
          localStorage.setItem('token', user);
          this.router.navigateByUrl('/vertical-header');
        } else if (response.statusCode === 200 && response.type === 'User') {
          console.log('inside if');
          const user = JSON.stringify(response);
          localStorage.setItem('token', user);
          this.router.navigateByUrl('/vertical-header/user-hotel-list');
        } else if (response.statusCode === 200 && response.type === 'Employee') {
          console.log('inside if');
          const user = JSON.stringify(response);
          localStorage.setItem('token', user);
          this.router.navigateByUrl('/vertical-header/employee-room-list');
        }

      },
      err => {
        console.log(err);
        // this.error = err.error.error.message;
        loginForm.reset();
      }
    );
  }

}
