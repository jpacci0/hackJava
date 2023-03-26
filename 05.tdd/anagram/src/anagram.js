export default function anagram(str1, str2) {
    if(str1.length !== str2.length) return false;
    if(str1 === str2) return true;
    //capire se le stringhe hanno gli stessi caratteri
    //1. modo: ciclare la prima stringa e vedere se i caratteri sono presenti nella seconda e fare lo stesso per la seconda
    //2. modo: splitto entrambe le stringhe per ottenere i singoli car
            //ordino i car in ordine alfabetico
            //se i due array sono uguali le stringhe sono anagrammi
    return sameChar(str1) === sameChar(str2);
}

function sameChar(str) {
    return str.split('').sort().join('')
}