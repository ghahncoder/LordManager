package br.com.lordsmanager.modelJPA;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PLAYERS", schema = "yesmylor_mobs")
public class PlayersEntity {
    private int playerId;
    private String name;
    private String nickname;
    private Timestamp dateInc;

    @Id
    @Column(name = "PLAYER_ID", nullable = false)
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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
    @Column(name = "NICKNAME", nullable = true, length = 200)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

        PlayersEntity that = (PlayersEntity) o;

        if (playerId != that.playerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (dateInc != null ? !dateInc.equals(that.dateInc) : that.dateInc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (dateInc != null ? dateInc.hashCode() : 0);
        return result;
    }
}
