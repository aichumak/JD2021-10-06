package by.it.astapchik.calculator;

interface Patterns {

//    {1,2} *5 {10.0} {1.0,4}
//    {{1,2,3},{4,5,6},{7,8,9}}
// 1 2 3 -3.2
    String OPERATIONS = "[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";

}

//\{-?[0-9]+(\.[0-9]+)?(,-?[0-9]+(\.[0-9]+)?)*}


