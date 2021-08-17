import { TestBed } from '@angular/core/testing';
import { Wizard } from '../models/wizard.model';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { WizardService } from './wizard.service';

describe('Wizard Service', () => {
  let service: WizardService;
  let mock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientTestingModule ]
    });
    service = TestBed.inject(WizardService);
    mock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all expected wizards', () => {
    const expectedWizards: Wizard[] = [
      {
        id: 1,
        name: 'Harry Potter',
        species: 'human',
        gender: 'male',
        house: 'Gryffindor',
        dateOfBirth: '31-07-1980',
        yearOfBirth: 1980,
        ancestry: 'half-blood',
        eyeColour: 'green',
        hairColour: 'black',
        wand: { id: 1, wood: 'holly', core: 'phoenix feather', length: 11 },
        patronus: 'stag',
        hogwartsStudent: true,
        hogwartsStaff: false,
        actor: 'Daniel Radcliffe',
        alive: true,
        image: 'http://hp-api.herokuapp.com/images/harry.jpg',
      },
      {
        id: 2,
        name: 'Hermione Granger',
        species: 'human',
        gender: 'female',
        house: 'Gryffindor',
        dateOfBirth: '19-09-1979',
        yearOfBirth: 1979,
        ancestry: 'muggleborn',
        eyeColour: 'brown',
        hairColour: 'brown',
        wand: { id: 2, wood: 'vine', core: 'dragon heartstring', length: 0 },
        patronus: 'otter',
        hogwartsStudent: true,
        hogwartsStaff: false,
        actor: 'Emma Watson',
        alive: true,
        image: 'http://hp-api.herokuapp.com/images/hermione.jpg',
      },
    ];

    service.getAllWizards().subscribe((wizards) => {
      expect(wizards.toString()).toEqual(expectedWizards.toString(), 'expected wizards');
    });
    
    const request = mock.expectOne("https://20.98.180.248/api/characters/view/all");

    expect(request.request.method).toBe("GET");

    request.flush(expectedWizards);
  });

  it('should create a new wizard', () => {
    const expectedNewWizard: Wizard= 
      {
        id: 1,
        name: 'Harry Potter',
        species: 'human',
        gender: 'male',
        house: 'Gryffindor',
        dateOfBirth: '31-07-1980',
        yearOfBirth: 1980,
        ancestry: 'half-blood',
        eyeColour: 'green',
        hairColour: 'black',
        wand: { id: 1, wood: 'holly', core: 'phoenix feather', length: 11 },
        patronus: 'stag',
        hogwartsStudent: true,
        hogwartsStaff: false,
        actor: 'Daniel Radcliffe',
        alive: true,
        image: 'http://hp-api.herokuapp.com/images/harry.jpg'
      };

    service.addWizard(expectedNewWizard).subscribe((wiz) => {
      expect(wiz.id).toEqual(expectedNewWizard.id, 'expected new wizard');
    });

    const request = mock.expectOne("https://20.98.180.248/api/characters/create");

    expect(request.request.method).toBe("POST");

    request.flush(expectedNewWizard);
  });

  //end of test bed
});
