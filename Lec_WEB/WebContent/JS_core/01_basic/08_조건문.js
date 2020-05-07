//Java, C언어와 구조 동일

a=100

if(a+1 > 100){
    
    let a = 10;
    console.log('if안의 a값은', a);
}

// Falsy 로 평가될때!
// false, 0, '', null, undefine, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

function print(data){
    if(data){ //참 거짓 판정
        console.log(data, typeof data, '-- Truthy');

    } else{
        console.log(data, typeof data, '-- falsy');
    }
}

print(true)
print(false)
print(100)
print(0)
print(-1)
print('hello')
print("")
print('')
print([10, 20, 30])
print([])
print({})
print(null)
print(NaN)
print(undefined)
console.log(100/0)
print(100/0)
print() //호출시 전달인자 없으면 undefiend값으로 동작함

console.log()
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")
console.log(!NaN)

console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10, 20, 30])
console.log(![])
console.log(!{})

let value = {'a':100}
let isTrue = value ? true:false;
console.log('isTrue=', isTrue, typeof isTrue)

isTrue = !!value;
console.log('isTrue=', isTrue, typeof isTrue)

function printName(person){
    console.log('이름은', person.name)
}

let myBrother = {name : "John"}
printName(myBrother)
//printName() 에러

function printName(person){
    if(!person) return;

    console.log('이름은', person.name)
}

printName(myBrother);
printName();