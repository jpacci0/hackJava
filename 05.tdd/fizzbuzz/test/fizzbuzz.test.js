import fizzbuzz from "./../src/fizzbuzz.js";

describe("fizzbuzz", () => {
    //ritorna js per i multipli di 3
    //ritorna php per i multipli di 5
    //ritorna java per i multipli di 3 e 5
    //per tutti i multipli che non sono multipli dei precedenti ritorna il numero
    it("should return 1 for 1", () => {
        expect(fizzbuzz(1)).toBe(1);
    }) 
    
    it("should return js for multiples of 3", () => {
        expect(fizzbuzz(3)).toBe("js");
        expect(fizzbuzz(6)).toBe("js");
    }) 

    it("should return php for multiples of 5", () => {
        expect(fizzbuzz(5)).toBe("php");
        expect(fizzbuzz(20)).toBe("php");
        expect(fizzbuzz(25)).toBe("php");
    }) 

    it("should return java for multiples of 5 and 3", () => {
        expect(fizzbuzz(15)).toBe("java");
        expect(fizzbuzz(30)).toBe("java");
        expect(fizzbuzz(45)).toBe("java");
    }) 

})