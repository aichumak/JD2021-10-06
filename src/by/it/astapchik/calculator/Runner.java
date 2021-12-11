package by.it.astapchik.calculator;

class Runner {
    private static void print(Var var) {
        if (var != null){
            System.out.print(var);
        }
//        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(4.0);
        Var s1 = new Scalar(1.0);
        Var v = new Vector(new double[]{1, 2, 3});

//        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        Var m = new Matrix(new double[][]{
                                            {1,2,3},
                                            {4,5,6},
                                            {7,8,9}
                                        });


        /* Уровень сложности A (калькулятор) */
//        System.out.println(s.add(s) + " = scalar + scalar"); //выведет в консоль 6.0
//        System.out.println(s.sub(s1)); //выведет в консоль 0.0
//        System.out.println(s.mul(s1)); //выведет в консоль 9.0
//        System.out.println(s.div(s)); //выведет в консоль 1.0

//        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
//        System.out.println(v.add(v) + " = vector + vector"); //выведет в консоль {2.0, 4.0, 6.0}
//        System.out.println(v.add(s) + " = scalar + vector");
//        System.out.println(v.sub(v)+ " = vector - vector"); //выведет в консоль {0.0, 0.0, 0.0}
//        System.out.println(v.sub(s1)+ " = scalar - vector");
//        System.out.println(v.mul(s) + " = scalar * vector"); //выведет в консоль 14.0
//        System.out.println(v.mul(v) + " = vector * vector");
//        System.out.println(v.div(s)); //сообщит о невозможности операции

///* Уровень сложности C (матричные операции и умножение на вектор)
//закомментируйте, если не реализовали */
//        System.out.println(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
//        System.out.println("scalar + matrix = " + m.add(s));
//        System.out.println("matrix + matrix = " + m.add(m));

//        System.out.println("matrix - matrix = " + m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
//        System.out.println("scalar - matrix = " + m.sub(s));
//        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
//        System.out.println("scalar * matrix = " + m.mul(s));
        System.out.println("matrix * matrix = " + m.mul(m));//{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        System.out.println("matrix * vector = " + m.mul(v)); //{14.0, 32.0, 50.0}
    }
}
