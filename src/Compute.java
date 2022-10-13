public class Compute {
    int compute(int num) {
        if(num <= 1) return num;
        return compute(num - 1) + compute(num - 3);
    }
}

class TestCompute {
    public static void main(String[] args) {
        Compute compute = new Compute();
        System.out.println(compute.compute(4));
    }
}
