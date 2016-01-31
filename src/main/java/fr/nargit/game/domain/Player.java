package fr.nargit.game.domain;

/**
 * (c) 17-janv.-2016
 *
 * @author NargiT
 */
public class Player {
  public static final double NOOB_RANK = 1000d;

  private String name;
  private Double quotation;

  public Player(String name, Double quotation) {
    this.name = name;
    this.quotation = quotation;
  }

  public Player(String name) {
    this.name = name;
    this.quotation = NOOB_RANK;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (quotation != null ? quotation.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Player player = (Player) o;

    if (name != null ? !name.equals(player.name) : player.name != null) return false;
    return quotation != null ? quotation.equals(player.quotation) : player.quotation == null;

  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", quotation=" + quotation +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getQuotation() {
    return quotation;
  }

  public void setQuotation(Double quotation) {
    this.quotation = quotation;
  }
}
