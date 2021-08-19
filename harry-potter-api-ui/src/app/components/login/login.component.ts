import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService, public router: Router) { }

  ngOnInit(): void {
    //NOTE TO DEV: No initiation action for this component!
  }

  loginWithPopup(): void {
    console.log(`login event triggered.`);
    this.auth.loginWithPopup();
    console.log('login event complete!');
    this.router.navigateByUrl('/home');
  }

  logout(){
    console.log('logout event triggered. Location:' + this.document.location.origin);
    this.auth.logout();
    console.log('event complete');
  }
}
