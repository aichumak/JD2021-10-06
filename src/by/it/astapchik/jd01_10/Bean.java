package by.it.astapchik.jd01_10;

class Bean {

    @Param(a = 10, b = 5)
    static double sum(int left, int right){
         return left + right;
    }

    double min(int left, int right){
        return Math.min(left, right);
    }

    @Param(a = 1, b = 5)
    double max(int left, int right){
        return Math.max(left, right);
    }

    @Param(a = 10, b = 35)
    static double avg(int left, int right){
        return (left + right)/2.0;
    }
}
