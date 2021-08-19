import { Wand } from "./wand.model";
import { Wizard } from "./wizard.model";

describe('Wizard Model', () => {
    it('should create an instance of Wizard model', () => {
        expect(new Wizard(
            1, 
            "test user", 
            "greatest actor", 
            "https://google.com", 
            "human", 
            "male", 
            "Ravenclaw", 
            "1975-03-08", 
            1975, 
            "pure-blood", 
            "brown", 
            "black",
            new Wand(1, "oak", "dragon claw", 12),
            "wolf",
            true,
            false,
            true
        )).toBeTruthy();
    })
});