import splitstrings from "./../src/splitstrings.js";

describe("splistrings", () => {
    //controllare se la stringa è pari o dispari
    //se è pari dividere la stringa due caratteri alla volta, se dispari fare lo stesso e aggiungere sull'ultimo carattere _
    it("should return ['ab', 'c_'] if string is odd", () => {
        expect(splitstrings('abc')).toEqual(['ab', 'c_']);
    })  

    it("should return ['ab', 'cd', 'ef'] if string is even", () => {
        expect(splitstrings('abcdef')).toEqual(['ab', 'cd', 'ef']);
    })  

})