export class CollexionDto {
  constructor(private _id: number, private _nom: string) {}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  public get nom(): string {
    return this.nom;
  }

  public set nom(value: string) {
    this.nom = value;
  }

  public toJson(): any {
    return {
      nom: this.nom,
    };
  }
}
