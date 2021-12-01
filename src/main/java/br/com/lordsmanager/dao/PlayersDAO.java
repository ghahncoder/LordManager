package br.com.lordsmanager.dao;

import br.com.lordsmanager.modelJPA.PlayersEntity;

public class PlayersDAO extends LordsDAO<PlayersEntity>{

    public PlayersDAO() {
        super(PlayersEntity.class);
    }

}
