public class Circulo {
    private double radio = 1.0;
    private String color = "rojo";

    public Circulo(){}

    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }

    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * radio * radio;
    }
}

class Cilindro extends Circulo {
    private double altura = 1.0;

    public Cilindro() {
        super();
    }

    public Cilindro(double radio, double altura, String color) {
        super(radio, color);
        this.altura = altura;
    }

    public double getVolumen() {
        return getArea() * altura;
    }

    public double getAltura() {
        return altura;
    }
}