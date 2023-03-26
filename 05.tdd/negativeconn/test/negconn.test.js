import negconn from "../src/negconn.js";

describe("negconn", () => {

    it("should return true if there are more initials that belong to a-m A-M", () => {
        expect(negconn("A big brown fox caught a bad bunny")).toBe(true);
        expect(negconn("CHOCOLATE MAKES A GREAT SNACK")).toBe(true);
        expect(negconn("Is  this the  best  Kata?")).toBe(true);
    }) 

    it("should return false if there are more initials that belong to n-z N-Z", () => {
        expect(negconn("Xylophones can obtain Xenon.")).toBe(false);
    }) 
    
    

})