import { Component, OnInit } from '@angular/core';
import { GsapService } from 'src/app/services/gsap.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _gsapService: GsapService) { }

  ngOnInit(): void {
    this.fOpeningAnim();
  }

  public fOpeningAnim(){
    const anim = this._gsapService;
    const mainContainer = '#opening-container';
    anim.fFadeFrom ( mainContainer, 1, 0, 1, 100);
  }

}
