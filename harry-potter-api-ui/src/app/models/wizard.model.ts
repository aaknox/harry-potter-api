import { Wand } from './wand.model';

export class Wizard {
  id: number;
  name: string;
  actor: string;
  image: string;
  species: string;
  gender: string;
  house: string;
  dateOfBirth: string;
  yearOfBirth: string;
  ancestry: string;
  eyeColour: string;
  hairColour: string;
  wand: Wand;
  patronus: string;
  alive: boolean;
  hogwartsStaff: boolean;
  hogwartsStudent: boolean;

  constructor(
      id: number,
      name: string,
      actor: string,
      image: string,
      species: string,
      gender: string,
      house: string,
      dateOfBirth: string,
      yearOfBirth: string,
      ancestry: string,
      eyeColour: string,
      hairColour: string,
      wand: Wand,
      patronus: string,
      alive: boolean,
      hogwartsStaff: boolean,
      hogwartsStudent: boolean
      ) {
      if(id === 0){
          this.name = name;
          this.actor = actor;
          this.image = image;
          this.species = species;
          this.gender = gender;
          this.house = house;
          this.dateOfBirth = dateOfBirth;
          this.yearOfBirth = yearOfBirth;
          this.ancestry = ancestry;
          this.eyeColour = eyeColour;
          this.hairColour = hairColour;
          this.wand = wand;
          this.patronus = patronus;
          this.alive = alive;
          this.hogwartsStaff = hogwartsStaff;
          this.hogwartsStudent = hogwartsStudent;
      }else{
          this.id = id;
          this.name = name;
          this.actor = actor;
          this.image = image;
          this.species = species;
          this.gender = gender;
          this.house = house;
          this.dateOfBirth = dateOfBirth;
          this.yearOfBirth = yearOfBirth;
          this.ancestry = ancestry;
          this.eyeColour = eyeColour;
          this.hairColour = hairColour;
          this.wand = wand;
          this.patronus = patronus;
          this.alive = alive;
          this.hogwartsStaff = hogwartsStaff;
          this.hogwartsStudent = hogwartsStudent;
      }
  }
}
