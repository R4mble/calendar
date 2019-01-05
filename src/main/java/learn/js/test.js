var foo = 'bar';

var obj = {
    foo: 1,
    bar: 2
};

console.log(obj.foo);
console.log(obj[foo]);

obj.key = "music";

console.log(Object.keys(obj));
delete obj.key;


