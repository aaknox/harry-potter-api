import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Wand } from 'src/app/models/wand.model';
import { Wizard } from 'src/app/models/wizard.model';
import { WizardService } from 'src/app/services/wizard.service';

@Component({
  selector: 'app-add-wizard',
  templateUrl: './add-wizard.component.html',
  styleUrls: ['./add-wizard.component.css']
})
export class AddWizardComponent implements OnInit {

  addWizardForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router, private wizardService: WizardService) { }

  ngOnInit(): void {
    this.addWizardForm = this.fb.group({
      name: new FormControl('', Validators.required),
      imageURL: new FormControl('', Validators.required),
      species: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      house: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('', Validators.required),
      yearOfBirth: new FormControl('', Validators.required),
      ancestry: new FormControl('', Validators.required),
      eyeColor: new FormControl('', Validators.required),
      hairColor: new FormControl('', Validators.required),
      //excluding wand for now
      patronus: new FormControl('', Validators.required),
      isAlive: new FormControl('', Validators.required),
      isHogwartStudent: new FormControl('', Validators.required),
      isHogwartStaff: new FormControl('', Validators.required)
    });
  }

  async addWizard(){
    //step 1: get Wizard info from form
    const wizard = this.addWizardForm.value;
    const wand = new Wand(0, "oak", "phoenix", 11);
    console.log(`TEST: Wizard being added - ${wizard.name}`);

    //step 2: send request to backend
    const tempWiz = new Wizard(0, wizard.name, wizard.imageURL, wizard.species, wizard.gender, wizard.house, wizard.dateOfBirth, wizard.yearOfBirth, wizard.ancestry, wizard.eyeColor, wizard.hairColor, wand, wizard.patronus, wizard.isAlive, wizard.isHogwartStuduent, wizard.isHogwartStaff);
    console.log(`TEST: TempWiz being added - ${tempWiz.name}`);
    await this.wizardService.addWizard(tempWiz)
    .subscribe(data => {
      //step 3: process results based on response status code
      console.log(data);
      alert("Success! New Wizard Created.")
    });

    //step 4: redirect user to home page after 5 secs
    setTimeout(()=>{                           
      console.log("Returning to homepage...")
    }, 3000);

    this.router.navigate(['home']);
  }

}
