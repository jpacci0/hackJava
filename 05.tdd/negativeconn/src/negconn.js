function negconn(str) {
    str = str.toLowerCase();
    let array = str.split(" ");
    array = array.filter(item => item);
    let firstHalf = 0;
    let secondHalf = 0;
    for(let i = 0; i < array.length; i++){
      if("abcdefghijklm".includes(array[i][0])) {
        firstHalf++;
      } else {
        secondHalf++;
      }
    }
    return firstHalf >= secondHalf;
  }
export default negconn;