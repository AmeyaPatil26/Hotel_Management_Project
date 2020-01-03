import { Injectable, RootRenderer } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate {



    constructor(private auth: AuthService) { }
    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRole;
        const userDetails = JSON.parse(localStorage.getItem('token'));
        let expectedRole;
        for (const index in expectedRoleArray) {
            if (userDetails && userDetails.type === expectedRoleArray[index]) {
                expectedRole = expectedRoleArray[index];
            }
        }
        if (userDetails && userDetails.type === expectedRole) {
            console.log('user loggedIn');
            return true;
        } else {
            console.log(expectedRole);
            console.log(userDetails.type);
            console.log('user not loggedin');
            return false;
        }
    }

}
