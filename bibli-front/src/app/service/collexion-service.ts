import { Injectable } from '@angular/core';
import { CollexionDto } from '../dto/collexion.dto';
import { HttpClient } from '@angular/common/http';
import { Observable, startWith, Subject, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CollexionService {
  private apiUrl: string = '/collexion';
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<CollexionDto[]> {
    return this.refresh$.pipe(
      // permet de transformer un flux / manipuler un flux
      // Forcer un premier chargement
      startWith(null),

      // Transformer le "void" que CollexionDto[] en allant chercher les informations
      switchMap(() => {
        return this.http.get<CollexionDto[]>(this.apiUrl);
      })
    );
  }

  public refresh() {
    this.refresh$.next(); // Permet d'envoyer des nouvelles infos
  }

  public findById(id: number): Observable<CollexionDto> {
    return this.http.get<CollexionDto>(`${this.apiUrl}/${id}`);
  }

  public save(collexionDto: CollexionDto): void {
    const payload = collexionDto.toJson();

    if (!collexionDto.id) {
      this.http.post<CollexionDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    } else {
      this.http
        .put<CollexionDto>(`${this.apiUrl}/${collexionDto.id}`, payload)
        .subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}
