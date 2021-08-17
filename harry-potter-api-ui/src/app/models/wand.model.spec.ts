import { Wand } from "./wand.model";

describe('Wand Model', () => {
    it('should create an instance of Wand model', () => {
        expect(new Wand(1, 'a', 'a', 1)).toBeTruthy();
    })
});