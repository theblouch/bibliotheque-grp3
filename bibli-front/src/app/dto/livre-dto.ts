import { AuteurDto } from "./auteur-dto";
import { CollexionDto } from "./collexion-dto";
import { EditeurDto } from "./editeur-dto";

export class LivreDto {
    constructor(private _id: number, private _titre: string, private _résumé: string, private _année: number, private _auteur: AuteurDto, private _editeur: EditeurDto, private _collexion: CollexionDto) { }

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

    public get auteur(): AuteurDto {
        return this._auteur;
    }

    public set auteur(value: AuteurDto) {
        this._auteur = value;
    }

    public get editeur(): EditeurDto {
        return this._editeur;
    }

    public set editeur(value: EditeurDto) {
        this._editeur = value;
    }
    public get collexion(): CollexionDto {
        return this._collexion;
    }
    public set collexion(value: CollexionDto) {
        this._collexion = value;
    }

    public toJson(): any {
        return {
            titre: this._titre,
            résumé: this._résumé,
            année: this._année,
            auteur: this._auteur,
            editeur: this._editeur,
            collexion: this._collexion
        };
    }
}
