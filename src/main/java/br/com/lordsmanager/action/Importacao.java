package br.com.lordsmanager.action;

import br.com.lordsmanager.dao.GuildReportsDAO;
import br.com.lordsmanager.dao.LordsDAO;
import br.com.lordsmanager.dao.PlayersDAO;
import br.com.lordsmanager.dao.SpyFoldersDAO;
import br.com.lordsmanager.modelJPA.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;


public class Importacao {


    public static void main(String[] args) throws IOException {

        System.out.println("***************** INICIANDO IMPORTACAO ********************");

        // Le e grava SpyFolders
        File currentDir = new File("C:\\Users\\Administrator\\AppData\\Roaming\\Lords Bot\\config");
        //File currentDir = new File("C:\\Projetos\\YesMyLords");

        Date date = new Date();

        File[] files = currentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory() && !file.getName().equals("global")) {

                SpyFoldersDAO daoSF = new SpyFoldersDAO();
                SpyfoldersEntity folder = daoSF.obterPorID(Integer.valueOf(file.getName()));

                if (Objects.isNull(folder)) {

                    SpyfoldersEntity spyFolder = new SpyfoldersEntity();

                    spyFolder.setFolderId(Integer.valueOf(file.getName()));
                    spyFolder.setDateInc(new Timestamp(date.getTime()));
                    spyFolder.setBot((byte) 1);

                    try {
                        daoSF.abrirT();
                        daoSF.incluir(spyFolder);
                        daoSF.fecharT();
                        System.out.println("spyFolder " + file.getName() + " inserida.");
                    } catch (Exception e) {
                        daoSF.voltarT();
                        daoSF.fechar();
                        System.out.println("Abortou ao tentar inserir spyFolder.");
                        System.exit(1);
                    }

                }
                daoSF.fechar();

                // Lista planilhas na pasta
                File xlsxDir = new File(file.getPath() + "\\stats\\exported");
                File[] planilhas = xlsxDir.listFiles();
                if (planilhas != null) {
                    for (File planilha : planilhas) {
                        if (planilha.isFile() && planilha.getName().toLowerCase().endsWith("xlsx") && planilha.getName().indexOf("~") == -1) {
                            incluiArquivo(planilha, Integer.valueOf(file.getName()));
                        }
                    }
                }
            }
        }

        System.out.println("***************** IMPORTACAO FINALIZADA ********************");

    }

    private static void incluiArquivo(final File arquivo, final Integer folderId) throws IOException {

        Date date = new Date();
        Integer fileId = null;
        LordsDAO<FilesEntity> daoFiles = new LordsDAO<>(FilesEntity.class);

        List<FilesEntity> files = daoFiles.consultarNative("getFileByName", arquivo.getName(),folderId);
        System.out.println("arquivo: " + arquivo.getName());
        if (files.size() == 0) {
            FilesEntity file = new FilesEntity();

            file.setType("GR");
            file.setFileName(arquivo.getName());
            file.setDateInc(new Timestamp(date.getTime()));
            file.setFolderId(folderId);

            Integer guildId = incluiConsultaGuilda(arquivo.getName());
            file.setGuildId(guildId);

            try {
                daoFiles.abrirT();
                daoFiles.incluir(file);
                daoFiles.fecharT();

                List<FilesEntity> filesNew = daoFiles.consultarNative("getFileByName", arquivo.getName(),folderId);
                for (FilesEntity arq: filesNew) {
                    fileId = arq.getFileId();
                }

                System.out.println("Arquivo inserido em files: " + arquivo.getName() + " da pasta " + folderId.toString());
                
            } catch (Exception e) {
                daoFiles.voltarT();
                daoFiles.fechar();
                System.out.println("Abortou ao tentar inserir File.");
                System.exit(1);
            }

            //importaPlanilha(arquivo, fileId, guildId);

        } else {
            for (FilesEntity file: files) {

                if (file.getDateImp()==null) {
                    Integer guildId = incluiConsultaGuilda(file.getFileName());
                    //importaPlanilha(arquivo, file.getFileId(), guildId) ;
                }

            }
        }
        daoFiles.fechar();

    }

    private static Integer incluiConsultaGuilda(final String nomeArquivo) throws IOException {

        Date date = new Date();

        Integer guildId=0;

        String nomeGuilda = nomeArquivo.replace(".xlsx","");
        nomeGuilda = nomeGuilda.substring(nomeGuilda.lastIndexOf(" ")).trim();

        LordsDAO<GuildsEntity> daoGuilds = new LordsDAO<>(GuildsEntity.class);
        List<GuildsEntity> guilds = daoGuilds.consultarNative("getGuildByName", nomeGuilda);

        if (guilds.size() == 0) {

            GuildsEntity guild = new GuildsEntity();

            guild.setName(nomeGuilda);
            guild.setDateInc(new Timestamp(date.getTime()));

            try {
                daoGuilds.abrirT();
                daoGuilds.incluir(guild);
                daoGuilds.fecharT();
                List<GuildsEntity> guildNew = daoGuilds.consultarNative("getGuildByName", nomeGuilda);
                for (GuildsEntity guilda: guildNew) {
                    guildId = guilda.getGuildId();
                }
                System.out.println("Incluiu Guild " + guildId.toString() + "-" + nomeGuilda);
            } catch (Exception e) {
                daoGuilds.voltarT();
                daoGuilds.fechar();
                System.out.println("Abortou ao tentar inserir Guild.");
                System.exit(1);
            }

        } else {
            for (GuildsEntity guild: guilds) {
                guildId = guild.getGuildId();
            }
        }
        daoGuilds.fechar();

        return guildId;

    }

    private static void incluiPlayer(final Integer playerId,
                                     final String playerName) {

        Date date = new Date();
        PlayersDAO daoPlayers = new PlayersDAO();
        PlayersEntity player = daoPlayers.obterPorID(playerId);

        if (Objects.isNull(player)) {

            PlayersEntity playersEntity = new PlayersEntity();

            playersEntity.setPlayerId(playerId);
            playersEntity.setName(playerName);
            playersEntity.setNickname(playerName);
            playersEntity.setDateInc(new Timestamp(date.getTime()));

            try {
                daoPlayers.abrirT();
                daoPlayers.incluir(playersEntity);
                daoPlayers.fecharT();

                System.out.println("Incluiu Player " + playerId.toString() + "-" + playerName);

            } catch (Exception e) {
                daoPlayers.voltarT();
                daoPlayers.fechar();
                System.out.println("Abortou ao tentar inserir Player.");
                System.exit(1);
            }

        } else {

            if (!playerName.toUpperCase().equals(player.getNickname())) {

                player.setName(playerName);
                player.setNickname(playerName);

                try {
                    daoPlayers.abrirT();
                    daoPlayers.atualizar(player);
                    daoPlayers.fecharT();

                    System.out.println("Atualizou Player " + playerId.toString() + "-" + playerName);

                } catch (Exception e) {
                    daoPlayers.voltarT();
                    daoPlayers.fechar();
                    System.out.println("Abortou ao tentar atualizar Player.");
                    System.exit(1);
                }
            }
        }

        daoPlayers.fechar();

    }


    private static void importaPlanilha(final File planilha,
                                        final Integer fileId,
                                        final Integer guildId) throws IOException {

        /*
        A = User ID
        B = Name
        C = Total
        D = Hunt
        E = Purchase
        F =
        G = L1 (Hunt)
        H = L2 (Hunt)
        I = L3 (Hunt)
        J = L4 (Hunt)
        K = L5 (Hunt)
        L =
        M = L1 (Purchase)
        N = L2 (Purchase)
        O = L3 (Purchase)
        P = L4 (Purchase)
        Q = L5 (Purchase)
        R =
        S= Points (Hunt)
        T = Goal Percentage (Hunt)
        U =
        V = Points (Purchase)
        W = Goal Percentage (Purchase)
        X =
        Y = Start Time
        Z = End Time
*/

        java.sql.Date dataArquivo = new java.sql.Date(planilha.lastModified());
        LocalDate dtArq = dataArquivo.toLocalDate().minusDays(1);
        dataArquivo = java.sql.Date.valueOf(dtArq);

        Date date = new Date();

        System.out.println("Planilha " + planilha.getName() + " sera importada.");

        String filePath = planilha.getPath();
        File file = new File(filePath);

        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        // Call getSheet() method to read the sheet name inside the workbook. The getSheet() method will return the sheet name.
        // Since the return type of getSheet method is an XSSFSheet. Therefore, we will store the returning value by using variable 'sheet' with type XSSFSheet.
        XSSFSheet sheet = wb.getSheet("Sheet");

        // Call iterator method to iterate row of the sheet.
        Iterator<Row> rows = sheet.rowIterator();
        rows.next(); // It will start to iterate from the second row.
        while (rows.hasNext()) {

            Row r = rows.next();

            if (r.getRowNum() > 1 ) {

                GuildReportsEntity guildReportsEntity = new GuildReportsEntity();

                XSSFRow row = (XSSFRow) r; // Typecasting.

                // Iterating all cells of the current row.
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    Cell c = cells.next();
                    XSSFCell cell = (XSSFCell) c;

                    // Call getCellType() method to compare value of cell type using if-else statement.
                    if (cell.getCellType() == CellType.STRING) {

                        // B = Name
//                        if (c.getColumnIndex()==2){
//                            guildReportsEntity.setPlayerId();
//                        }
                        String stringData = cell.getStringCellValue();
                        if (c.getColumnIndex()==1) {
//                            if (guildReportsEntity.getPlayerId()>0) {
                                incluiPlayer(guildReportsEntity.getPlayerId(), cell.getStringCellValue().toUpperCase());
//                            }
                        }

                    } else if (cell.getCellType() == CellType.NUMERIC) {

                        // A = User ID
                        if (c.getColumnIndex()==0) {
                            guildReportsEntity.setPlayerId((int) cell.getNumericCellValue());

                            // D = (Total Hunt)
                        } else if (c.getColumnIndex()==3) {
                            guildReportsEntity.setTotalHunt((int) cell.getNumericCellValue());

                            // E = (Total Purchase)
                        } else if (c.getColumnIndex()==4) {
                            guildReportsEntity.setTotalPurchase((int) cell.getNumericCellValue());

                        // G = L1 (Hunt)
                        } else if (c.getColumnIndex()==6) {
                            guildReportsEntity.setHuntL1((int) cell.getNumericCellValue());

                        // H = L2 (Hunt)
                        } else if (c.getColumnIndex()==7) {
                            guildReportsEntity.setHuntL2((int) cell.getNumericCellValue());

                        // I = L3 (Hunt)
                        } else if (c.getColumnIndex()==8) {
                            guildReportsEntity.setHuntL3((int) cell.getNumericCellValue());

                        // J = L4 (Hunt)
                        } else if (c.getColumnIndex()==9) {
                            guildReportsEntity.setHuntL4((int) cell.getNumericCellValue());

                        // K = L5 (Hunt)
                        } else if (c.getColumnIndex()==10) {
                            guildReportsEntity.setHuntL5((int) cell.getNumericCellValue());

                        // M = L1 (Purchase)
                        } else if (c.getColumnIndex()==12) {
                            guildReportsEntity.setPurchaseL1((int) cell.getNumericCellValue());

                        // N = L2 (Purchase)
                        } else if (c.getColumnIndex()==13) {
                            guildReportsEntity.setPurchaseL2((int) cell.getNumericCellValue());

                        // O = L3 (Purchase)
                        } else if (c.getColumnIndex()==14) {
                            guildReportsEntity.setPurchaseL3((int) cell.getNumericCellValue());

                        // P = L4 (Purchase)
                        } else if (c.getColumnIndex()==15) {
                            guildReportsEntity.setPurchaseL4((int) cell.getNumericCellValue());

                        // Q = L5 (Purchase)
                        } else if (c.getColumnIndex()==16) {
                            guildReportsEntity.setPurchaseL5((int) cell.getNumericCellValue());

                        // S= Points (Hunt)
                        } else if (c.getColumnIndex()==18) {
                            guildReportsEntity.setPointsHunt((int) cell.getNumericCellValue());

                        // T = Goal Percentage (Hunt)
                        } else if (c.getColumnIndex()==19) {
                            guildReportsEntity.setGoalPercHunt((int) cell.getNumericCellValue());

                        // V = Points (Purchase)
                        } else if (c.getColumnIndex()==21) {
                            guildReportsEntity.setPointsPurchase((int) cell.getNumericCellValue());

                        // W = Goal Percentage (Purchase)
                        } else if (c.getColumnIndex()==22) {
                            guildReportsEntity.setGoalPercPurchase((int) cell.getNumericCellValue());

                        } else if (c.getColumnIndex()==24) {
                            guildReportsEntity.setDateReference(dataArquivo);
                            guildReportsEntity.setGuildId(guildId);
                            guildReportsEntity.setFileId(fileId);

                        }

                    } else {
                        // Here if require, we can also add below methods to
                        System.out.print("outro tipo");
                        // Read the cell content
                        // XSSFCell.CELL_TYPE_BLANK
                        // XSSFCell.CELL_TYPE_FORMULA
                        // XSSFCell.CELL_TYPE_ERROR
                    }
                }

                try {
                    // Close the fileinputstream.
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                if (guildReportsEntity.getPlayerId() > 0) {
                    GuildReportsDAO grDAO = new GuildReportsDAO();
                    try {
                        grDAO.abrirT();
                        grDAO.incluir(guildReportsEntity);
                        grDAO.fecharT();

                    } catch (Exception e) {
                        grDAO.voltarT();
                        grDAO.fechar();
                        System.out.println("Abortou ao tentar inserir GuildReport.");
                        System.exit(1);
                    }
                    grDAO.fechar();
//                }

            }

        }

        // atualiza data de importacao
        LordsDAO<FilesEntity> daoFiles = new LordsDAO<>(FilesEntity.class);
        FilesEntity fileUpd = daoFiles.obterPorID(fileId);
        fileUpd.setDateImp(new Timestamp(date.getTime()));

        try {
            daoFiles.abrirT();
            daoFiles.atualizar(fileUpd);
            daoFiles.fecharT();

        } catch (Exception e) {
            daoFiles.voltarT();
            daoFiles.fechar();
            System.out.println("Abortou ao tentar atualizar data de importação do arquivo.");
            System.exit(1);
        }

    }

}
