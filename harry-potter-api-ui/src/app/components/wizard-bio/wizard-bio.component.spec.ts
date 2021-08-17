import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardBioComponent } from './wizard-bio.component';

describe('WizardBioComponent', () => {
  let component: WizardBioComponent;
  let fixture: ComponentFixture<WizardBioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardBioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardBioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
