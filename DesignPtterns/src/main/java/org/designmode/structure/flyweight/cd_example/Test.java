package org.designmode.structure.flyweight.cd_example;

public class Test {
    public static void main(String[] args) {
        Artist artist1 = FlyWeightFactory.getArtist("alen");
        Artist artist2 = FlyWeightFactory.getArtist("alen");
        System.out.println(artist1.equals(artist2));
    }
}
