"use strict";
const { readFileSync } = require("fs");
var text = readFileSync("./text.txt").toString();
let textSplitted = [];
let numberOfTokens = 0;
let textByLine = text.toString().split("\n");

// removing string
for (let i = 0; i < textByLine.length; i++) {
  if (textByLine[i].includes('"')) {
    textByLine[i] = textByLine[i].replace(
      textByLine[i].slice(
        textByLine[i].indexOf('"'),
        textByLine[i].lastIndexOf('"') + 1
      ),
      "a"
    );
  }
  //removing comment
  if (textByLine[i].trim().startsWith("//")) {
    textByLine[i] = "";
  }
  textSplitted.push(textByLine[i].split(" "));
}
for (let i = 0; i < textSplitted.length; i++) {
  textSplitted[i] = textSplitted[i].filter((element) => {
    return element !== "";
  });
  numberOfTokens += textSplitted[i].length;
}
console.log(numberOfTokens);
