export class LivreDto {
    constructor(private _id: number, private _titre: string, private _résumé: string, private _année: number, private _auteur: Auteur, private _editeur: Editeur, private _collexion: Collexion) { }

    public get id(): number {
        return this._id;
    }

    public set id(value: number) {
        this._id = value;
    }

    public get titre(): string {
        return this._titre;
    }

    public set titre(value: string) {
        this._titre = value;
    }


    public get résumé(): string {
        return this._résumé;
    }

    public set résumé(value: string) {
        this._résumé = value;
    }

    public get année(): number {
        return this._année;
    }

    public set année(value: number) {
        this._année = value;
    }

    public get auteur(): Auteur {
        return this._auteur;
    }

    public set auteur(value: Auteur) {
        this._auteur = value;
    }

    public get editeur(): Editeur {
        return this._editeur;
    }

    public set editeur(value: Editeur) {
        this._editeur = value;
    }
    public get collexion(): Collexion {
        return this._collexion;
    }
    public set collexion(value: Collexion) {
        this._collexion = value;
    }

    public toJson(): any {
        return {
            libelle: this._titre
        };
    }
}
