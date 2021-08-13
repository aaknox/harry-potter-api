import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-return-home-button',
  templateUrl: './return-home-button.component.html',
  styleUrls: ['./return-home-button.component.css'],
})
export class ReturnHomeButtonComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  returnHome() {
    console.log('return home button clicked!');
    this.router.navigateByUrl('/home').then(() => {
      console.log('now reloading page...');
      window.location.reload();
    });
  }
}
