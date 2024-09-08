public class Cartas {
    //atributos
    private String valor; //el valor que tiene la carta, sea As 2,3,4...
    private String Simbolo; //corazon, espadas, diamantes, trebol

    //metodos
    //metodo constructor tiene el mismo nombre que su clase
    public Cartas(String valor, String Simbolo) {
        this.valor = valor;
        this.Simbolo = Simbolo;
    }
    //obtiene el valor
    public String getValor() {
        return valor;
    }
    //obtiene el simbolo
    public String getSimbolo() {
        return Simbolo;
    }
    public int getValorNumerico(){
        switch (valor){ //es como un if y case es la condicional
            case "As":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default: //valor para las cartas con numeros
                return Integer.parseInt(valor); //parse sirve para que un String pase a Int
        }
    }
    @Override
    public String toString() {
        return Simbolo + " de " + valor;
    }
}

