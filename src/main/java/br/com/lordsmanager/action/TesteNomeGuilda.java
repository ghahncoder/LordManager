package br.com.lordsmanager.action;

public class TesteNomeGuilda {

    public static void main(String[] args) {

        String nomeGuilda = "03 03 0303 nOme.xlsx".toUpperCase();

        nomeGuilda = nomeGuilda.replace(".XLSX","");
        nomeGuilda = nomeGuilda.substring(nomeGuilda.lastIndexOf(" ")).trim();

        System.out.println(nomeGuilda);

    }
}
