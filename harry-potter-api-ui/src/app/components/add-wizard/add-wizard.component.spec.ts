import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from 'src/app/app-routing.module';

import { AddWizardComponent } from './add-wizard.component';

describe('AddWizardComponent', () => {
  let component: AddWizardComponent;
  let fixture: ComponentFixture<AddWizardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddWizardComponent ],
      imports: [
        FormsModule,
        ReactiveFormsModule,
        NgbModule,
        AppRoutingModule,
        HttpClientModule
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddWizardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
