import { Component, OnInit } from '@angular/core';
import { CollexionDto } from '../../dto/collexion-dto';
import { Observable } from 'rxjs';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CollexionService } from '../../service/collexion-service';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-collexion',
  imports: [CommonModule, RouterLink, ReactiveFormsModule],
  templateUrl: './collexion.html',
  styleUrl: './collexion.css',
})
export class Collexion implements OnInit {
  protected collexions$!: Observable<CollexionDto[]>;
  protected collexionForm!: FormGroup;
  protected nomCtrl!: FormControl;
  protected editingCollexion!: CollexionDto | null;

  constructor(private collexionService: CollexionService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.collexions$ = this.collexionService.findAll();

    this.nomCtrl = this.formBuilder.control('', Validators.required);

    this.collexionForm = this.formBuilder.group({
      nom: this.nomCtrl,
    });
  }

  public trackCollexion(index: number, value: CollexionDto) {
    return value.id;
  }

  public creerOuModifier() {
    if (this.editingCollexion) {
      this.collexionService.save(new CollexionDto(this.editingCollexion.id, this.nomCtrl.value));
    } else {
      this.collexionService.save(new CollexionDto(0, this.nomCtrl.value));
    }

    this.editingCollexion = null;
    this.nomCtrl.setValue('');
  }

  public editer(collexion: CollexionDto) {
    this.editingCollexion = collexion;
    this.nomCtrl.setValue(collexion.nom);
  }

  public supprimer(collexion: CollexionDto) {
    this.collexionService.deleteById(collexion.id);
  }
}
