package br.com.lordsmanager.modelJPA;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SPYFOLDERS", schema = "yesmylor_mobs")
public class SpyfoldersEntity {
    private int folderId;
    private Timestamp dateInc;
    private byte bot;

    @Id
    @Column(name = "FOLDER_ID", nullable = false)
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
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
    @Column(name = "BOT", nullable = false)
    public byte getBot() {
        return bot;
    }

    public void setBot(byte bot) {
        this.bot = bot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpyfoldersEntity that = (SpyfoldersEntity) o;

        if (folderId != that.folderId) return false;
        if (bot != that.bot) return false;
        if (dateInc != null ? !dateInc.equals(that.dateInc) : that.dateInc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = folderId;
        result = 31 * result + (dateInc != null ? dateInc.hashCode() : 0);
        result = 31 * result + (int) bot;
        return result;
    }
}
