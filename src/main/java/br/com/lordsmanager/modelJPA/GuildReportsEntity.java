package br.com.lordsmanager.modelJPA;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "GUILD_REPORTS", schema = "yesmylor_mobs")
@IdClass(GuildReportsEntityPK.class)
public class GuildReportsEntity {
    private int guildId;
    private int fileId;
    private Timestamp startTime;
    private Integer finishTime;
    private Integer playerId;
    private Integer startUtc;
    private Integer finishUtc;
    private Integer huntL1;
    private Integer huntL2;
    private Integer huntL3;
    private Integer huntL4;
    private Integer huntL5;
    private Integer huntL6;
    private Integer huntL7;
    private Integer purchaseL1;
    private Integer purchaseL2;
    private Integer purchaseL3;
    private Integer purchaseL4;
    private Integer purchaseL5;
    private Integer purchaseL6;
    private Integer purchaseL7;
    private Integer totalHunt;
    private Integer totalPurchase;
    private Integer pointsHunt;
    private Integer pointsPurchase;
    private Integer goalPercHunt;
    private Integer goalPercPurchase;
    private Date dateReference;

    @Id
    @Column(name = "GUILD_ID", nullable = false)
    public int getGuildId() {
        return guildId;
    }

    public void setGuildId(int guildId) {
        this.guildId = guildId;
    }

    @Id
    @Column(name = "FILE_ID", nullable = false)
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Id
    @Column(name = "PLAYER_ID", nullable = false)
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "START_TIME", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "FINISH_TIME", nullable = true)
    public Integer getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Integer finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "START_UTC", nullable = true)
    public Integer getStartUtc() {
        return startUtc;
    }

    public void setStartUtc(Integer startUtc) {
        this.startUtc = startUtc;
    }

    @Basic
    @Column(name = "FINISH_UTC", nullable = true)
    public Integer getFinishUtc() {
        return finishUtc;
    }

    public void setFinishUtc(Integer finishUtc) {
        this.finishUtc = finishUtc;
    }

    @Basic
    @Column(name = "HUNT_L1", nullable = true)
    public Integer getHuntL1() {
        return huntL1;
    }

    public void setHuntL1(Integer huntL1) {
        this.huntL1 = huntL1;
    }

    @Basic
    @Column(name = "HUNT_L2", nullable = true)
    public Integer getHuntL2() {
        return huntL2;
    }

    public void setHuntL2(Integer huntL2) {
        this.huntL2 = huntL2;
    }

    @Basic
    @Column(name = "HUNT_L3", nullable = true)
    public Integer getHuntL3() {
        return huntL3;
    }

    public void setHuntL3(Integer huntL3) {
        this.huntL3 = huntL3;
    }

    @Basic
    @Column(name = "HUNT_L4", nullable = true)
    public Integer getHuntL4() {
        return huntL4;
    }

    public void setHuntL4(Integer huntL4) {
        this.huntL4 = huntL4;
    }

    @Basic
    @Column(name = "HUNT_L5", nullable = true)
    public Integer getHuntL5() {
        return huntL5;
    }

    public void setHuntL5(Integer huntL5) {
        this.huntL5 = huntL5;
    }

    @Basic
    @Column(name = "HUNT_L6", nullable = true)
    public Integer getHuntL6() {
        return huntL6;
    }

    public void setHuntL6(Integer huntL6) {
        this.huntL6 = huntL6;
    }

    @Basic
    @Column(name = "HUNT_L7", nullable = true)
    public Integer getHuntL7() {
        return huntL7;
    }

    public void setHuntL7(Integer huntL7) {
        this.huntL7 = huntL7;
    }

    @Basic
    @Column(name = "PURCHASE_L1", nullable = true)
    public Integer getPurchaseL1() {
        return purchaseL1;
    }

    public void setPurchaseL1(Integer purchaseL1) {
        this.purchaseL1 = purchaseL1;
    }

    @Basic
    @Column(name = "PURCHASE_L2", nullable = true)
    public Integer getPurchaseL2() {
        return purchaseL2;
    }

    public void setPurchaseL2(Integer purchaseL2) {
        this.purchaseL2 = purchaseL2;
    }

    @Basic
    @Column(name = "PURCHASE_L3", nullable = true)
    public Integer getPurchaseL3() {
        return purchaseL3;
    }

    public void setPurchaseL3(Integer purchaseL3) {
        this.purchaseL3 = purchaseL3;
    }

    @Basic
    @Column(name = "PURCHASE_L4", nullable = true)
    public Integer getPurchaseL4() {
        return purchaseL4;
    }

    public void setPurchaseL4(Integer purchaseL4) {
        this.purchaseL4 = purchaseL4;
    }

    @Basic
    @Column(name = "PURCHASE_L5", nullable = true)
    public Integer getPurchaseL5() {
        return purchaseL5;
    }

    public void setPurchaseL5(Integer purchaseL5) {
        this.purchaseL5 = purchaseL5;
    }

    @Basic
    @Column(name = "PURCHASE_L6", nullable = true)
    public Integer getPurchaseL6() {
        return purchaseL6;
    }

    public void setPurchaseL6(Integer purchaseL6) {
        this.purchaseL6 = purchaseL6;
    }

    @Basic
    @Column(name = "PURCHASE_L7", nullable = true)
    public Integer getPurchaseL7() {
        return purchaseL7;
    }

    public void setPurchaseL7(Integer purchaseL7) {
        this.purchaseL7 = purchaseL7;
    }

    @Basic
    @Column(name = "TOTAL_HUNT", nullable = true)
    public Integer getTotalHunt() {
        return totalHunt;
    }

    public void setTotalHunt(Integer totalHunt) {
        this.totalHunt = totalHunt;
    }

    @Basic
    @Column(name = "TOTAL_PURCHASE", nullable = true)
    public Integer getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Integer totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    @Basic
    @Column(name = "POINTS_HUNT", nullable = true)
    public Integer getPointsHunt() {
        return pointsHunt;
    }

    public void setPointsHunt(Integer pointsHunt) {
        this.pointsHunt = pointsHunt;
    }

    @Basic
    @Column(name = "POINTS_PURCHASE", nullable = true)
    public Integer getPointsPurchase() {
        return pointsPurchase;
    }

    public void setPointsPurchase(Integer pointsPurchase) {
        this.pointsPurchase = pointsPurchase;
    }

    @Basic
    @Column(name = "GOAL_PERC_HUNT", nullable = true, precision = 0)
    public Integer getGoalPercHunt() {
        return goalPercHunt;
    }

    public void setGoalPercHunt(Integer goalPercHunt) {
        this.goalPercHunt = goalPercHunt;
    }

    @Basic
    @Column(name = "GOAL_PERC_PURCHASE", nullable = true, precision = 0)
    public Integer getGoalPercPurchase() {
        return goalPercPurchase;
    }

    public void setGoalPercPurchase(Integer goalPercPurchase) {
        this.goalPercPurchase = goalPercPurchase;
    }

    @Basic
    @Column(name = "DATE_REFERENCE", nullable = false)
    public Date getDateReference() {
        return dateReference;
    }

    public void setDateReference(Date dateReference) {
        this.dateReference = dateReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuildReportsEntity that = (GuildReportsEntity) o;

        if (guildId != that.guildId) return false;
        if (fileId != that.fileId) return false;
        if (playerId != that.fileId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (startUtc != null ? !startUtc.equals(that.startUtc) : that.startUtc != null) return false;
        if (finishUtc != null ? !finishUtc.equals(that.finishUtc) : that.finishUtc != null) return false;
        if (huntL1 != null ? !huntL1.equals(that.huntL1) : that.huntL1 != null) return false;
        if (huntL2 != null ? !huntL2.equals(that.huntL2) : that.huntL2 != null) return false;
        if (huntL3 != null ? !huntL3.equals(that.huntL3) : that.huntL3 != null) return false;
        if (huntL4 != null ? !huntL4.equals(that.huntL4) : that.huntL4 != null) return false;
        if (huntL5 != null ? !huntL5.equals(that.huntL5) : that.huntL5 != null) return false;
        if (huntL6 != null ? !huntL6.equals(that.huntL6) : that.huntL6 != null) return false;
        if (huntL7 != null ? !huntL7.equals(that.huntL7) : that.huntL7 != null) return false;
        if (purchaseL1 != null ? !purchaseL1.equals(that.purchaseL1) : that.purchaseL1 != null) return false;
        if (purchaseL2 != null ? !purchaseL2.equals(that.purchaseL2) : that.purchaseL2 != null) return false;
        if (purchaseL3 != null ? !purchaseL3.equals(that.purchaseL3) : that.purchaseL3 != null) return false;
        if (purchaseL4 != null ? !purchaseL4.equals(that.purchaseL4) : that.purchaseL4 != null) return false;
        if (purchaseL5 != null ? !purchaseL5.equals(that.purchaseL5) : that.purchaseL5 != null) return false;
        if (purchaseL6 != null ? !purchaseL6.equals(that.purchaseL6) : that.purchaseL6 != null) return false;
        if (purchaseL7 != null ? !purchaseL7.equals(that.purchaseL7) : that.purchaseL7 != null) return false;
        if (totalHunt != null ? !totalHunt.equals(that.totalHunt) : that.totalHunt != null) return false;
        if (totalPurchase != null ? !totalPurchase.equals(that.totalPurchase) : that.totalPurchase != null)
            return false;
        if (pointsHunt != null ? !pointsHunt.equals(that.pointsHunt) : that.pointsHunt != null) return false;
        if (pointsPurchase != null ? !pointsPurchase.equals(that.pointsPurchase) : that.pointsPurchase != null)
            return false;
        if (goalPercHunt != null ? !goalPercHunt.equals(that.goalPercHunt) : that.goalPercHunt != null) return false;
        if (goalPercPurchase != null ? !goalPercPurchase.equals(that.goalPercPurchase) : that.goalPercPurchase != null)
            return false;
        if (dateReference != null ? !dateReference.equals(that.dateReference) : that.dateReference != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guildId;
        result = 31 * result + fileId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (playerId != null ? playerId.hashCode() : 0);
        result = 31 * result + (startUtc != null ? startUtc.hashCode() : 0);
        result = 31 * result + (finishUtc != null ? finishUtc.hashCode() : 0);
        result = 31 * result + (huntL1 != null ? huntL1.hashCode() : 0);
        result = 31 * result + (huntL2 != null ? huntL2.hashCode() : 0);
        result = 31 * result + (huntL3 != null ? huntL3.hashCode() : 0);
        result = 31 * result + (huntL4 != null ? huntL4.hashCode() : 0);
        result = 31 * result + (huntL5 != null ? huntL5.hashCode() : 0);
        result = 31 * result + (huntL6 != null ? huntL6.hashCode() : 0);
        result = 31 * result + (huntL7 != null ? huntL7.hashCode() : 0);
        result = 31 * result + (purchaseL1 != null ? purchaseL1.hashCode() : 0);
        result = 31 * result + (purchaseL2 != null ? purchaseL2.hashCode() : 0);
        result = 31 * result + (purchaseL3 != null ? purchaseL3.hashCode() : 0);
        result = 31 * result + (purchaseL4 != null ? purchaseL4.hashCode() : 0);
        result = 31 * result + (purchaseL5 != null ? purchaseL5.hashCode() : 0);
        result = 31 * result + (purchaseL6 != null ? purchaseL6.hashCode() : 0);
        result = 31 * result + (purchaseL7 != null ? purchaseL7.hashCode() : 0);
        result = 31 * result + (totalHunt != null ? totalHunt.hashCode() : 0);
        result = 31 * result + (totalPurchase != null ? totalPurchase.hashCode() : 0);
        result = 31 * result + (pointsHunt != null ? pointsHunt.hashCode() : 0);
        result = 31 * result + (pointsPurchase != null ? pointsPurchase.hashCode() : 0);
        result = 31 * result + (goalPercHunt != null ? goalPercHunt.hashCode() : 0);
        result = 31 * result + (goalPercPurchase != null ? goalPercPurchase.hashCode() : 0);
        result = 31 * result + (dateReference != null ? dateReference.hashCode() : 0);
        return result;
    }
}
