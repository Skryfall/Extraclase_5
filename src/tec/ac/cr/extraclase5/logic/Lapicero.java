package tec.ac.cr.extraclase5.logic;

public class Lapicero {

    public Lapicero(){}

    public Lapicero(int id, String marca, int precio){
        this.id = id;
        this.marca = marca;
        this.precio = precio;
    }

    private int id;
    private String marca;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
