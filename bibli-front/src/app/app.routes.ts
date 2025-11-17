import { Routes } from '@angular/router';
import { AuteurPage } from './page/auteur-page/auteur-page';
import { Editeur } from './page/editeur/editeur';
import { Collexion } from './page/collexion/collexion';
import { LivrePage } from './page/livre-page/livre-page';
import { authGuard } from './Copier/auth-guard';
import { LoginPage } from './Copier/login-page';


export const routes: Routes = [
    { path: 'login', component:LoginPage},
    { path: 'livre', component: LivrePage, canActivate: [ authGuard ]},
    { path: 'livre/:id', component: LivrePage, canActivate: [ authGuard ] },
    { path: 'auteur', component: AuteurPage, canActivate: [ authGuard ] },
    { path: 'auteur/:id', component: AuteurPage, canActivate: [ authGuard ] },
    { path: 'editeur', component: Editeur, canActivate: [ authGuard ] },
    { path: 'editeur/:id', component: Editeur, canActivate: [ authGuard ] },
    { path: 'collexion', component: Collexion, canActivate: [ authGuard ] },
    { path: 'collexion/:id', component: Collexion, canActivate: [ authGuard ] }
];
