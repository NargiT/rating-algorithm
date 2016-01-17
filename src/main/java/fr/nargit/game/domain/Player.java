package fr.nargit.game.domain;

import java.util.Date;

/**
 * (c) 17-janv.-2016
 *
 * @author NargiT
 */
public class Player {
  public static final double NOOB_RANK = 1000d;

  private String name;
  private Double rank;
  private Date creationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Player player = (Player) o;

    if (name != null ? !name.equals(player.name) : player.name != null) return false;
    return rank != null ? rank.equals(player.rank) : player.rank == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (rank != null ? rank.hashCode() : 0);
    return result;
  }

  public Player(String name) {
    this.name = name;
    this.rank = NOOB_RANK;
    this.creationDate = new Date();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getRank() {
    return rank;
  }

  public void setRank(Double rank) {
    this.rank = rank;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", rank=" + rank +
        '}';
  }
}
