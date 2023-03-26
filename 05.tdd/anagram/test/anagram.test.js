import anagram from "./../src/anagram.js";

describe("anagram", () => {
    //non sono anagrammi se hanno lunghezza differente
    it("is not anagram when strings have different length", () => {
        expect(anagram("abc", "ad")).toBe(false);
    });

    //sono anagrammi se sono uguali
    it("should return true if strings are the same", () => {
        expect(anagram("abc", "abc")).toBe(true);
    });

    //sono anagrammi se hanno gli stessi caratteri
    it("should return true if strings have same chars", () => {
        expect(anagram("abc", "cab")).toBe(true);
    });

})