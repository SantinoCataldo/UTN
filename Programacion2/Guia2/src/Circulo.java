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

    public void mostrarDatos() {
        System.out.println("Radio: " + radio);
        System.out.println("Color: " + color);
        System.out.println("Area: " + getArea());
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
        return super.getArea() * altura;
    }

    public double getAltura() {
        return altura;
    }

    public double getArea() {
        return 2 * Math.PI * getRadio() * altura + 2 * super.getArea();
    }

    public void mostrarDatos() {
        System.out.println("----------- Datos del Cilindro -----------");
        System.out.println("Radio: " + getRadio());
        System.out.println("Color: " + getColor());
        System.out.println("Area (circulo): " + super.getArea());
        System.out.println("Area (circunferencia): " + getArea());
        System.out.println("Altura: " + altura);
        System.out.println("Volumen: " + getVolumen());
    }
}