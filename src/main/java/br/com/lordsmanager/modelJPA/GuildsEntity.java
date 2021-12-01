package br.com.lordsmanager.modelJPA;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "GUILDS", schema = "yesmylor_mobs")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getGuildByName",
                query = "SELECT *" +
                        "  FROM GUILDS " +
                        " WHERE NAME = ?",
                resultClass=GuildsEntity.class
        )
})
public class GuildsEntity {
    private int guildId;
    private String name;
    private Integer iggId;
    private Timestamp dateInc;

    @Id
    @Column(name = "GUILD_ID", nullable = false)
    public int getGuildId() {
        return guildId;
    }

    public void setGuildId(int guildId) {
        this.guildId = guildId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "IGG_ID", nullable = true)
    public Integer getIggId() {
        return iggId;
    }

    public void setIggId(Integer iggId) {
        this.iggId = iggId;
    }

    @Basic
    @Column(name = "DATE_INC", nullable = false)
    public Timestamp getDateInc() {
        return dateInc;
    }

    public void setDateInc(Timestamp dateInc) {
        this.dateInc = dateInc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuildsEntity that = (GuildsEntity) o;

        if (guildId != that.guildId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (iggId != null ? !iggId.equals(that.iggId) : that.iggId != null) return false;
        if (dateInc != null ? !dateInc.equals(that.dateInc) : that.dateInc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guildId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (iggId != null ? iggId.hashCode() : 0);
        result = 31 * result + (dateInc != null ? dateInc.hashCode() : 0);
        return result;
    }
}
