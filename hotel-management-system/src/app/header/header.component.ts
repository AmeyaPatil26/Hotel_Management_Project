import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { LoginRegister } from '../login-register';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {




  userDetails = JSON.parse(localStorage.getItem('token'));
  constructor(public auth: AuthService, private router: Router, private breakpointObserver: BreakpointObserver) { }

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
