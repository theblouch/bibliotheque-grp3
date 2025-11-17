import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LivreDto } from '../../dto/livre-dto';
import { RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
import { LivreService } from '../../service/livre-service';

@Component({
  selector: 'app-livre-page',
  imports: [CommonModule, RouterLink, ReactiveFormsModule],
  templateUrl: './livre-page.html',
  styleUrl: './livre-page.css',
})
export class LivrePage implements OnInit {
  protected livres$!: Observable<LivreDto[]>;
  protected livreForm!: FormGroup;

  protected idCtrl!: FormControl;
  protected titreCtrl!: FormControl;
  protected résuméCtrl!: FormControl;
  protected collexionCtrl!: FormControl;
  protected annéeCtrl!: FormControl;
  protected auteurCtrl!: FormControl;
  protected editeurCtrl!: FormControl;


  protected editingLivre!: LivreDto | null;

  constructor(private livreService: LivreService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.livres$ = this.livreService.findAll();

    this.idCtrl = this.formBuilder.control('', Validators.required);
    this.résuméCtrl = this.formBuilder.control('', Validators.required);
    this.collexionCtrl = this.formBuilder.control('', Validators.required);
    this.annéeCtrl = this.formBuilder.control('', Validators.required);
    this.auteurCtrl = this.formBuilder.control('', Validators.required);
    this.editeurCtrl = this.formBuilder.control('', Validators.required);

    this.livreForm = this.formBuilder.group({
      id: this.idCtrl,
      titre: this.titreCtrl,
      résumé: this.résuméCtrl,
      collexion: this.collexionCtrl,
      année: this.annéeCtrl,
      auteur: this.auteurCtrl,
      editeur: this.editeurCtrl,
    });
  }

  public trackLivre(index: number, value: LivreDto) {
    return value.id;
  }

  public creerOuModifier() {
    if (this.editingLivre) {
      this.livreService.save(new LivreDto(this.editingLivre.id, this.editingLivre.titre, this.editingLivre.résumé, this.editingLivre.année, this.editingLivre.auteur, this.editingLivre.editeur, this.editingLivre.collexion));
    }
    else {
      this.livreService.save(new LivreDto(0, this.titreCtrl.value, this.résuméCtrl.value, this.annéeCtrl.value, this.auteurCtrl.value, this.editeurCtrl.value, this.collexionCtrl.value));
    }

    this.editingLivre = null;
    this.titreCtrl.setValue("");
    this.résuméCtrl.setValue("");
    this.annéeCtrl.setValue("");
    this.auteurCtrl.setValue("");
    this.editeurCtrl.setValue("");
    this.collexionCtrl.setValue("");
  }

  public editer(livre: LivreDto) {
    this.editingLivre = livre;
    this.titreCtrl.setValue(livre.titre);
    this.résuméCtrl.setValue(livre.résumé);
    this.annéeCtrl.setValue(livre.année);
    this.auteurCtrl.setValue(livre.auteur);
    this.editeurCtrl.setValue(livre.editeur);
    this.collexionCtrl.setValue(livre.collexion);

  }

  public supprimer(livre: LivreDto) {
    this.livreService.deleteById(livre.id);
  }
}
