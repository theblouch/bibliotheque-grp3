import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EditeurDto } from '../../../dto/matiere-dto';
import { EditeurService } from '../../../service/matiere-service';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-matiere',
  imports: [ CommonModule, RouterLink, ReactiveFormsModule ],
  templateUrl: './matiere.html',
  styleUrl: './matiere.css',
})
export class Editeur implements OnInit {
  protected matieres$!: Observable<EditeurDto[]>;
  protected matiereForm!: FormGroup;
  protected labelCtrl!: FormControl;
  protected editingMatiere!: EditeurDto | null;

  constructor(private matiereService: EditeurService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.editeurs$ = this.editeurService.findAll();

    this.labelCtrl = this.formBuilder.control('', Validators.required);

    this.editeurForm = this.formBuilder.group({
      label: this.labelCtrl
    });
  }

  public trackMatiere(index: number, value: EditeurDto) {
    return value.id;
  }

  public creerOuModifier() {
    if (this.editingEditeur) {
      this.EditeurService.save(new EditeurDto(this.editingEditeur.id, this.labelCtrl.value));
    }

    else {
      this.editeurService.save(new EditeurDto(0, this.labelCtrl.value));
    }

    this.editingMatiere = null;
    this.labelCtrl.setValue("");
  }

  public editer(matiere: EditeurDto) {
    this.editingEditeur = editeur;
    this.labelCtrl.setValue(editeur.libelle);
  }

  public supprimer(editeur: EditeurDto) {
    this.editeurService.deleteById(editeur.id);
  }

}
