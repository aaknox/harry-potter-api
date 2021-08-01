export class Wand{

    id: number;
    wood: string;
    feather: string;
    length: number;

    constructor(id: number, wood: string, feather: string, length: number){
        if(id === 0){
            this.wood = wood;
            this.feather = feather;
            this.length = length;
        } else{
            this.id = id;
            this.wood = wood;
            this.feather = feather;
            this.length = length;
        }
    }
}
