import { Component, OnInit } from '@angular/core';
import { GsapService } from 'src/app/services/gsap.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  isCollapsed = true;
  
  constructor() { }

  ngOnInit(): void { }

  public closeMenuEvent() {
    console.log('event triggered');
    this.isCollapsed = !this.isCollapsed;
  }
}
