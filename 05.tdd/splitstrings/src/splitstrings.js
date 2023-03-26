function splitstrings(stringa) {
    if (stringa.length % 2 !== 0) {
        stringa += "_";
      }
      return stringa.match(/.{1,2}/g);
}

export default splitstrings;