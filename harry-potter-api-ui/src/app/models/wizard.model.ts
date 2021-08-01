import { Wand } from './wand.model';

export class Wizard {
  id: number;
  name: string;
  actor: string;
  imageURL: string;
  species: string;
  gender: string;
  house: string;
  dateOfBirth: string;
  yearOfBirth: string;
  ancestry: string;
  eyeColor: string;
  hairColor: string;
  wands: Wand;
  patronusForm: string;
  alive: boolean;
  hogwartStaff: boolean;
  hogwartStudent: boolean;

  constructor(
      id: number,
      name: string,
      actor: string,
      imageURL: string,
      species: string,
      gender: string,
      house: string,
      dateOfBirth: string,
      yearOfBirth: string,
      ancestry: string,
      eyeColor: string,
      hairColor: string,
      wands: Wand,
      patronusForm: string,
      alive: boolean,
      hogwartStaff: boolean,
      hogwartStudent: boolean
      ) {
      if(id === 0){
          this.name = name;
          this.actor = actor;
          this.imageURL = imageURL;
          this.species = species;
          this.gender = gender;
          this.house = house;
          this.dateOfBirth = dateOfBirth;
          this.yearOfBirth = yearOfBirth;
          this.ancestry = ancestry;
          this.eyeColor = eyeColor;
          this.hairColor = hairColor;
          this.wands = wands;
          this.patronusForm = patronusForm;
          this.alive = alive;
          this.hogwartStaff = hogwartStaff;
          this.hogwartStudent = hogwartStudent;
      }else{
          this.id = id;
          this.name = name;
          this.actor = actor;
          this.imageURL = imageURL;
          this.species = species;
          this.gender = gender;
          this.house = house;
          this.dateOfBirth = dateOfBirth;
          this.yearOfBirth = yearOfBirth;
          this.ancestry = ancestry;
          this.eyeColor = eyeColor;
          this.hairColor = hairColor;
          this.wands = wands;
          this.patronusForm = patronusForm;
          this.alive = alive;
          this.hogwartStaff = hogwartStaff;
          this.hogwartStudent = hogwartStudent;
      }
  }
}
