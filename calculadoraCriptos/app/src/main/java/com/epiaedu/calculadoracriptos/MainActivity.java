package com.epiaedu.calculadoracriptos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
     Posicio 0: EUR
        Posicio 1: BTC
        Posicio 2: ETH
        Posicio 3: ADA
        Posicio 4: LTC
        */

    public static String cotitzacioBTC = "";
    double cotitzacioBTCParse;
    public static String cotitzacioETH = "";
    double cotitzacioETHParse;
    public static String cotitzacioADA = "";
    double cotitzacioADAParse;
    public static String cotitzacioLTC = "";
    double cotitzacioLTCParse;

    private ArrayList<Double> valors = new ArrayList<>(5);
    private ArrayList<Integer> posicions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valors.add(1.00);
        valors.add(0.0);
        valors.add(0.0);
        valors.add(0.0);
        valors.add(0.0);
        posicions.add(0);


        TextView inputUsuari = findViewById(R.id.inputUser);
        Button boto0 = findViewById(R.id.boto0);
        Button boto1 = findViewById(R.id.boto1);
        Button boto2 = findViewById(R.id.boto2);
        Button boto3 = findViewById(R.id.boto3);
        Button boto4 = findViewById(R.id.boto4);
        Button boto5 = findViewById(R.id.boto5);
        Button boto6 = findViewById(R.id.boto6);
        Button boto7 = findViewById(R.id.boto7);
        Button boto8 = findViewById(R.id.boto8);
        Button boto9 = findViewById(R.id.boto9);
        Button botoComa = findViewById(R.id.botoComa);

        Button botoEliminar = findViewById(R.id.botoEliminar);
        Button botoCE = findViewById(R.id.botoCE);
        Button botoEUR = findViewById(R.id.botoEUR);
        Button botoBTC = findViewById(R.id.botoBTC);
        Button botoETH = findViewById(R.id.botoETH);
        Button botoADA = findViewById(R.id.botoADA);
        Button botoLTC = findViewById(R.id.botoLTC);


        botoEUR.setPressed(true);


        boto0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("0");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        boto1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("1");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }


            }
        });

        boto2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("2");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        boto3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("3");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        boto4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("4");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        boto5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("5");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        boto6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("6");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        boto7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("7");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        boto8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("8");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        boto9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append("9");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        botoComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (noConteMesDe8Decimals(inputUsuari)) {
                    inputUsuari.append(",");
                } else {
                    Snackbar.make(view, R.string.mesDe8Decimals, Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //Boto d'eliminar
        botoEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputUsuari.getText().toString();

                try {
                    inputUsuari.setText(text.substring(0, text.length() - 1));
                } catch (StringIndexOutOfBoundsException e) {
                    Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                }


            }
        });

        //Boto de CE
        botoCE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                inputUsuari.setText("0");
            }
        });

        //Boto de EUR
        botoEUR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (noEstaBuit(inputUsuari) && comprobarValorCorrecte(inputUsuari)) {
                    if (inputUsuari.getText().toString().charAt(0) == '0') {
                        eliminar0(inputUsuari);
                    }
                    setPos(0);

                    Double inputAText = transformarDeStringADouble(inputUsuari.getText().toString());
                    String textCalculat = calcular(inputAText, valors.get(getUltim()), valors.get(getPenultim()));

                    inputUsuari.setText(textCalculat);

                    botoEUR.requestFocusFromTouch();

                } else if (!noEstaBuit(inputUsuari)) {
                    Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                } else if (!comprobarValorCorrecte(inputUsuari)) {
                    Snackbar.make(view, R.string.valorIncorrecte, Snackbar.LENGTH_LONG).show();
                }
            }

        });

        //Boto de BTC
        botoBTC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Si l'usuari no ha introduit encara cap valor es mostrarà el dialog
                if (cotitzacioBTC.isEmpty()) {
                    mostrarDialogBTC();

                } else {


                    if (noEstaBuit(inputUsuari) && comprobarValorCorrecte(inputUsuari)) {
                        setPos(1);

                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }

                        Double inputAText = transformarDeStringADouble(inputUsuari.getText().toString());

                        String textCalculat = calcular(inputAText, valors.get(getUltim()), valors.get(getPenultim()));
                        inputUsuari.setText(textCalculat);

                        botoBTC.requestFocusFromTouch();

                    } else if (!noEstaBuit(inputUsuari)) {
                        Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                    } else if (!comprobarValorCorrecte(inputUsuari)) {
                        Snackbar.make(view, R.string.valorIncorrecte, Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        //Boto de ETH
        botoETH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cotitzacioETH.isEmpty()) {
                    mostrarDialogETH();

                } else {

                    if (noEstaBuit(inputUsuari) && comprobarValorCorrecte(inputUsuari)) {
                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }
                        setPos(2);

                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }

                        Double inputAText = transformarDeStringADouble(inputUsuari.getText().toString());
                        String textCalculat = calcular(inputAText, valors.get(getUltim()), valors.get(getPenultim()));
                        inputUsuari.setText(textCalculat);


                        botoETH.requestFocusFromTouch();
                    } else if (!noEstaBuit(inputUsuari)) {
                        Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                    } else if (!comprobarValorCorrecte(inputUsuari)) {
                        Snackbar.make(view, R.string.valorIncorrecte, Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        //Boto de ADA
        botoADA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (cotitzacioADA.isEmpty()) {
                    mostrarDialogADA();

                } else {


                    if (noEstaBuit(inputUsuari) && comprobarValorCorrecte(inputUsuari)) {
                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }
                        setPos(3);

                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }

                        Double inputAText = transformarDeStringADouble(inputUsuari.getText().toString());
                        String textCalculat = calcular(inputAText, valors.get(getUltim()), valors.get(getPenultim()));
                        inputUsuari.setText(textCalculat);

                        botoADA.requestFocusFromTouch();

                    } else if (!noEstaBuit(inputUsuari)) {
                        Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                    } else if (!comprobarValorCorrecte(inputUsuari)) {
                        Snackbar.make(view, R.string.valorIncorrecte, Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        //Boto de LTC
        botoLTC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (cotitzacioLTC.isEmpty()) {
                    mostrarDialogLTC();

                } else {


                    if (noEstaBuit(inputUsuari) && comprobarValorCorrecte(inputUsuari)) {
                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }


                        setPos(4);

                        if (inputUsuari.getText().toString().charAt(0) == '0') {
                            eliminar0(inputUsuari);
                        }


                        Double inputAText = transformarDeStringADouble(inputUsuari.getText().toString());
                        String textCalculat = calcular(inputAText, valors.get(getUltim()), valors.get(getPenultim()));

                        inputUsuari.setText(textCalculat);

                        botoLTC.requestFocusFromTouch();

                    } else if (!noEstaBuit(inputUsuari)) {
                        Snackbar.make(view, R.string.noHiHaNum, Snackbar.LENGTH_LONG).show();
                    } else if (!comprobarValorCorrecte(inputUsuari)) {
                        Snackbar.make(view, R.string.valorIncorrecte, Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });


    }


    public void mostrarDialogBTC() {

        Dialog dialogBTC = new Dialog(this);
        dialogBTC.setContentView(R.layout.dialogbtc);

        Button botoEnviar = dialogBTC.findViewById(R.id.botoEstablir);

        EditText cotitzacio = dialogBTC.findViewById(R.id.introduirCotitzacioBTC);

        botoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (comprovarDataCorrecta(cotitzacio, view)) {

                    cotitzacioBTC = cotitzacio.getText().toString();

                    cotitzacioBTCParse = transformarDeStringADouble(cotitzacioBTC);

                    valors.set(1, cotitzacioBTCParse);

                    dialogBTC.dismiss();
                }


            }

        });

        dialogBTC.show();

    }

    public void mostrarDialogETH() {

        Dialog dialogETH = new Dialog(this);
        dialogETH.setContentView(R.layout.dialogeth);

        Button botoEnviar = dialogETH.findViewById(R.id.botoEstablir);

        EditText cotitzacio = dialogETH.findViewById(R.id.introduirCotitzacioBTC);

        botoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (comprovarDataCorrecta(cotitzacio, view)) {

                    cotitzacioETH = cotitzacio.getText().toString();

                    cotitzacioETHParse = transformarDeStringADouble(cotitzacioETH);

                    valors.set(2, cotitzacioETHParse);

                    dialogETH.dismiss();


                }

            }
        });

        dialogETH.show();

    }

    public void mostrarDialogADA() {

        Dialog dialogADA = new Dialog(this);
        dialogADA.setContentView(R.layout.dialogada);

        Button botoEnviar = dialogADA.findViewById(R.id.botoEstablir);

        EditText cotitzacio = dialogADA.findViewById(R.id.introduirCotitzacioBTC);

        botoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //El valor no pot estar buit
                if (comprovarDataCorrecta(cotitzacio, view)) {

                    cotitzacioADA = cotitzacio.getText().toString();

                    cotitzacioADAParse = transformarDeStringADouble(cotitzacioADA);

                    valors.set(3, cotitzacioADAParse);
                    dialogADA.dismiss();
                }
            }
        });

        dialogADA.show();

    }

    public void mostrarDialogLTC() {

        Dialog dialogLTC = new Dialog(this);
        dialogLTC.setContentView(R.layout.dialogltc);

        Button botoEnviar = dialogLTC.findViewById(R.id.botoEstablir);

        EditText cotitzacio = dialogLTC.findViewById(R.id.introduirCotitzacioBTC);

        botoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (comprovarDataCorrecta(cotitzacio, view)) {

                    cotitzacioLTC = cotitzacio.getText().toString();

                    cotitzacioLTCParse = transformarDeStringADouble(cotitzacioLTC);

                    valors.set(4, cotitzacioLTCParse);
                    dialogLTC.dismiss();
                }
            }
        });

        dialogLTC.show();

    }

    public double transformarDeStringADouble(String valor) {

        //Reemplaça les comes per punts i transforma el string en un double

        if (valor.contains(",")) {
            return Double.parseDouble(valor.replace(",", "."));
        } else {
            return Double.parseDouble(valor);
        }

    }

    public String transformarDeDoubleAString(Double valor) {

        //Transforma el double a string
        String string1 = String.valueOf(valor);

        //Es formateja el string de manera que es vegi amb 2 decimals
        String string2 = string1.format("%,.2f", valor);

        //Es reemplacen els punts per comes
        return string2.replace(".", ",");

    }


    public void setPos(int pos) {

        this.posicions.add(pos);
    }

    public int getUltim() {
        //Retorna l'última posició
        return posicions.get(posicions.size() - 1);
    }

    public int getPenultim() {
        //Retorna la penúltima posició
        return posicions.get(posicions.size() - 2);
    }


    public String calcular(Double inputUsuari, Double botoActual, Double botoAnterior) {


        double resultat = (inputUsuari * botoAnterior) * botoActual;

        return transformarDeDoubleAString(resultat);


    }

    public boolean comprovarDataCorrecta(EditText cotitzacio, View view) {

        if (cotitzacio.getText().toString().matches("")) {
            Snackbar.make(view, R.string.estaBuit, Snackbar.LENGTH_LONG).show();
            return false;

        } else if (cotitzacio.getText().toString().contains(".")) {
            Snackbar.make(view, R.string.conteUnPunt, Snackbar.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public boolean noEstaBuit(TextView userInput) {

        String text = userInput.getText().toString();

        if (text.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean comprobarValorCorrecte(TextView userInput) {

        String condicions = "^\\d+(\\,\\d+)?$";

        String text = userInput.getText().toString();

        if (!text.matches(condicions)) {
            return false;
        }
        return true;
    }

    public void eliminar0(TextView userInput) {

        String text = userInput.getText().toString();
        if (!(text.startsWith("0,"))) {
            userInput.setText(text.substring(1));

        }

    }

    public boolean noConteMesDe8Decimals(TextView userInput) {

        String text = userInput.getText().toString();

        if (text.contains(",")) {

            String despresDeDecimal = text.substring(text.indexOf(",") + 1);

            if (despresDeDecimal.length() >= 8) {

                return false;
            }
        }

        return true;
    }


}


