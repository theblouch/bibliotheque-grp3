import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EditeurDto } from '../../dto/editeur-dto';
import { EditeurService } from '../../service/editeur-service';


@Component({
  selector: 'app-editeur',
  imports: [CommonModule, RouterLink, ReactiveFormsModule],
  templateUrl: './editeur.html',
  styleUrl: './editeur.css',
})
export class Editeur implements OnInit {
  protected editeurs$!: Observable<EditeurDto[]>;
  protected editeurForm!: FormGroup;
  protected nomCtrl!: FormControl;
  protected paysCtrl!: FormControl;
  protected editingEditeur!: EditeurDto | null;

  constructor(private editeurService: EditeurService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.editeurs$ = this.editeurService.findAll();

    this.nomCtrl = this.formBuilder.control('', Validators.required);

    this.editeurForm = this.formBuilder.group({
      nom: this.nomCtrl,
      pays: this.paysCtrl
    });
  }

  public trackEditeur(index: number, value: EditeurDto) {
    return value.id;
  }

  public creerOuModifier() {
    if (this.editingEditeur) {
      this.editeurService.save(new EditeurDto(this.editingEditeur.id, this.nomCtrl.value, this.paysCtrl.value));
    }

    else {
      this.editeurService.save(new EditeurDto(0, this.nomCtrl.value, this.paysCtrl.value));
    }

    this.editingEditeur = null;
    this.nomCtrl.setValue("");
    this.paysCtrl.setValue("");
  }

  public editer(editeur: EditeurDto) {
    this.editingEditeur = editeur;
    this.nomCtrl.setValue(editeur.nom);
    this.paysCtrl.setValue(editeur.pays);
  }

  public supprimer(editeur: EditeurDto) {
    this.editeurService.deleteById(editeur.id);
  }

}
