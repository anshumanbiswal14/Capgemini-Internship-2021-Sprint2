import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login/login.service';

@Injectable({
  providedIn: 'root'
})
export class FinanceOfficerAuthGuard implements CanActivate {

  constructor(private loginService: LoginService,private router:Router) {}
  
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.loginService.isFinanceOfficerLoggedIn()){
        return true;
      }
      else{
        alert('Can not access this page without login.\nLogin First !!!')
        this.router.navigate(['']);
        return false;
      }
  }
  
}

