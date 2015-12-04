package com.epam.entity;
/**
 * 
 * @author Alina 
 */

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "pavilion")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(factoryMethod = "newInstance")

public class Pavilion implements Cloneable, Iterable<Gem> {
    @XmlElementWrapper(name = "gems")
    @XmlElement(name = "gem")
    private List<Gem> gems;

    public Pavilion(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public void addGem(Gem gem) {
        gems.add(gem);
    }

    @Override
    public Object clone() {
        try {
            Pavilion necklace = (Pavilion) super.clone();
            necklace.gems = this.gems;
            return necklace;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("There is no cloneable!");
        }
    }

    public static Pavilion newInstance() {
        return new Pavilion(null);
    }

    @Override
    public String toString() {
        if (!gems.equals(null)) {
            String s = "This pavilion contains:\n";
            Collections.sort(gems, new Comparator<Gem>() {
                @Override
                public int compare(Gem o1, Gem o2) {
                    if (((Gem)o1).getValue() > ((Gem)o2).getValue())
                        return 1;
                    if (((Gem)o1).getValue() < ((Gem)o2).getValue())
                        return -1;
                    return 0;
                }
            });
            for (Gem gem : gems) {
                s += gem.toString() + "\n";
            }
            return s.substring(0, s.length() - 1);
        } else return "This pavilion does not contain gems.";
    }

    @Override
    public Iterator<Gem> iterator() {
        return new Iterator<Gem>() {
            private int index;
            private List<Gem> list = getGems();

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Gem next() {

                return list.get(index++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
