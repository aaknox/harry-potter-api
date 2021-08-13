export class Wand{

    id: number;
    wood: string;
    core: string;
    length: number;

    constructor(id: number, wood: string, core: string, length: number){
        if(id === 0){
            this.wood = wood;
            this.core = core;
            this.length = length;
        } else{
            this.id = id;
            this.wood = wood;
            this.core = core;
            this.length = length;
        }
    }
}
