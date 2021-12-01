package com.epiaedu.appescola;

public class pregunta {

    private String numero;
    private String enunciat;

    private String opcio1, opcio2, opcio3, opcio4;
    private String resposta;

    private boolean complerta;


    public pregunta(String numero, String enunciat, String opcio1, String opcio2, String opcio3, String opcio4, String resposta) {
        this.numero = numero;
        this.enunciat = enunciat;
        this.opcio1 = opcio1;
        this.opcio2 = opcio2;
        this.opcio3 = opcio3;
        this.opcio4 = opcio4;
        this.resposta = resposta;
    }


    public boolean getComplerta() {
        return complerta;
    }

    public void setComplerta(boolean complerta) {
        this.complerta = complerta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String getOpcio1() {
        return opcio1;
    }

    public void setOpcio1(String opcio1) {
        this.opcio1 = opcio1;
    }

    public String getOpcio2() {
        return opcio2;
    }

    public void setOpcio2(String opcio2) {
        this.opcio2 = opcio2;
    }

    public String getOpcio3() {
        return opcio3;
    }

    public void setOpcio3(String opcio3) {
        this.opcio3 = opcio3;
    }

    public String getOpcio4() {
        return opcio4;
    }

    public void setOpcio4(String opcio4) {
        this.opcio4 = opcio4;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

}
