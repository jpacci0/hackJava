import sum from "./../src/sum.js";

describe("sum", () => {

    it("should return 2 for 1 and 1", () => {
        expect(sum(1, 1)).toBe(2);
    }) 

    it("should return other number if one of them is 0", () => {
        expect(sum(0, 3)).toBe(3);
    })
    
})