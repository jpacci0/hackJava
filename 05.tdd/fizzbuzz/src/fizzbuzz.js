function fizzbuzz(a) {
    if (a % 15 == 0) return "java";
    if (a % 3 == 0) return "js";
    if (a % 5 == 0) return "php";
    return a;
}

export default fizzbuzz;