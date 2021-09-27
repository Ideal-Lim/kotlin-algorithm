package basic.datatype

fun main(){
    val bool = true // 컴파일러가 알아서 Boolean 형으로 추론
    val char1 = 'C' // 컴파일러가 알아서 Char 형으로 추론
    val a = 123 // Int형으로 추론
    val b = 123L // 접미사 L을 이용하여 Long형으로 추론
    val c = 0x1F // 접두사 0x 를 사용해 16진법 표기가 사용된 Int 형으로 추론
    val d = 0b00101010 // 접두사 0b 를 이용하여 2진 표기가 사용된 Int 형으로 추론
    val float1 = 1.23e-2F // 0.0123

}
