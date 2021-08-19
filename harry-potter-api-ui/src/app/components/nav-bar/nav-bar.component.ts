import { Component, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  isCollapsed = true;
  
  constructor(public auth: AuthService) { }

  ngOnInit(): void {
    //NOTE TO DEV: No initiation action for this component!
   }

  public closeMenuEvent() {
    console.log('event triggered');
    this.isCollapsed = !this.isCollapsed;
  }
}
