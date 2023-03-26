//Calcolare l'ipotenusa di un triangolo rettangolo di cateti 3 e 4. Potete usare Math.

// function calcIpotenusa(cat1, cat2) {
//     let ipotenusa = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
//     return ipotenusa;
// }
// console.log(calcIpotenusa(3, 4));



// Scrivere una funzione che trasformi un nome nelle sue iniziali "Tizio Caio" => T.C.

// function getInit(nome) {
//     let nomi = nome.split(" ");
//     let iniziali = "";
//     console.log(nomi)
//     for (let i = 0; i < nomi.length; i++) {
//         iniziali = iniziali + nomi[i].charAt(0) + ".";
//     }
//     return iniziali;
// }
// console.log(getInit('Tizio Caio'));



//Scrivere una funzione che, dati 3 numeri, ritorni true se questi 3 numeri possono formare un triangolo. False altrimenti

// function isTriangle(num1, num2, num3) {
//     if (num1 + num2 > num3 && num3 + num2 > num1 && num1 + num3 > num2) {
//         return true;
//     } 
//     return false;
// }

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
//     let arr = [];
//     let j = 0;
//     if(num <= 0){
//         console.log('Il numero è minore di 1');
//     }
//     while (num > 1) {
//         if(num % 2 == 0) {
//             num = num / 2;
//         } else {
//             num = num * 3 + 1;
//         }
//         arr[j] = num;
//         j = j + 1;
//     }
//     return arr;
// }
// console.log(collatz(3))



//Scrivere una funzione che, assegnato un numero n, ritorni la successione di fibonacci fino al numero n sottoforma di array.

// Ad esempio 3 => [1,1,2], 9 => [1,1,2,3,5,8,13,21,34]
// function fibonacci(num) {
//     if(num <= 2) return 1;
// 	let array = [];
//     let numero_corrente = 1;
//     let prev = 0;
//     let j = 0;
// 	while(j < num) {
//         array[j] = numero_corrente;
// 		let dopo = numero_corrente + prev;
//         prev = numero_corrente;
//         numero_corrente = dopo;
//         j = j + 1;
// 	}
//     return array;
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



//Scrivere una funzione che assegnata una stringa ritorni la somma delle cifre in essa presenti. Ad esempio "Sono 1 stringa di 6 parole" => 7

// function sommaStringa(stringa) {
//     let somma = 0;
//     for (let i = 0; i < stringa.length; i++) {
//     if (!isNaN(parseInt(stringa[i]))) {
//       somma = somma + parseInt(stringa[i]);
//     }
//   }
//   return somma;
// }
// console.log(sommaStringa("Sono 1 stringa di 6 parole"));



//Scrivere una funzione che trasformi un numero in ore e minuti. Ad esempio 3014 => 50:14. Devono essere sempre presenti due cifre, sia per le ore che per i minuti

// function oreMinuti(ora) {
//     let ore = Math.floor(ora / 60);
//     let minuti = ora % 60;
//     if(ore < 10) ore = '0' + ore;
//     if(minuti < 10) minuti = '0' + minuti;

//     // if (ore.toString().length == 2 && minuti.toString().length == 2) {
//     //     return (ore + ":" + minuti);
//     // } else if (ore.toString().length !== 2 && minuti.toString().length == 2) {
//     //     return ("0" + ore + ":" + minuti);
//     // } else if (ore.toString().length == 2 && minuti.toString().length !== 2) {
//     //     return (ore + ":0" + minuti);
//     // } else if (ore.toString().length !== 2 && minuti.toString().length !== 2) {
//     //     return ("0" + ore + ":0" + minuti);
//     // }
//     return ore +' : '+ minuti;
// }
// console.log(oreMinuti(3007));



//Scrivere una funzione che, assegnata una stringa, ritorni il numero di vocali presenti. gestire le maiuscole

// function contaVocali(stringa){
//     stringa = stringa.toLowerCase();
//     let vocali = ["a", "e", "i", "o", "u"]
//     let counter = 0;

//     for (var i = 0; i < stringa.length; i++) {
//         if (vocali.includes(stringa[i])) {
//             counter++;
//         }
//     }
//     return counter;
// }
// console.log(contaVocali('ciao sono jacopo')) //8



//Scrivere una funzione che accetta una stringa e restituisce la parola più lunga

// function parolaLunga(stringa) {
//     let parole = stringa.split(' ');
//     let piùLunga = "";

//     for (let i = 0; i < parole.length; i++) {
//         if (parole[i].length > piùLunga.length) {
//             piùLunga = parole[i];
//         }
//     }
//     return piùLunga;
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

