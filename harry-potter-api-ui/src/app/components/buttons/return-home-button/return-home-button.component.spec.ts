import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AppRoutingModule } from 'src/app/app-routing.module';

import { ReturnHomeButtonComponent } from './return-home-button.component';

describe('ReturnHomeButtonComponent', () => {
  let component: ReturnHomeButtonComponent;
  let fixture: ComponentFixture<ReturnHomeButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReturnHomeButtonComponent ],
      imports:[ AppRoutingModule ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReturnHomeButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
