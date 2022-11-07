class Equation{
    private int a, b, c;

    // public static void main(String args[]){
    //     System.out.println("20, 15: " + gcd(20, 15));
    //     System.out.println("90, 45: " + gcd(90, 45));
    //     System.out.println("8, 3: " + gcd(8, 3));

    //     Equation test1 = new Equation(10, 5, 5);
    //     test1.reduceEquation();
    //     System.out.println(test1);
    // }

    public Equation(int a, int b, int c){
        if (b < 0){
            this.a = (-1) * a;
            this.b = (-1) * b;
            this.c = (-1) * c;
        }
        else{
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getC(){
        return c;
    }

    public void reduceEquation(){
        int final_gcd = gcd3(Math.abs(a), Math.abs(b), Math.abs(c));
        a /= final_gcd;
        b /= final_gcd;
        c /= final_gcd;
    }

    private int gcd(int x, int y){
        if (y == 0){
            return x;
        }
        return gcd(y, x%y);
    }

    private int gcd3(int x, int y, int z){
        int xy = gcd(x, y);
        int yz = gcd(y, z);
        return gcd(xy, yz);
    }

    public Equation add(Equation eq2){
        a += eq2.getA();
        b += eq2.getB();
        c += eq2.getC();
        this.reduceEquation();
        return this;
    }

    public Equation subtract(Equation eq2){
        a -= eq2.getA();
        b -= eq2.getB();
        c -= eq2.getC();
        this.reduceEquation();
        return new Equation(a, b, c);
    }

    public boolean equals(Equation eq){
        Equation eq1 = new Equation(a, b, c);
        Equation eq2 = new Equation(eq.getA(), eq.getB(), eq.getC());
        return  ((eq1.getA() == eq2.getA()) && (eq1.getB() == eq2.getB()) && (eq1.getC() == eq2.getC()));
    }

    public String toString(){
        //TODO add rules for output if b = 1;
        String result = "";
        if (b == 0){
            result += a + " = " + c;
        }
        else if (c == 0){
            result += a + " = " + b + "x";
        }
        else{
            if (c > 0){
                result = a + " = " + b + " x + " + c;
            }
            else{
                result = a + " = " + b + " x " + c;
            }
        }
        return result;
    }
}