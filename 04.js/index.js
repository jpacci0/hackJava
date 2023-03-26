//Calcolare l'ipotenusa di un triangolo rettangolo di cateti 3 e 4. Potete usare Math.

// function calcIpotenusa(cat1, cat2) {
//     return Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
// }
// console.log(calcIpotenusa(3, 4));



// Scrivere una funzione che trasformi un nome nelle sue iniziali "Tizio Caio" => T.C.

//usando map
// function getInitials(nome) {
//     return nome.split(" ")
//                .map(el => el.charAt(0))
//                .join('.') + ".";
// }
// let nomeCompleto = "Jacopo Paccioretti";
// console.log(getInitials(nomeCompleto));

//senza funzione
// let nomeCompleto = "Jacopo Paccioretti";
// console.log(nomeCompleto.split(" ").map(el => el.charAt(0)).join('.') + ".");

//usando la reduce
// function onlyCapital(str){
//     return str.split(" ")
//               .reduce((acc, val) => acc + val[0] + ".", "");
// }
// console.log(onlyCapital("Desi Totaro"));



//Scrivere una funzione che, dati 3 numeri, ritorni true se questi 3 numeri possono formare un triangolo. False altrimenti

// function isTriangle(a,b,c){
//     return check(a, b, c ) && check(b, c, a) && check(c,b,a);
// }
// function check(num1, num2, num3){
//     return num1 > Math.abs(num2-num3) && (num1 < num2+num3);
// }
// console.log(isTriangle(1, 2, 3));
// console.log(isTriangle(3, 2, 3));
// console.log(isTriangle(4, 2, 1));



//Congettura di Collatz: preso un numero maggiore di 1, se questo è pari dividerlo per due, se dispari moltiplicarlo per 3 e aggiungere 1. Ripetere. Qualunque sia il numero di partenza, l'algoritmo termina sempre ad uno. Scrivere una funzione che implementi l'algoritmo e ritorni un array con il valore calcolato ad ogni iterazione

// function collatz(num) {
//     if(num <= 0){
//         console.log('Il numero deve essere maggiore di 0');
//         return [];
//     }
//     let arr = [];
//     while (num > 1) {
//         num = num % 2 == 0 ? num = num / 2 : num = num * 3 + 1;
//         arr.push(num);
//         }
//     return arr;
// }
// console.log(collatz(3))



//Scrivere una funzione che, assegnato un numero n, ritorni la successione di fibonacci fino al numero n sottoforma di array.
// Ad esempio 3 => [1,1,2], 9 => [1,1,2,3,5,8,13,21,34]

// function fibonacci(num) {
//     if (num <= 2) {
//         return new Array(num).fill(1);
//     }
//     const arr = [1, 1];
//     for (let i = 2; i < num; i++) {
//       arr[i] = arr[i - 1] + arr[i - 2];
//     }
//     return arr;
// }
// console.log(fibonacci(9));



//Scrivere una funzione che, assegnato un numero n, ritorni se è primo

// function primo(num) {
//     if (num <= 1) {
//         return false;
//     }
//     for (let i = 2; i <= Math.sqrt(num); i++) {
//         if (num % i === 0) {
//           return false;
//         }
//     }
//     return true;
// }
// console.log(primo(9));

// function isPrime(num) {
//     if (num <= 1) return false;
//     for (let i = 2; i <= num / 2; i++) {
//       if (num % i === 0) {
//         return false;
//       }
//     }
//     return true;
// }
// console.log(isPrime(8));
  


//Scrivere una funzione che assegnata una stringa ritorni la somma delle cifre in essa presenti. Ad esempio "Sono 1 stringa di 6 parole" => 7

// function sommaStringa(stringa) {
//     const numeri = stringa.split('')
//       .filter(char => !isNaN(parseInt(char)))
//       .map(char => parseInt(char));
    
//     return numeri.reduce((acc, val) => acc + val, 0);
// }
// console.log(sommaStringa("Sono 1 stringa di 6 parole"));
  


//Scrivere una funzione che trasformi un numero in ore e minuti. Ad esempio 3014 => 50:14. Devono essere sempre presenti due cifre, sia per le ore che per i minuti

// function oreMinuti(ora) {
//     let ore = Math.floor(ora / 60);
//     let minuti = ora % 60;
//     if(ore < 10) ore = '0' + ore;
//     if(minuti < 10) minuti = '0' + minuti;

//     return ore + ':' + minuti;
// }
// console.log(oreMinuti(3007));



//Scrivere una funzione che, assegnata una stringa, ritorni il numero di vocali presenti. gestire le maiuscole

// function contaVocali(stringa){
//     stringa = stringa.toLowerCase().split('');
//     let vocali = ["a", "e", "i", "o", "u"]
//     return stringa.filter(el => vocali.includes(el)).length;
// }
// console.log(contaVocali('ciao sono jacopo')) //8



//Scrivere una funzione che accetta una stringa e restituisce la parola più lunga

// function parolaLunga(stringa) {
//     return stringa.split(' ')
//                   .reduce((piùLunga, parola) => parola.length > piùLunga.length ? parola : piùLunga, "");
// }
// console.log(parolaLunga("La parola più lunga qui dentro è questaparolaqui"));
  


//Scrivere una funzione che accetti una stringa contenente solo caratteri x e y e ritorni true se il numero delle x è uguale al numero delle y

// function xy(stringa) {
    
//     let xc = 0;
//     let yc = 0;
//     stringa = stringa.toLowerCase()
    

//     for (let i = 0; i < stringa.length; i++) {
//         if (stringa[i] !== 'x' && stringa[i] !== 'y') {
//             console.log('La stringa non ha solo x e y');
//             return false;
//         }
//         if (stringa[i] === 'x') {
//             xc++;
//         } else if (stringa[i] === 'y') {
//             yc++;
//         }
//     }

//     return xc === yc;
// }

// console.log(xy('xxyy')); 

