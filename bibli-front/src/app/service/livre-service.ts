import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LivreDto } from '../dto/livre-dto';
import { Observable, startWith, Subject, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LivreService {
  private apiUrl: string = 'http://localhost:8080/livre';
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) { }

  public findAll(): Observable<LivreDto[]> {
    return this.refresh$.pipe( // permet de transformer un flux / manipuler un flux
      // Forcer un premier chargement
      startWith(null),

      // Transformer le "void" que LivreDto[] en allant chercher les informations
      switchMap(() => {
        return this.http.get<LivreDto[]>(this.apiUrl);
      })
    );
  }

  public refresh() {
    this.refresh$.next(); // Permet d'envoyer des nouvelles infos
  }

  public findById(id: number): Observable<LivreDto> {
    return this.http.get<LivreDto>(`${this.apiUrl}/${id}`);
  }

  public save(livreDto: LivreDto): void {
    const payload = livreDto.toJson();

    if (!livreDto.id) {
      this.http.post<LivreDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    }

    else {
      this.http.put<LivreDto>(`${this.apiUrl}/${livreDto.id}`, payload).subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}


