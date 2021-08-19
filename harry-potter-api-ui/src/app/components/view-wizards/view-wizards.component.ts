import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Observable } from 'rxjs';
import { Wizard } from 'src/app/models/wizard.model';
import { WizardService } from 'src/app/services/wizard.service';

@Component({
  selector: 'app-view-wizards',
  templateUrl: './view-wizards.component.html',
  styleUrls: ['./view-wizards.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ViewWizardsComponent implements OnInit {

  wizards: Wizard[];
  newWizards: Wizard[];
  public wizard: Observable<Wizard>;

  activeId: number;

  constructor(private changeDetect: ChangeDetectorRef, private service: WizardService) { }

  ngOnInit(): void {
    this.getAllWizards();
  }

  public trackItem(index: number, item: Wizard ) {
    return `${item.id}-${index}`;
  }

  public getAllWizards(): void {
    this.service.getAllWizards()
    .subscribe(
      data => {
        console.log(data);
        this.wizards = data;
        this.changeDetect.detectChanges();
        console.log(this.wizards);
      }
    );
    this.wizards = this.newWizards;
      // change to appropriate title
    const title = document.getElementById('wizards-list');
    title.innerHTML = '';
    title.innerHTML = 'View All Wizards';
    }

}
