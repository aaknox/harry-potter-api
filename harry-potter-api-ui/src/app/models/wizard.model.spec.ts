import { Wand } from "./wand.model";
import { Wizard } from "./wizard.model";

describe('Wizard', () => {
    it('should create an instance of Wizard model', () => {
        expect(new Wizard(1, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', new Wand(1, 'a', 'a', 1), 'k', false, true, false)).toBeTruthy();
    })
});