import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Wizard } from 'src/app/models/wizard.model';
import { WizardService } from 'src/app/services/wizard.service';

@Component({
  selector: 'app-wizard-bio',
  templateUrl: './wizard-bio.component.html',
  styleUrls: ['./wizard-bio.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class WizardBioComponent implements OnInit {

  wizards: Wizard[];
  newWizards: Wizard[];
  wizard: Wizard;
  newWizard: Wizard;
  public wizardO: Observable<Wizard>;

  activeId: number;
  imageURL: string;

  constructor(private route : ActivatedRoute, private service: WizardService, private router: Router, private changeDetect: ChangeDetectorRef) { }

  ngOnInit(): void {
    const wizardId = +this.route.snapshot.paramMap.get('wizardId')!.valueOf();
    this.getSelectedWizardBio(wizardId);
  }

  public trackItem(index: number, item: Wizard ) {
    return `${item.id}-${index}`;
  }

  get Wiz(){
    this.imageURL = this.wizard.image;
    return Object.keys(this.wizard);
  }

  public getSelectedWizardBio(wizardId: number): void{
    this.service.getWizardByWizardId(wizardId)
    .subscribe(
      data => {
        console.log(data);
        this.wizard= data;
        this.changeDetect.detectChanges();
        console.log(this.wizard);
      }
    );
    //reset wizard array for next API call
    this.wizard = this.newWizard;
  }
}
