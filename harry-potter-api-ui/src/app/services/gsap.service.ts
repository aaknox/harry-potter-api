import { Injectable } from '@angular/core';
import { SlowMo } from 'gsap/all';
import { gsap, Power2, Elastic } from 'gsap/all';

@Injectable({
  providedIn: 'root'
})
export class GsapService {

  constructor() { }

  public fFadeFrom(e, tym, alfa, dlay, my){
    gsap.from(e, { duration: tym, opacity: alfa, ease: Power2, delay: dlay, y: my});
  }

  public fSlideInRight(e, tym, dlay, mxf, mxt){
    gsap.from(e, { duration: tym, ease: Power2.easeInOut, delay: dlay, x: mxf });
    gsap.to(e, { x: mxt});
  }
}
