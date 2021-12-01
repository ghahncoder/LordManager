package br.com.lordsmanager.action;

import com.google.gson.Gson;
import br.com.lordsmanager.model.Lords;

import java.io.*;
import java.util.List;

public class TesteJson {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\git\\LordManager\\resources\\guild-stats-2021-02-21.json")) {

            // Convert JSON File to Java Object
            Lords lords = gson.fromJson(reader, Lords.class);

            List<Lords.BoxData> boxData = lords.getBoxData();

            for (final Lords.BoxData box : boxData) {

                System.out.println(box.getBoxItemId());
                System.out.println(box.getBoxLevel());
                System.out.println(box.getBoxName());
                System.out.println(box.getIsPurchase());
                System.out.println(box.getPlayerName());
                System.out.println(box.getRcvTime());
                System.out.println(box.getSn());
                System.out.println(box.getStatus());

                System.out.println("Item");
                System.out.println(box.getItem().getItemId());
                System.out.println(box.getItem().getItemName());
                System.out.println(box.getItem().getItemRank());
                System.out.println(box.getItem().getNum());

            }

            // print staff
            //System.out.println(lords);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
