package br.com.lordsmanager.model;

import com.google.gson.annotations.SerializedName;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class Lords {

    @SerializedName("IGG_ID")
    private double iggId;

    private String guildDetail;

    private double startDay;

    private double startTime;

    private double discardTime;

    private boolean isDiscard;

    private StatInfo statInfo;

    private List<BoxData> boxData;

    public double getIggId() {
        return iggId;
    }

    public String getGuildDetail() {
        return guildDetail;
    }

    public double getStartDay() {
        return startDay;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getDiscardTime() {
        return discardTime;
    }

    public boolean getIsDiscard() {
        return isDiscard;
    }

    public StatInfo getStatInfo() {
        return statInfo;
    }

    public List<BoxData> getBoxData() {
        return boxData;
    }

    public static class StatInfo {
        private double helpSent;

        private double giftsCollectedTotal;

        private List<Integer> giftsCollected;

        public double getHelpSent() {
            return helpSent;
        }

        public double getGiftsCollectedTotal() {
            return giftsCollectedTotal;
        }

        public List<Integer> getGiftsCollected() {
            return giftsCollected;
        }
    }

    public static class BoxData {
        @SerializedName("SN")
        private double sn;

        @SerializedName("Status")
        private double status;

        @SerializedName("RcvTime")
        private double rcvTime;

        @SerializedName("BoxItemID")
        private double boxItemId;

        @SerializedName("PlayerName")
        private String playerName;

        private boolean isPurchase;

        private double boxLevel;

        private String boxName;

        @SerializedName("Item")
        private Item item;

        public double getSn() {
            return sn;
        }

        public double getStatus() {
            return status;
        }

        public double getRcvTime() {
            return rcvTime;
        }

        public double getBoxItemId() {
            return boxItemId;
        }

        public String getPlayerName() {
            return playerName;
        }

        public boolean getIsPurchase() {
            return isPurchase;
        }

        public double getBoxLevel() {
            return boxLevel;
        }

        public String getBoxName() {
            return boxName;
        }

        public Item getItem() {
            return item;
        }

        public static class Item {
            @SerializedName("ItemID")
            private double itemId;

            @SerializedName("Num")
            private double num;

            @SerializedName("ItemRank")
            private double itemRank;

            private String itemName;

            public double getItemId() {
                return itemId;
            }

            public double getNum() {
                return num;
            }

            public double getItemRank() {
                return itemRank;
            }

            public String getItemName() {
                return itemName;
            }
        }
    }

    @Override
    public String toString() {
        return "Lords{" +
                "iggId=" + iggId +
                ", guildDetail='" + guildDetail + '\'' +
                ", startDay=" + startDay +
                ", startTime=" + startTime +
                ", discardTime=" + discardTime +
                ", isDiscard=" + isDiscard +
                ", statInfo=" + statInfo +
                ", boxData=" + boxData +
                '}';
    }
}
