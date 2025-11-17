import { Routes } from '@angular/router';
import { AuteurPage } from './page/auteur-page/auteur-page';
import { Editeur } from './page/editeur/editeur';
import { Collexion } from './page/collexion/collexion';
import { LivrePage } from './page/livre-page/livre-page';

export const routes: Routes = [
    { path: 'livre', component: LivrePage },
    { path: 'auteur', component: AuteurPage },
    { path: 'editeur', component: Editeur },
    { path: 'collexion', component: Collexion }
];
