package br.com.lordsmanager.modelJPA;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GuildReportsEntityPK implements Serializable {
    private int guildId;
    private int fileId;

    @Column(name = "GUILD_ID", nullable = false)
    @Id
    public int getGuildId() {
        return guildId;
    }

    public void setGuildId(int guildId) {
        this.guildId = guildId;
    }

    @Column(name = "FILE_ID", nullable = false)
    @Id
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuildReportsEntityPK that = (GuildReportsEntityPK) o;

        if (guildId != that.guildId) return false;
        if (fileId != that.fileId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guildId;
        result = 31 * result + fileId;
        return result;
    }
}
