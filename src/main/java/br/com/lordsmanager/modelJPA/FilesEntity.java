package br.com.lordsmanager.modelJPA;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "FILES", schema = "yesmylor_mobs")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getFileByName",
                query = "SELECT *" +
                        "  FROM FILES " +
                        " WHERE FILE_NAME = ?" +
                        "   AND FOLDER_ID = ?",
                resultClass=FilesEntity.class
        )
})
public class FilesEntity {
    private int fileId;
    private String type;
    private String fileName;
    private Timestamp dateInc;
    private Timestamp dateImp;
    private int folderId;
    private int guildId;

    @Id
    @Column(name = "FILE_ID", nullable = false)
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "TYPE", nullable = false, length = 2)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "FILE_NAME", nullable = false, length = 200)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "DATE_INC", nullable = false)
    public Timestamp getDateInc() {
        return dateInc;
    }

    public void setDateInc(Timestamp dateInc) {
        this.dateInc = dateInc;
    }

    @Basic
    @Column(name = "DATE_IMP", nullable = true)
    public Timestamp getDateImp() {
        return dateImp;
    }

    public void setDateImp(Timestamp dateImp) {
        this.dateImp = dateImp;
    }

    @Basic
    @Column(name = "FOLDER_ID", nullable = true)
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    @Basic
    @Column(name = "GUILD_ID", nullable = false)
    public int getGuildId() {
        return guildId;
    }

    public void setGuildId(int guildId) {
        this.guildId = guildId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilesEntity that = (FilesEntity) o;
        return fileId == that.fileId && folderId == that.folderId && guildId == that.guildId && type.equals(that.type) && fileName.equals(that.fileName) && dateInc.equals(that.dateInc) && Objects.equals(dateImp, that.dateImp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, type, fileName, dateInc, dateImp, folderId, guildId);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        FilesEntity that = (FilesEntity) o;
//
//        if (fileId != that.fileId) return false;
//        if (type != null ? !type.equals(that.type) : that.type != null) return false;
//        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
//        if (dateInc != null ? !dateInc.equals(that.dateInc) : that.dateInc != null) return false;
//        if (dateImp != null ? !dateImp.equals(that.dateImp) : that.dateImp != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = fileId;
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
//        result = 31 * result + (dateInc != null ? dateInc.hashCode() : 0);
//        result = 31 * result + (dateImp != null ? dateImp.hashCode() : 0);
//        return result;
//    }
}
