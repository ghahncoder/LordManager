package br.com.lordsmanager.action;

import br.com.lordsmanager.dao.SpyFoldersDAO;
import br.com.lordsmanager.modelJPA.SpyfoldersEntity;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class LeituraPastas {

    public static void main(String[] args) {

        File currentDir = new File("C:\\programa\\config");
        SpyFoldersDAO daoSF = new SpyFoldersDAO();
        Date date = new Date();

        daoSF.abrirT();

        File[] files = currentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory() && !file.getName().equals("global")) {

                SpyfoldersEntity folder = daoSF.obterPorID(Integer.valueOf(file.getName()));

                System.out.println(Objects.isNull(folder));
                if (Objects.isNull(folder)) {

                    SpyfoldersEntity spyFolder = new SpyfoldersEntity();

                    spyFolder.setFolderId(Integer.valueOf(file.getName()));
                    spyFolder.setDateInc(new Timestamp(date.getTime()));
                    spyFolder.setBot((byte) 1);
                    daoSF.incluir(spyFolder);
                } else {
                    System.out.println(file.getName() + " já existe.");
                }

            }
        }

        daoSF.fecharT();
        daoSF.fechar();

    }

//    public static void displayDirectoryContents(File dir) {
//        try {
//            File[] files = dir.listFiles();
//            for (File file : files) {
//                if (file.isDirectory()) {
//                    System.out.println("directory:" + file.getCanonicalPath());
//                    displayDirectoryContents(file);
//                } else {
//                    System.out.println("     file:" + file.getCanonicalPath());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
