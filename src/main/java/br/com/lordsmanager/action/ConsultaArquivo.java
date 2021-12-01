package br.com.lordsmanager.action;

import br.com.lordsmanager.dao.LordsDAO;
import br.com.lordsmanager.modelJPA.FilesEntity;

import java.util.List;

public class ConsultaArquivo {

    public static void main(String[] args) {

        LordsDAO<FilesEntity> dao = new LordsDAO<>(FilesEntity.class);
        List<FilesEntity> files = dao.consultar("getFileByName",  "1","Arquivo.xlsx");

        if (files.size() == 0) {
            System.out.println("Nenhum arquivo encontrado.");

        } else {
            for (FilesEntity file: files) {
                System.out.println(file.getFileName());

//                if (file.getDateImp()==null) {
//
//                }

            }
        }
    }
}
