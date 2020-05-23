/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab11bonus;

/**
 *
 * @author adria
 */
import javax.persistence.*;

@Entity
@Table(name = "games", schema = "games")
public class Games {
    private int id;
    private Integer idPlayer1;
    private Integer idPlayer2;
    private int idCastigator;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_player1")
    public Integer getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(Integer idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    @Basic
    @Column(name = "id_player2")
    public Integer getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(Integer idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    @Basic
    @Column(name = "id_castigator")
    public int getIdCastigator() {
        return idCastigator;
    }

    public void setIdCastigator(int idCastigator) {
        this.idCastigator = idCastigator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Games that = (Games) o;

        if (id != that.id) return false;
        if (idCastigator != that.idCastigator) return false;
        if (idPlayer1 != null ? !idPlayer1.equals(that.idPlayer1) : that.idPlayer1 != null) return false;
        if (idPlayer2 != null ? !idPlayer2.equals(that.idPlayer2) : that.idPlayer2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPlayer1 != null ? idPlayer1.hashCode() : 0);
        result = 31 * result + (idPlayer2 != null ? idPlayer2.hashCode() : 0);
        result = 31 * result + idCastigator;
        return result;
    }
}
