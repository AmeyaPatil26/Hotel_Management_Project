import { Component, OnInit } from '@angular/core';
import { LoginRegister } from '../login-register';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userDetails = JSON.parse(localStorage.getItem('token'));
  constructor(public auth: AuthService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  isAdmin() {
    const user: LoginRegister = JSON.parse(localStorage.getItem('token'));
    if (user && user.type === 'Admin') {
      return true;
    } else {
      return false;
    }
  }


  isUser() {
    const user: LoginRegister = JSON.parse(localStorage.getItem('token'));
    if (user && user.type === 'User') {
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn(): boolean {
    const user: LoginRegister = JSON.parse(localStorage.getItem('token'));
    if (user && user.statusCode === 200) {
      return true;
    } else {
      return false;
    }
  }


}
