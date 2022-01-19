var list = [1, 2, 3];
var categories = ['Sport', 'IT', 'Car'];
console.log('list');
list.forEach(function (num) { return console.log(num.toFixed(2)); });
console.log('categries');
categories.forEach(function (str) {
    return console.log(str.includes('a'));
});
