import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { tap, catchError } from 'rxjs/operators';
import { Wizard } from '../models/wizard.model';

@Injectable({
  providedIn: 'root',
})
export class WizardService {
  //fields
  httpOptions = {
    headers: new HttpHeaders({})
  }

  //constructor
  constructor(private http: HttpClient) { }

  //methods
  addWizard(wizard: Wizard): Observable<any> {
    console.log(`${this.addWizard.name} - Wizard being added: ${wizard.wand.wood}.`);
    return this.http.post<any>(`${environment.APP_URL}characters/create`, wizard, this.httpOptions)
      .pipe(
        tap((newWizard: Wizard) => console.log(`Wizard created successfully.`)),
        catchError(this.handleError<any>('addWizard'))
      );
  }

  getAllWizards(): Observable<Wizard[]> { 
    return this.http.get<Wizard[]>(`${environment.APP_URL}characters/view/all`,this.httpOptions)  
  }

  //error handling methods
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error)
      return of(result as T);
    }
  }
}
