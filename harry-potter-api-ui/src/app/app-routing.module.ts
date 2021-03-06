import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddWizardComponent } from './components/add-wizard/add-wizard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ViewWizardsComponent } from './components/view-wizards/view-wizards.component';
import { WizardBioComponent } from './components/wizard-bio/wizard-bio.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'characters/create',
    component: AddWizardComponent
  },
  {
    path: 'characters/view',
    component: ViewWizardsComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'characters/view/:wizardId',
    component: WizardBioComponent
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
