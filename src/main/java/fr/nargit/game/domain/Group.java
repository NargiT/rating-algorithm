package fr.nargit.game.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * (c) 23-janv.-2016
 *
 * @author tigran-mac
 */
public class Group<T>  {

  private Set<T> members;

  public Group(T... members) {
    this.members = new HashSet<>();
    Collections.addAll(this.members, members);
  }

  public boolean add(T member) {
    return members.add(member);
  }

  public boolean remove(T member) {
    return members.remove(member);
  }
}
